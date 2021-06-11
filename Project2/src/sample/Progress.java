package sample;

import java.io.*;
import java.util.ArrayList;

public class Progress {

    private double progress;

    private ArrayList<String> boxStatus = new ArrayList<String>();


    //Requires: nothing
    //Modifies: this
    //Effects: sets the default value
    Progress(){
        progress = 0.0;
    }

    //Requires: double
    //Modifies: this
    //Effects: sets the progress value
    Progress(double progress){
        this.progress = progress;
    }



    //Requires: String
    //Modifies: Progress.txt
    //Effects: write the String entered to Progress.txt
    public void writeToProgressFile(String value) throws IOException {
        FileWriter fw = new FileWriter("Progress.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(value);
        bw.close();
    }

    //Requires: String
    //Modifies: BoxStatus.txt
    //Effects: append the String entered to BoxStatus.txt
    public void writeToBoxFile(String booleanV) throws IOException {
        FileWriter fw = new FileWriter("BoxStatus.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(booleanV + "\r");
        bw.close();
    }

    //Requires: nothing
    //Modifies: BoxStatus.txt
    //Effects: clears BoxStatus.txt
    public void clearBoxFile() throws IOException {
        FileWriter fw = new FileWriter("BoxStatus.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("");
        bw.close();
    }


    //Requires: nothing
    //Modifies: nothing
    //Effects: retrieve the single value from Progress.txt and return it as a Double
    public double getFromProgressFile() throws IOException {
        FileReader fr = new FileReader("Progress.txt");
        BufferedReader br = new BufferedReader(fr);
        return Double.parseDouble(br.readLine());
    }

    //Requires: nothing
    //Modifies: nothing
    //Effects: retrieve values from BoxStatus.txt, store them in an arraylist and return the arraylist
    public ArrayList storeBoxStatus() throws IOException {
        FileReader fr = new FileReader("BoxStatus.txt");
        BufferedReader br = new BufferedReader(fr);
        String status;
        while((status = br.readLine()) != null){
            boxStatus.add(status);
        }
        return boxStatus;
    }


}
