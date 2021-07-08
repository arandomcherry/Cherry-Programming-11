import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ReadingTextTest {

    SearchWord testSearch;

    @Before
    public void setUp(){
        testSearch = new SearchWord();

    }

    //this tests to see if the number of occurrences of a word is correct
    @Test
    public void testWordNum() throws IOException {

        assertEquals(testSearch.searchWord("cards").size(), 4); //this is an end word
        assertEquals(testSearch.searchWord("IBM").size(), 3);

    }

    //this tests to see if the locations of a word is correct
    @Test
    public void testWordLocation() throws IOException {
        assertEquals(testSearch.searchWord("cards").toString(), "[1, 6, 15, 15]");
        assertEquals(testSearch.searchWord("However").toString(), "[3, 7, 9]");
        assertEquals(testSearch.searchWord("language").toString(), "[9, 9, 9, 13]" ); //notice this is 'language', not 'languages'
    }

    //this program is designed to not be case sensitive, therefore shouldn't matter if the first letter is capital letter or lowercase letter
    //e.g. searching for 'ibm' will also shows the result of 'IBM'
    @Test
    public void testNotCaseSensitive() throws IOException {
        assertEquals(testSearch.searchWord("programs").toString(), "[7, 9, 13, 15, 15]");
        assertEquals(testSearch.searchWord("Data").toString(), "[6, 7, 7, 13, 15]");
        assertEquals(testSearch.searchWord("ibm").toString(), "[7, 7, 12]");
    }

    //this tests to see a word not in the text will have nothing in the 'ans' arraylist
    @Test
    public void testWordNotThere() throws IOException {

        assertEquals(testSearch.searchWord("Pinetree").size(), 0);
        assertEquals(testSearch.searchWord("examples").size(), 0); //there is the word 'example', but 'examples' should not be found

    }

    //this tests for words that end with a bracket, comma, apostrophe...etc.
    @Test
    public void testSpecialWords() throws IOException {
        assertEquals(testSearch.searchWord("easier").size(), 1);
        assertEquals(testSearch.searchWord("TOTAL").size(), 1);
        assertEquals(testSearch.searchWord("However").size(), 3);
        assertEquals(testSearch.searchWord("high-level").size(), 2);
        assertEquals(testSearch.searchWord("machine-readable").size(), 1);
        assertEquals(testSearch.searchWord("plugboard").size(), 1);
        assertEquals(testSearch.searchWord("Babbage").toString(), "[3]");

        //need more locations test

    }

    //this tests that numbers will not be counted as words, and therefore not be searched
    @Test
    public void testNotWord() throws IOException {

        assertEquals(testSearch.searchWord("1880s").size(), 0); //error here
        assertEquals(testSearch.searchWord("1957[7]").size(), 0);
        assertEquals(testSearch.searchWord("X*2").size(), 0);
        assertEquals(testSearch.searchWord("Y").size(), 0); //change, make only A and a be single word
        assertEquals(testSearch.searchWord("X").size(), 0);
        assertEquals(testSearch.searchWord("+").size(), 0);

        //this tests that letters that are only a part of a word will not be identified (only an entire word can be searched)
        assertEquals(testSearch.searchWord("wi").size(), 0);
        assertEquals(testSearch.searchWord("is").size(), 2);
        assertEquals(testSearch.searchWord("e").size(), 0);
        assertEquals(testSearch.searchWord("s").size(), 0);
        assertEquals(testSearch.searchWord("or").size(), 1); //here 'or' should only appear once as a word, although the letter combination appears in several words
        assertEquals(testSearch.searchWord("A").size(), 9); //'A' can be defined as a single word, which also applies for 'a' (not case sensitive)



    }






}
