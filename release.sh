#!/bin/bash
set -e
cd `dirname $0`
./mvnw clean package && mv target/*.jar release/
./mvnw clean package -Pwar && mv target/*.war release/