package td4.exercice1;

public class Descendant {
    private final int ID;
    private static int numAuto=0;
    private Mare asMother;
    private Stallion asFather;

    public Descendant(){
        ++Descendant.numAuto;
        this.ID=Descendant.numAuto;
    }
}
