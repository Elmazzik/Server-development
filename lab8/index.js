const express = require("express");
const bodyParser = require("body-parser");
const dotenv = require("dotenv");
const logger = require("./src/config/logger");
dotenv.config();
const startConsumer = require("./src/kafka/consumer");

startConsumer().catch(console.error);

const userRoutes = require("./src/routes/userRoutes");
const app = express();

app.use(bodyParser.json());
app.use("/api", userRoutes);

const PORT = process.env.PORT || 5000;
app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
  logger.info(`Server running on port ${PORT}`);
});
