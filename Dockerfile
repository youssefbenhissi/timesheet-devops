FROM openjdk:8-jdk-alpine
EXPOSE 8082
RUN wget --user=admin --password=admin123 -o timesheetDevops-1.0.jar http://localhost:8081/repository/maven-releases/tn/esprit/timesheetDevops/1.0/timesheetDevops-1.0.jar
ADD timesheetDevops-1.0.jar timesheetDevops-1.0.jar 
ENTRYPOINT ["java","-jar","/timesheetDevops-1.0.jar"]