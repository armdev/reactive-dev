FROM openjdk
COPY target/sp28.jar /opt/sp28.jar
ENTRYPOINT ["java","-Xmx256m", "-jar","/opt/sp28.jar"]
EXPOSE 10007