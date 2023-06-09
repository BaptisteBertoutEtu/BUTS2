package td5;

public class Main {
    
    public static void main(String[] args) {
        Mail m1 = new Mail(false, "adr");
        Mail m2 = new Mail(true, "adr");
        Mail m3 = new Mail(true, "");

        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);

        RegistredLetter r1 = new RegistredLetter(false, "adr","A4");
        RegistredLetter r2 = new RegistredLetter(true, "adr","A3");
        RegistredLetter r3 = new RegistredLetter(true, "","A3");

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);

        Packet p1 = new Packet(false, "adr", 10);
        Packet p2 = new Packet(true, "adr", 10);
        Packet p3 = new Packet(true, "", 10);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
    
}
