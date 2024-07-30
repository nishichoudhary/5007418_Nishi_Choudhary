package Exercise_4;

public class Main
{

    public static void main(String[] args)
    {
        EmployeeManagement empMgmt = new EmployeeManagement(5);

        empMgmt.addEmployee(new Employee("Emp1", "Nishi Choudhary", "Manager", 75000.00));
        empMgmt.addEmployee(new Employee("Emp2", "Riya Singh", "Developer", 65000.00));
        empMgmt.addEmployee(new Employee("Emp3", "Pritam Kumar", "Designer", 55000.00));

        System.out.println("All Employees:");
        empMgmt.traverseEmployees();

        System.out.println("\nSearching for Emp2:");
        Employee employee = empMgmt.searchEmployeeById("Emp2");
        if (employee != null)
        {
            System.out.println(employee);
        }
        else
        {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDeleting employee Emp3:");
        boolean deleted = empMgmt.deleteEmployeeById("Emp3");
        if (deleted)
        {
            System.out.println("Employee Emp3 deleted.");
        }
        else
        {
            System.out.println("Employee not found.");
        }

        System.out.println("\nAll Employees After Deletion:");
        empMgmt.traverseEmployees();
    }
}
