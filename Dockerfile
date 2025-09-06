FROM amazoncorretto:24
COPY ./build/libs/ExpenseService-0.0.1-SNAPSHOT.jar ExpenseService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ExpenseService-0.0.1-SNAPSHOT.jar"]