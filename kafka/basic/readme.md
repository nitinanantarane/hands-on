Get docker image
<pre>
docker pull apache/kafka:3.9.0
</pre>

Start the Kafka Docker container
<pre>
docker run -p 9092:9092 apache/kafka:3.9.0
</pre>

Create Topic
<pre>
bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092
</pre>

Describe Topic
<pre>
bin/kafka-topics.sh --describe --topic quickstart-events --bootstrap-server localhost:9092
</pre>

Message Producer
<pre>
bin/kafka-console-producer.sh --topic quickstart-events --bootstrap-server localhost:9092
</pre>

Message Consumer
<pre>
bin/kafka-console-consumer.sh --topic quickstart-events --from-beginning --bootstrap-server localhost:9092
</pre>

Import/Export Kafka Connect
<pre>
echo "plugin.path=libs/connect-file-3.9.0.jar" >> config/connect-standalone.properties
echo foo > test.txt
echo bar >> test.txt

bin/connect-standalone.sh config/connect-standalone.properties config/connect-file-source.properties config/connect-file-sink.properties

more test.sink.txt

bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic connect-test --from-beginning

echo "Another line" >> test.txt
</pre>

Kafka Streams
<pre>
Start zookeeper server
bin/zookeeper-server-start.sh config/zookeeper.properties

Start Kafka server
bin/kafka-server-start.sh config/server.properties

Input Topic
bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic streams-plaintext-input

Output Topic
bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic streams-wordcount-output --config cleanup.policy=compact

Describe
bin/kafka-topics.sh --bootstrap-server localhost:9092 --describe

Start Application --> WordCount
bin/kafka-run-class.sh org.apache.kafka.streams.examples.wordcount.WordCountDemo

Producer write input data
bin/kafka-console-producer.sh --bootstrap-server localhost:9092 --topic streams-plaintext-input

Consumer output data
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic streams-wordcount-output --from-beginning --property print.key=true --property print.value=true --property key.deserializer=org.apache.kafka.common.serialization.StringDeserializer --property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer

</pre>