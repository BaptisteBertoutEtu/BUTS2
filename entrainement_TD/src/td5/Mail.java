package td5;

public class Mail {
    public static final double BASIS = 1.5;
    protected boolean express;
    private String address;
    protected static final int MULTI = 2;


    public Mail(boolean express, String address) {
        this.express = express;
        this.address = address;
    }

    public boolean isValid(){
        return this.address!=null && this.address.length()>0;
    }

    public double frank(){
        if(!this.isValid()) return 0.0;
        if(this.express) return Mail.BASIS*2; 
        return Mail.BASIS;
    }
    

    public String toString(){
        String plus="";
        if(!isValid()){
            plus="(invalide)";
        }
        else if(this.express){
            plus="(express)";
        }
        return "Mail "+plus+"\n\tDestination : "+ this.address + "\n\tPrice : "+this.frank()+" euros\n";
    }
}
