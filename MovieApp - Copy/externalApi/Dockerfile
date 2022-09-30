FROM openjdk
WORKDIR usr/lib
ADD  ./target/temp-0.0.1-SNAPSHOT.jar /usr/lib/temp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","temp-0.0.1-SNAPSHOT.jar"]