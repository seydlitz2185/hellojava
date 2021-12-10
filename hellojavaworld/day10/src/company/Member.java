package company;

public class Member {
    private String name;
    private double salary;
    private int year;
    private int month;

    public Member(String name, double salary, int year, int month) {
        this.name = name;
        this.salary = salary;
        this.year = year;
        this.month = month;
    }

    public double raiseSalary/*_percent*/(Member m,Integer i){
        m.salary *= (1 + i/100);
        return m.salary;
    }
//    public double raiseSalary/*_immediate*/(Member m,)
    public String getName (Member m){
        return  m.name;
    }

    public double getSalary(Member m){
        return  m.salary;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", year=" + year +
                ", month=" + month+", ";
    }

    public void print(){
        System.out.println(this.toString());
    }
}
