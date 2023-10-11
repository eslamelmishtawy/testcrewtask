FROM --platform=linux/amd64 jenkins/jenkins:jdk21

USER root

RUN apt-get update \
 && apt-get install maven -y

RUN apt-get update && apt-get install -y wget

RUN apt-get install -y fonts-liberation libappindicator3-1 libasound2 libatk-bridge2.0-0 \
            libnspr4 libnss3 lsb-release xdg-utils libxss1 libdbus-glib-1-2

RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
RUN echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list
RUN apt-get update -y
RUN apt-get install -y google-chrome-stable

ENV FF_VER 105.0
ENV FF_DIR /dist
RUN apt update -y && apt upgrade -y && apt install -y libgtk-3-common libasound2 libdbus-glib-1-2
RUN mkdir -p $FF_DIR
WORKDIR $FF_DIR
RUN apt-get install bzip2
RUN wget -O - https://ftp.mozilla.org/pub/firefox/releases/$FF_VER/linux-x86_64/en-US/firefox-$FF_VER.tar.bz2 | tar -xjf -
ENV PATH $FF_DIR/firefox:$PATH

USER jenkins
