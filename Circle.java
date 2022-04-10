package stepa_project;

public class Circle {
    public double radius;
    public Point point;

    public Circle(double radius, Point point){
        this.radius = radius;
        this.point = point;
    }

    public Circle(Point p1, Point p2){
        this.point = p1;
        this.radius = p1.getDlin(p2);
    }

}
