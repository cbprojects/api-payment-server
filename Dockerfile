FROM adoptopenjdk/openjdk11
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME

ARG JAR_FILE=api-payment-server.jar
ADD api-payment-server.jar /usr/app/api-payment-server.jar
COPY generated-sources/ /usr/app/generated-sources/

EXPOSE 8443
ENTRYPOINT ["java", "-jar", "/usr/app/api-payment-server.jar"]