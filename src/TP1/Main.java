package TP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        SAT sat = new SAT(66,4);
        sat.computeCloses();
//        sat.printClauses();
        sat.outputDimacs("model");
//        Runtime rt = Runtime.getRuntime();
//        Process proc = rt.exec("minisat model result");
//        BufferedReader stdInput = new BufferedReader(new
//                InputStreamReader(proc.getInputStream()));
//
//        String s = null;
//        while( (s =  stdInput.readLine()) != null){
//            System.out.println(s);
//        }
    }
}
