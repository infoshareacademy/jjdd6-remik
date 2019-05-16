Dockerfile

FROM jboss/wildfly
​ADD target/ApkaWebowa.war /opt/jboss/wildfly/standalone/deployments/
​RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

uruchomienie kontenerow z compose (i przebudoanie obrazow na sile): docker-compose up -d --build --force-recreate



version: "2"
services:
  db:
    image: mysql
    environment:
      - MYSQL_ROOT_PASSWORD=pass123
      - MYSQL_DATABASE=NazwaBazy
      - MYSQL_USER=root
      - MYSQL_PASSWORD=pass123
    ports:
      - portBazy:3306
    command: mysqld --character-set-server=utf8 --collation-server=utf8_unicode_ci --init-connect='SET NAMES UTF8;' --innodb-flush-log-at-trx-commit=0
  app:
    build:
      context: ./ProjektWebowy
    ports:
      - PortWIldflya:8080
      - PortAdminaWildflya:9990
    depends_on:
      - db
    links:
      - db
    dns: 8.8.8.8