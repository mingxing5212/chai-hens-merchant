#!/usr/bin/env bash
exec 2>&1
exec 1>validate.log
set -x
wait_file() {
  local file="$1"; shift
  local wait_seconds="${1:-60}"; shift # 10 seconds as default timeout

  until test $((wait_seconds--)) -eq 0 -o -f "$file" ; do sleep 1; done

  ((++wait_seconds))
}

wait_file "application.port" || {
    echo "no application.port created in 60 seconds!"
    exit 1
}

while true; do
    URL="http://127.0.0.1:$(cat application.port)/management/health";
    JSON="$(curl -G -m 1 -s ${URL})"
    STATUS="$( echo ${JSON} | python -c 'import sys, json; print json.load(sys.stdin)["status"]')"
    echo ${STATUS}
    if [ "UP" = "${STATUS}" ]; then
        exit 0
    fi
done
