public class Practise {
    public static void linearFibo(int n) {
        int n1 = 0, n2 = 1, sum;
        for (int i = 0; i < n; i++) {

            System.out.println(n1);
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
    }

    public static void uptoFibo(int n) {
        int n1 = 0, n2 = 1, sum;
        for (; n1 <= n; ) {
            System.out.println(n1);
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;

        }
    }

    public static int recuFibo(int n) {

        if (n <= 1) {
            return n;
        }
        return recuFibo(n - 1) + recuFibo(n - 2);
    }

    /*public int solution(int[] A) {
        // write your code in Java SE 8
        int maxlenth=0;
        for (int i =0;i<A.length; i++){
            if(A[i]==0){
                continue;
            }
            boolean b = false;
            for (int j =1;j<A[i];j++)
            {   if((i+j)>A.length-1)
                break;
                if(A[i]<=A[i+j]){
                    b= true;
                }else{
                    b=false;
                }
            }
            if(b){
                if(maxlenth<A[i])
                    maxlenth=A[i];
            }
        }
        return maxlenth;
    }*/
    public int solution(int[] A) {
        // write your code in Java SE 8
        int maxlenth = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                continue;
            }
            boolean b = false;
            int len = 0;
            for (int k = A[i]; k > maxlenth; k--) {
                if (b) {
                    len = k + 1;
                    break;
                }
                for (int j = 1; j < k; j++) {
                    if ((i + j) > A.length - 1)
                        break;
                    if (k <= A[i + j]) {
                        b = true;
                    } else {
                        b = false;
                        break;
                    }
                }
            }
            if (b && maxlenth < len) {
                maxlenth = len;
            }
        }
        return maxlenth;
    }



    // main method.
    public static void main(String[] args) {
        uptoFibo(9);
        System.out.println(recuFibo(9));

        Practise p = new Practise();
        int A[] = {6, 5, 5, 6, 2, 2};
        System.out.println(p.solution(A));

    }
}
