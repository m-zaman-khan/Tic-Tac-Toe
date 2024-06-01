public abstract class Salary {
    public static void main(String[] args) {
        Employee em=new Employee();
        Service_Employee se=new Service_Employee();
        System.out.println("Salary of Service Employee "+se.salary());
        System.out.println("Salary of Admin Employee "+em.salary());
    }
    public abstract int  salary();
}
