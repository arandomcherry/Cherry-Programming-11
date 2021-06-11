package sample;
import java.util.ArrayList;

public class Sort {


    //Requires: ArrayList <Card>
    //Modifies: ArrayList entered
    //Effects: sort the Cards by it's ID number and returns the sorted arraylist
    public ArrayList selectionSort(ArrayList <Card> list){

        int jNum;
        int indexNum;
        int index;


        for (int i = 0; i < list.size()-1; i++)
        {
            index = i;
            indexNum = Integer.parseInt(list.get(index).getPosNum());
            for (int j = i+1; j < list.size(); j++) {

                jNum = Integer.parseInt(list.get(j).getPosNum()); //needs to store the number individually since the arraylist contains Cards not integers
                if (jNum < indexNum) {
                    index = j;//searching for lowest index
                    indexNum = jNum;
                }
            }
            Card smallerCard = list.get(index);
            list.set(index, list.get(i));//arr[index] = arr[i];
            list.set(i, smallerCard);

        }
        return list;
    }
}
