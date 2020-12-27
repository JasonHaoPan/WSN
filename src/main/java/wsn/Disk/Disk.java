package wsn.Disk;

import processing.core.PApplet;
import processing.core.PVector;
import wsn.Graph.Graph;

/**
 * Created by mymac on 17/4/14.
 */
public class Disk extends Graph {
    int N;
    int radius;
    int avgDegree;
    int size;
    PVector[] points = new PVector[N];
    public Disk(int numofpoints, int radius, int avgdegree, int size)
    {
        super(numofpoints, radius, avgdegree, size);
    }

    @Override
    public double degreeToRadius()
    {
        return sqrt((radius*radius*avgDegree)/(N));
    }

    @Override
    public PVector generateRandomPoints() {
        PVector vector;
        double distance;
        do {
            vector = new PVector(random(2*radius), random(2*radius));
            distance = sqrt((vector.x - radius)*(vector.x - radius)+(vector.y - radius)*(vector.y - radius));
        }
        while(distance > radius);
        return vector;
    }

    @Override
    public void draw() {
    }

    @Override
    public void generateGraph() {
        stroke(255, 255, 0);
        translate(size/2 - radius,size/2 - size);
        for (int i = 0; i < N; i++)
        {
            point(this.points[i].x, this.points[i].y);
        }
    }

    @Override
    public void connectPoints(PVector[] vector, double r) {

    }
}
