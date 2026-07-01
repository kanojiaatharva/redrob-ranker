package com.ak.redrob.ranking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Performs a final audit of ranked candidates.
 */
public class HoneypotAuditReport {

    private static final Logger log =
            LoggerFactory.getLogger(
                    HoneypotAuditReport.class
            );

    /**
     * Audits ranked candidates.
     *
     * Expected:
     *
     * Zero honeypots.
     */
    public void audit(

            List<RankedCandidate> ranked,

            int honeypotsFiltered) {

        System.out.println();

        System.out.println(
                "========== AUDIT =========="
        );

        System.out.printf(
                "Top Candidates : %d%n",
                ranked.size()
        );

        System.out.printf(
                "Honeypots Filtered : %d%n",
                honeypotsFiltered
        );

        if (honeypotsFiltered == 0) {

            log.info(
                    "No honeypot candidates detected."
            );

        } else {

            log.warn(
                    "{} honeypot candidates were excluded.",
                    honeypotsFiltered
            );

        }

        System.out.println(
                "==========================="
        );

    }

}