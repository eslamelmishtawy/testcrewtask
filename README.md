## Test Crew Task
 <p>
    Java Cucumber BDD Project
</p>

<!-- ABOUT THE PROJECT -->
## About The Project
An automated test framework to execute steps for testing [website](https://subscribe.stctv.com/sa-en)

### Built With
* [Java](https://www.oracle.com/java/technologies/javase/21-relnote-issues.html)
* [Maven](https://maven.apache.org/download.cgi)
* [Selenium](https://www.selenium.dev/)

<!-- GETTING STARTED -->
## Getting Started

Examples on how to run test on a local machine or in docker

### Prerequisites
Install Java 21
* [java](https://www.oracle.com/java/technologies/javase/21-relnote-issues.html)
```sh
java -version
```

Install Maven
* [maven](https://maven.apache.org/install.html)
```sh
mvn --version
```

Install Docker
* [docker](https://docs.docker.com/engine/install/)
```sh
docker --version
```

[Install IntelliJ (Preferrable IDE)](https://www.jetbrains.com/idea/download/?section=mac)

### Installation
1. Clone the repo
```sh
git https://github.com/eslamelmishtawy/testcrewtask.git
```
<!-- USAGE EXAMPLES -->
## Run the test locally

TO run the test locally please use the following command
1. All Features
```commandline
mvn test
```

2. Specific tag
```commandline
mvn test -Dcucumber.filter.tags="@Smoke"
```

This Project Support parallel execution of feature using cucumber, junit, surefire
```
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-surefire-plugin</artifactId>
	<version>2.22.1</version>
	<configuration>
		<includes>
			<include>**/TestRunner.java</include>
		</includes>
		<parallel>methods</parallel>
		<threadCount>4</threadCount>
		<useUnlimitedThreads>false</useUnlimitedThreads>
	</configuration>
</plugin>
```
## Run the test using jenkins and docker

1. Create Docker Image from Dockerfile in repo
```commandline
docker build --tag="jenkinswithmaven" .
```

2. Create Docker Network
```
docker network create jenkins
```

3. Create Docker Container with the created image
```
docker run \
  --name jenkins-maven \
  --restart=on-failure \
  --detach \
  --network jenkins \
  --env DOCKER_HOST=tcp://docker:2376 \
  --env DOCKER_CERT_PATH=/certs/client \
  --env DOCKER_TLS_VERIFY=1 \
  --publish 8080:8080 \
  --publish 50000:50000 \
  --volume jenkins-data:/var/jenkins_home \
  --volume jenkins-docker-certs:/certs/client:ro \
  jenkinswithmaven
```

4. Go to localhost:8080 in your machine

5. Enter Jenkins Initial Password => To get password run
```
docker ps -a
docker logs [container_id]
```

6. Install Jenkins Plugin

7. Create New Jenkins Pipline as follow [![Jenkins Pipeline](https://ibb.co/n8pnYW5 "Jenkins Pipeline")](https://ibb.co/n8pnYW5 "Jenkins Pipeline")

8. Click Save

9. Click Build Now



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the automation such an amazing place to learn, inspire, and create.
Any contributions you make are **greatly appreciated**.

Please follow the following steps in order to contribute to the existing scripts
1. Clone the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Merge Request
6. A Reviewer will review your changes, comment on them if needed
7. After all conflicts are sorted out the MR can then be merged

<!-- Design Pattern -->
## Design Pattern
This project is build based on the **Page Object Model**, please follow this design pattern in adding new resources
or test cases.
```editorconfig
├── src/main/java/com  >> Contains: DriverFactory, Pages, Helper Functions
├── src/test/java           >> Contains:  AppHooks, Step Definition, Test Runner.
├── src/test/resources  >> Contains:  App Configuration, App Features.
```
```editorconfig
Driver Factory => Initallize Webdriver required for test

Pages => Web Pages (POM), Locators and Action Function for each page
├── CountrySelect.java
└── SubscriptionPage.java

AppHooks => Setups and teardown for scenarios

Stepdefinition => Logic and assertion for the steps in a scenario
├── SubscriptionSteps.java
└── SubscriptionPage.java

Test Runner
├── RerunFailedRunner.java
└── TestRunner.java

Features => Features and Scenarios of each feature
├── SubscriptionPackage.feature

Config => Application configuration (eg, Browser = Chrome)
```
<!-- CONTACT -->
## Contact

Eslam Elmishtawy - eslamelmishtawy@gmail.com
