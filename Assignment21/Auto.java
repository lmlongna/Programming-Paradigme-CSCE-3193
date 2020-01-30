package com.Longnang;

                    ////////////////////////////////////////////
                    ///////////   ASSIGNMENT 3       ///////////
                    ////////// LAMBERT LONGNANG     ///////////
                    /////////     09-27-2018        //////////
                    //////////////////////////////////////////

import static java.lang.Math.*;
public class Auto {
    private String description;
    private int x = 0;
    private int y = 0;
    private GasTank gasTank;
    private Engine engine;


    public Auto(String description, int capacity, Engine engine) {
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

    public int getX() {
        return this.x;

    }

    public int getY() {
        return this.y;

    }

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
        double gasLevel = ((double)distance/engine.getMpg());
        double m = pow(xRatio,2)+pow(yRatio,2);
        if (gasLevel > gasTank.getLevel())
        {
            distance = (int)gasTank.getLevel()*engine.getMpg();
            gasTank.setLevel(0);
            System.out.printf("Ran out of gas after driving " + (double)distance + " miles\n");

            this.x= this.x + (int)((distance/ sqrt(m))*xRatio);
            this.y= this.y + (int)((distance/ sqrt(m))*yRatio);
        }
        else
        {
            gasTank.setLevel(gasTank.getLevel()-gasLevel);

            this.x= this.x + (int)((distance/ sqrt(m))*xRatio);
            this.y= this.y + (int)((distance/ sqrt(m))*yRatio);
        }
        return distance;


        
    }
}











