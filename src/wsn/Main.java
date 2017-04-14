package wsn;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by mymac on 17/4/13.
 */
public class Main extends PApplet {
    //radius

    int Z = 500;
    int R = 400;
    //number of points
    int N = 1500;
    //int point
    PVector point[] = new PVector[N];
    public void generatesquare()
    {

        for (int i = 0; i < N; i++)
        {

            stroke(0,255,0);
            point(point[i].x, point[i].y);

        }
    }
    public void generatedisk()
    {
        stroke(0,255,255);
        ellipseMode(CENTER);
        noFill();
        arc(250,250,R,R,0,TWO_PI);
        for (int i = 0; i < N; i++)
        {

            stroke(0,255,0);
            double distance = sqrt((point[i].x - 250)*(point[i].x - 250)+(point[i].y - 250)*(point[i].y - 250));
            if(distance <= 200)
            {
                //System.out.println(distance);
                point(point[i].x, point[i].y);
            }
        }
    }
    public void generatesphare()
    {

    }
    public void settings() {
        size(Z,Z);
        //noLoop();
    }
    public void setup() {
        background(0);
        for(int i = 0; i < N; i++)
        {
            point[i] = new PVector(random(Z),random(Z));
        }
    }
    public void draw()
    {
        //generatesquare();
        generatedisk();


    }

    public static void main(String[] args)
    {
        //NOTE: If your class is part of a package other than the default package,
        //you must call PApplet's main using the package name as well, like this:
        //PApplet.main("packageName.ClassName");
        PApplet.main("wsn.Main");
    }
}
