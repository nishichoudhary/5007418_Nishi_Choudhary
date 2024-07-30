package Exercise_5;

public class Main
{

    public static void main(String[] args)
    {
        TaskManagement taskMgmt = new TaskManagement();

        taskMgmt.addTask(new Task("T001", "Complete project report", "Pending"));
        taskMgmt.addTask(new Task("T002", "Review code", "In Progress"));
        taskMgmt.addTask(new Task("T003", "Update documentation", "Completed"));

        System.out.println("All Tasks:");
        taskMgmt.traverseTasks();

        System.out.println("\nSearching for T002:");
        Task task = taskMgmt.searchTaskById("T002");
        if (task != null)
        {
            System.out.println(task);
        }
        else
        {
            System.out.println("Task not found.");
        }

        System.out.println("\nDeleting task T003:");
        boolean deleted = taskMgmt.deleteTaskById("T003");
        if (deleted)
        {
            System.out.println("Task T003 deleted.");
        }
        else
        {
            System.out.println("Task not found.");
        }

        System.out.println("\nAll Tasks After Deletion:");
        taskMgmt.traverseTasks();
    }
}
