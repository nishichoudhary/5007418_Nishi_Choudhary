package Exercise_4;

public class EmployeeManagement
{
    private Employee[] employees;
    private int size;

    public EmployeeManagement(int capacity)
    {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee)
    {
        if (size < employees.length)
        {
            employees[size++] = employee;
        }
        else
        {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    public Employee searchEmployeeById(String employeeId)
    {
        for (int i = 0; i < size; i++)
        {
            if (employees[i].getEmployeeId().equals(employeeId))
            {
                return employees[i];
            }
        }
        return null;
    }
    public void traverseEmployees()
    {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean deleteEmployeeById(String employeeId)
    {
        for (int i = 0; i < size; i++)
        {
            if (employees[i].getEmployeeId().equals(employeeId))
            {
                for (int j = i; j < size - 1; j++)
                {
                    employees[j] = employees[j + 1];
                }
                employees[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }
}
