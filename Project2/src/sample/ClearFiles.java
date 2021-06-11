package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ClearFiles { //this class is mainly to use in testing


    //Requires: String
    //Modifies: file entered
    //Effects: clear the file entered
    public void clearFiles(String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("");
        bw.close();

    }
}
