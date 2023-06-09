package td4.exercice1;
import java.util.ArrayList;

public class Stallion {
    private final int MAX;
    public ArrayList<Descendant> children;

    public Stallion(Descendant desc, int max){
        this.children= new ArrayList<>();
        this.children.add(desc);
        this.MAX=max;
    }

    public boolean addDescendant(Descendant desc){
        if(this.children.size()!=this.MAX){
            this.children.add(desc);
            return true;
        }
        else{
            return false;
        }
    }
}
