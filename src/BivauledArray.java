import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class BivauledArray {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int len=0;
        for (int i =0; i<A.length-1;i++){
            for (int j = i+1; j<A.length;j++){
                int temp = bivaluedArray(A,i,j);
                if(temp==0){
                    break;
                }
                len = (temp>len)? temp:len;
            }
        }
        return len;
    }
    private int bivaluedArray(int A[], int start, int end){
        if((end - start) == 1 ){
            return 2;
        }
        int[] slice = IntStream.range(start, end + 1)
                .map(i -> A[i])
                .toArray();
        if(isBiValued(slice))
            return slice.length;
        return 0;
    }
    private boolean isBiValued(int A[]){
        int end = A.length;
        Set<Integer> set = new HashSet();
        for(int i = 0; i < end; i++){
            set.add(A[i]);
            if(set.size()>2){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BivauledArray s = new BivauledArray();
        int[] A = {0,5,4,4,12,1,2,2,1,2};
        System.out.println(s.solution(A));


    }
}
