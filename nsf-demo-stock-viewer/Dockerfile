FROM tomcat:7.0.77-jre8

ADD target/nsf*.war /usr/local/tomcat/webapps/

ADD nsf.yml /opt/nsf/nsf.yml

RUN cd /usr/local/tomcat/webapps && \
    mv nsf*.war ROOT.war && \
    rm -rf ROOT 
    
# RUN wget "http://dev-test.netease.com/filemanager?path=/nsf-agent-release/nsf-agent-develop-20180920-20180921-115128-42bf4002.jar" -O nsf-agent.jar

# RUN wget "https://cloud-solution.nos-eastchina1.126.net/0129demo/nsf-agent.jar"

RUN wget -P /nce-dev/nce/nsf-demo-stock/apm http://java-aent.nos-eastchina1.126.net/napm-java-agent.tar.gz && \
    tar zxvf /nce-dev/nce/nsf-demo-stock/apm/napm-java-agent.tar.gz -C /nce-dev/nce/nsf-demo-stock/apm 

ADD napm-agent.properties /nce-dev/nce/nsf-demo-stock/apm/napm-java-agent/conf

CMD ["catalina.sh", "run"]
