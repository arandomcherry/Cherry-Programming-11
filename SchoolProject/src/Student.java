public class Student {

    private String firstName; //here are the fields
    private String lastName;
    private String grade;
    private int idNum;
    static int studentNum = 1;

    Student() { //here is the constructor for default values
        firstName = "";
        lastName = "";
        grade = "N/A";
        idNum = studentNum;
        studentNum++;
    }
    Student(String firstName, String lastName, String grade){ //here is the constructor for setting values
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.idNum = studentNum;
        studentNum++; //this is for unique idNum for each newly created object
    }

    public String toString(){ //this is to print of the name and grade in correct format instead of printing out the memory location
        return "Name: " +this.firstName + " " +this.lastName + " Grade: " +this.grade;
    }


    public String getFirstName() {
        return firstName;
    } //these are the getters and setters to access private fields

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getIdNum(int i) {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

}


