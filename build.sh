#!/bin/sh

CLASS="PrivatePemToJwk"

CLASSPATH="./lib/*"

javac -cp "$CLASSPATH" -d classes src/ibc/pem2jwk/"$CLASS".java && \
jar cvfm PrivatePemToJwk.jar manifest -C classes ibc
