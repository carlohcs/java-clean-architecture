# Java Clean Arch

A Java Clean Architecture implementation example

Repository based on https://github.com/DaniloArantesSilva/clean-architecture 

(Training: https://www.udemy.com/course/descomplicando-clean-architecture-na-pratica)

## Dependencies

* Wiremock - https://github.com/wiremock/wiremock
* Offset Explorer - https://www.kafkatool.com/download.html
* Kafkalytic (IDE extension) - Install inside of IntelliJ
* Java 17 - Use the Java 17 version


### Running dependencies

```
docker-compose up
```

### Running Wiremock (A tool for mocking HTTP services)

At the terminal:

```
java -jar wiremock-standalone-3.5.2.jar --port 8082
```

### Known issues

Try to run `./gradlew build --warning-mode all` in order to get what is wrong.

#### Errors

> Java compiler is not available. Please check that /Library/Java/JavaVirtualMachines/temurin-21.jre/Contents/Home contains a valid JDK installation.

Solution:
Open `gradle-wrapper.properties` and add `org.gradle.java.home=/Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home`


## Hitting the API

## Get

```bash
curl -i http://localhost:8081/api/v1/customers/<CUSTOMER-ID>
```

### Create

```bash
curl -d '{"name": "Carlos", "zipCode": "38400000", "cpf": "4121212"}' -H "Content-Type: application/json" -X POST http://localhost:8081/api/v1/customers
```

### Update

```bash
curl -d '{"name": "Carlos", "zipCode": "38400001", "cpf": "11111"}' -H "Content-Type: application/json" -X PUT http://localhost:8081/api/v1/customers
```

### Delete

```bash
curl -X DELETE http://localhost:8081/api/v1/customers/<CUSTOMER-ID>
```

### Changing record data by Kafka event

(in the Kafkalytic)

`Publish single message`:

```
{
 "id": "661f484c88701126c82d8d02",
 "name": "Carlos from event",
 "zipCode": "38400000",
 "cpf": "111111",
 "isValidCpf": true
}
```

## Connecting to DB

```bash
docker exec -it <MONGO-CONTAINER-ID> /bin/bash
```

Enter into mongo manager:

```bash
mongosh -u root -p <MONGO-DB-PASSWORD-FROM-DOCKER-COMPOSE-FILE>
```

Define db

```bash
use clearnarch
```

Show collections

```bash
show collections
```

Show all records

```bash
db.customers.find()
```
