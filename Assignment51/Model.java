
////////////////////////////////////////////
///////////   ASSIGNMENT 5       ///////////
////////// LAMBERT LONGNANG     ///////////
/////////     10-19-2019        //////////
//////////////////////////////////////////

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


class Model
{

    private ArrayList<Sprite> sprites; // = new ArrayList<Sprite>();
    private int captured;
    int tempAuto ;


    Model() throws IOException
    {

        this.sprites = new ArrayList<>();
        this.tempAuto = 0;
        this.sprites.add(new Bank());


    }

    public void update(Graphics g)
    {
        synchronized(sprites) {
            Iterator<Sprite> iterator = this.sprites.iterator();

            while (iterator.hasNext()) {
                iterator.next().updateImage(g);

            }
        }
    }

    public void addSprite(int x, int y)
    {
        synchronized(sprites) {
            Sprite auto;

            if (this.tempAuto == 1)
                auto = new RobberAuto();
            else
                auto = new CopAuto();

            this.tempAuto = (this.tempAuto + 1) % 2;
            auto.setX(x);
            auto.setY(y);
            if (this.tempAuto == 0) {
                auto.setX(300);
                auto.setY(300);
            }
            this.sprites.add(auto);

        }
    }
    public void updateScene(int width, int height) {
//        var iterator = this.sprites.iterator();
//        while (iterator.hasNext()) {
//
//            // updateState();
//        }
        synchronized(sprites) {
            for (Sprite sprite : sprites) {
                sprite.updateState(width, height);
            }
            Iterator<Sprite> iterator = this.sprites.iterator();
            while (iterator.hasNext()) {
                Sprite sprite = iterator.next();
                if (sprite instanceof RobberAuto && ((RobberAuto) sprite).hasEscaped()) {
                    System.out.println("I am Free!");
                    iterator.remove();
                }
            }

            for (int x = 0; x < sprites.size(); x++) {
                if (sprites.get(x) instanceof CopAuto) {
                    for (int y = 0; y < sprites.size(); y++) {
                        if (sprites.get(y) instanceof RobberAuto) {
                            if (sprites.get(y).overlaps(sprites.get(x))) {
                                ((RobberAuto) sprites.get(y)).captured();
                                System.out.println("Gotcha!");

                            }
                        }
                    }
                }
            }
        }
    }
    public void initalize () {
        synchronized (sprites) {
            sprites = new ArrayList<Sprite>();
            Bank bank = new Bank();
            sprites.add(bank);
            RobberAuto.escaped = 0;
            RobberAuto.captured = 0;
//
        }
    }
//    public void fillUp()
//    {
//        Iterator<Sprite> iterator = this.sprites.iterator();
//
//        while (iterator.hasNext())
//        {
//            Sprite sprite = iterator.next();
//            ((Auto) sprite).fillUp();
//        }
//    }
}


