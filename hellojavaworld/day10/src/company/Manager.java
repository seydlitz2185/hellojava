package company;

public class Manager extends Member{
    private String rank;

    public Manager(String name, double salary, int year, int month, String rank) {
        super(name, salary, year, month);
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Manager{" + super.toString() +
                "rank='" + rank + '\'' +
                '}';
    }
}
