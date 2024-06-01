import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        int [] marks1 = new int[5];
        int [] marks2 = new int[5];
        int [] union = new int[marks1.length+marks2.length];
        int i=0;
        int j=0;
        Scanner in = new Scanner(System.in);
        for(int z = 0 ; z < 5 ; z ++)
        {
            System.out.printf("Enter the %d elements of first Array : ",z+1);
            marks1[z] = in.nextInt();
        }
        System.out.println();
        for(int t = 0 ; t < 5 ; t ++)
        {
            System.out.printf("Enter the %d elements of Second Array : ",t+1);
            marks2[t] = in.nextInt();
        }
        //Union of an array
        for( i = 0 ; i < 5 ; i ++)
        {
            union[j]=marks1[i];
            j++;
        }
        for(i =0; i < 5 ; i++)
        {
            union[j]=marks2[i];
            j++;
        }
        for (int k=0 ; k<marks1.length+marks2.length;k++)
        {
            System.out.println(union[k]);
        }
    }
}
