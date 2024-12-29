const express = require("express");
const {
  getUsers,
  createUser,
  updateUser,
  deleteUser,
  login,
} = require("../controllers/userController");
const authenticateToken = require("../middleware/auth");

const router = express.Router();

router.get("/users", authenticateToken, getUsers);
router.post("/users", createUser);
router.put("/users/:id", updateUser);
router.delete("/users/:id", deleteUser);
router.post("/login", login);

module.exports = router;
