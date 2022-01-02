# Spring Kafka Playground

Testing spring kafka and play around with kafka (+ schema registry) in spring.

# Start service
1. `docker-compose up`
2. `./gradlew bootRun`

## Post a Movie (Default Settings: Schema Registry (Avro))
`curl -X POST localhost:8080/movie`

## Post a Show (Plain JSON)
`curl -X POST localhost:8080/show`
