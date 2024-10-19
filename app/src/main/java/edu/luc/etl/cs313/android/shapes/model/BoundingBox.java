package edu.luc.etl.cs313.android.shapes.model;
import java.util.List;

/**
 * A shape visitor for calculating the bounding box, that is, the smallest
 * rectangle containing the shape. The resulting bounding box is returned as a
 * rectangle at a specific location.
 */
public class BoundingBox implements Visitor<Location> {

    // TODO entirely your job (except onCircle)

    @Override
    public Location onCircle(final Circle c) {
        final int radius = c.getRadius();
        return new Location(-radius, -radius, new Rectangle(2 * radius, 2 * radius));
    }

    @Override
    public Location onFill(final Fill f) {
        return f.getShape().accept(this);
    }

    @Override
    public Location onGroup(final Group g) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for(Shape shape : g.getShapes()) {
            Location location = shape.accept(this);
            if(location != null) {
                Shape containedShape = location.getShape();

                if(containedShape instanceof Rectangle) {
                    Rectangle r = (Rectangle) containedShape;
                    int x = location.getX();
                    int y = location.getY();

                    minX = Math.min(minX, x);
                    minY = Math.min(minY, y);
                    maxX = Math.max(maxX, x + r.getWidth());
                    maxY = Math.max(maxY, y + r.getHeight());
                }

            }
        }
        return new Location(minX, minY, new Rectangle(maxX- minX, maxY - minY));
    }

    @Override
    public Location onLocation(final Location l) {
        Location location = l.getShape().accept(this);
        if (location != null) {
            int newX = location.getX() + l.getX();
            int newY = location.getY() + l.getY();
            return new Location(newX, newY, location.getShape());
        }
        return new Location(l.getX(), l.getY(), l.getShape());  // Fallback to original location if no bounding box is found
    }

    @Override
    public Location onRectangle(final Rectangle r) {
        return new Location(0, 0, r);
    }

    @Override
    public Location onStrokeColor(final StrokeColor c) {
        return c.getShape().accept(this);
    }

    @Override
    public Location onOutline(final Outline o) {
        return o.getShape().accept(this);
    }

    @Override
    public Location onPolygon(final Polygon s) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        // Iterate through all points in the polygon
        for (Point p : s.getPoints()) {
            System.out.println(p);

            minX = Math.min(minX, p.getX());
            minY = Math.min(minY, p.getY());
            maxX = Math.max(maxX, p.getX());
            maxY = Math.max(maxY, p.getY());
        }

        return new Location(minX, minY, new Rectangle(maxX - minX, maxY - minY));
    }

}
