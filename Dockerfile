FROM jboss/wildfly:latest
#ENV JAVA_OPTS="-Dfile.encoding=UTF-8"
ADD target/jjdd6-movieSpotter-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent
COPY data /opt/jboss/MovieSpotter_data
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
