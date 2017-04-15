package wsn;
import processing.core.PApplet;
import processing.core.PVector;
/**
 * Created by mymac on 17/4/14.
 */
public class Square extends PApplet{
    int N = 0;
    //int SIZE = 800;
    int avgDegree = 0;
    PVector[] points = new PVector[N];

    public Square(int numofpoints, int size,int avgdegree)
    {
        N = numofpoints;
        points= new PVector[numofpoints];
        for (int i = 0; i < numofpoints; i++)
        {
            points[i] = randomSquarePoint(size);
        }
    }
    public void drawsquare()
    {
//        for (int i = 0; i < N; i++)
//        {
//            point(points[i].x, points[i].y);
//        }
        //System.out.println("aaa");
    }
    public PVector randomSquarePoint(int SIZE)
    {
        return new PVector(random(0, SIZE),random(0, SIZE));
    }
    public int degreeToRadius(int avgdegree)
    {
        return 0;
    }
}
