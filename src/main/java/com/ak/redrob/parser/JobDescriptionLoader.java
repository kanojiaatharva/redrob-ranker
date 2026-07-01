package com.ak.redrob.parser;

import com.ak.redrob.model.JobDescription;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Loads and parses a Job Description.
 *
 * <p>
 * Currently returns a preconfigured JobDescription representing the
 * Redrob Senior AI Engineer role.
 *
 * The file is only validated for existence. Future versions can
 * parse .txt/.docx contents dynamically.
 * </p>
 */
public class JobDescriptionLoader {

    /**
     * Loads a Job Description.
     *
     * @param path JD path
     * @return JobDescription
     * @throws IOException if file doesn't exist
     */
    public JobDescription load(Path path) throws IOException {

        if (!Files.exists(path)) {
            throw new IOException("Job description file not found: " + path);
        }

        return JobDescription.builder()

                .requiredSkills(List.of(
                        "embeddings",
                        "vector search",
                        "retrieval",
                        "ranking",
                        "NLP",
                        "fine-tuning LLMs",
                        "Pinecone",
                        "Weaviate",
                        "Qdrant",
                        "Milvus",
                        "FAISS",
                        "Elasticsearch",
                        "sentence-transformers",
                        "Python",
                        "evaluation frameworks",
                        "NDCG",
                        "MRR",
                        "A/B testing",
                        "RAG",
                        "recommendation systems"
                ))

                .preferredSkills(List.of(
                        "LoRA",
                        "QLoRA",
                        "PEFT",
                        "XGBoost",
                        "learning to rank",
                        "distributed systems",
                        "open source contributions",
                        "Spark",
                        "Kafka"
                ))

                .targetTitles(List.of(
                        "AI Engineer",
                        "ML Engineer",
                        "Machine Learning Engineer",
                        "NLP Engineer",
                        "Data Scientist",
                        "Research Engineer",
                        "Applied Scientist",
                        "Senior Engineer",
                        "Backend Engineer"
                ))

                .targetIndustries(List.of(
                        "Technology",
                        "AI",
                        "ML",
                        "SaaS",
                        "Product",
                        "FinTech",
                        "EdTech",
                        "HealthTech"
                ))

                .redFlags(List.of(
                        "consulting only",
                        "pure research",
                        "no production",
                        "TCS",
                        "Infosys",
                        "Wipro",
                        "Accenture",
                        "Cognizant",
                        "Capgemini"
                ))

                .locationKeywords(List.of(
                        "Pune",
                        "Noida",
                        "Bangalore",
                        "Hyderabad",
                        "Mumbai",
                        "Delhi",
                        "India"
                ))

                .requiredYearsMin(5)

                .requiredYearsMax(9)

                .noticePeriodMaxDays(60)

                .salaryBudgetMaxLpa(45)

                .build();

    }

}