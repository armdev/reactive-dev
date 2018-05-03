FROM OPENJDK
VOLUME /tmp
ADD target/eureka.jar /app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Xmx256m", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
#HEALTHCHECK --interval=10s --timeout=5s CMD curl -f http://192.168.99.100:8761/health || exit 1
EXPOSE 8761 8762 8763 8764 8765 8766 8768 8769
