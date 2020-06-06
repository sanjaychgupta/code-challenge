import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BinaryAdditionPP {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        String[] binary = new String[2];
        while ((line = in.readLine()) != null) {
            line=line.trim();
            binary=line.split(",");
        }
        BinaryAdditionPP.addBinary(Long.parseLong(binary[0]), Long.parseLong(binary[1]));

    }
    public static void addBinary(long binary1, long binary2){
        int remainder = 0;
        List<Integer> sum = new ArrayList<>();
        while (binary1 != 0 || binary2 != 0)
        {
            sum.add((int)((binary1 % 10 + binary2 % 10 + remainder) % 2));
            remainder = (int)((binary1 % 10 + binary2 % 10 + remainder) / 2);
            binary1 = binary1 / 10;
            binary2 = binary2 / 10;
        }
        if (remainder != 0) {
            sum.add(remainder);
        }
        Collections.reverse(sum);
        for (int bit : sum) {
            System.out.print(bit);
        }
    }
}