FROM java:8-jre
MAINTAINER Max Syachin <maxsyachin@gmail.com>

ADD ./target/smaller.jar /app/

CMD ["java", "-jar", "/app/smaller.jar"]

EXPOSE 8080