package ArrayProblems;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ReverseArray {
    public int[] reverse(int arr[]) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int temp = arr[high];
            arr[high] = arr[low];
            arr[low] = temp;
            low++;
            high--;
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        ReverseArray instance1 = new ReverseArray();
        for (int i : instance1.reverse(arr)
                ) {
            System.out.println(i);
        }
    }

    @Test
    public void testReverse() {
        ReverseArray unit = new ReverseArray();

        int[] result = unit.reverse(new int[]{1, 2, 3, 4, 5, 6});

        assertArrayEquals(new int[]{6, 5, 4, 3, 2, 1}, result);

    }
}
