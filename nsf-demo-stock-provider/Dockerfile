FROM tomcat:7.0.77-jre8
ADD target/nsf*.war /usr/local/tomcat/webapps/
ADD nsf.yml /opt/nsf/nsf.yml
RUN cd /usr/local/tomcat/webapps && \
    mv nsf*.war ROOT.war && \
    rm -rf ROOT 
    
RUN wget "http://httpserver.v181108.163skiff.com/download/nsf-agent.jar" -O nsf-agent.jar && \
RUN wget -P /nce-dev/nce/nsf-demo-stock/apm http://httpserver.v181108.163skiff.com/download/napm-java-agent.tar.gz && \
    tar zxvf /nce-dev/nce/nsf-demo-stock/apm/napm-java-agent.tar.gz -C /nce-dev/nce/nsf-demo-stock/apm && \
    cd /nce-dev/nce/nsf-demo-stock/apm/napm-java-agent && \
    cd conf && \
    echo "endpoint=http://apm-collector-inner.v181108.163skiff.com\ncustomHeader=stockCode" >> napm-agent.properties 
CMD ["catalina.sh", "run"]

