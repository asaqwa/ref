package Games.Arkanoid;

public abstract class BaseObject {
    private double x;
    private double y;
    private double radius;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public boolean intersects(BaseObject o) {         // Math.hypot(x-o.x, y-o.y) works much longer
        double distance = Math.sqrt(Math.pow((x - o.x), 2) + Math.pow((y - o.y), 2));
        return distance <= Math.max(radius, o.radius);
    }

    public abstract void draw(Canvas canvas);

    public abstract void move();

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
