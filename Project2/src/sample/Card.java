package sample;

import java.io.*;

public class Card {

    private String name;
    private String url;
    private String posNum = "";

    //Requires: nothing
    //Modifies: this
    //Effects: sets the default value
    public Card(){
        url = "";
        name = "";
    }

    //Requires: Strings
    //Modifies: this
    //Effects: set the name and url
    public Card(String name, String url){
        this.name = name;
        this.url = url;
    }


    //Requires: Strings
    //Modifies: this
    //Effects: set the name and url
    public String getName(){ return name; }
    public String getUrl(){ return url; }

    //Requires: String
    //Modifies: file entered
    //Effects: write the name and url of itself into the file (name) entered
    public void writeToFile(String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name + ";"+url+"\r");
        bw.close();
    }

    //Requires: nothing
    //Modifies: nothing
    //Effects: returns the position number of the card in the 'All-Cards' collection
    public String getPosNum(){
        int i = name.indexOf(" ");
        posNum = name.substring(0, i);

        return posNum;
    }


    //Requires: nothing
    //Modifies: nothing
    //Effects: returns the name of the card
    public String toString(){
        return name;
    }


}
