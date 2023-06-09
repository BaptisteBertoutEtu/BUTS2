package td5;

public class EncapsuledCircle {
    private Point p;
    private double r;

    public EncapsuledCircle(double x, double y, double r) {
        this.p = new Point(x, y);
        this.r=r;
    }

    public void moveCenter(double dX, double dY) {
        this.p.setX(dX);
        this.p.setY(dY);
    }

    public void updateCenter(double dR) {
        this.r=dR;
    }

    public Point getCenter(){
        return this.p;
    }

    public String toString(){
        return "EncapsulatedCircle[Point("+this.p.getX()+","+this.p.getY()+"),"+this.r+"]";
    }
    
}