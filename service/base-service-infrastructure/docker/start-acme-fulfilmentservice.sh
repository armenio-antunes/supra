#!/bin/sh

JAVA_ARGS=$BASE_JVM_ARGS

echo "Starting service..."
#exec java -Djgroups.tcp.address=$HOSTNAME $JAVA_ARGS -jar ${project.build.finalName}-final.jar
exec java $JAVA_ARGS -jar ${project.build.finalName}-final.jar
