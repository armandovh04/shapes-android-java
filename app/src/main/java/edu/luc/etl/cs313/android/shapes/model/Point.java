package edu.luc.etl.cs313.android.shapes.model;

/**
 * A point, implemented as a location without a shape.
 */
public class Point extends Location {



    public Point(final int x, final int y) {
        super(x, y, new Circle(0));
        assert x >= 0;
        assert y >= 0;
    }
}
