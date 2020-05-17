
/***
 * Task description
 *
 * XOR is a standard operation on bits. If X and Y are two bits (1s or 0s), then X XOR Y equals 1 when X ≠ Y. Otherwise X XOR Y = 0.
 * 0 XOR 1 = 1 XOR 0 = 1
 * 0 XOR 0 = 1 XOR 1 = 0
 *
 * The XOR operation can be extended to non-negative integers. Let K and L be two such integers, and A and B their binary representations. (For the sake of simplicity, if one of them is shorter, let us add some leading zeros, so that A and B are of the same length.) The bitwise XOR of K and L (denoted as K bitxor L) is defined in the following way: We build a sequence of bits C by taking the XOR of bits from A and B at the same positions. C is a binary representation of K bitxor L.
 *
 * For example, for K = 12 and L = 21 we obtain:
 *
 * A = 01100 B = 10101 C = 11001
 * and C is a binary representation of K bitxor L = 25.
 *
 * Now we can define the bitwise XOR product. If M and N are two non-negative integers, such that M ≤ N, then their bitwise XOR product is the bitwise XOR of all integers from M to N:
 * M bitxor (M+1) bitxor ... bitxor (N−1) bitxor N
 * Note that the bitwise XOR is associative; that is, the order in which this operation is performed does not matter.
 *
 * For example, the bitwise XOR product of M = 5 and N = 8 is 12, because:
 *
 * 5 bitxor 6 bitxor 7 bitxor 8 = 3 bitxor 15 = 12
 * Write a function:
 *
 * int solution(int M, int N);
 *
 * that, given two non-negative integers M and N, returns their bitwise XOR product.
 *
 * For example, given M = 5 and N = 8, the function should return 12, as explained in the example above.
 *
 * Assume that:
 *
 * M and N are integers within the range [0..1,000,000,000];
 * M ≤ N.
 * Complexity:
 *
 * expected worst-case time complexity is O(log(N));
 * expected worst-case space complexity is O(1).
 */
public class XORRange {
    public static int findXORRange(int m, int n) {
        int[] patternTracker;

        if(m % 2 == 0)
            patternTracker = new int[] {n, 1, n^1, 0};
        else
            patternTracker = new int[] {m, m^n, m-1, (m-1)^n};
        return patternTracker[(n-m) % 4];
    }

    public static void main(String[] args) {
        System.out.println(findXORRange(5,8));
    }
}
