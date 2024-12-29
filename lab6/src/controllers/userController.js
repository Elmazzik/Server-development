const {
  getUsers,
  createUser,
  updateUser,
  deleteUser,
  getUserByEmail,
} = require("../models/userModel");
const logger = require("../config/logger");
const auditLogger = require("../config/auditLogger");
const bcrypt = require("bcryptjs");
const jwt = require("jsonwebtoken");

exports.getUsers = (req, res) => {
  getUsers((err, results) => {
    if (err) {
      logger.error("Error fetching users: " + err.message);
      res.status(500).send("Database error");
      return;
    }
    logger.info("Fetched all users");
    res.json(results);
  });
};

exports.createUser = (req, res) => {
  const { name, email, password } = req.body;
  createUser({ name, email, password }, (err, results) => {
    if (err) {
      logger.error("Error creating user: " + err.message);
      res.status(500).send("Error creating user");
      return;
    }
    logger.info(`User created: ${email}`);
    res.status(201).send("User created");
  });
};

exports.updateUser = (req, res) => {
  const id = req.params.id;
  updateUser(id, req.body, (err, results) => {
    if (err) {
      logger.error("Error updating user: " + err.message);
      res.status(500).send("Error updating user");
      return;
    }
    logger.info(`User updated: ${id}`);
    res.status(200).send("User updated");
  });
};

exports.deleteUser = (req, res) => {
  const id = req.params.id;
  deleteUser(id, (err, results) => {
    if (err) {
      logger.error("Error deleting user: " + err.message);
      res.status(500).send("Error deleting user");
      return;
    }
    logger.info(`User deleted: ${id}`);
    res.status(200).send("User deleted");
  });
};

const sendMessage = require("../kafka/producer");

exports.login = (req, res) => {
  const { email, password } = req.body;
  const ipAddress =
    req.headers["x-forwarded-for"] || req.connection.remoteAddress;

  getUserByEmail(email, (err, results) => {
    if (err || results.length === 0) {
      const message = `Failed login attempt for email: ${email} from IP: ${ipAddress}`;
      sendMessage("audit-log", message);
      return res.status(401).send("Invalid email or password");
    }

    const user = results[0];
    if (!bcrypt.compareSync(password, user.password)) {
      const message = `Failed login attempt for email: ${email} from IP: ${ipAddress}`;
      sendMessage("audit-log", message);
      return res.status(401).send("Invalid email or password");
    }

    const token = jwt.sign({ id: user.id }, process.env.JWT_SECRET, {
      expiresIn: "1h",
    });
    const message = `Successful login for email: ${email} from IP: ${ipAddress}`;
    sendMessage("audit-log", message);
    res.json({ token });
  });
};
