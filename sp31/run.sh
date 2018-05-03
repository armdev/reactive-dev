#!/usr/bin/env bash

set -e

eval $(docker-machine env default)

docker service create --name eureka --replicas=3 eureka
docker service create --name client --replicas=1 client