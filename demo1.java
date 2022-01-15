import java.util.Scanner;
public class demo1 {

    public static void main(String arg[]){

        int arr[]=new int[10];
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value");
        int a=sc.nextInt();
        System.out.println("value "+a);
        for(int i=0;i<10;i++){
            arr[i]=i;
        }
        sc.close();
    }
}
