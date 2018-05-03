#!/usr/bin/env bash

set -e

eval $(docker-machine env default)

docker service create --name eureka --replicas=5 eureka