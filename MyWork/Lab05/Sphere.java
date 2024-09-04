public class Sphere {
    private double diameter;

    public Sphere(double diameter) {
        this.diameter = diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double radius() {
        return this.diameter / 2;
    }

    public double diameter() {
        return this.diameter;
    }

    public double surfaceArea() {
        double radius = this.radius();
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public double volume() {
        double radius = this.radius();
        return (4.0 / 3) * Math.PI * Math.pow(radius, 3);
    }
}
