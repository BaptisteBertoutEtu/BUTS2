class A{

    public String label;

    public A(){
        this.label="42";
    }

    public A(String label){
        this.label=label;
    }

    public String toString(){
        return this.label;
    }

    public static void main(String[] args){
        A a1 = new A();
        A a2 = new A("choix");
        System.out.println(a1);
        System.out.println(a2);
    }

}