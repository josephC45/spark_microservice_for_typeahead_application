# Spark Microservice
The Spark Microservice consumes messages from the Typeahead Service via Kafka, processes the incoming text data in real time, and aggregates word occurrences. These aggregates are stored in HBase for fast, scalable access. This setup enables efficient handling of typeahead suggestions and analytics at scale.

## Architecture Overview
Typeahead Service: Produces messages (e.g., words or phrases) to a Kafka topic.
Kafka Broker: Acts as the messaging layer, delivering messages from the Typeahead Service to consumers, including the Spark Microservice.
Spark Microservice: Consumes messages from Kafka, processes them to aggregate word occurrences, and stores the aggregated data in HBase.
HBase: A distributed, scalable NoSQL database used for storing and retrieving the aggregated word occurrences efficiently.

## Features
- Real-time Processing: Consumes data in real time from the Kafka topic, enabling up-to-date analysis of user input.
- Scalable Aggregation: Aggregates word occurrences using Apache Spark, with results stored in HBase for efficient querying.
- HBase Integration: The word frequency data is stored in HBase, providing a fast and scalable solution for reading and updating word counts.
- Spark for Data Processing: Uses Apache Spark for processing large-scale data, performing operations such as filtering, grouping, and aggregation.