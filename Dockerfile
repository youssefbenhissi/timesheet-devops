FROM openjdk:8-jdk-alpine
EXPOSE 8082
RUN  curl -u admin:admin123 -o target/tun451.jar "http://localhost:8081/service/local/artifact/maven/redirect?g=tn.esprit&a=timesheetDevops&v=1.0" -L
ADD tun451.jar tun451.jar
ENTRYPOINT ["java","-jar","/tun451.jar"]