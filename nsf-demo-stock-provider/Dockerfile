FROM tomcat:7.0.77-jre8
ADD target/nsf*.war /usr/local/tomcat/webapps/
RUN cd /usr/local/tomcat/webapps && \
    mv nsf*.war ROOT.war && \
    rm -rf ROOT 
    
RUN mkdir -p /opt/nsf && cd /opt/nsf && \
#    wget "http://httpserver.v190613.163skiff.com/download/nsf-agent-v1.jar"
    wget "http://httpserver.v190613.163skiff.com/download/nsf-agent-v1-release-2.4-57956be7-20190812-164241.jar"
ADD nsf.yml /opt/nsf/
RUN mkdir -p /opt/apm && cd /opt/apm && \
    wget "http://httpserver.v190613.163skiff.com/download/napm-java-agent.tar.gz" && \
    tar zxvf napm-java-agent.tar.gz && \
    cd ./napm-java-agent/conf && \
    echo "endpoint=http://apm-collector.v190613.163skiff.com\ncustomHeader=stockCode" >> napm-agent.properties 
CMD ["catalina.sh", "run"]
