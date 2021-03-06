#!/bin/sh

CLASSPATH="lib/*"

SRCPATH="src/ibc/pem2jwk/"

CLASS="PemToJwk"

mkdir -p classes

javac -cp "$CLASSPATH" -d classes "$SRCPATH$CLASS".java && \
jar cvfm "$CLASS".jar manifest -C classes ibc
