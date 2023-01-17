# Will's Auto Complete

In this project you will be able to find the Back-end and Front-end project of Will's Auto Complete App. *That app can be run using docker*.

## How to run (Docker)

### Compile BE project (Docker take too long to do it)
- Go to `will-auto-complete-be` folder and run `./gradlew bootjar` it will geenerate a new java artifact to us to use.

#### Execute docker-compose

- In the root of the repository simply run `docker-compose build` so we mount all our containers.
- Now we can execute it with `docker-compose up` it the following order:
  - DB
  - API
  - WEB

*PS: It may take some little more time once you run the compose to all work since the java project sometimes takes a bit longer*
