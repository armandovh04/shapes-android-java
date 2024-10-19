
package edu.luc.etl.cs313.android.shapes.model;

/**
 * A decorator indicating that a shape should be drawn as a filled shape instead
 * of an outlined one.
 */
public class Fill implements Shape {

    protected final Shape shape;

    public Fill(final Shape shape) {

        this.shape = shape;
    }

    public Shape getShape() {

        return shape;
    }

    @Override
    public <Result> Result accept(final Visitor<Result> v) {
        return v.onFill(this);
    }
}
