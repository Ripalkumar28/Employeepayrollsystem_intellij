package org.example.employee;

import java.util.ArrayList;

abstract class Employee{ //abstraction
    //access modifier
    private int id;
    private String name;

    //constructor
    public Employee(int id, String name) {//parameterize constructor
        this.id = id;
        this.name = name;
    }

    //getter//encapsulation
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //abstract method ,incomplete method call abstract method
    public abstract double calculateSalary();

    //polymorphism
    @Override
    //toString- convert value to String
    public String toString(){
        return "Employee [name="+name+",id="+id+",salary="+calculateSalary()+"]";
    }
}

//inheritance using extends keyword
class FullTimeEmployee extends Employee{

    private double monthlySalary;

    //constructor
    public FullTimeEmployee(int id, String name, double monthlySalary) {
        super(id, name);//we use parent class to inharate  using super keyword
        this.monthlySalary = monthlySalary;
    }
    //Getter

    public double getMonthlySalary() {
        return monthlySalary;
    }


    @Override//polymorphisam -1

    public double calculateSalary() {
        return monthlySalary;
    }
}

//Class PartTime Employee
class PartTimeEmployee extends Employee{//extends-inheritance
    private int hourWorked;
    private double hourlyRate;
    //constructor
    public PartTimeEmployee(int id, String name, int hourWorked, double hourlyRate) {
        super(id, name);//using super keyword
        this.hourWorked = hourWorked;
        this.hourlyRate = hourlyRate;
    }
    //Getters

    public int getHourWorked() {
        return hourWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    @Override //polymorphism - 2
    public double calculateSalary() {
        return hourWorked*hourlyRate;
    }
}
//payroll System
class PayrollSystem {
    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }

        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployee(){
        for (Employee employee: employeeList) {
            System.out.println(employee);
        }
    }
}

    public class Main {
        public static void main(String[] args) {
           PayrollSystem payrollSystem = new PayrollSystem();
           FullTimeEmployee emp1 = new FullTimeEmployee(1,"nilay",15000);
           PartTimeEmployee emp2 = new PartTimeEmployee(2,"bharat",45,150);
           FullTimeEmployee emp3 = new FullTimeEmployee(3,"Bhavik",12450);


           payrollSystem.addEmployee(emp1);
           payrollSystem.addEmployee(emp2);
           payrollSystem.addEmployee(emp3);

           System.out.println("initial employee Details: ");
           payrollSystem.displayEmployee();
           System.out.println("Removing employees: "   );
           payrollSystem.removeEmployee(1);
           System.out.println("Remaining employee Details:");
           payrollSystem.displayEmployee();
        }

}