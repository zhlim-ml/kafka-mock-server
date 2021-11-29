FROM adoptopenjdk:11-jdk-hotspot

RUN mkdir -p /scripts

WORKDIR /scripts

RUN curl -Ls https://github.com/intuit/karate/releases/download/v1.1.0/karate-1.1.0.jar --output karate.jar
             #&& jar xf karate.zip && rm karate.zip 
             #&& mv karate-* karate && chmod +x jbang/bin/jbang

COPY src/test/resources/mock-server/ /scripts/

ENTRYPOINT [ "java", "-jar", "karate.jar", "-p", "80", "-m", "mock.feature"]