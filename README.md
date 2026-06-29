# Redrob Ranker

> High-performance Java candidate ranking engine built for the Redrob AI Hiring Challenge.

## Features

- Java 17
- Maven Multi-Module
- Streaming JSONL parser
- Multi-signal ranking engine
- Top-K heap ranking
- CSV output
- CPU-only execution
- Scales to 100,000+ candidates

## Modules

| Module | Responsibility |
|---------|---------------|
| core | Domain models & contracts |
| ingestion | JSONL streaming |
| scoring | Candidate scoring |
| ranking | Top-K ranking & CSV |
| cli | Command-line interface |

## Build

```bash
mvn clean package
```

## Run

```bash
java -jar cli/target/redrob-ranker.jar \
    --candidates candidates.jsonl \
    --jd job_description.txt \
    --out rankings.csv
```

## Project Status

🚧 Under active development.

## License

MIT
