
        ////////////////////////////////////////////
        ///////////   ASSIGNMENT 4       ///////////
        ////////// LAMBERT LONGNANG     ///////////
        /////////     10-10-2019        //////////
        //////////////////////////////////////////

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


class Model
{
//    private Sprite sprite;
//    private Engine engine;
    private ArrayList<Sprite> sprites; // = new ArrayList<Sprite>();
    int z ;

    Model() throws IOException
    {
        this.sprites = new ArrayList<>();
        this.z = 0;
        this.sprites.add((Sprite)new CopAuto());


    }

    public void update(Graphics g)
    {
        Iterator<Sprite> iterator = this.sprites.iterator();

        while (iterator.hasNext()) {
            Sprite temp = iterator.next();
            temp.update(g);
        }
    }

    public void addSprite(int x, int y)
    {
        Sprite auto;

        if (this.z == 0)
            auto = new RobberAuto();
        else
            auto = new CopAuto();

        this.z = (this.z + 1) % 2;
        auto.setX(x);
        auto.setY(y);
        this.sprites.add(auto);


    }

    public void fillUp()
    {
        Iterator<Sprite> iterator = this.sprites.iterator();

        while (iterator.hasNext())
        {
            Sprite sprite = iterator.next();
            ((Auto) sprite).fillUp();
        }
    }
}

