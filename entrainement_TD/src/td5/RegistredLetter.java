package td5;


public class RegistredLetter extends Mail{
    private String format;

    public RegistredLetter(boolean express,String address, String format){
        super(express, address);
        this.format=format;
    }

    @Override
    public String toString(){
        return super.toString() + "\tFormat : "+this.format+"\n\t";
    }

    @Override
    public double frank(){
        double frank = Mail.BASIS;
        if(this.format!=null && this.format.equals("A4")) frank += 2;
        if(this.format!=null && this.format.equals("A3")) frank += 3 ;
        if(this.express) frank *= Mail.MULTI;
        return frank;
    }
}
