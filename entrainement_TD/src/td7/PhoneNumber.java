package td7;

public class PhoneNumber {
    private int countryCode;
    private int areaCode;
    private int secteurCode;
    private int one;
    private int two;
    private int three;

    public PhoneNumber(int countryCode, int areaCode, int secteurCode, int one, int two, int three) {
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.secteurCode = secteurCode;
        this.one = one;
        this.two = two;
        this.three = three;
    }

    public String standardFormat(){
        return ""+this.countryCode+" "+this.areaCode+" "+this.secteurCode+" "+this.one+" "+this.two+" "+this.three;
    }

    public String internationalFormat(){
        return "+33 "+this.standardFormat().substring(1);
    }

    public String toString(){
        return this.standardFormat();
    }
    
}