

public class GasTank {
    private int capacity;
    private double level;


    public GasTank(int capacity) {

        if (capacity < 0) {
            this.capacity = 0;
        }
        else {
            this.capacity = capacity;
        }

        this.level = 0;
    }


    public int getCapacity(){

        return  this.capacity;

    }
    public double getLevel(){
        return this.level;

    }
    public void setLevel(double levelIn){
        if (levelIn < 0.0)
            levelIn = 0.0;


        if (levelIn > getCapacity())
            this.level = this.capacity;
        else
            this.level = levelIn;



    }


}

