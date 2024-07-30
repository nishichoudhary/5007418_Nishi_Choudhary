package Exercise_5;

public class TaskManagement
{
    private Node head;

    private class Node
    {
        Task task;
        Node next;

        Node(Task task)
        {
            this.task = task;
            this.next = null;
        }
    }

    public void addTask(Task task)
    {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        }
        else
        {
            Node current = head;
            while (current.next != null)
            {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTaskById(String taskId)
    {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId))
            {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks()
    {
        Node current = head;
        while (current != null)
        {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public boolean deleteTaskById(String taskId)
    {
        if (head == null) return false;

        if (head.task.getTaskId().equals(taskId))
        {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null && !current.next.task.getTaskId().equals(taskId))
        {
            current = current.next;
        }

        if (current.next != null)
        {
            current.next = current.next.next;
            return true;
        }

        return false;
    }
}
