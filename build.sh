#!/usr/bin/env bash
mvn clean install tomcat7:run-war -Dspring.profiles.active=development