import java.util.ArrayList;
public class School {

    ArrayList<Teacher> teachers = new ArrayList<>(); //here are the arraylists that the class holds
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Courses> courses = new ArrayList<>();

    private String name; //here are the 3 fields of my choosing (all private)
    private int allStudentAverage;
    private int teachersIncome;

    School(){ //here is the constructor that sets the default values
        name = "";
        allStudentAverage= 0;
        teachersIncome = 0;
    }

    School(String name, int allStudentAverage, int teachersIncome){ //here is the constructor to set the values for the object
        this.name = name;
        this.allStudentAverage = allStudentAverage;
        this.teachersIncome = teachersIncome;
    }

    public void addTeacher(){ //this is a method that adds a newly created Teacher object
        teachers.add(new Teacher()); //I used the add() method in ArrayList class
    }

    public void addStudent(){ //this is a method that adds a newly created Student object
        students.add(new Student()); //I used the add() method in ArrayList class to do so
    }

    public void deleteTeacher(int position ){ //this is a method that deletes a teacher from the certain index position entered
        teachers.remove(position); //I used the remove() method in ArrayList to do so
    }

    public void deleteStudent(int idNum){ //this is a method that deletes a student from the position corresponding to the student's idNum entered
        students.remove(idNum); //I used the remove() method in ArrayList to do so
    }

    public void showAllTeachers(){ //this is a method that can show all teachers by going through a for loop
        for(int i=1; i<teachers.size(); i++){
            System.out.println(teachers.get(i)); //I used the get() method in ArrayList to do so
        }
    }

    public void showAllStudents(){ //this is a method that can show all students by going through a for loop
        for (int i=1; i<students.size(); i++){
            System.out.println(students.get(i)); //I used the get() method in ArrayList to do so
        }
    }


    public String getName() { //these are the getters and setters to access the private fields
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAllStudentAverage() {
        return allStudentAverage;
    }

    public void setAllStudentAverage(int allStudentAverage) {
        this.allStudentAverage = allStudentAverage;
    }

    public int getTeachersIncome() {
        return teachersIncome;
    }

    public void setTeachersIncome(int teachersIncome) {
        this.teachersIncome = teachersIncome;
    }

}
