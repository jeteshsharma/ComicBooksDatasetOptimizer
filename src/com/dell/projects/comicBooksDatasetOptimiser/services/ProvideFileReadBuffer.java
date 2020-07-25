package com.dell.projects.comicBooksDatasetOptimiser.services;

import java.io.BufferedReader;
import java.io.FileReader;

public class ProvideFileReadBuffer {

    private BufferedReader bufferedReader=null;

    private FileReader fileReader=null;

    public BufferedReader getReader(String fileAddress) {



        try {
            this.fileReader = new FileReader(fileAddress);
        } catch (Exception e) {
            System.out.println("AT ProvideFileReadBuffer.java:" + e);
        }

        this.bufferedReader = null;

        try {
            this.bufferedReader = new BufferedReader(fileReader);
        } catch (Exception e) {
            System.out.println("AT ProvideFileReadBuffer:" + e);
        }

        return this.bufferedReader;


    }

    public void close() {
        try {
            this.bufferedReader.close();
        } catch (Exception e) {
            System.out.println("At OpenAndCloseLogFile.java,method close(),key:bufferedReader" + e);
        }
        try {
            this.fileReader.close();
        } catch (Exception e) {
            System.out.println("At OpenAndCloseLogFile.java,method close(),key:fileReader" + e);
        }

    }

}
