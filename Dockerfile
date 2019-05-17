FROM jboss/wildfly:latest
ADD target/jjdd6-movieSpotter-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/
ADD lib/FilmwebApi-0.3.4.jar /opt/jboss/wildfly/standalone/deployments/
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent
COPY data /opt/jboss/MovieSpotter_data
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
