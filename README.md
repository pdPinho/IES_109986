# Lab01

## Build management with the Maven tool

mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

groupID = com.ua.pt
artifactID = name_example

mvn package
mvn exec:java -Dexec.mainClass="com.ua.pt.WeatherStarter" -Dexec.args=""


## Git tools

(Important: always add a .gitignore with the right info)

git pull
git add *
git commit -m "comments"
git push


## Docker setup
example image:
/# syntax=docker/dockerfile:1

FROM node:18-alpine
WORKDIR /app
COPY . .
RUN yarn install --production
CMD ["node", "src/index.js"]
EXPOSE 3000

building image :
docker build -t getting-started .

run container :
docker run -dp 127.0.0.1:3000:3000 getting-started

check containers :
docker ps

stop/remove container :
docker stop ID
docker remove ID

docker volume create todo-db
docker run -dp 127.0.0.1:3000:3000 --mount type=volume,src=todo-db,target=/etc/todos getting-started

docker inspect todo-db
