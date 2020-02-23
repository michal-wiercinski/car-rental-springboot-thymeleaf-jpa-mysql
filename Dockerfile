FROM java:11

VOLUME /tmp 

EXPOSE 10222 

ADD /target/car-rental-0.0.1-SNAPSHOT.jar car-rental-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","car-rental-0.0.1-SNAPSHOT"]
