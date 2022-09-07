package company;

public class Employee extends Member {
    private  String department ;
    public Employee(String name, double salary, int year, int month,String department ) {
        super(name, salary, year, month);
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" + super.toString() +
                "department='" + department + '\'' +
                '}';
    }
}
