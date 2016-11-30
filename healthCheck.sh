#!/bin/bash
rep=$(curl -s 'http://localhost:8080/health' | jq '.status')
echo "$rep"
if [ "$rep" != "\"UP\"" ]; then
	echo "Call relaunch.sh"
	./relaunch.sh
fi;
