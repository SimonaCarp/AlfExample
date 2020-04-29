###
#
# A docker image for alfexample
#
# Usage:
#
# 1. Build the container:
# docker build -t alfexample .
#
# 2. Start the container:
# docker run -td alfexample
#

FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=target/dependency

ENTRYPOINT ["java","-cp","alfExample.AlfExampleApplication"]