package stepa_project;

import java.util.List;

public class Line {
    public Point p1, p2;
    public Circle c1, c2;

    public Line(Circle c1, Circle c2) {
        List<Point> points = Solution.findIntersections(c1, c2);

        this.p1 = points.get(0);
        this.p2 = points.get(1);

        this.c1 = c1;
        this.c2 = c2;
    }

    public double length() {
        return Math.sqrt(Math.pow(this.p1.x - this.p2.x, 2) + Math.pow(this.p1.y - this.p2.y, 2));
    }
}
