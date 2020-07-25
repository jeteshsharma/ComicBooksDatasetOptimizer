package com.dell.projects.comicBooksDatasetOptimiser.services;

import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parse {

    private final String regex = "\\[(.*?)\\]\\s?|(.*?)\\s";

    private Pattern compiledPattern;

    private Matcher matcher = null;

    private BufferedReader bufferedReader;

    public Parse(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public String[] parseSingleLine() {

        String[] entityValues = new String[5];


        String line = null;

        try {
            line = bufferedReader.readLine();

        } catch (Exception e) {
            System.out.println(e);
        }


        if (line == null)
            return null;

        matcher = compiledPattern.matcher(line);


        int i = 0;

        while (matcher.find()) {
            entityValues[i] = "" + (matcher.group(1) != null ? matcher.group(1) : matcher.group(2));

            i++;
        }
        return entityValues;
    }


}
