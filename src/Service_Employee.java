import java.util.Scanner;

public class Service_Employee extends Salary{
    private int hours;

    public Service_Employee() {
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
        salary = hours * 500;
        if(hours>40){
            salary=salary+2000;
        }
        return salary;
    }
}
