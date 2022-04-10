package stepa_project;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Circle> circles;

    Solution(List<Circle> circles){
        this.circles = circles;
    }

    public Line findMaxLength(List<Line> lines) {
        Line maxLine = lines.get(0);

        for (int i = 1; i < lines.size(); i++) {
            if (maxLine.length() <= lines.get(i).length()) {
                maxLine = lines.get(i);
            }
        }

        return maxLine;
    }

    List<Line> findLines(List<Circle> circles) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < circles.size(); i++) {
            for (int j = i + 1; j < circles.size(); j++) {
                if (hasIntersection(circles.get(i), circles.get(j))) {
                    lines.add(new Line(circles.get(i), circles.get(j)));
                }
            }
        }

        return lines;
    }

    public static List<Point> findIntersections(Circle c1, Circle c2) {
        List<Point> points = new ArrayList<>();

        double d = c1.point.getDlin(c2.point);
        double a = (Math.pow(c1.radius, 2) - Math.pow(c2.radius, 2) + Math.pow(d, 2)) / (2 * d);
        double h = Math.sqrt(c1.radius * c1.radius - Math.pow(a, 2));

        Point p2 = new Point(0, 0);
        p2.x = c1.point.x + a * (c2.point.x - c1.point.x) / d;
        p2.y = c1.point.y + a * (c2.point.y - c1.point.y) / d;

        Point p3 = new Point(0, 0);
        Point p4 = new Point(0, 0);

        p3.x = p2.x + h * (c2.point.y - c1.point.y) / d;
        p3.y = p2.y - h * (c2.point.x - c1.point.x) / d;

        p4.y = p2.y + h * (c2.point.x - c1.point.x) / d;
        p4.x = p2.x - h * (c2.point.y - c1.point.y) / d;

        points.add(p3);
        points.add(p4);

        return points;
    }

    public boolean hasIntersection(Circle c1, Circle c2) {
        double d = c1.point.getDlin(c2.point);

        return d <= c1.radius + c2.radius && d >= Math.abs(c1.radius - c2.radius);
    }

}
