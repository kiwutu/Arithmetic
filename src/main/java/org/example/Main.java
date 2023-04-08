package org.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String fileNameResult = "Bsjadqwpurbvjfqs_raf.txt";
        File fileResult = new File("result", fileNameResult);

        try (FileOutputStream fos = new FileOutputStream(fileResult)) {
        } catch (IOException e) {
            e.printStackTrace();
        }


        String fileName = "Bsjadqwpurbvjfqs_data.txt";
        File file = new File("result", fileName);

        WorkWithLine thread = new WorkWithLine(file);
        thread.start();
    }
}