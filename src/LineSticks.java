import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/**
 * Problem Statement
 * You have several sticks of different lengths, and a stick case of a fixed length.
 * We want to find 2 sticks that just fit in the case.
 *
 * Input
 * [L1] [L2] ... [LN]
 * [target]
 * The first line of input contains a list of integers separated by a whitespace. This list represents the lengths of the sticks.
 *
 * The second line of input contains an integer target. This integer represents the length of the case.
 *
 * Output
 * Output a pair of lengths whose sum is equal to target.
 *
 * [La] [Lb]
 * Output should be ordered in ascending order. (e.g. "1 2" is acceptable. "2 1" is not)
 *
 * If you find 2 or more pairs, output the pair which contains the stick of the shortest length. (e.g. If the target is 5, and you find both "1 4" and "2 3", output "1 4")
 *
 * In case there is no such pairs, output a single -1
 *
 * -1
 *
 *
 *
 *
 * Input Example
 * 1 2 3 4 5
 * 6
 * Output Example
 * 1 5
 */


class LineSticks {
    /*
     * In this program we execute one for loop to convert input string array into integer array
     * Then process these inputs to find the pairs which can achieve the target length
     * as we are only going through the array only once in each loop my conclusion of complexity is O(n)
     * where the complexity increases linearly with number of inputs.
     *
     */

    static String getPair(int[] sticks, int target){
        int[] a= sticks;
        int sum=target;
        Set<Integer> pairs=new TreeSet<Integer>();
        int min=0;
        boolean exist=false;
        for(int i=0;i<a.length;i++) {
            if(pairs.contains(a[i]) ) {
                if(min==0) {
                    min = sum-a[i];
                }else {
                    min=Math.min(min, sum-a[i]);
                }
                exist=true;
            }
            pairs.add(sum-a[i]);
        }

        if(exist) {
            return (min<(sum-min)?min+" "+(sum-min):(sum-min)+" "+min);
        }else {
            return "-1";
        }
    }

    public static void main(String[] args) throws java.lang.Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] sticks = input.split(" ");
        int[] intSticks= new int[sticks.length];
        int i=0;
        for(String str:sticks){
            intSticks[i]=Integer.parseInt(str);
            i++;
        }
        int target = Integer.parseInt(br.readLine());

        System.out.println(getPair(intSticks, target));


    }

}