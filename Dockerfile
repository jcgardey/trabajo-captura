FROM java:8-alpine

# Maven
RUN apk add --update ca-certificates && rm -rf /var/cache/apk/* && \
  find /usr/share/ca-certificates/mozilla/ -name "*.crt" -exec keytool -import -trustcacerts \
  -keystore /usr/lib/jvm/java-1.8-openjdk/jre/lib/security/cacerts -storepass changeit -noprompt \
  -file {} -alias {} \; && \
  keytool -list -keystore /usr/lib/jvm/java-1.8-openjdk/jre/lib/security/cacerts --storepass changeit

ENV MAVEN_VERSION 3.5.4
ENV MAVEN_HOME /usr/lib/mvn
ENV PATH $MAVEN_HOME/bin:$PATH

RUN wget http://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz && \
  tar -zxvf apache-maven-$MAVEN_VERSION-bin.tar.gz && \
  rm apache-maven-$MAVEN_VERSION-bin.tar.gz && \
  mv apache-maven-$MAVEN_VERSION /usr/lib/mvn


# Mongo
RUN echo 'http://dl-cdn.alpinelinux.org/alpine/v3.6/main' >> /etc/apk/repositories
RUN echo 'http://dl-cdn.alpinelinux.org/alpine/v3.6/community' >> /etc/apk/repositories
#RUN apk add mongodb=3.4.4-r0
#RUN apk add mongodb-tools

RUN /bin/sh -c "apk add --no-cache bash"

#RUN mongo --version

ENV user captura

# Create a group and user
RUN addgroup -S ${user} && adduser -S ${user} -G ${user} -h /home/${user} \
&& chown -R ${user} /home/${user}

RUN apk update
RUN apk add sudo
RUN echo "captura ALL=(ALL) NOPASSWD:ALL" >> /etc/sudoers

WORKDIR /var/captura/org.gardey.captura
