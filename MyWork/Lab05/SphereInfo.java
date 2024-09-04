public class SphereInfo {
    public static void main(String[] args) {
        if (args.length > 0) {
            double diameter = Double.parseDouble(args[0]);
            Sphere sphere = new Sphere(diameter);

            System.out.println("A sphere of radius " + sphere.radius() + " has surface area " + sphere.surfaceArea() + " and volume " + sphere.volume());
        }
    }
}
