public class Demo {
public static int count=0;

        public static int solution(int[] A) {
            int count = 0;
            for (int i = 0; i < A.length - 2; i = i + 2) {
                if (A[i] < A[i + 1]) {
                    if (!(A[i + 1] > A[i + 2])) {
                        count++;
                    }
                } else {
                    if (!(A[i + 1] < A[i + 2])) {
                        count++;
                    }
                }
            }
            return count;
        }


    public static void main(String args[]){
            int a[]={3,7,4,5};
        System.out.println(solution(a));

    }
}
