FROM frolvlad/alpine-oraclejdk8:slim

RUN apk upgrade --update && \
    apk add --update curl unzip && \
    curl -o /tmp/unlimited_jce_policy.zip "http://artifactory.truphone.com:8081/artifactory/simple/cs-third-party-local/com/oracle/jre/jce_policy-8/jce_policy-8/jce_policy-8-jce_policy-8.zip" && \
    unzip -jo -d /usr/lib/jvm/java-8-oracle/jre/lib/security /tmp/unlimited_jce_policy.zip && \
    apk del curl unzip && \
    rm -rf /tmp/* /var/cache/apk/*

ADD /build/${project.build.finalName}-bin.zip /tmp/${project.build.finalName}-bin.zip
ADD ${docker.script.name}.sh /tmp/${docker.script.name}.sh

RUN mkdir -p /home/acme/service/log

RUN	mv /tmp/${project.build.finalName}-bin.zip /home/acme/service/${project.build.finalName}-bin.zip && \
	cd /home/acme/service/ && \
	unzip ${project.build.finalName}-bin.zip && \
	rm ${project.build.finalName}-bin.zip && \
    mv /tmp/${docker.script.name}.sh /home/acme/service/${docker.script.name}.sh && \
    chmod +x /home/acme/service/${docker.script.name}.sh
WORKDIR /home/acme/service/

VOLUME /home/acme/service/log
VOLUME /home/acme/service/config

EXPOSE 7001
EXPOSE 7002
CMD ["/home/acme/service/${docker.script.name}.sh"]