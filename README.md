E:\MAX\IT\1Coding\IntelliJ_IDEA_Projects\SeleniumDockerProject\target
**java -cp "selenium-docker.jar;selenium-docker-tests.jar;libs/*" -DBROWSER=firefox org.testng.TestNG ../book-flight-module.xml**




# **NOTE:**

Some of you keep your configuration file / properties etc under src/test/resources. Once we create a jar, it can NOT be read! 
Because there is NO src/test/resources directory inside the jar. Usually it is not a good practice.

Preferred Approach:

Your code should be always reading from the classpath as shown here!

For ex: If I have a file like this src/test/resources/my.properties, We have to read this as shown here.

Properties properties = new Properties();
String file = "my.properties";
InputStream inputstream = getClass().getClassLoader().getResourceAsStream(file);
properties.load(inputstream);
---

Alternative Approach:

If you do NOT want to change the code, then you can create src/test/resources directory relative to the jar and place the my.properties file.

selenium-docker.jar
selenium-docker-tests.jsr
lib/....
**src/test/resources/my.properties**