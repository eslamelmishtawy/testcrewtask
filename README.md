# testcrewtask
Install JAVA 21
Install Maven
Generate (Arctype quick start) Maven Project => "mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4"
Install required dependancies ==> mvn dependency:copy-dependencies

page layer ==> under main src java, because they are not realted to test cases
scenarios should be written in feature file
test cases should be written in step definition

Cucumber uses junit to run parallel execuition of feature files rather than senarios each feature file will run on a single thread.

run mvn tests
mvn clean test

run mvn with tags
mvn test -Dcucumber.filter.tags="@smoke and @fast"
