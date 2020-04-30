public class Practise {
    public static void linearFibo(int n){
        int n1 =0,n2=1,sum;
        for(int i= 0; i<n ;i++){

            System.out.println(n1);
            sum=n1+n2;
            n1=n2;
            n2=sum;
        }
    }
    public static void uptoFibo(int n){
        int n1 =0,n2=1,sum;
        for( ;n1<=n;){
            System.out.println(n1);
            sum=n1+n2;
            n1=n2;
            n2=sum;

        }
    }
    public static int recuFibo(int n){

        if(n<=1){
            return n;
        }
        //rebase comment
        return recuFibo(n-1) + recuFibo(n-2);
    }
    public static void main(String[] args) {
        uptoFibo(9);
        System.out.println(recuFibo(9));

    }
}
