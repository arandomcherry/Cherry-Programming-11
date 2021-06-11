package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.util.ArrayList;

//duplicates will either add to x_ or turn into "money"
//box1 has issues
public class Controller {

    public Button btnDrawCard;
    public ImageView imageView;
    public Label lblCardName;
    public CheckBox check1;
    public CheckBox check2;
    public CheckBox check3;
    public CheckBox check4;
    public CheckBox check5;
    public CheckBox check6;
    public CheckBox check7;
    public TextField txtTask;
    public AnchorPane anchor2;
    public AnchorPane anchor;
    public ImageView imageCCard;
    public ListView<String> listUserCards;
    public ProgressBar progressBar;
    public Label lblCardNum;
    public Label lblCName;
    public static int cardNum = 0;
    public Button btnSortRecent;
    public static int duplicateCard = 0;
    public Label lblDuplicates;
    public Button btnRecover;
    public Button btnNewRound;
    public static boolean cardsRecovered = false;
    public Label lblAlert;
    public static ArrayList<Task> tasks = new ArrayList<>();


    // this recovers all the tasks and check boxes' statues from where the user last saved when the user clicks the "Recover" button on the first tab
    public void recover(ActionEvent actionEvent) throws IOException {

        ManageTasks mt = new ManageTasks();
        ArrayList<Task> tasks = mt.createTasks(); //gets all the tasks from the Tasks.txt file and store inside a temporary arraylist

        ArrayList<CheckBox> checkBoxes = new ArrayList<>(); //creates an arraylist to contain all check boxes (for better managing, looping)

        checkBoxes.add(check1); //now add all the 7 check boxes
        checkBoxes.add(check2);
        checkBoxes.add(check3);
        checkBoxes.add(check4);
        checkBoxes.add(check5);
        checkBoxes.add(check6);
        checkBoxes.add(check7);

        Progress p = new Progress();
        progressBar.setProgress(p.getFromProgressFile()); //set progressbar from the progress saved (retrieved from Progress.txt)

        ArrayList statues = new ArrayList(p.storeBoxStatus()); //retrieve box statues fom BoxStatus.txt and store each in a position in the temporary arraylist
        for(int i=0; i<tasks.size(); i++){ //loop through the tasks
            checkBoxes.get(i).setText(tasks.get(i).getName()); //set each check box to the name of the saved task's name
            if(statues.get(i).equals("true")){ //"true" means that it is a task that has been completed
                checkBoxes.get(i).setDisable(true); //if it is completed the task can be disabled and set to already selected
                checkBoxes.get(i).setSelected(true);
            }else if(checkBoxes.get(i).getText().equals("Add New Task")){
                checkBoxes.get(i).setDisable(true); //if it is not a task, just set to disabled
                checkBoxes.get(i).setSelected(false);
            }else{
                checkBoxes.get(i).setSelected(false); //if it it an uncompleted task, set it to not disabled and not selected
                checkBoxes.get(i).setDisable(false);
            }
        }
    }



    //this happen when  the user clicks on the "Draw" button
    public void drawNewCard(MouseEvent actionEvent) throws IOException {

        //happens the first time the 'Draw' (at the time it's the Recover button) button is clicked
        if(!cardsRecovered) {

            cardsRecovered = true; //after this click it will be recovered (this boolean is static)

            //get the number of duplicates and drawCard numbers from the files
            Duplicate d = new Duplicate();
            duplicateCard = d.getFromFile();
            lblDuplicates.setText(String.valueOf(duplicateCard));
            CardNum cn = new CardNum();
            cardNum = cn.getFromFile();
            lblCardNum.setText(String.valueOf(cardNum));

            btnDrawCard.setText("Draw"); //now the button can be set to "Draw" button and no longer the "Recover" button

        } else{ //user needs to click on the button first to let it recover to what was saved
            CreateCards cc = new CreateCards();
            ArrayList<Card> allCards = new ArrayList<>(cc.storeCards());
            ArrayList<Card> cards = new ArrayList<>(cc.storeUserCards("collections.txt")); //this gets all the cards the user stored inside the txt file and 'puts' it inside an arraylist
            boolean foundDup = false; //to keep track if duplicate cards occur

            if (!(cardNum == 0)) { //can only draw a card when the cardNum that user has is greater than 0
                CardNum cn = new CardNum();
                cardNum--; //cardNum decrease by 1 when user draws a card
                cn.writeToFile(String.valueOf(cardNum)); //the cardNum value is being stored to the CardNum.txt (saved automatically)
                lblCardNum.setText(String.valueOf(cardNum)); //this updates the new cardNum after the decrease
                Probability p = new Probability();
                int rand = p.drawCardNum(); //stores a random number from 1-40 into rand (different range numbers have different probabilities)
                Card c = new Card(allCards.get(rand).getName(), allCards.get(rand).getUrl()); //creates a new Card Object with that card 'ID' (index 0 is an empty Card Object)
                Image i = new Image(c.getUrl());
                imageView.setImage(i); //set image to the card's url

                //this enhanced for loop checks to see if that new Card is already in the user's collection (is it a duplicate?)
                for (Card card : cards) {
                    if (c.getName().equals(card.getName())) { //if it finds the same name, the card is a duplicate
                        lblCardName.setText("Duplicated Card: " + c.getName()); //let's the user know it is a duplicate card
                        duplicateCard++;
                        lblDuplicates.setText(String.valueOf(duplicateCard)); //update the number of duplicate cards the user has after the increase
                        Duplicate d = new Duplicate();
                        d.writeToFile(String.valueOf(duplicateCard)); //write the new update to Duplicates.txt
                        if (duplicateCard == 5) { //5 duplicate cards = 1 new card
                            duplicateCard = 0; //set the value, the file's (Duplicates.txt) text, and the text that user sees of the duplicate cards all back to 0
                            d.writeToFile("0");
                            lblDuplicates.setText("0");
                            cardNum++; //increase cardNum, update it to CardNum.txt, and lets the user see the updated text
                            cn.writeToFile(String.valueOf(cardNum));
                            lblCardNum.setText(String.valueOf(cardNum));
                        }
                        foundDup = true; //duplicate is found and the loop breaks
                        break;
                    }
                }
                if (!foundDup) { //when duplicate card is not found:
                    lblCardName.setText(c.getName()); //label is just simply the card's name
                    c.writeToFile("collections.txt"); //card is stored inside user's collection's text file
                    lblCardNum.setText(String.valueOf(cardNum)); //show to the user the cardNum after one being drawn (decrease)
                }
            }
        }

        }

        //this happens when the user clicks on an item in the listView
    public void displayCards(MouseEvent mouseEvent) throws IOException {

        ObservableList s = listUserCards.getSelectionModel().getSelectedItems(); //s.toString will later show the name of the chosen item in brackets
        String bracketC;
        CreateCards cc = new CreateCards();
        ArrayList <Card> userList = new ArrayList(cc.storeUserCards("collections.txt")); //stores the saved user cards into a temporary arraylist

        for(Card c : userList){ //loops through the userList
            bracketC = "["+c.getName()+"]"; //put the card's name in between square brackets for later comparison
            if(bracketC.equals(s.toString())){ //if a card's name (in square bracket) is the same as the selected items name:
                lblCName.setText(c.getName()); //displays the card's name and its image
                Image i = new Image (c.getUrl());
                imageCCard.setImage(i);
                break; //loop breaks, as it only needs to find that one certain card
            }
        }

    }


    //this happens when the user clicks on the "ADD" button to add their new task into the checkBox
    public void addTask(ActionEvent actionEvent) throws IOException {

        if(txtTask.getText().equals("")){ //makes sure the user doesn't enter nothing
            lblAlert.setText("Can't leave name blank!");
        }else {
            lblAlert.setText(""); //make the warning text "disappear" as now it has a task with name
            Task t = new Task(txtTask.getText()); //create a new task with the name that the user enters
            tasks.add(t); //adds it into a static arraylist
            txtTask.clear();

            ArrayList<CheckBox> checkBoxes = new ArrayList<>();

            //make all the checkBoxes into a temporary arrayList
            checkBoxes.add(check1);
            checkBoxes.add(check2);
            checkBoxes.add(check3);
            checkBoxes.add(check4);
            checkBoxes.add(check5);
            checkBoxes.add(check6);
            checkBoxes.add(check7);

            for (CheckBox box : checkBoxes) {
                if (box.getText().equals("Add New Task")) { //when it shows "Add New Task" for the checkBox it means that there is no new task assigned to it yet
                    box.setText(t.getName()); //set it to the task name and cancel its disable
                    box.setDisable(false);
                    break; //loop breaks as there's no need to continue (already added to a checkBox's text)
                }
            }
        }
    }

    //this saves all the tasks, tasks' progress, and the boxes' statues into each file for each specific usage
    public void saveProgress(ActionEvent actionEvent) throws IOException {

        Progress pr =  new Progress();
        pr.clearBoxFile(); //before saving, it is necessary to clear everything in the files
        ManageTasks mt = new ManageTasks();
        mt.clearFile();

        //add checkBoxes into a temporary arraylist (for better managing, looping)
        ArrayList<CheckBox> checkBoxes = new ArrayList<>();

        checkBoxes.add(check1);
        checkBoxes.add(check2);
        checkBoxes.add(check3);
        checkBoxes.add(check4);
        checkBoxes.add(check5);
        checkBoxes.add(check6);
        checkBoxes.add(check7);

        int boxSelected = 0;

        for (CheckBox box : checkBoxes) { //loops through the 7 checkBoxes

            if (box.isSelected()) { //if box is selected, the task is done and the box is disabled
                boxSelected++; //record how many tasks are completed (for later usage in progressbar)
                box.setDisable(true);
                pr.writeToBoxFile("true"); //it write to BoxStatus.txt file "true" for completed tasks
            }else{
                pr.writeToBoxFile("false"); //otherwise "false" for incomplete tasks
            }
            Task t = new Task(box.getText()); //write all the name of the tasks into Tasks.txt (even "Add New Task" is written, to make sure that all 7 boxes' statues are being stored)
            t.writeToFile();
        }

        double progress = boxSelected * 0.1429; //now the progress is the number of boxes selected (or tasks completed) times (100/7)
        Progress p = new Progress(progress);
        progressBar.setProgress(progress); //update/set the progressbar to that new progress
        p.writeToProgressFile(String.valueOf(progress)); //write the new progress' data into Progress.txt

        if (progress >= 1) { //when progress is over 1, that means all tasks are completed
            cardNum++; //when all tasks are completed, a single "round" is complete, and the user and receive one drawCard to draw a card
            CardNum cn = new CardNum();
            cn.writeToFile(String.valueOf(cardNum)); //updates the new data (increased) for cardNum into CardNum.txt
            if(cardsRecovered){ //only shows the cardNum to user after all cardNum and duplicates' numbers are recovered to avoid confusion
                lblCardNum.setText(String.valueOf(cardNum));
            }

        }
    }

    //this loads all user's cards into the listView in UNSORTED order (also the order to "oldest" to "newest" cards)
    public void loadRecentCards(ActionEvent actionEvent) throws IOException {

        listUserCards.getItems().clear(); //clears everything from the listView
        CreateCards cc = new CreateCards();
        ArrayList <Card> userList = new ArrayList(cc.storeUserCards("collections.txt")); //retrieve saved cards and store inside the temporary userList (arraylist)

        for (Card card : userList) { //loop through the userList and add each card's name into the listView
            listUserCards.getItems().add(card.toString());
        }
    }


    //this load the cards in user's collection into the listView in SORTED ORDER (from 1 to 40)
    public void sortNum(ActionEvent actionEvent) throws IOException {
        listUserCards.getItems().clear(); //clears everything on the listView (to add new things later on)
        CreateCards cc = new CreateCards();
        Sort s = new Sort();

        //a new temporary arraylist containing retrieved user's cards from collections.txt is taken as a parameter for the method 'selectionSort'
        //the returned arrayList is then being stored inside the listSorted ArrayList
        ArrayList <Card> listSorted = s.selectionSort(new ArrayList(cc.storeUserCards("collections.txt")));
        for(Card c : listSorted){ //now adds all items in the sorted order
            listUserCards.getItems().add(c.getName());
        }

    }


    //this lets the user restart progresses and tasks at anytime - plus deleting saved data for both progresses and tasks
    public void startNewRound(ActionEvent actionEvent) throws IOException {

        Progress p = new Progress(); //set progressbar to 0, save its value as 0, and clear all saved box statues
        progressBar.setProgress(0);
        p.writeToProgressFile("0");
        p.clearBoxFile();
        ManageTasks mt = new ManageTasks(); //also clear all saved tasks
        mt.clearFile();

        ArrayList<CheckBox> checkBoxes = new ArrayList<>(); //creates a temporary checkBoxes arraylist

        checkBoxes.add(check1);
        checkBoxes.add(check2);
        checkBoxes.add(check3);
        checkBoxes.add(check4);
        checkBoxes.add(check5);
        checkBoxes.add(check6);
        checkBoxes.add(check7);

        for(CheckBox box : checkBoxes){ //loops through all checkBoxes and set everything for the boxes back to default
            box.setText("Add New Task");
            box.setSelected(false);
            box.setDisable(true);
        }
    }
}
