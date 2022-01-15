import java.util.Scanner;
class app{
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);
        int arr[]=new int[10];
        for(int i=0;i<10;i++){
            System.out.println("Enter the data");
            int t=sc.nextInt();
            arr[i]=t;
        }
        for(int i:arr){
            System.out.println(i);
        }
        sc.close();
    }
}