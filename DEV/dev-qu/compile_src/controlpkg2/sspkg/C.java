package controlpkg2.sspkg;

public class C {
    private String aLabel;
    private int aNumber;
    
    public C(String aLabel, int aNumber) {
        this.aLabel = aLabel;
        this.aNumber = aNumber;
    }
    public String getALabel() {return aLabel;}
    public void setALabel(String aLabel) {this.aLabel = aLabel;}
    public int getANumber() {return aNumber;}
    public void setANumber(int aNumber) {this.aNumber = aNumber;}
    @Override
    public String toString() {
        return "C [aLabel=" + aLabel + ", aNumber=" + aNumber + "]";
    }
}
