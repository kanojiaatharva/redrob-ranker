package com.ak.redrob.scoring.util;

public final class ScoreUtils {

    private ScoreUtils(){}

    public static double clamp(double value){

        return Math.max(
                0,
                Math.min(1, value)
        );

    }

}
