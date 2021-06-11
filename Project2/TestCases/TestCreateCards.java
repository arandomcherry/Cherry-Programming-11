import org.junit.Before;
import org.junit.Test;
import sample.Card;
import sample.ClearFiles;
import sample.CreateCards;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestCreateCards {

    CreateCards testCreateCards;

    @Before
    public void setUp() {
        testCreateCards = new CreateCards();

    }

    //this tests to see if all cards are stored into the arraylist
    //I picked one random card and two cards at each end points to test for both names and urls
    @Test
    public void testAllCardsStored() throws IOException {
        ArrayList <Card> list = testCreateCards.storeCards();
        assertEquals(list.size(), 40); //first ensure there's actually 40 items in the list
        assertEquals(list.get(22).getName(), "23 A - Cow");
        assertEquals(list.get(39).getName(), "40 C - Watermelon");
        assertEquals(list.get(0).getName(), "1 SSS - Kurisu Makise");

        assertEquals(list.get(15).getUrl(), "https://s-media-cache-ak0.pinimg.com/736x/da/83/3a/da833a1236a3b917e1951533d02ec245.jpg");
        assertEquals(list.get(0).getUrl(), "https://static.wikia.nocookie.net/steins-gate/images/8/83/Kurisu_profile.png/revision/latest?cb=20141222010103");
        assertEquals(list.get(39).getUrl(), "https://images.vexels.com/media/users/3/137097/isolated/preview/83d2c229e8dc6aee2e8e5316f335c5a3-watermelon-icon-by-vexels.png");

    }


    //this tests to see if all cards from a certain txt file can be retrieved and stored
    //I also picked two endpoint cards and one random card to write to the test.txt file
    //I compare both the names and the urls
    @Test
    public void testUserCardsStored() throws IOException { //also test duplicates

        ClearFiles clear = new ClearFiles();
        clear.clearFiles("test.txt");
        Card c1 = new Card("33 B - Chicken", "https://images-na.ssl-images-amazon.com/images/I/71c0aln6S3L._AC_SL1500_.jpg");
        c1.writeToFile("test.txt");
        Card c2 = new Card("1 SSS - Kurisu Makise", "https://static.wikia.nocookie.net/steins-gate/images/8/83/Kurisu_profile.png/revision/latest?cb=20141222010103");
        c2.writeToFile("test.txt");
        Card c3 = new Card("40 C - Watermelon", "https://images.vexels.com/media/users/3/137097/isolated/preview/83d2c229e8dc6aee2e8e5316f335c5a3-watermelon-icon-by-vexels.png");
        c3.writeToFile("test.txt");

        ArrayList <Card> uList = testCreateCards.storeUserCards("test.txt");
        assertEquals(uList.size(), 3); //first ensures the correct numbers are being stored
        assertEquals(uList.get(0).getName(), "33 B - Chicken");
        assertEquals(uList.get(1).getName(), "1 SSS - Kurisu Makise");
        assertEquals(uList.get(2).getName(), "40 C - Watermelon" );

        assertEquals(uList.get(0).getUrl(), "https://images-na.ssl-images-amazon.com/images/I/71c0aln6S3L._AC_SL1500_.jpg");
        assertEquals(uList.get(1).getUrl(), "https://static.wikia.nocookie.net/steins-gate/images/8/83/Kurisu_profile.png/revision/latest?cb=20141222010103");
        assertEquals(uList.get(2).getUrl(), "https://images.vexels.com/media/users/3/137097/isolated/preview/83d2c229e8dc6aee2e8e5316f335c5a3-watermelon-icon-by-vexels.png");




    }
}
