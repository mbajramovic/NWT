FROM alpine-jdk:base

MAINTAINER javaonfly

RUN apk --no-cache add netcat-openbsd

COPY files/scholarship-service.jar /opt/lib/

COPY scholarship-service-entrypoint.sh /opt/bin/scholarship-service-entrypoint.sh

RUN chmod 755 /opt/bin/scholarship-service-entrypoint.sh

EXPOSE 8888