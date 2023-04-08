package org.example;

import java.io.*;

public class WorkWithLine extends Thread {
    private String line;
    String s;
    File file;
    long sum, resultLine, result;
    int amt;

    public WorkWithLine(File file1) {
        file = file1;
    }

//        not work :(
/*    public void workWithLine(){
        if (line.contains("\"id\":13,\"number\":")) {

            String str = line ;
            s= (str.substring(str.lastIndexOf("\"id\":13,\"number\":")));

            String resultStr = s.substring(s.indexOf("\"id\":13,\"number\":") + 1, s.indexOf("}"));

            resultLine = Long.parseLong(resultStr);
            sum += resultLine;
            amt++;
        }

    }

 */

    @Override
    public synchronized void start() {
        super.start();
    }

    @Override
    public void run() {
        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            while ((line = bufferedReader.readLine()) != null) {

//                workWithLine();
                if (line.contains("\"id\":13,\"number\":")) {

                    s = line.substring(line.indexOf("\"id\":13,\"number\":"));
                    s = s.replaceAll("\"id\":13,\"number\":", "0r");
                    s = s.substring(0, s.indexOf("0r") + 15);
                    s = s.substring(s.indexOf("0r") + 2);

                    resultLine = Long.parseLong(s);
                    sum += resultLine;
                    amt++;
                }
                line = bufferedReader.readLine();
            }
            result = (sum / amt);
            System.out.println("Result = " + result);


            fileResult();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void fileResult() {
        String resultToFile = "Result = " + result + "!!!!";

        String fileNameResult = "Bsjadqwpurbvjfqs_raf.txt";
        File fileResult = new File("result", fileNameResult);

        try {
            FileWriter fstream1 = new FileWriter(fileResult);
            BufferedWriter out1 = new BufferedWriter(fstream1);
            out1.write(resultToFile);
            out1.close();
        } catch (Exception e)
        {System.err.println("Error in file cleaning: " + e.getMessage());}

//        try {
//            PrintWriter pw = new PrintWriter(fileResult, resultToFile);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
