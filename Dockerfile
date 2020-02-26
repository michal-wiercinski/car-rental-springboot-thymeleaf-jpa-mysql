ENTRYPOINT ["java","-jar","car-rental-0.0.1-SNAPSHOT"]
FROM openjdk:11
COPY ./target/car-rental-0.0.1-SNAPSHOT.jar car-rental-0.0.1-SNAPSHOT.jar
CMD ["java","-jar", "car-rental-0.0.1-SNAPSHOT"]

