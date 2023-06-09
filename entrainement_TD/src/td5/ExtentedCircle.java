package td5;

public class ExtentedCircle extends Point{
    private double r;

    public ExtentedCircle(double x, double y,double r) {
        super(x, y);
        this.r=r;
    }

    public void moveCenter(double dX, double dY) {
        super.setX(dX);
        super.setY(dY);
    }

    public void updateCenter(double dR) {
        this.r=dR;
    }

    public Point getCenter(){
        return (Point)this;
    }

    public String toString(){
        return "EncapsulatedCircle[Point("+super.getX()+","+super.getY()+"),"+this.r+"]";
    }

    
}
