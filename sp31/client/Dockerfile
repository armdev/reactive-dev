FROM openjdk
COPY target/client.jar /opt/client.jar
ENTRYPOINT ["java","-Xmx512m", "-jar","/opt/client.jar"]
EXPOSE 5000