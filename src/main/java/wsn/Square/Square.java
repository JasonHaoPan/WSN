package wsn.Square;
import processing.core.PApplet;
import processing.core.PVector;
import wsn.Graph.Graph;

/**
 * Created by mymac on 17/4/14.
 */
public class Square extends Graph {
    int numOfPoints ;
    int size = 600;
    int avgDegree;
    PVector[] points;

    public Square(int numofpoints, int size, int avgdegree)
    {
        super();
    }
    /*public PVector randomSquarePoint(int SIZE)
    {
        return new PVector(random(0, SIZE),random(0, SIZE));
    }*/

    @Override
    public PVector generateRandomPoints() {
        return new PVector(random(0, size),random(0, size));
    }

    @Override
    public double degreeToRadius()
    {
        return sqrt((size*size*avgDegree)/(numOfPoints*PI));
    }

    @Override
    public void draw() {
    }

    @Override
    public void generateGraph() {
        stroke(255, 0, 255);
        strokeWeight(2);
        for (int i = 0; i < numOfPoints; i++)
        {
            point(this.points[i].x, this.points[i].y);
        }
    }

    @Override
    public void connectPoints(PVector[] vector, double r) {

    }
}
