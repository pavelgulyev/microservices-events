FROM openjdk:17

#WORKDIR /notesapp

# buid the project using mvn install
COPY target/service-shedule-0.0.1-SNAPSHOT.jar .

ENTRYPOINT [ "java", "-jar", "service-shedule-0.0.1-SNAPSHOT.jar" ]