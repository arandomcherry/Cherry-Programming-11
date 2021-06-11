package sample;

import java.util.Random;

public class Probability {

    int num;
    int cardNum;


    //Requires: nothing
    //Modifies: nothing
    //Effects: return a number from 1-40, probability for each number ranges vary
    public int drawCardNum() {
        num = (int) ((Math.random() * 101));
        if (num <= 10 & num>0 || num >= 30 && num < 40 || num >= 70 && num < 75) { //C
            cardNum = (int) ((Math.random() * 7) + 34);
        } else if (num > 10 && num < 20 || num >= 50 && num < 60 || num >= 80 && num < 85) { //B
            cardNum = (int)((Math.random()*6)+28);
        } else if (num >= 20 && num < 25 || num >= 60 && num < 65 || num >= 85 && num < 95) {
            cardNum = (int) ((Math.random() * 7) + 21); //A
        } else if (num == 100 || num == 0) { //SSS
            cardNum = (int) ((Math.random() * 9) + 1);
        } else if (num >= 95 && num < 100) { //SS
            cardNum = (int) ((Math.random() * 4) + 10);
        } else {
            cardNum = (int) ((Math.random() * 7) + 14); //S
        }
        return cardNum;
    }
}

