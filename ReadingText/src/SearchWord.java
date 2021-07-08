import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SearchWord {

    //every line in the text will be added to an individual index position in the lines Arraylist
    //ans will store every index position of the arraylist that the word is in
    private ArrayList<String> lines = new ArrayList<>();
    private ArrayList<Integer> ans = new ArrayList<>();


    //Requires: String
    //Modifies: nothing
    //Effects: returns the number of words in a line
    public int getWordNum(String line) throws IOException {
        int num = 0;
        for(int i = 0; i<line.length(); i++){ //for loop gets the number of spaces in a line
            if(line.charAt(i) == ' '){
                num++;
            }
        }
        return num+1; //the number of words is the number of spaces plus one
    }

    //Requires: String
    //Modifies: nothing
    //Effects: returns every index position of the arraylist that the word is in (only when the user enters a real word)
    public ArrayList<Integer> searchWord(String userWord) throws IOException {
        lines = new ArrayList<>();
        ans = new ArrayList<>(); //the line positions of all occurrences of the word is stored inside an Arraylist to better design testCases
        FileReader fr = new FileReader("in.txt"); //read info from "in.txt"
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null) { //store each line from "in.txt" to the Arraylist 'lines'
            lines.add(line);
        }
        br.close();

        String uWord = userWord.toLowerCase(); //get the lowercase form of user's word, for easier comparison later
        String word;
        int wordEnd;
        String nextRange;
        char letter;
        int ascii;
        int asciiBef;
        int linePos = 0;
        int wordsNum;
        int wordOn;

        for (String eachLine : lines) { //loops through the lines arraylist
            wordOn = 0; //set to default, starting from the beginning of the new line
            word = "";
            nextRange = eachLine;
            wordsNum = getWordNum(eachLine); //get the new number of words in the new line
            linePos++; //this will later be returned to the user in the 'ans' arraylist, to tell the user which line the word is found

            while (wordOn <= wordsNum) { //loops through all words in the line

                wordOn++;

                if (wordOn != wordsNum) { //the end of a word is the next space when it is not at the end of the line
                    wordEnd = nextRange.indexOf(" ");
                } else { //else it would be a period
                    wordEnd = nextRange.indexOf(".");
                }

                if (wordEnd == 1) { //this indicates that the word only consists of one letter
                    letter = nextRange.charAt(0);
                    if (letter == 'a') { //only the letter 'a' works as a word
                        word = "a";
                    }
                } else { //happens when the word is more than one letter
                    for (int i = 0; i < wordEnd; i++) { //loops through the letters in a single word
                        letter = nextRange.charAt(i);
                        ascii = letter; //convert the letter to its ascii form

                        //can only be added to form a word if the letter is either an alphabet or a hyphen (e.g. high-school is counted as a word)
                        if (ascii >= 65 && ascii < 91 || ascii >= 97 && ascii < 123 || ascii == 45) {
                            if (i > 0) { //this if statement is to avoid IndexOutOfBounds error
                                asciiBef = nextRange.charAt(i - 1);
                                letter = (char) ascii; //get the ascii of the letter before the current letter
                                if (asciiBef == 39) { //when the letter is an apostrophe, the loop breaks and all letters between the space and the apostrophe form a word
                                    break; //Break when : e.g."Babbage" is a word and "Babbage's" is not a word
                                }
                            }
                            word += letter; //appending the letter onto the word
                        }
                    }
                }

                //if the word is one letter and that letter is anything other than "a", it is not a word and therefore word is set to empty
                if(word.length() == 1 && !word.equals("a")){
                    word = "";
                }
                //first checks that the word is not 'empty', then compare the word in the line with the user entered word in LOWERCASE forms (this program is designed to be not case sensitive)
                if (!word.equals("") && word.toLowerCase().equals(uWord)) { //make capitals okay too
                    ans.add(linePos); //arraylist 'ans' adds that line position (an occurrence of the searched word)
                }
                word = ""; //set word back to 'empty'/default
                nextRange = nextRange.substring(wordEnd + 1); //nextRange now 'moves' forward and becomes shorter (going on to the next word)
            }
        }
        return ans; //returning the answer in String
    }
}


