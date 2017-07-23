# Kafka-Documentation

Downloading the Required Files

Download Server JRE according to your OS & CPU architecture from 
http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
Download Zookeeper from http://zookeeper.apache.org/releases.html
Download Kafka from http://kafka.apache.org/downloads.html


Start JRE installation

1. Now open system environment variables dialogue by opening Control Panel -> System -> Advanced system settings -> 
      Environment Variables…
2. Hit New… button in User variables section then type JAVA_HOME in Variable name & give your jre path in Variable value.
                               JAVA_HOME = C:\Program Files\Java
3. Search for Path variable in the “System Variable” section in “Environment Variables” dialogue box you just opened.
4. Edit the path and type “;%JAVA_HOME%\bin” at the end of the text already written in the path.
5. To confirm java installation just open cmd and type “java –version”, you should be able to see version of the java you 
      just installed.


Installing & Running Zookeeper

1. Goto your zookeeper config directory. For me its C:\zookeeper-3.4.7\conf
2. Rename file “zoo_sample.cfg” to “zoo.cfg”
3. Open zoo.cfg in any text editor like notepad but I’ll prefer notepad++.
4. Find & edit dataDir=/tmp/zookeeper to dataDir=C:\zookeeper-3.4.7\data
             a. Add entry in System Environment Variables as we did for java
             b. Add in System Variables ZOOKEEPER_HOME = C:\zookeeper-3.4.7
5. Edit System Variable named “Path” add ;%ZOOKEEPER_HOME%\bin;
6. You can change the default zookeeper port in zoo.cfg file (Default port 2181).
7. Run zookeeper by opening a new cmd & Type --- C:\zookeeper-3.4.6\bin>zkserver.


Setting Up Kafka

1. Go to your Kafka config directory. For me its C:\kafka_2.11-0.9.0.0\config
2. Edit file “server.properties”
3. Find & edit line “log.dirs=/tmp/kafka-logs” to “log.dir= C:\kafka_2.11-0.9.0.0\kafka-logs”.
4. If your zookeeper is running on some other machine or cluster you can edit “zookeeper.connect=localhost:2181” to your custom IP & port. For this demo we are using same machine so no need to change. Also Kafka port & broker.id are configurable in this file. Leave other settings as it is.
5. Your Kafka will run on default port 9092 & connect to zookeeper’s default port which is 2181.


Running Kafka Server

Note:
Please ensure that your zookeeper is up & running before starting Kafka server.

1. Go to your kafka installation directory C:\kafka_2.11-0.9.0.0\
2. Open a command prompt here by pressing Shift + right click and choose “Open command window here” option)
3. Now type .\bin\windows\kafka-server-start.bat .\config\server.properties & press enter.


Creating Topic

1. Open a new command prompt in the location C:\kafka_2.11-0.9.0.0\bin\windows
2. Type following command and hit enter
        kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic kafkatest
3. The last word is your Topic Name........       


Creating a producer & consumer to test server...

1. Open a new command prompt in the location C:\kafka_2.11-0.9.0.0\bin\windows
2. To start a producer type command “kafka-console-producer.bat --broker-list localhost:9092 --topic kafkatest”.
3. Again open a new command prompt in the same location as C:\kafka_2.11-0.9.0.0\bin\windows
4. Now start a consumer by typing command “kafka-console-consumer.bat --zookeeper localhost:2181 --topic kafkatest”.
5. Now type anything in the producer command prompt & press enter and you should be able to see the message in the other 
   consumer command prompt.

Some Other Useful Commands

1. List Topics: kafka-topics.bat --list --zookeeper localhost:2181
2. Describe Topic: kafka-topics.bat --describe --zookeeper localhost:2181 --topic [Topic Name]
3. Read messages from beginning: kafka-console-consumer.bat --zookeeper localhost:2181 --topic [Topic Name] --from-
   beginning
4. Delete Topic: kafka-run-class.bat kafka.admin.TopicCommand --delete --topic [topic_to_delete] --zookeeper 
   localhost:2181
























