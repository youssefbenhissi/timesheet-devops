FROM openjdk:8-jdk-alpine
EXPOSE 8082
RUN wget "http://localhost:8081/service/local/artifact/maven/redirect?g=tn.esprit&a=timesheetDevops&v=1.0" -o tun1.jar --content-disposition
ADD tun1.jar tun1.jar
ENTRYPOINT ["java","-jar","/tun1.jar"]