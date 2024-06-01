import java.util.Scanner;

public class Employee extends Salary{
    private int hours;

    public Employee() {
        setHours(hours);
    }

    public int getHours() {
        return hours;
    }
    public void setHours(int hours) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the hour : ");
        this.hours = in.nextInt();
    }
    @Override
    public int salary() {
        int salary;
        int bonus;
        salary = hours * 1000;
        if(hours>40){
            salary=salary+5000;
        }
        return salary;
    }
}
