Prerequisites: to run the project **docker-compose** (https://docs.docker.com/compose/) needed to be installed on the testing machine


To build and run the application execute:

**./gradlew start**

It will:
* build savings services
* build gateway service
* start 2 postgresql instances
* start 2 saving instances
* start gateway instance

All services will run within docker (composer)

Requests for testing:

* Post:
curl -X POST \
http://localhost:8080/savings/a/balance \
-H 'content-type: application/json' \
-d '{
"amount": 0.0015151515
}'

* Get:
  curl -X GET \
  http://localhost:8080/savings/a/balance

After tests we need shutdown composer by command:

**./gradlew stop**