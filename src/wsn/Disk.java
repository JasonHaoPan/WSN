package wsn;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by mymac on 17/4/14.
 */
public class Disk extends PApplet {
    int N;
    int R;
    int avgDegree;
    PVector[] points = new PVector[N];
    public Disk(int numofpoints,int radius, int avgdegree)
    {
        N = numofpoints;
        R = radius;
        avgDegree = avgdegree;
        points = new PVector[numofpoints];

        for (int i = 0; i < numofpoints; i++)
        {
            points[i] = randomDiskPoints(radius);
        }
    }
    public PVector randomDiskPoints(int radius)
    {
        PVector vector;
        double distance;
        do {
            vector = new PVector(random(2*radius), random(2*radius));
            distance = sqrt((vector.x - radius)*(vector.x - radius)+(vector.y - radius)*(vector.y - radius));
        }
        while(distance > radius);
        return vector;
    }
    public double degreeToRadius()
    {
        return sqrt((R*R*avgDegree)/(N));
    }
}
