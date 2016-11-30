#!/bin/sh
docker run -e "JAVA_OPTS=-Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=9090 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false" -p 8080:8080 -p 9090:9090 -t ileossa/fondation 
