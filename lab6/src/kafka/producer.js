const { Kafka } = require("kafkajs");
const kafka = new Kafka({ brokers: [process.env.KAFKA_BROKER] });

const producer = kafka.producer();

const sendMessage = async (topic, message) => {
  await producer.connect();
  await producer.send({
    topic,
    messages: [{ value: message }],
  });
  await producer.disconnect();
};

module.exports = sendMessage;
