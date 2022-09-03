FROM tomcat:7.0-jre7-alpine
COPY tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
COPY target/cartao-virtual-1.0.0-SNAPSHOT.war /usr/local/tomcat/webapps
EXPOSE 8080

