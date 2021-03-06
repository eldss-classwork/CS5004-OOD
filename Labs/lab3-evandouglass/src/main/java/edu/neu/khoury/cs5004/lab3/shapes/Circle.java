package edu.neu.khoury.cs5004.lab3.shapes;

/**
 * This class represents a circle.  It offers all the operations mandated by the Shape interface.
 */
public class Circle extends AbstractShape {

  private double radius;

  /**
   * Construct a circle object using the given center and radius.
   *
   * @param cordY x coordinate of the center of this circle
   * @param cordY y coordinate of the center of this circle
   * @param radius the radius of this circle
   */
  public Circle(double cordX, double cordY, double radius) {
    super(new Posn(cordX, cordY));
    this.radius = radius;
  }

  /**
   * Construct a circle object with the given radius. It is centered at (0,0)
   *
   * @param radius the radius of this circle
   */
  public Circle(double radius) {
    super(new Posn(0, 0));
    this.radius = radius;
  }

  //@Override
  public double area() {
    return Math.PI * radius * radius;
  }

  @Override
  public double perimeter() {
    return 2 * Math.PI * radius;
  }

  @Override
  public Shape resize(double factor) {
    return new Circle(reference.getX(), reference.getY(),
        Math.sqrt(factor) * radius);
  }


  public String toString() {
    return String.format("Circle: center (%.3f,%.3f) radius %.3f",
        this.reference.getX(), this.reference.getY(), this.radius);
  }

  @Override
  public double distanceFromOrigin() {
    return 0;
  }
}