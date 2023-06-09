package td4.exercice1;

public class Mare {
    private static final int MAX = 5;
    public Descendant[] children;
    private int nbPoulins;

    public boolean addDescendant(Descendant desc){
        if (this.nbPoulins!=Mare.MAX){
            this.children[this.nbPoulins]=desc;
            ++this.nbPoulins;
            return true;
        }
        else {
            return false;
        }
    }
}
