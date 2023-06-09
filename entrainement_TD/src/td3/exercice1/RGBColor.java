package td3.exercice1;

class RGBColor{
    private String name;

    private int red;
    private int green;
    private int blue;

    public RGBColor(String name, int red, int green, int blue){

        if(!between(red) || !between(green) || !between(blue)){
            this.red=0;
            this.green=0;
            this.blue=0;
            this.name=null;
        }
        else{
            this.red=red;
            this.green=green;
            this.blue=blue;
            this.name=name;
        }
    }

    private boolean between(int nb) {
        return nb>=0 && nb<=255;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return ""+this.name+":R="+this.red+",G="+this.green+",B="+this.blue;
    }

    public void deepen(int k){
        this.name+="+"+k;
        this.red=add(this.red,k);
        this.green=add(this.green,k);
        this.blue=add(this.blue,k);
    }

    public int add(int before, int multiplicator){
        int temp = before * multiplicator;
        while(temp>255){
            temp -= 255;
        }
        return temp;
    }

    
}