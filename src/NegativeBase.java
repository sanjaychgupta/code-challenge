import java.util.ArrayList;
import java.util.List;

public class NegativeBase {
    public static int[] solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;
        if (A.length == 0) {
            int b[] = {};
            return b;
        } else {
            for (int i = 0; i < A.length; i++) {
                result = (int) (result + (A[i] * Math.pow(-2, i)));
            }
        }
        int decimal = (int) Math.ceil(result / 2);
        List <Integer> l = toNegativeBase(decimal, -2);
        int[] binary = l.stream().mapToInt(Integer::intValue).toArray();


        return binary;
    }

    static List toNegativeBase(int n, int negBase) {
        // If n is zero then in any base
        // it will be 0 only
        List <Integer> l = new ArrayList <>();
        if (n == 0) {
            l.add(0);
        }
        String converted = "";
        while (n != 0) {
            // Get remainder by negative base,
            // it can be negative also
            int remainder = n % negBase;
            n /= negBase;

            // if remainder is negative,
            // add Math.abs(base) to it
            // and add 1 to n
            if (remainder < 0) {
                remainder += (-negBase);
                n += 1;
            }

            // convert remainder to String add into the result
            l.add(remainder);
        }
        return l;
    }

    public static void main(String[] args) {
        int A[] = {1, 0, 0, 1, 1, 1};
        //int A[] ={0,0,1,0,1,1};
        System.out.println(solution(A));

    }
}
