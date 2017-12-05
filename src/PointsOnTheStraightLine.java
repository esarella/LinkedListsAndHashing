/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Sample Input :

(1, 1)
(2, 2)
Sample Output :

2
You will be give 2 arrays X and Y. Each point is represented by (X[i], Y[i])

 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PointsOnTheStraightLine {

    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        int maxPoint = 0;
        if (a == null || b == null || a.size() == 0 || b.size() == 0) return maxPoint;
        if (a.size() != b.size()) return maxPoint;
        if (a.size() == 1 && b.size() == 1) return 1;

        for (int i = 0; i < a.size(); i++) {
            int duplicate = 1;
            int vertical = 0;
            Map<Double, Integer> map = new HashMap<>();

            int xi = a.get(i);
            int yi = b.get(i);

            for (int j = i + 1; j < a.size(); j++) {
                int xj = a.get(j);
                int yj = b.get(j);
                if (xi == xj) {
                    if (yi == yj) {
                        duplicate++;
                    } else {
                        vertical++;
                    }
                } else {
                    double slope = 0.0;
                    if (yi != yj) {
                        slope = (double) (yi - yj) / (double) (xi - xj);
                    }

                    if (!map.containsKey(slope)) {
                        map.put(slope, 1);
                    } else {
                        map.put(slope, map.get(slope) + 1);
                    }
                }
            }

            for (Integer cur : map.values()) {
                if (cur + duplicate > maxPoint) {
                    maxPoint = cur + duplicate;
                }
            }
            maxPoint = Math.max(maxPoint, vertical + duplicate);
        }
        return maxPoint;
    }
}
