import java.io.IOException;
import java.util.ArrayList;

public class SearchWordUsage {

    public static void main (String[]args) throws IOException {

        SearchWord sw = new SearchWord();

        ArrayList list = new ArrayList(sw.searchWord("cards"));
        System.out.println(list);



    }
}
