FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD timesheetDevops-1.0.jar timesheetDevops-1.0.jar 
ENTRYPOINT ["java","-jar","/timesheetDevops-1.0.jar"]