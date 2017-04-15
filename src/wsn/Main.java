package wsn;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by mymac on 17/4/13.
 */
public class Main extends PApplet {
    //radius

    int _SIZE = 700;
    int R = 300;
    int position = (_SIZE - 2*R)/2;
    int avgdegree = 0;
    //number of points
    int N = 16000;
    Square rs = new Square(N, _SIZE,0);
    Sphere rsp = new Sphere(N, R);
    Disk dsk = new Disk(N, R, avgdegree);
    //int point
    //PVector points[] = new PVector[N];

    public void generateSquare(int N)
    {
        //translate(position,position);
        for (int i = 0; i < N; i++)
        {
            point(rs.points[i].x, rs.points[i].y);
        }

    }

    public void generateDisk(int N)
    {
        translate(position,position);
        for (int i = 0; i < N; i++)
        {
            point(dsk.points[i].x, dsk.points[i].y);
        }

    }
    public void generateSphare(int N)
    {
        translate(R + position,R + position);
        for (int i = 0; i < N; i++)
        {
            point(rsp.points[i].x, rsp.points[i].y, rsp.points[i].z);
        }

    }



    public void settings() {
        size(_SIZE,_SIZE,P3D);


    }
    public void setup() {
        background(40);
        stroke(0, 166,0);
        //ellipseMode(CENTER);



    }
    public void draw()
    {
//        translate(position,position);
//        for (int i = 0; i < N; i++) {
//
//            point(rsp.points[i].x,rsp.points[i].y,rsp.points[i].z);
//
//        }
//        for (int i = 0; i < N; i++) {
//
//            point(rs.points[i].x,rs.points[i].y);
//
//        }

        //rs.drawsquare();
        //generateSquare(N);
        //generateDisk(N);
        generateSphare(N);

    }

    public static void main(String[] args)
    {
        //NOTE: If your class is part of a package other than the default package,
        //you must call PApplet's main using the package name as well, like this:
        //PApplet.main("packageName.ClassName");
        PApplet.main("wsn.Main");
    }
}
