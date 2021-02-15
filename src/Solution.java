import java.util.*;

class Solution {
    public static int[] shuffleBruteF(int[] nums, int n) {
        int sol[] = new int[nums.length];
        int j = 0;
        for (int i = 0; i < n; i++) {
            sol[j] = nums[i];
            sol[j + 1] = nums[i + n];
            j += 2;
        }
        return sol;
    }


    public static int[] shuffle(int[] nums, int n) {
        int temp1 = nums[1];
        int temp2 = nums[0];
        for (int i = 0; i < nums.length; i = i + 2) {
            if (i != 0) {
                temp1 = nums[i];
            }
            nums[i] = temp2;
            temp2 = nums[i + 1];
            nums[i + 1] = nums[i + n];
            n--;
        }
        return nums;
    }

    public static void permute(int[] arr) {
        permuteHelper(arr, 0);
    }

    static boolean checkIsAP(int arr[], int n) {
        if (n == 1)
            return true;

        // Sort array
        Arrays.sort(arr);

        // After sorting, difference between
        // consecutive elements must be same.
        int d = arr[1] - arr[0];
        for (int i = 2; i < n; i++)
            if (arr[i] - arr[i - 1] != d)
                return false;

        return true;
    }

    private static void permuteHelper(int[] arr, int index) {
        if (index >= arr.length - 1) { //If we are at the last element - nothing left to permute
            //System.out.println(Arrays.toString(arr));
            //Print the array

            System.out.print("[");
            for (int i = 0; i < arr.length - 1; i++) {
                System.out.print(arr[i] + ", ");
            }
            if (arr.length > 0)
                System.out.print(arr[arr.length - 1]);
            System.out.println("]");
            return;
        }

        for (int i = index; i < arr.length; i++) { //For each index in the sub array arr[index...end]

            //Swap the elements at indices index and i
            int t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;

            //Recurse on the sub array arr[index+1...end]
            permuteHelper(arr, index + 1);

            //Swap the elements back
            t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
        }
    }

    public static int calcSets(int[] nums, int total) {
        return calcSetsRec(nums, total, 0);
    }

    public static int calcSetsRec(int[] nums, int total, int i) {
        if (total == 0) {
            return 1;
        } else if (total < 0) {
            return 0;
        } else if (i >= nums.length) {
            return 0;
        } else if (total < nums[i]) {
            return calcSetsRec(nums, total, i + 1);
        } else {
            return calcSetsRec(nums, total - nums[i], i + 1) + calcSetsRec(nums, total, i + 1);
        }
    }

    public static int calcSetsDP(int[] nums, int total) {
        Map <String, Integer> mem = new Hashtable <>();
        return calcSetsDPRec(nums, total, 0, mem);
    }

    public static int calcSetsDPRec(int[] nums, int total, int i, Map <String, Integer> mem) {
        String key = total + ":" + i;
        int retvalue = 0;
        if (mem.containsKey(key))
            return mem.get(key);
        if (total == 0) {
            return 1;
        } else if (total < 0) {
            return 0;
        } else if (i >= nums.length) {
            return 0;
        } else if (total < nums[i]) {
            retvalue = calcSetsRec(nums, total, i + 1);
        } else {
            retvalue = calcSetsRec(nums, total - nums[i], i + 1) + calcSetsRec(nums, total, i + 1);
        }
        mem.put(key, retvalue);
        return retvalue;
    }

    public static int calcFibRec(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return calcFib(n - 1) + calcFib(n - 2);
    }


    public static int calcFib(int n) {
        int a = 0;
        int b = 1;
        int c;
        while (n > 0) {
            System.out.print(b + "  ");
            c = a + b;
            a = b;
            b = c;
            n--;
        }
        return a;
    }


    public static List <Integer> findDiagonalOrder(List <List <Integer>> nums) {
        List <Integer> result = new ArrayList <>();
        Map <String, Integer> mem = new Hashtable <>();
        findDiagonalOrderRec(nums, result, 0, 0,mem);
        return result;
    }

    public static List <Integer> findDiagonalOrderRec(List <List <Integer>> nums, List <Integer> result, int i, int j, Map <String, Integer> mem) {

        String key = i + ":" + j;
        if (mem.containsKey(key))
            return null;
        if (i <0 || j<0){
            return null;
        }
        if (i >= nums.size())
            return null;
        if (j >= nums.get(i).size()) {
            return null;
        }
        int temp =nums.get(i).get(j);
        result.add(temp);
        mem.put(key,temp );
       /* findDiagonalOrderRec(nums, result, i + 1, j,mem);*/
        findDiagonalOrderRec(nums, result, i-1, j + 1,mem);
        findDiagonalOrderRec(nums, result, i+1, 0,mem);
        if(i==nums.size()-1 && j>=0)
            findDiagonalOrderRec(nums, result, i, j+1,mem);
        findDiagonalOrderRec(nums, result, i-1, j+1,mem);
        return result;
    }

    public static void main(String[] args) {
        /*int nums[] = {2, 5, 1, 3, 4, 7, 8, 9};
        for (int i : DSet.shuffle(nums, 4)
                ) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        System.out.println(7 & 1);

        int nums1[] = {3, 5, 1};
        DSet.permute(nums1);

        System.out.println(DSet.checkIsAP(nums1, nums1.length));

        int nums2[] = {2, 4, 6, 10};
        System.out.println(DSet.calcSets(nums2, 16));


        System.out.println(DSet.calcSetsDP(nums2, 16));


        System.out.println(DSet.calcFib(4));
        System.out.println(5 >>> 1);
*/

        List <List <Integer>> twoD = new ArrayList <>();

        List <Integer> l1 = new LinkedList <>(Arrays.asList(1,2,3));
        List <Integer> l2 = new LinkedList <>(Arrays.asList(4,5,6));
        List <Integer> l3 = new LinkedList <>(Arrays.asList(7,8,9));

        /*List <Integer> l1 = new LinkedList <>(Arrays.asList(1,2,3,4,5));
        List <Integer> l2 = new LinkedList <>(Arrays.asList(6,7));
        List <Integer> l3 = new LinkedList <>(Arrays.asList(8));
        List <Integer> l4 = new LinkedList <>(Arrays.asList(9,10,11));
        List <Integer> l5 = new LinkedList <>(Arrays.asList(12,13,14,15,16));
*/

        twoD.add(l1);
        twoD.add(l2);
        twoD.add(l3);
        /*twoD.add(l4);
        twoD.add(l5);*/

        System.out.println(Solution.findDiagonalOrder(twoD));


        System.out.println("________________________________");

        LinkedList<Integer> llll = new LinkedList <>(Arrays.asList(1, 2, 3, 4, 5, 3));
        Immutable immutable = new Immutable("Sanjay",llll );

        LinkedList <Integer> list1 = immutable.getList();
        list1.add(12345);
        System.out.println("object in get" + list1);

        System.out.println("object in get" + immutable.getList());

        llll.add(1234567);

        System.out.println("object in get" + list1);

        System.out.println("object in get" + immutable.getList());

        String s= "sanjay";
        String s1=s;


        System.out.println("S   :"+s.hashCode());
        System.out.println("S1  :"+s1.hashCode());

        s1=s1+" Gupta";

        System.out.println("S   :"+s.hashCode());
        System.out.println("S1  :"+s1.hashCode());
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}