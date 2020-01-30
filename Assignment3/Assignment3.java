

                        ////////////////////////////////////////////
                        ///////////   ASSIGNMENT 3       ///////////
                        ////////// LAMBERT LONGNANG     ///////////
                        /////////     09-27-2018        //////////
                        //////////////////////////////////////////


import javax.swing.*;

public class Assignment3 {


    public static void main(String[] args) {
        String description = JOptionPane.showInputDialog(null, "Please enter the auto's description");
        String gasTank = JOptionPane.showInputDialog(null, "please enter the tank fuel capacity");


        /////
        int tempGasTank = 0;

        try {

            tempGasTank = Integer.parseInt(gasTank);

        }
        catch (NumberFormatException E) {
            JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting");
            System.exit(0);
        }
        while (tempGasTank < 0) {
            gasTank = JOptionPane.showInputDialog(null, "please enter the tank fuel capacity: ");
            try {

                tempGasTank = Integer.parseInt(gasTank);

            }
            catch (NumberFormatException E) {
                JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting");
                System.exit(0);
            }
        }

        ////////////////

        String engine = JOptionPane.showInputDialog(null, "Please enter the engine description: ");

        String mpg = JOptionPane.showInputDialog(null, "Please enter the miles per gallon: ");
        //////
        int tempMpg = 0;

        try {
            tempMpg = Integer.parseInt(mpg);
        }
        catch (NumberFormatException E) {
            JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting");
            System.exit(0);
        }


        /////
        while (tempMpg <= 0) {
            mpg = JOptionPane.showInputDialog(null, "please enter the miles per gallon: ");
            try {
                tempMpg = Integer.parseInt(mpg);
            }
            catch (NumberFormatException E) {
                JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting");
                System.exit(0);
            }

        }
        String maxSpeed = JOptionPane.showInputDialog(null, "please enter the max speed: ");
        ////
        int tempSpeed = 0;

        try {
            tempSpeed = Integer.parseInt(maxSpeed);
        }
        catch (NumberFormatException E) {
            JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting");
            System.exit(0);
        }
        ////

         tempSpeed = Integer.parseInt(maxSpeed);

        while (tempSpeed <= 0) {
            maxSpeed = JOptionPane.showInputDialog(null, "please enter the max speed: ");
            try {
                tempSpeed = Integer.parseInt(maxSpeed);
            }
            catch (NumberFormatException E) {
                JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting");
                System.exit(0);
            }

        }
        Engine engine1 = new Engine(engine, tempSpeed, tempMpg); //Engine(String, int, int);


        Auto auto1 = new Auto(description, tempGasTank, engine1);
        JOptionPane.showMessageDialog(null, auto1.getDescription());

        auto1.fillUp();

        String legs = JOptionPane.showInputDialog(null, "please enter the number of legs on the trip: ");

        /// checking  valid input
        int tempLegs = 0;

        try {
            tempLegs = Integer.parseInt(legs);
        }
        catch (NumberFormatException E) {
            JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting");
            System.exit(0);
        }
        /// checking positive numbers
        while (tempLegs <= 0) {
            legs = JOptionPane.showInputDialog(null, "please enter the number of legs on the trip: ");
            try {
                tempLegs = Integer.parseInt(legs);
            }
            catch (NumberFormatException E) {
                JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting");
                System.exit(0);
            }
        }
        auto1.fillUp();
        int[] xLegs = new int[tempLegs + 1];
        int[] yLegs = new int[tempLegs + 1];
        xLegs[0] = 0;
        yLegs[0] = 0;
        for (int i = 0; i < tempLegs; ++i) {

            String distance = JOptionPane.showInputDialog(null, "Please enter the distance for leg  " + (i + 1));
                int distanceLegs = 0;

            try {
                distanceLegs = Integer.parseInt(distance);
            }
            catch (NumberFormatException E) {
                JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting");
                System.exit(0);
            }

             distanceLegs = Integer.parseInt(distance);
            ///
            while (distanceLegs <=0){
                distance = (JOptionPane.showInputDialog(null, "Please enter the distance for leg  " + (i + 1)));

                try {
                    distanceLegs = Integer.parseInt(distance);
                }
                catch (NumberFormatException E) {
                    JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting");
                    System.exit(0);
                }
            }
            ///

            String ratioX = JOptionPane.showInputDialog(null, "Please enter the xRatio for leg " + (i + 1));
            double xRatio = 0;

            // checking xRatio
            try {
                xRatio = Double.parseDouble(ratioX);
            }
            catch (NumberFormatException E) {
                JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting");
                System.exit(0);
            }
            //// checking yRatio

            String ratioY = JOptionPane.showInputDialog(null, "Please enter the yRatio for leg " + (i + 1));
            double yRatio = 0;

            // checking xRatio
            try {
                yRatio = Double.parseDouble(ratioY);
            }
            catch (NumberFormatException E) {
                JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting");
                System.exit(0);
            }


            //double yRatio = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the yRatio for leg  " + (i + 1)));

            auto1.drive(distanceLegs, xRatio, yRatio);
            xLegs[i] = auto1.getX();
            yLegs[i] = auto1.getY();
       }

            DrivenPanel panel = new DrivenPanel(xLegs, yLegs, tempLegs);
            JFrame application = new JFrame();
            application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            application.add(panel);
            application.setSize(600, 600);
            application.setVisible(true);
        }




}



