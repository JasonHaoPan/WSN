package wsn;

import processing.core.PVector;

import java.util.Comparator;

/**
 * Created by mymac on 17/4/15.
 */
public class PointsComparator implements Comparator<PVector> {

    public int compare(PVector p1, PVector p2) {
        float dif = p1.x - p2.x;
        if (dif > 0)
            return 1;
        else if(dif < 0)
            return -1;
        else
            return 0;
    }
}
