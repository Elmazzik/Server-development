const { createLogger, transports, format } = require("winston");
const path = require("path");

const auditLogger = createLogger({
  level: "info",
  format: format.combine(
    format.timestamp(),
    format.printf(({ timestamp, level, message }) => {
      return `${timestamp} [${level.toUpperCase()}]: ${message}`;
    })
  ),
  transports: [
    new transports.File({
      filename: path.join(__dirname, "../../logs/security-audit.log"),
      level: "info",
    }),
  ],
});

module.exports = auditLogger;
