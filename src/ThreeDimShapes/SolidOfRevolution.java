package ThreeDimShapes;

public class SolidOfRevolution extends Shape{

    private double radius;

    public SolidOfRevolution(double volume) {
        super(volume);
    }

    public double getRadius() {
        return radius;
    }
}
