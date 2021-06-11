package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Task {

    private String name;

    //Requires: nothing
    //Modifies: this
    //Effects: sets the default value
    Task(){
        name = "";
    }

    //Requires: String
    //Modifies: this
    //Effects: sets the name
    Task(String name){
        this.name = name;
    }

    //Requires: nothing
    //Modifies: nothing
    //Effects: returns the name
    public String getName(){ return name; }


    //Requires: nothing
    //Modifies: Tasks.txt
    //Effects: append the name to Tasks.txt
    public void writeToFile() throws IOException {
        FileWriter fw = new FileWriter("Tasks.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name + "\r");
        bw.close();
    }



}
