#FROM openjdk:8-jdk
FROM fabric8/java-centos-openjdk8-jdk:1.5.4

ARG JAR_FILE
ARG JAR_PATH="/apps/jars/app.jar"

ENV JAR_PATH $JAR_PATH
ENV JAVA_OPTS "-server -Xms256M -Xmx1024M -Xss1M -XX:MinHeapFreeRatio=30 -XX:MaxHeapFreeRatio=50 -XX:MaxMetaspaceSize=256M -XX:MinMetaspaceFreeRatio=20 -XX:MaxMetaspaceFreeRatio=30 -Duser.timezone=GMT+08"
ENV JAVA_PROPS "-Djava.io.tmpdir=/tmp/tomcat -Djava.security.egd=file:/dev/./urandom"
ENV LANG en_US.UTF-8

VOLUME /tmp/tomcat
VOLUME /opt/logs/ipark

RUN echo JAR_FILE: ${JAR_FILE}
ADD target/${JAR_FILE} $JAR_PATH

ENTRYPOINT ["/bin/bash", "-c", "java $JAVA_PROPS $JAVA_OPTS -jar $JAR_PATH $APP_OPTS"]

#EXPOSE 8080