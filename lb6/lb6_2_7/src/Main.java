import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(new Point(1, 1), new Point(4, 4)));
        segments.add(new Segment(new Point(3, 2), new Point(1, 4)));
        segments.add(new Segment(new Point(0, 3), new Point(5, 3)));

        TreeMap<Double, Point> intersections = new TreeMap<>(); //  Для хранения точек пересечения отрезков

        for (int i = 0; i < segments.size() - 1; i++) {
            for (int j = i + 1; j < segments.size(); j++) {
                Segment seg1 = segments.get(i);
                Segment seg2 = segments.get(j);
                // Для каждой пары отрезков проверяется их пересечение
                if (seg1.intersects(seg2)) {
                    // Если отрезки пересекаются, то вычисляется абсцисса пересечения и добавляется в дерево
                    double xIntersection = seg1.getXIntersection(seg2);
                    Point intersectionPoint = new Point(xIntersection, seg1.getSlope() * xIntersection + seg1.getIntercept());
                    intersections.put(xIntersection, intersectionPoint);
                }
            }
        }

        System.out.println(intersections);
        if (!intersections.isEmpty()) {
            System.out.println("Точка пересечения с минимальной абсциссой: " + intersections.firstEntry().getValue());
        } else {
            System.out.println("Отрезки не пересекаются.");
        }
    }
}