import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.IntStream;

public class PlayGround {
    public static void main(String[] args) {
        /*BitSet bset = new BitSet();
        bset.set(0);
        bset.set(1);
        bset.set(2);
        bset.set(4);
        bset.set(6);
        System.out.println(bset.nextClearBit(0));
        // three missing number
        printMissingNumber(new int[]{8}, 10);
        System.out.println(reverseInt(1234));
        System.out.println(romantoNumer("MMMDCCXXIV"));
        // System.out.println(divide(-2147483648, -1));
        List <Employee> emplist = new ArrayList();
        emplist.add(new Employee(10, "Sanjay", "Engineer"));
        emplist.add(new Employee(5, "Amit", "BU"));
        emplist.add(new Employee(3, "Zoravar", "IT"));
        emplist.sort(Comparator.comparing(Employee::getName));
        emplist.forEach(System.out::println);
        Comparator <Employee> comparator = (e1, e2) -> {
            if (e1.getId() > e2.getId()) {
                return 1;
            }
            return 0;
        };
        int number = 10;
        boolean b = number > 1 && IntStream.range(2, number).noneMatch(index -> (number & index) == 0);
        IntStream.range(1, 5).forEach(System.out::println);*/



        /*System.out.println(fib(46));
        System.out.println(fastFibonacciDoubling(46));
        System.out.println(largeFib(46));
*/
        Instant start;
        Instant end;

        start = Instant.now();
        System.out.println("fibonacci = " + fib(46));
        end = Instant.now();
        System.out.println(Duration.between(start, end).getSeconds());

        start = Instant.now();
        System.out.println("fibonacci = " + fastFibonacciDoubling(1000000));
        end = Instant.now();
        System.out.println(Duration.between(start, end).getNano());

        start = Instant.now();
        System.out.println("fibonacci = " + largeFib(1000000));
        end = Instant.now();
        System.out.println(Duration.between(start, end).getNano());

    }

    static int divide(int dividend, int divisor) {
        long dividendLong = dividend;
        int sign = ((dividendLong < 0) ^
                (divisor < 0)) ? -1 : 1;

        dividendLong = Math.abs(dividendLong);
        divisor = Math.abs(divisor);


        int quotient = 0;

        while (dividendLong >= divisor) {
            dividendLong -= divisor;
            if (dividendLong == 5) {
                System.out.println();
                System.out.println();
            }
            quotient++;
        }

        return (sign * quotient);
    }

    private static int reverseInt(int num) {
        long reverse = 0;
        while (num != 0) {
            reverse = (reverse * 10) + (num % 10);
            num = num / 10;
        }

        if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE)
            throw new RuntimeException("crossed integer limit");
        return (int) reverse;
    }

    private static int romantoNumer(String roman) {
        Map <Character, Integer> m = new HashMap() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int result = 0;
        char prevChar = roman.charAt(0);
        for (int i = 0; i < roman.length(); i++) {
            result += m.get(roman.charAt(i));
            if (m.get(roman.charAt(i)) > m.get(prevChar))
                result -= (2 * m.get(prevChar));
            prevChar = roman.charAt(i);
        }
        return result;
    }

    private static void printMissingNumber(int[] numbers, int count) {
        int missingCount = count - numbers.length;
        BitSet bitSet = new BitSet(count);

        for (int number : numbers) {
            bitSet.set(number - 1);
        }

        System.out.printf("Missing numbers in integer array %s, with total number %d is %n",
                Arrays.toString(numbers), count);
        int lastMissingIndex = 0;

        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);

        }

    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    private static BigInteger fastFibonacciDoubling(int n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        int m = 0;
        for (int bit = Integer.highestOneBit(n); bit != 0; bit >>>= 1) {
            // Loop invariant: a = F(m), b = F(m+1)

            // Double it
            BigInteger d = multiply(a, b.shiftLeft(1).subtract(a));
            BigInteger e = multiply(a, a).add(multiply(b, b));
            a = d;
            b = e;
            m *= 2;


            // Advance by one conditionally
            if ((n & bit) != 0) {
                BigInteger c = a.add(b);
                a = b;
                b = c;
                m++;

            }
        }
        return a;
    }

    private static BigInteger multiply(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }

    private static BigInteger largeFib(int n) {
        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c;

        while (n > 0) {
            //System.out.println(b);
            c = a.add(b);
            a = b;
            b = c;
            n--;
        }

        return a;
    }

}



