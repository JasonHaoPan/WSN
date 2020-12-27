package wsn.Sphere;

import processing.core.PApplet;
import processing.core.PVector;
import wsn.Graph.Graph;

/**
 * Created by mymac on 17/4/14.
 */
public class Sphere extends Graph {
    //number of vertices
    int N;
    int radius;
    int avgDegree;
    int size;
    //points
    PVector[] points;


    public Sphere(int numofpoints, int radius, int avgdegree, int size)
    {
        super();
    }

    //--------------------------------------------------------
    // draw random sphere points
    //--------------------------------------------------------
   /* void drawSphere()
    {
        for (int i = 0; i < N; i++) {
            //point(this.points[i].x, this.points[i].y, this.points[i].z);
            //System.out.println(this.points[i].x +","+ this.points[i].y+","+this.points[i].z);
        }
    }*/

    //--------------------------------------------------------
    // return random sphere point using method of Cook/Neumann
    //x	=	(2(x_1x_3+x_0x_2))/(x_0^2+x_1^2+x_2^2+x_3^2)
    //        (13)
    //y	=	(2(x_2x_3-x_0x_1))/(x_0^2+x_1^2+x_2^2+x_3^2)
    //        (14)
    //z	=	(x_0^2+x_3^2-x_1^2-x_2^2)/(x_0^2+x_1^2+x_2^2+x_3^2)
    //--------------------------------------------------------

    @Override
    public PVector generateRandomPoints() {
        float a=0, b=0, c=0, d=0, k=200;
        while (k >= 1.0)
        {
            a = random (-1, 1);
            b = random (-1, 1);
            c = random (-1, 1);
            d = random (-1, 1);
            k = a*a +b*b +c*c +d*d;
        }
        k = k / radius;
        return new PVector
                ( 2*(b*d + a*c) / k
                        , 2*(c*d - a*b) / k
                        , (a*a + d*d - b*b - c*c) / k);
    }

    @Override
    public double degreeToRadius()
    {
        return sqrt((4*radius*radius*avgDegree)/(N));
    }

    @Override
    public void draw() {

    }

    @Override
    public void generateGraph() {
        translate(size/2,size/2);
        stroke(255, 0, 255);
        strokeWeight(3);

        for (int i = 0; i < N; i++)
        {
            point(this.points[i].x, this.points[i].y, this.points[i].z);
        }
    }

    @Override
    public void connectPoints(PVector[] vector, double r) {

    }
}


