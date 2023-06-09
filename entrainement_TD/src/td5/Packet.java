package td5;


public class Packet extends Mail{
    private double weight;

    public Packet(boolean express, String address,double weight) {
        super(express, address);
        this.weight=weight;
    }

    @Override
    public String toString(){
        return super.toString() + "\tWeight : "+this.weight+" g";
    }

    @Override
    public double frank(){
        double plus = 0.05 * (this.weight/10.0);
        double frank = Mail.BASIS + plus;
        if(this.express) frank*= Mail.MULTI;
        return frank;
    }
    

    
}
