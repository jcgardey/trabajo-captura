#!/bin/bash
docker exec -it app mvn exec:java -Dexec.args="run-queries" -DtargetDatastore="MySQL"
docker exec -it app mvn exec:java -Dexec.args="run-queries" -DtargetDatastore="MONGODB"
docker exec -it app mvn exec:java -Dexec.args="run-queries" -DtargetDatastore="CASSANDRA"
docker exec -it app mvn exec:java -Dexec.args="run-queries" -DtargetDatastore="NEO4J"
