#!/bin/bash

set -e

echo "Building project..."

mvn clean package -DskipTests -q

echo "Running ranker..."

java \
    -Xms4g \
    -Xmx12g \
    -XX:+UseParallelGC \
    -jar target/redrob-ranker.jar \
    --candidates candidates.jsonl \
    --jd job_description.txt \
    --out submission.csv \
    --verbose

echo "Done."

echo "Submission written to submission.csv"