

        ////////////////////////////////////////////
        ///////////   ASSIGNMENT 4       ///////////
        ////////// LAMBERT LONGNANG     ///////////
        /////////     10-10-2019        //////////
        //////////////////////////////////////////

import static java.lang.Math.*;
import java.awt.Graphics;
public class Auto extends Sprite{
    private String description;
//    private int x = 0;
//    private int y = 0;
    private GasTank gasTank;
    private Engine engine;


    public Auto(String description, int capacity, Engine engine, String jpgName) {
        super(jpgName);
        this.gasTank = new GasTank(capacity);
        if (description.isEmpty())
            this.description = "Generic auto";

        else {
            this.description = description;
        }

        if (engine == null)
            this.engine = new Engine(" ", 0, 0);
        else {
            this.engine = engine;
        }
        this.gasTank = new GasTank(capacity);

    }

    public String getDescription() {


        String description = this.description + " (engine: " + engine.getDescription() + "), fuel: "
                + String.format("%.2f", this.gasTank.getLevel()) + "/" + this.gasTank.getCapacity()
                + " location: (" + this.getX() + ", " + this.getY() + ")";
        return description;


    }

//    public int getX() {
//        return this.x;
//
//    }
//
//    public int getY() {
//        return this.y;
//
//    }

    public double getFuelLevel() {
        return this.gasTank.getLevel();

    }

    public int getMPG() {
        return this.engine.getMpg();

    }

    public void fillUp() {
        this.gasTank.setLevel(this.gasTank.getCapacity());

    }

    public int getMaxSpeed() {
        return this.engine.getMaxSpeed();

    }


     public double drive (int distance, double xRatio, double yRatio)
    {

        double xMile = (double)(gasTank.getLevel()* engine.getMpg());


        if (distance > xMile)
        {

            System.out.printf("Ran out of gas after driving %.2f miles. \n", xMile);

            gasTank.setLevel(0.0);
        }
        else
        {
            xMile = (double)distance;
            double gasLevel = (xMile/engine.getMpg());
            double gasLevelIn = gasTank.getLevel()- gasLevel;
            gasTank.setLevel(gasLevelIn);


        }
        double l=xMile/(sqrt(pow(xRatio,2)+pow(yRatio,2)));
        setX((int) ((int)getX()+(l*xRatio)));
        setY((int) ((int)getY()+(l*yRatio)));

        return xMile;
    }


    @Override
    public void update(Graphics g) {
        super.update(g);
    }
}











