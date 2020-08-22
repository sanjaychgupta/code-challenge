package dailyCodingChallenge;

import com.sun.xml.internal.bind.v2.TODO;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListProblem {
    public static Instant start;
    public static Instant end;
    /**
     * This is the Daily Coding Problem.
     * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
     * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
     *
     * @param list to hold list of numbers.
     * @param sum to hold Sum.
     * @return Boolean.
     */

    private static boolean checkSumExist(List<Integer> list, int sum){
        // TODO :- Needs to optimize because currently it is taking  O(N^2)
        if(list.isEmpty())
            return false;
         // Boolean b =list.stream().anyMatch(e->list.contains(sum-e.intValue()));
        for (Integer integer : list) { //  O(N)
            int temp = sum - integer;
            if(list.contains(temp))//  O(N)
                return true;
        }

        return false;
    }


    public static void main(String args[]){

        List<Integer> list = new ArrayList <>(Arrays.asList(1,2,-3,4,5,3));
        start = Instant.now();
        System.out.println(ListProblem.checkSumExist(list,8));
        end = Instant.now();
        System.out.println(Duration.between(start, end).getNano());
    }
}
