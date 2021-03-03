public class Main {

    public static void main(String[] args) {

        School school = new School(); //here I create an instance of the School class

        for(int i=0; i<10; i++) { //now I can go through the for loop to go into my school object and access my method to add a new student each time
            school.addStudent();
        }

        for(int i=0; i<3; i++){ //not I can go through the for loop to go into my school object to access my method of adding a new teacher each time
            school.addTeacher();
        }

        school.showAllStudents(); //I again go into my school object to access my methods for showing all students and all teachers
        school.showAllTeachers();

        school.students.get(5).setFirstName("Cherry"); //this is not on the criteria but I did it just to test :)
        school.students.get(5).setLastName("Tang");
        school.students.get(5).setGrade("B");

        school.deleteStudent(3); //I go into my school object to access my method for deleting student object at a certain index position in the arraylist
        school.deleteStudent(7); //I deleted another one

        school.deleteTeacher(1); //I go into my school object to access my method for deleting a teacher object at a certain index position in the arraylist

        school.showAllStudents(); //I again display both lists by accessing the methods in my school object
        school.showAllTeachers();

    }
}

