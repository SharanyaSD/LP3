import java.util.*;

public class Practice {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int no;
        System.out.print("Enter no: ");
        no=sc.nextInt();
        System.out.println("Recursive output- ");
        System.out.print(fiborec(no));
        System.out.println();
        System.out.println("Non - Recursive output- ");
        System.out.print(fibononrec(no));

    }

    static int fiborec(int n) {
        if (n ==1)
            return 0;
        else if(n==2)return 1;
        return fiborec(n-1)+fiborec(n-2);
    }

    static int fibononrec(int n) {
        if (n ==1)
            return 0;
        else if(n==2)return 1;
        int f1=0,f2=1,f3=0;
        for(int i=3;i<=n;i++) {
            f3=f1+f2;
            f1=f2;
            f2=f3;
        }
        return f3;
    }

}
