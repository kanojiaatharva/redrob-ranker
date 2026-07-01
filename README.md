
# redrob-ranker 🎯

> **A deterministic, interpretable multi-signal candidate ranking engine — built for the Redrob Intelligent Candidate Discovery Hackathon**

![Java](https://img.shields.io/badge/Java-17-orange)
![Maven](https://img.shields.io/badge/Maven-3.9+-blue)
![Build](https://img.shields.io/badge/Build-Passing-brightgreen)
![License](https://img.shields.io/badge/License-MIT-green)

---

## Overview

`redrob-ranker` is a high-performance candidate ranking engine designed to rank up to **100,000 candidate profiles** against a target Job Description without making any external API calls at runtime.

Instead of relying on LLM inference, the engine combines deterministic scoring strategies with behavioral signals to produce rankings that are:

- Fast (CPU-only)
- Explainable
- Reproducible
- Resistant to keyword stuffing
- Resistant to synthetic / honeypot profiles

Each ranked candidate includes both a numerical score and a human-readable explanation describing why they ranked highly.

---

# Architecture

```text
               candidates.jsonl
                      │
                      ▼
           Jackson Streaming Parser
                      │
                      ▼
             Honeypot Detection
                      │
                      ▼
      Parallel Multi-Signal Scoring Engine
 ┌──────────────┬─────────────┬──────────────┬──────────────┐
 │ Skill Match  │ Career      │ Experience   │ Location     │
 └──────────────┴─────────────┴──────────────┴──────────────┘
                      │
                      ▼
        Behavioral Readiness Modifier
                      │
                      ▼
        Top-K Priority Queue (O(N log K))
                      │
                      ▼
             submission.csv
```

## Scoring Components

| Signal | Weight | Purpose |
|--------|-------:|---------|
| Skill Match | 35% | AI/ML skills, proficiency, endorsements, duration |
| Title & Career | 25% | Current & historical role alignment |
| Experience | 15% | Relevant experience, education & certifications |
| Location | 5% | Geographic preference & relocation |
| Behavioral Readiness | × Modifier | Platform engagement & hiring readiness |

---

# Key Design Decisions

## Why not keyword-only scoring?

Keyword-only ranking is vulnerable to resumes containing long lists of unrelated buzzwords.

Instead, skills are validated using:

- proficiency
- endorsements
- experience duration
- career descriptions
- current role consistency

## Behavioral signals as a multiplier

Behavior reflects hiring readiness rather than technical capability.

Instead of adding points, behavioral readiness scales the technical score:

```
Final Score =
Weighted Technical Score × Behavioral Modifier
```

This prevents inactive candidates from outranking equally qualified active candidates.

## Honeypot Detection

Profiles are rejected when they exhibit statistically implausible patterns such as:

- impossible work histories
- expert skills with zero experience
- impossible education timelines
- perfect assessment scores across every category

## Efficient Ranking

The project never sorts all candidates.

Instead it maintains only the best **K** candidates using a bounded priority queue.

Complexity:

```
Time:  O(N log K)

Memory: O(K)
```

---

# Quick Start

```bash
git clone https://github.com/YOUR_USERNAME/redrob-ranker.git
cd redrob-ranker

mvn clean package

java -jar target/redrob-ranker.jar \
  --candidates candidates.jsonl \
  --jd job_description.docx \
  --out submission.csv \
  --verbose
```

---

# Project Structure

```text
redrob-ranker
├── src
│   ├── main
│   │   ├── java/com/ak/redrob
│   │   │   ├── cli
│   │   │   ├── model
│   │   │   ├── parser
│   │   │   ├── ranking
│   │   │   ├── scoring
│   │   │   └── App.java
│   │   └── resources
│   └── test
├── candidates.jsonl
├── pom.xml
└── README.md
```

---

# Scoring Overview

## Skill Match

Measures:

- required skills
- proficiency
- endorsements
- duration
- keyword stuffing penalties

## Title & Career

Evaluates:

- current title
- previous AI/ML titles
- consulting penalties
- product company boosts

## Experience

Considers:

- years of experience
- AI-specific experience
- education tier
- certifications

## Location

Scores:

- preferred hiring locations
- relocation willingness

## Behavioral Readiness

Modifier derived from:

- response rate
- notice period
- profile completeness
- recruiter engagement
- GitHub activity
- interview completion

---

# Performance

Target benchmark on modern desktop hardware:

| Metric | Expected |
|---------|----------|
| Candidates | 100,000 |
| Runtime | 45–90 seconds |
| Memory | < 16 GB |
| Complexity | O(N log K) |

---

# Submission Format

The generated CSV follows:

```text
candidate_id,rank,score,reasoning
```

Example:

```csv
candidate_id,rank,score,reasoning
C001,1,0.9732,"Senior AI Engineer | 6yr exp | 14 AI skills matched | Behavioral: 1.18x"
```

---

# Engineering Principles

- Deterministic scoring
- Explainable rankings
- CPU-only execution
- Streaming ingestion
- Minimal memory footprint
- Modular architecture
- Production-style logging
- Unit & integration tested

---

# Future Improvements

- Learning-to-Rank models
- Semantic embeddings
- Dynamic JD parsing
- Distributed execution
- Explainability dashboard
- REST API

---

# License

MIT License

---

## Acknowledgements

Built for the **Redrob Intelligent Candidate Discovery Hackathon** to demonstrate scalable, interpretable, and production-oriented candidate ranking without runtime LLM dependencies.
