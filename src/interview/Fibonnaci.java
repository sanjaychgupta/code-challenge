package interview;

public class Fibonnaci {

    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        int c = 0;
        int n = 10;
        System.out.println(a);
        System.out.println(b);

        while (n >= 2) {
            c=a+b;
            System.out.println(c);
            a=b;
            b=c;
            n--;
        }
        System.out.println(fibRec(10));
    }

    public static int fibRec(int n){
        if(n==0){
            return 0;
        }if(n==1){
            return 1;
        }
        return fibRec(n-1)+ fibRec(n-2);
    }

}
