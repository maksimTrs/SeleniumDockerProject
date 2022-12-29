FROM openjdk:17-alpine

WORKDIR usr/share/udemy

ADD target/selenium-docker.jar        selenium-docker.jar
ADD target/selenium-docker-tests.jar  selenium-docker-tests.jar
ADD target/libs                       libs

ADD book-flight-module.xml   book-flight-module.xml
ADD search-module.xml        search-module.xml
# ADD pom.xml                  pom.xml

ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE
#../book-flight-module.xml