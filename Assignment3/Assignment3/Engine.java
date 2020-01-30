

                    ////////////////////////////////////////////
                    ///////////   ASSIGNMENT 3       ///////////
                    ////////// LAMBERT LONGNANG     ///////////
                    /////////     09-27-2018        //////////
                    //////////////////////////////////////////

public class Engine {
    private String description;
    private int mpg;
    private int maxSpeed;

    public Engine(String description, int mpg, int maxSpeed) {
        this.description = description;
        if (description.isEmpty())
            this.description = " Generic engine";

        this.mpg = mpg;
        if (this.mpg < 0)
            this.mpg = 0;

        this.maxSpeed = maxSpeed;
        if (this.maxSpeed < 0)
            this.maxSpeed = 0;

    }

    public String getDescription() {
        String engine1 = this.description + " (MPG: " + this.mpg + ", Max speed: " + this.maxSpeed+")" ;
        return engine1;
    }

    public int getMpg() {

        return this.mpg;
    }
    public int getMaxSpeed(){

        return this.maxSpeed;
    }
}
