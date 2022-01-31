import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Employee {

    private Scanner sc = new Scanner(System.in);
    private List<Employee> employeeList = new ArrayList<>();

    private String firstName;
    private String lastName;
    private int salary;


    public Employee(String firstName, String lastName, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Employee() {
    }

    public void switchMethod() {
        final int PRINTSUM = 1;
        final int DISPLAY = 2;
        final int ADDEMP = 3;
        final int EXIT = 4;
        int start = -52;

        while (start != EXIT) {
            System.out.println("Podaj opcję od 1-4. 1 - Wyświetl sumę wynagordzeń. 2 - Wyświetl wszystkich. 3 - Dodaj pracownika." +
                    " 4 - Wyjdź z programu.");
            switch (start = sc.nextInt()) {
                case (PRINTSUM):
                    System.out.println("Suma wynagrodzeń wynosi:");
                    System.out.println(sumSalary());
                    break;
                case (DISPLAY):
                    System.out.println("Lista wszystkich pracowników w firmie:");
                    getAllData();
                    break;
                case (ADDEMP):
                    sc.nextLine();
                    addNewEmployee();
                    break;
                case (EXIT):
                    System.out.println("Zamykanie programu.");
                    break;
                default:
                    System.out.println("Zła liczba, spróbuj ponownie.");
            }
        }
    }
    private void getAllData(){
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
    public  void add5Employees() {
        for (int i = 0; i < 5; i++) {
                    System.out.println("Podaj imię.");
                    firstName = sc.nextLine();
                    System.out.println("Podaj nazwisko");
                    lastName = sc.nextLine();
                    Employee employee = new Employee(firstName, lastName, exceptionSalary());
                    employeeList.add(employee);

            }
        }

    private int exceptionSalary(){
        while(true){
            try{
                System.out.println("Podaj wynagordzenie");
                salary = sc.nextInt();
                sc.nextLine();
                return salary;
            } catch (InputMismatchException e) {
                System.out.println("You entered string, please enter integer value");
                sc.nextLine();
            }
        }
    }
    private int sumSalary(){
        int sum = 0;
        for (Employee employee : employeeList) {
            sum += employee.salary;
        }
        return sum;
    }
    private  void addNewEmployee() {
            System.out.println("Podaj imię.");
            firstName = sc.nextLine();
            System.out.println("Podaj nazwisko");
            lastName = sc.nextLine();
            Employee employee = new Employee(firstName, lastName, exceptionSalary());
            employeeList.add(employee);
        }

    @Override
    public String toString() {
        return "Salary for " + firstName + " " + lastName + " is " + salary;
    }
}
