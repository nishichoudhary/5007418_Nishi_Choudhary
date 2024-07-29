package MVCPatternExample;

public class TestMVCPattern
{
    public static void main(String[] args)
    {
        Student model = retrieveStudentFromDatabase();

        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        controller.setStudentName("Nishi");
        controller.setStudentId("12");
        controller.setStudentGrade("A");

        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase()
    {
        Student student = new Student();
        student.setName("Riya");
        student.setId("11");
        student.setGrade("B");
        return student;
    }
}