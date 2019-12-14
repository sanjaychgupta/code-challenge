
public class FavoriteNumber {
    int  solution(int X, int Y, int[] A) {
        int N = A.length;
        int result = -1;
        int nX = 0;
        int nY = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == X)
                nX += 1;
            else if (A[i] == Y)
                nY += 1;
            if (nX == nY && nX!= 0 && nY!=0 && result <1)
                result = i;
        }
        return result;
    }

    public static void main(String[] args) {
        int A[]={6,42,11,7,1,42};
        int B[]={100,63,1,6,2,13};
        int C[]={13,13,1,6};
        FavoriteNumber f = new FavoriteNumber();
        System.out.println(f.solution(6,13,C));

    }
}