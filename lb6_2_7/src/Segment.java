class Segment {
    Point start, end; // Начало и конец отрезка

    Segment(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    // Угловой коэффициент k прямой, на которой лежит отрезок
    double getSlope() {
        return (end.y - start.y) / (end.x - start.x);
    }

    //Свободный член прямой, равный b = y - kx
    double getIntercept() {
        return start.y - getSlope() * start.x;
    }

    //Расчет абсциссы пересечения из уравнения k1*x+b1 = k2*x+b2
    double getXIntersection(Segment other) {
        double slopeDiff = getSlope() - other.getSlope(); // k1 - k2
        double interceptDiff = other.getIntercept() - getIntercept(); // b2 - b1
        return interceptDiff / slopeDiff;
    }

    // Проверка, пересекаются ли отрезки
    boolean intersects(Segment other) {
        return (start.x <= other.end.x) && (end.x >= other.start.x) &&
                (start.y <= other.end.y) && (end.y >= other.start.y);
    }
}