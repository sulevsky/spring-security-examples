FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD dataconsumer-*.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]