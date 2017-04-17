package wsn;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.Arrays;

/**
 * Created by mymac on 17/4/13.
 */
public class Main extends PApplet {
    //radius

    int _SIZE = 600;
    int R = 250;
    int avgdegree = 32;
    int edges = 0;
    int counter = 1;
    //number of points
    int N = 1000;
    Square square = new Square(N, _SIZE, avgdegree);
    Sphere sphere = new Sphere(N, R,avgdegree);
    Disk disk = new Disk(N, R, avgdegree);
    //int point
    PVector points[] = new PVector[N];

    public void generateSquare()
    {
        stroke(255, 0, 255);
        strokeWeight(2);
        for (int i = 0; i < N; i++)
        {

            point(square.points[i].x, square.points[i].y);

        }

    }
    public void generateDisk()
    {
        stroke(255, 255, 0);
        translate(_SIZE/2 - R,_SIZE/2 - R);
        for (int i = 0; i < N; i++)
        {
            point(disk.points[i].x, disk.points[i].y);
        }
    }

    public void generateSphere()
    {
        translate(_SIZE/2,_SIZE/2);
        stroke(255, 0, 255);
        strokeWeight(3);

        for (int i = 0; i < N; i++)
        {
            point(sphere.points[i].x, sphere.points[i].y, sphere.points[i].z);
        }


    }
    //sort the points by x axis
    public void vectorSort(PVector[] vector)
    {
        Arrays.sort(vector,new PointsComparator());

    }

    //connect points using sweep method
    public void connectPoints(PVector[] vector, double r)
    {
        double distance;
        vectorSort(vector);
        for (int i = 0; i < N; i++) {
            for (int j = 0; (j < i); j++) {
                if (vector[i].x - vector[j].x > r) {
                    j++;
                    continue;
                }
                distance = dist(vector[i].x, vector[i].y,vector[i].z, vector[j].x, vector[j].y, vector[j].z);
                if (distance <= r) {
                    stroke(255, 255, 0,  (int)(r - distance));
                    line(vector[i].x, vector[i].y, vector[j].x, vector[j].y);
                    edges++;
                    //System.out.println(i+"---"+j+"-----"+distance+"connected.");
                }
            }
        }


        System.out.println("Edges is:  "+edges);
    }

    public void settings() {

        size(_SIZE,_SIZE,P3D);
    }
    public void setup() {
        smooth();
        background(40);
        stroke(255, 0, 255);
        noLoop();

    }
    public void draw()
    {
        //generateSquare();
        connectPoints(square.points, square.degreeToRadius());
//        generateDisk();
//        translate(_SIZE/2 - R,_SIZE/2 - R);
//        connectPoints(disk.points, disk.degreeToRadius());
//
//        generateSphere();
//        translate(_SIZE/2,_SIZE/2);
//        connectPoints(sphere.points, sphere.degreeToRadius());





    }

    public static void main(String[] args)
    {
        //NOTE: If your class is part of a package other than the default package,
        //you must call PApplet's main using the package name as well, like this:
        //PApplet.main("packageName.ClassName");
        PApplet.main("wsn.Main");
    }
}
