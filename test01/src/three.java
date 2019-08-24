import java.util.ArrayList;
import java.util.Scanner;

public class three {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        jiaohuan(a);
    }

    private static void jiaohuan(int a[]){
        int temp=0;
        for (int i = 0; i <a.length-1; i++) {
            for (int j = i+1; j <a.length; j++) {
                if((a[i]+a[j])%2==1){
                    if(a[i]>=a[j]){
                        temp=a[i];
                        a[i]=a[j];
                        a[j]=temp;
                    }
                }
            }
        }
        for (int m = 0; m <a.length ; m++) {
            System.out.print(a[m]+" ");
        }
    }
}
