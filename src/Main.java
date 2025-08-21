import java.util.*;
abstract class Employee{
    private String name;
    private int Id;


    public Employee(String name, int Id){
        this.name = name;
        this.Id = Id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return Id;
    }
    public abstract double calculateSalary();

    @Override

    public String toString(){
        return "Employee [name ="+name+", Id="+Id+", salary="+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee{

    private double montlySalary;

    public FullTimeEmployee(String name, int Id, double montlySalary){
        super(name, Id);
        this.montlySalary = montlySalary;
    }
    @Override
    public double calculateSalary(){
        return montlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int Id, int hoursWorked, double hourlyRate) {
        super(name, Id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

class PayrollSystem{
    private ArrayList<Employee> employeeList;

    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int Id){
        Employee employeeToRemove = null;
        for(Employee employee:employeeList){
            if(employee.getId()==Id){
                employeeToRemove =employee;
                break;
            }
        }

        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees(){
        for(Employee employee:employeeList){
            System.out.println(employee);
        }
    }
}


public class Main{
    public static void main(String args[]) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee(" SAHIL", 1, 80000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee(" ABHAY", 2, 40, 100);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Initial Employee Details: ");
        payrollSystem.displayEmployees();
        System.out.println("Removing Employees: ");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employee Details: ");
        payrollSystem.displayEmployees();
    }
}