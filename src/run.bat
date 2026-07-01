@echo off

echo Building...
call mvn clean package -DskipTests

echo Running...

java ^
-Xms4g ^
-Xmx12g ^
-XX:+UseParallelGC ^
-jar target\redrob-ranker.jar ^
--candidates candidates.jsonl ^
--jd job_description.txt ^
--out submission.csv ^
--verbose

pause