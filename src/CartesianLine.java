import java.util.HashMap;
import java.util.Map;

public class CartesianLine {


    int  gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
    // method to find maximum colinear point
    int maxPointOnSameLine(Point2D[] points)
    {
        int N = points.length;
        if (N < 2)
            return N;

        int maxPoint = 0;
        int curMax, overlapPoints, verticalPoints;

        // here since we are using unordered_map
        // which is based on hash function
        //But by default we don't have hash function for pairs
        //so we'll use hash function defined in Boost library
        /*unordered_map<pair<int, int>, int,boost::
        hash<pair<int, int> > > slopeMap;*/
        Map<Integer,Integer> slopeMap = new HashMap<Integer,Integer>();


        // looping for each point
        for (int i = 0; i < N; i++)
        {
            curMax = overlapPoints = verticalPoints = 0;

            // looping from i + 1 to ignore same pair again
            for (int j = i + 1; j < N; j++)
            {
                // If both point are equal then just
                // increase overlapPoint count
                if (points[i] == points[j])
                    overlapPoints++;

                    // If x co-ordinate is same, then both
                    // point are vertical to each other
                else if (points[i].x == points[j].x)
                    verticalPoints++;

                else
                {
                    int yDif = points[j].y - points[i].y;
                    int xDif = points[j].x - points[i].x;
                    int g = gcd(xDif, yDif);

                    // reducing the difference by their gcd
                    yDif /= g;
                    xDif /= g;

                    // increasing the frequency of current slope
                    // in map
                    slopeMap.put(yDif, xDif);
                    curMax = Math.max(curMax, slopeMap.put(yDif, xDif));
                }

                curMax = Math.max(curMax, verticalPoints);
            }

            // updating global maximum by current point's maximum
            maxPoint = Math.max(maxPoint, curMax + overlapPoints + 1);

            // printf("maximum colinear point
            // which contains current point
            // are : %d\n", curMax + overlapPoints + 1);
            slopeMap.clear();
        }

        return maxPoint;
    }

    // Driver code
    public static void main(String[] args) {

        Point2D[] points = {
                new Point2D(0,0),
                new Point2D(1,1),
                new Point2D(2,2),
                new Point2D(3,3),
                new Point2D(3,2),
                new Point2D(4,2),
                new Point2D(5,1),
        };
        CartesianLine cl = new CartesianLine();
        System.out.println( cl.maxPointOnSameLine(points));

    }

    static class Point2D{
        public int x;
        public int y;

        public Point2D(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

