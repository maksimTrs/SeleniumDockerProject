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
# docker run --rm  -e MODULE=search-module.xml  -e HUB_HOST=192.168.0.191 -v "E:\MAX\IT\UDEMY\Selenium WebDriver with D
  #ocker, Jenkins & AWS\test-output:/usr/share/udemy/test-output"  9ce72fae8b8b