package wsn;
import processing.core.PApplet;
import processing.core.PVector;
/**
 * Created by mymac on 17/4/14.
 */
public class Square extends PApplet{
    int N ;
    int SIZE = 600;
    int avgDegree;

    PVector[] points = new PVector[N];

    public Square(int numofpoints, int size, int avgdegree)
    {
        N = numofpoints;
        SIZE = size;
        avgDegree = avgdegree;
        points= new PVector[numofpoints];
        for (int i = 0; i < numofpoints; i++)
        {
            points[i] = randomSquarePoint(size);
        }
    }
    public PVector randomSquarePoint(int SIZE)
    {
        return new PVector(random(0, SIZE),random(0, SIZE));
    }
    public double degreeToRadius()
    {
        return sqrt((SIZE*SIZE*avgDegree)/(N*PI));
    }

}
