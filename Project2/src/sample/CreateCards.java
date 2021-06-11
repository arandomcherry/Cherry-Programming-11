package sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CreateCards {

    private ArrayList <Card> allCards = new ArrayList<>();
    private ArrayList<Card> userCards = new ArrayList<>();

    //Requires: nothing
    //Modifies: nothing
    //Effects: retrieve what is stored inside allCardsName.txt and allCardsURL.txt, create new cards with all the
    //names and URLs, and add them in number order to an ArrayList that will be returned
    public ArrayList storeCards() throws IOException {
        FileReader frN = new FileReader("allCardsName.txt");
        BufferedReader brN = new BufferedReader(frN);
        FileReader frU = new FileReader("allCardsURL.txt");
        BufferedReader brU = new BufferedReader(frU);
        String cardName;
        String url;

        while((cardName = brN.readLine()) != null && (url = brU.readLine()) != null) {
            allCards.add(new Card(cardName, url));
        }
        brU.close();
        brN.close();
        return allCards;
    }

    //Requires: String
    //Modifies: nothing
    //Effects: retrieve what is stored inside the file entered, create new cards with all the
    //names and URLs, and add them in number order to an ArrayList that will be returned
    public ArrayList storeUserCards(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String cardName;
        String url;
        String line;
        int pos;

        while((line = br.readLine()) != null){
            pos = line.indexOf(";");
            cardName = line.substring(0, pos);
            url = line.substring(pos+1);
            userCards.add(new Card(cardName, url));
        }
        br.close();
    return userCards;
    }




}
