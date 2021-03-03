public class Teacher {

    private String firstName; //here are the fields - all private
    private String lastName;
    private String subject;

    Teacher(){ //here is the constructor that sets the default value
        firstName = "";
        lastName = "";
        subject = "N/A";
    }

    Teacher(String firstName, String lastName, String subject){ //here is the constructor to set values for the object

        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    public String toString(){ //this is to print out the name and subject in correct format instead of printing out the memory location
        return "Name: " +this.firstName + " " +this.lastName + " Subject: " +this.subject;
    }

    public String getFirstName() {
        return firstName;
    } //here are the getters and setters to access private fields

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}

