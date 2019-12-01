import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Problem statement
 * Given a window size, W and a stream of number, S. You can see only W numbers in the window. Each time you receive a number from stream S, print max numbers in sliding window.
 *
 * Input
 * [W]
 * [N1]
 * [N2]
 * ...
 * Where W is the number of the window size, and Nn represents a element in the stream.
 *
 * Note that, you can assume following things.
 *
 * An element in the stream will be an integer in the range, -3,000,000,000 ≦ Nn ≦ 3,000,000,000.
 * the window size W will be an integer in the range, 0 < W ≦ 3,000,000,000.
 * Output
 * After you read first W + 1 lines, each time you read the number from the input, print max numbers in sliding window.
 *
 * [V1]
 * [V2]
 * ...
 * Input Example
 * (Window size W=2 and number stream is S = [2, 1, 2, -1, 3])
 *
 * 2
 * 2
 * 1
 * 2
 * -1
 * 3
 * Output Example
 *
 * 2
 * 2
 * 2
 * 3
 */

class LineFrame {
    /**
     * In below we have marked separate time complexity for n size stream
     * 1. getting n Size stream time complexity O(n)
     * 2. iterating Stream and moving window time complexity O(n)
     * 3. while iterating and find max numbertime complexity  (n-windowSize)*(O(1) + O(windowSize))
     * Hence overall time complexity O(n) + O(n) + (n-windowSize)*(O(1) + O(windowSize)) near to 3 O(n) == O(n)
     */
    public static void main(String[] args) throws java.lang.Exception {

        Scanner sc = new Scanner(System.in);
        long windowSize = 2;
        List<Long> stream = new ArrayList<>();
        stream.add(30000000000L);
        stream.add(2999999999L);
        stream.add(-1L);
        stream.add(3L);

        long pointer=0;
        while(pointer<=(stream.size()-windowSize)) // time complexity O(n)
        {
            List<Long> subStream = stream.subList((int)pointer,  (int)(pointer + windowSize)); // time complexity O(1)
            Optional<Long> max = subStream.stream().reduce(Long::max); // time complexity O(windowSize)
            System.out.println(max.get());
            pointer++;
        }
    }

}

