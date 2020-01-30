

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

    public double drive(int distance, double xRatio, double yRatio) {
        if (engine.getMpg() == 0)
            return  0;
        double m = abs(yRatio / xRatio);


        double xMile = gasTank.getLevel() * engine.getMpg();

        //if (distance > xMile)
            distance = (int) xMile;


        var v = distance * sqrt((1 / (1 + (m * m))));

        if (xRatio >= 0)
            this.x = (int) (this.x + v);
        else
            this.x = (int) (this.x - v);

        var v1 = m * distance * sqrt((1 / (1 + (m * m))));
        
        if (yRatio >= 0)
            this.y = (int) (this.y + v1);
        else
            this.y = (int) (this.y - v1);

        gasTank.setLevel(gasTank.getLevel() - (distance / (double) engine.getMpg()));

        if (distance > xMile)
            System.out.printf("Ran out of gas after %.2f miles \n ", xMile);


        if (distance <= 0)

            return xMile;

        else
            return distance;


    }
}











