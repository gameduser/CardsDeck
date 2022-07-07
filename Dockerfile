FROM maven:3.8.6-openjdk-18-slim

RUN apt-get -y update
RUN apt-get -y install git
RUN git clone https://github.com/gameduser/CardsDeck.git
WORKDIR /CardsDeck

CMD ["mvn", "test"]