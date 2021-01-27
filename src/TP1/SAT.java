package TP1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class SAT {
    private int n, k, nbVar, nbClauses;
    private ArrayList<String> clauses;

    public SAT(int n, int k) {
        this.n = n;
        this.k = k;
        this.nbVar = n*k;
        this.clauses = new ArrayList<>();
    }

    public void computeCloses(){
        computePresentClause();
        computeNotAllInOneBasquetClause();
    }
    private void computePresentClause(){
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < k; j++) {
                sb.append((i + j*n) + " ");
            }
            clauses.add(sb.toString());
            nbClauses++;
        }
    }

    private void computeNotAllInOneBasquetClause(){
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j < n; j++) {
                if(i+j <= n && i!=j){
                    for (int l = 0; l < k; l++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append((-(i + l*n)) + " " +(-(j + l*n) + " " + (-((i+j) + l*n))));
                        clauses.add(sb.toString());
                        nbClauses++;
                    }
                }
            }
        }
    }

    public void printClauses(){
        for(String clause : clauses){
            System.out.println(clause);
        }
    }

    public void outputDimacs(String outputFile){
        FileWriter writer = null;
        try {
            writer = new FileWriter(new File(outputFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.write("p cnf " + nbVar + " " + nbClauses + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String clause : clauses){
            try {
                writer.write(clause + " 0\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
