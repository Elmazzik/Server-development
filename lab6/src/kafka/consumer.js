const { Kafka } = require("kafkajs");
const kafka = new Kafka({ brokers: [process.env.KAFKA_BROKER] });

const consumer = kafka.consumer({ groupId: "audit-log-group" });

const startConsumer = async () => {
  await consumer.connect();
  await consumer.subscribe({ topic: "audit-log", fromBeginning: true });

  await consumer.run({
    eachMessage: async ({ topic, partition, message }) => {
      console.log(`Received message: ${message.value.toString()}`);
    },
  });
};

module.exports = startConsumer;
