const db = require("../config/db");
const bcrypt = require("bcryptjs");

const getUsers = (callback) => {
  db.query("SELECT * FROM users", callback);
};

const createUser = (data, callback) => {
  const { name, email, password } = data;
  const hashedPassword = bcrypt.hashSync(password, 10);
  db.query(
    "INSERT INTO users (name, email, password) VALUES (?, ?, ?)",
    [name, email, hashedPassword],
    callback
  );
};

const updateUser = (id, data, callback) => {
  const { name, email } = data;
  db.query(
    "UPDATE users SET name = ?, email = ? WHERE id = ?",
    [name, email, id],
    callback
  );
};

const deleteUser = (id, callback) => {
  db.query("DELETE FROM users WHERE id = ?", [id], callback);
};

const getUserByEmail = (email, callback) => {
  db.query("SELECT * FROM users WHERE email = ?", [email], callback);
};

module.exports = {
  getUsers,
  createUser,
  updateUser,
  deleteUser,
  getUserByEmail,
};
