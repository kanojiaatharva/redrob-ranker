package com.ak.redrob;

import com.ak.redrob.cli.RankCommand;
import picocli.CommandLine;

/**
 * Application entry point.
 */
public final class App {

    private App() {
    }

    public static void main(String[] args) {

        int exitCode = new CommandLine(new RankCommand())
                .execute(args);

        System.exit(exitCode);

    }

}