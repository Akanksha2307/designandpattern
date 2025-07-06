public class MVCTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Alice");
        student.setId("S101");
        student.setGrade("A");

        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);
        controller.updateView();
        controller.setStudentName("Alice Johnson");
        controller.setStudentGrade("A+");
        controller.updateView();
    }
}
