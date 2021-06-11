package sample;

import javafx.scene.control.CheckBox;

import java.io.*;
import java.util.ArrayList;

public class ManageTasks {


   private static ArrayList<Task> tasks = new ArrayList<>();

    //Requires: nothing
    //Modifies: Tasks.txt
    //Effects: clears the file Tasks.txt
    public void clearFile() throws IOException {
        FileWriter fw = new FileWriter("Tasks.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("");
        bw.close();
    }

    //Requires: nothing
    //Modifies: nothing
    //Effects: create and return an arraylist with values retrieved from Tasks.txt
    public ArrayList<Task> createTasks() throws IOException {
        tasks.clear();
        FileReader fr = new FileReader("Tasks.txt");
        BufferedReader br = new BufferedReader(fr);
        String taskName;
        while ((taskName = br.readLine()) != null) {
            tasks.add(new Task(taskName));
        }
        return tasks;
    }

}
