import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        Integer[][] a= new Integer[N][M];
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <M ; j++) {
                a[i][j]=sc.nextInt();
            }
        }
        int count=0;
        int s=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++) {
                int k = a[i][j];
                if(k!=0){
                    s++;
                }
                while (k > 0) {
                        if (i - 1 < 0 || a[i - 1][j] == 0||k-a[i - 1][j]>0) {
                            count++;
                        }
                        if (j + 1 > M-1 || a[i][j + 1] == 0||k-a[i ][j+1]>0) {
                            count++;
                        }
                        if (i + 1 > N-1 || a[i + 1][j] == 0||k-a[i + 1][j]>0) {
                            count++;
                        }
                        if (j - 1 < 0 || a[i][j - 1] == 0||k-a[i][j-1]>0) {
                            count++;
                        }
                        k--;
            }
        }
    }
        //count=count+s*2;
        System.out.println(count);
    }
}
