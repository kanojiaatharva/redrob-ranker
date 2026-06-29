package com.ak.redrob;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.concurrent.Callable;

@Command(name = "redrob-ranker", mixinStandardHelpOptions = true, version = "1.0.0",
        description = "High-performance candidate ranking engine for Redrob AI Hiring Challenge.")
public class App implements Callable<Integer> {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    @Option(names = {"-c", "--candidates"}, description = "Path to candidates JSONL file.", required = true)
    private File candidatesFile;

    @Option(names = {"-j", "--jd"}, description = "Path to job description text/docx file.", required = true)
    private File jdFile;

    @Option(names = {"-o", "--out"}, description = "Path to output rankings CSV file.", required = true)
    private File outputFile;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        logger.info("Starting Redrob Candidate Ranker Engine...");
        logger.info("Candidates File: {}", candidatesFile.getAbsolutePath());
        logger.info("Job Description File: {}", jdFile.getAbsolutePath());
        logger.info("Output CSV File: {}", outputFile.getAbsolutePath());

        System.out.println("--------------------------------------------------");
        System.out.println("Redrob Candidate Ranker initialized successfully!");
        System.out.println("Candidates: " + candidatesFile.getName());
        System.out.println("Job Description: " + jdFile.getName());
        System.out.println("Output: " + outputFile.getName());
        System.out.println("--------------------------------------------------");

        logger.info("Candidate ranking task finished successfully.");
        return 0;
    }
}
