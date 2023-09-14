# Build management with the Maven tool
Getting started with Maven
Using Maven -weather forecast project

mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

groupID = com.ua.pt
artifactID = X

mvn package
mvn exec:java -Dexec.mainClass="com.ua.pt.WeatherStarter"
-Dexec.args=""
