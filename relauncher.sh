#!/bin/sh
IMAGE="ileossa/gs-spring-boot-docker"
docker pull $IMAGE
STATUS="$(docker pull $IMAGE | grep -w "Image is up to date" | wc -l)"
echo $STATUS
if [ $STATUS -eq 1 ];then
	echo "up to date"
else
	echo "restart"
	docker ps | grep $IMAGE | awk '{print $1}' | xargs docker stop
	./launcher.sh
fi
