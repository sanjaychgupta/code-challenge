import java.util.Arrays;
/**
 * Task Swift 4 We call an array bi-valued if it contains at most two different numbers.For example: [4,5, 5,4, 5] is bi-valued (it contains two different numbers: 4 and 5), but  [1, 5,4, 5] is not bi-valued (it contains three different numbers: 1,4 and 5). What is the length of the longest bi-valued slice (continuous fragment) in a given array A? Write  a function: public func solution (A: inout (Int)> Int that, given an array A consisting of N integers, returns the length of the longest bi- valued slice in A. Examples: 1. Given A = [4, 2  , 2, 4, 2), the function should return 5, because the whole array is bi- valued 2. Given A = (1,2, 3, 2), the function should return 3. The longest bi-valued slice is  [2, 3, 21 3. Given A = [0, 5, 4, 4, 5, 12], the function should return 4. The longest bi-valued slice is [5, 4, 4, 5).  Given A = [4, 4], the function should return 2. Write an efficient algorithm for the following assumptions: N is an integer within the range [1. 100,000); each element o  f array A is an integer within the range [-1,000,000,000.1,000,000,000]. Copyright 2009-2019 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited*/
public class AdjacentArray {

    public int solution(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {

            for (int j = 0; j < A.length; j++) {
                if (i == j) {

                } else {
                    for (int k = i + 1; k < j; k++) {
                        if (Arrays.binarySearch(A,k)>=0) {
                            break;
                        } else {
                            int temp = Math.abs(i - j);
                            if (temp > max)
                                max = temp;
                        }
                    }
                }

            }

        }
        if (max == 0)
            return -1;
        return max;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        AdjacentArray s = new AdjacentArray();
        int[] A = { 1, 4, 7, 3, 3, 5 };
        System.out.println(Arrays.binarySearch(A,5));
        System.out.print(s.solution(A));
    }

}

