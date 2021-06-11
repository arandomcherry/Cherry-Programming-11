import org.junit.Before;
import org.junit.Test;
import sample.Probability;
import static org.junit.Assert.assertTrue;

public class TestProbability {

    Probability testProbability;

    @Before
    public void setUp(){
        testProbability = new Probability();
    }

    //this tests if the probabilities are reasonable
    @Test
    public void testProbability() {
        int num;
        int SSSTimes = 0;
        int SSTimes = 0;
        int STimes = 0;
        int ATimes = 0;
        int BTimes = 0;
        int CTimes = 0;
        for (int i = 0; i <= 200; i++) { //I loop for 200 times and record how many times each rarity occurs
            num = testProbability.drawCardNum();
            assertTrue(num <= 40); //this makes sure that the number being drawn is not greater than 40 (within the range)
            if(testProbability.drawCardNum() <= 9){
                SSSTimes ++;
            }else if(num > 9 && num<= 13){
                SSTimes ++;
            }else if(num > 13 && num <= 20){
                STimes ++;
            }else if(num>20 && num <=27){
                ATimes ++;
            }else if(num >27 && num<=33){
                BTimes ++;
            }else{
                CTimes ++;
            }
        }

        //these are quite risky, because random is something not as controllable
        //I tried to make the risk to fail as small as possible, and at the same time making sure that each probability is reasonable for its rarity
        //NOTE: this may not succeed 100% of times, but it will for 99%
        assertTrue(SSSTimes < 10 && SSSTimes!=0);
        assertTrue(ATimes > 20);
        assertTrue(BTimes >30);
        assertTrue(CTimes > 40);
        assertTrue(STimes >15);
        assertTrue(SSTimes <20 && SSTimes >2);

    }
}
