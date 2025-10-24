#!/bin/sh
# wait-for-it.sh - wait until the given host and port are available

host="$1"
shift
port="$1"
shift

echo "Waiting for $host:$port..."

while ! nc -z "$host" "$port"; do
  sleep 1
done

echo "$host:$port is available, starting application..."
exec "$@"
