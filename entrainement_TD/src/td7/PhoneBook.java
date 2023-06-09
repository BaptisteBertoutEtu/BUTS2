package td7;

import java.util.HashMap;
import java.lang.StringBuilder;

public class PhoneBook {
    private HashMap<String,PhoneNumber> directory;

    public PhoneBook(){
        directory = new HashMap<String,PhoneNumber>();
    }

    public String toString() {
        StringBuilder toString = new StringBuilder();
        for (String phone : directory.keySet()) {
            toString.append(phone);
        }
        return toString.toString();
    }

    public boolean alreadyDefined(){
        
    }
}
