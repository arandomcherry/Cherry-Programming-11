package sample;

import java.io.*;

public class Duplicate {

    private int duplicatesNum;

    //Requires: String
    //Modifies: "Duplicates.txt"
    //Effects: write the String entered to "Duplicates.txt"
    public void writeToFile(String duplicate) throws IOException {
        FileWriter fw = new FileWriter("Duplicates.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(duplicate);
        bw.close();

    }

    //Requires: nothing
    //Modifies: nothing
    //Effects: get and return the value in "Duplicates.txt" in Integer form
    public int getFromFile() throws IOException {
        FileReader fr = new FileReader("Duplicates.txt");
        BufferedReader br = new BufferedReader(fr);
        duplicatesNum = Integer.parseInt(br.readLine());
        return duplicatesNum;
    }



}
