import org.junit.Before;
import org.junit.Test;
import sample.Card;
import sample.Sort;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestSort {


    Sort testSort;

    @Before
    public void setUp(){
        testSort = new Sort();
    }

    //this tests to see if a certain arraylist of cards can be sorted in ascending order
    //I picked a duplicate to see if that can work as well (to be placed side by side)
    @Test
    public void testSortInOrder(){
        ArrayList <Card> list = new ArrayList<>();

        Card c1 = new Card("40 C - Watermelon", "https://images.vexels.com/media/users/3/137097/isolated/preview/83d2c229e8dc6aee2e8e5316f335c5a3-watermelon-icon-by-vexels.png");
        Card c2 = new Card("10 SS - MooMoo-Corn", "https://cdn11.bigcommerce.com/s-aldqfxyzxx/products/787/images/2440/Dabbing_Unicorn__02388.1562336843.500.750.jpg?c=2");
        Card c3 = new Card("18 S - Dolphin", "https://png.pngitem.com/pimgs/s/535-5350797_dolphin-clipart-kawaii-kawaii-cute-cartoon-dolphin-hd.png");
        Card c4 = new Card("4 SSS - Norman", "https://static.wikia.nocookie.net/p__/images/a/a4/Norman_%28Promised_Neverland%29.png/revision/latest/top-crop/width/360/height/360?cb=20201108040858&path-prefix=protagonist");
        Card c5 = new Card("10 SS - MooMoo-Corn", "https://cdn11.bigcommerce.com/s-aldqfxyzxx/products/787/images/2440/Dabbing_Unicorn__02388.1562336843.500.750.jpg?c=2");
        list.add(c1); list.add(c2); list.add(c3); list.add(c4); list.add(c5);

        ArrayList <Card> sList = testSort.selectionSort(list);
        assertEquals(sList.get(0), c4);
        assertEquals(sList.get(1), c2);
        assertEquals(sList.get(2), c5);
        assertEquals(sList.get(3), c3);
        assertEquals(sList.get(4), c1);
    }

}
