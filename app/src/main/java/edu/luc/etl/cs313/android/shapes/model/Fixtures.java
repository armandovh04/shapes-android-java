package edu.luc.etl.cs313.android.shapes.model;

import android.graphics.Color;

/**
 * Test fixtures shared across test cases.
 */
public class Fixtures {

    private Fixtures() { /* prevent instantiation! */ }

    public static final Shape simpleCircle = new Circle(50);

    public static final Shape simpleLocation = new Location(70, 30, new Rectangle(80, 120));

    public static final Shape simpleFill = new Fill(new Rectangle(80, 120));

    public static final Shape simpleStrokeColor = new StrokeColor(Color.RED, new Rectangle(80, 120));

    public static final Shape simpleGroup = new Group(
            new Location(200, 100, new Circle(50)),
            new Location(400, 300, new Rectangle(100, 50))
    );

    public static final Shape middleGroup = new Location(50, 100,
            new Group(
                    new Outline(new Rectangle(50, 30)),
                    new Location(400, 300,
                            new Group(
                                    new Circle(20),
                                    new Fill(new Rectangle(50, 30))
                            )
                    )
            )
    );

    public static final Shape complexGroup = new Location(50, 100,
            new Group(
                    new Circle(20),
                    new Rectangle(100, 200),
                    new Location(150, 50,
                            new StrokeColor(Color.RED,
                                    new Fill(
                                            new Group(
                                                    new Rectangle(50, 30),
                                                    new Outline(new Rectangle(300, 60)),
                                                    new StrokeColor(Color.BLUE,
                                                            new Polygon(
                                                                    new Point(50, 50),
                                                                    new Point(60, 100),
                                                                    new Point(100, 110),
                                                                    new Point(120, 60)
                                                            )
                                                    ),
                                                    new Location(100, 200,
                                                            new StrokeColor(Color.MAGENTA,
                                                                    new Outline(new Circle(50))
                                                            )
                                                    )
                                            )
                                    )
                            )
                    )
            )
    );

    public static final Shape simpleOutline = new Outline(new Rectangle(80, 120));

    public static final Shape simplePolygon = new Polygon(
            new Point(50, 50),
            new Point(60, 100),
            new Point(100, 110),
            new Point(120, 60)
    );
}
