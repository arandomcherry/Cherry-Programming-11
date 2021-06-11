package sample;

import java.io.*;

public class CardNum {

    private int drawCardNum;

    //Requires: String
    //Modifies: CardNum.txt
    //Effects: write a String input into CardNum.txt
    public void writeToFile(String cardNum) throws IOException {
        FileWriter fw = new FileWriter("CardNum.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(cardNum);
        bw.close();

    }

    //Requires: nothing
    //Modifies: CardNum.txt
    //Effects: get what is stored inside CardNum.txt, parse that value into Integer and return the Integer value
    public int getFromFile() throws IOException {
        FileReader fr = new FileReader("CardNum.txt");
        BufferedReader br = new BufferedReader(fr);
        drawCardNum = Integer.parseInt(br.readLine());
        return drawCardNum;
    }
}
