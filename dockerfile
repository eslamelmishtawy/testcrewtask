FROM jenkins/jenkins:jdk21

USER root

RUN apt-get update \
 && apt-get install maven -y

USER jenkins
