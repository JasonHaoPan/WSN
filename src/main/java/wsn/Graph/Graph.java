package wsn.Graph;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.Arrays;
import java.util.Comparator;

public abstract class Graph extends PApplet {
    int numOfPoints;
    int radius;
    int avgDegree;
    int size;
    int edges = 0;
    PVector[] points;
    public abstract PVector generateRandomPoints();
    public abstract double degreeToRadius();
    public abstract void generateGraph();
    public Graph(){}
    public Graph(int numOfPoints, int radius, int avgDegree, int size) {
        this.numOfPoints = numOfPoints;
        this.radius = radius;
        this.avgDegree = avgDegree;
        this.size = size;
        this.points = new PVector[numOfPoints];
        for (int i = 0; i < numOfPoints; i++)
        {
            points[i] = generateRandomPoints();
        }
    }
    public abstract void draw();
    public void connectPoints(PVector[] vector, double r) {
        double distance;
        vectorSort(vector);
        for (int i = 0; i < numOfPoints; i++) {
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
    };
    public void vectorSort(PVector[] vector)
    {
        Arrays.sort(vector,new Comparator<PVector>(){
            @Override
            public int compare(PVector p1, PVector p2) {
                return p1.x - p2.x > 0 ? 1 : p1.x - p2.x < 0 ? -1 : 0 ;
            }
        });
    }
}
