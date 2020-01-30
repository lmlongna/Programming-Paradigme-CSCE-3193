

////////////////////////////////////////////
///////////   ASSIGNMENT 5       ///////////
////////// LAMBERT LONGNANG     ///////////
/////////     10-19-2019        //////////
//////////////////////////////////////////

public class SpriteMover implements Runnable {
    Model model;
    View view;
    public SpriteMover(Model model1,View view1){
      model= model1;
      view= view1;
    }

    @Override
    public void run() {
        while (true) {
            model.updateScene(view.getWidth(),view.getHeight());
            view.repaint();
//		... cause the scene to be updated here ...
//
//		... cause the scene to be redrawn here ...

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {}

    }
}
}