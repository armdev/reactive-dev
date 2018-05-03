FROM openjdk
COPY target/client.jar /opt/client.jar
ENTRYPOINT ["java","-Xmx512m", "-jar","/opt/client.jar"]
EXPOSE 5000 5001 5002 5003 5004 5005