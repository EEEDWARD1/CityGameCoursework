package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game {

    /* Initialises a new Game*/
    public Game() {
        //Initialises a new world
        World world = new World();

        //Create floor
        Shape shape = new BoxShape(50, 0.5f);
        StaticBody ground = new StaticBody(world, shape);
        ground.setPosition(new Vec2(0f, -11.5f));
        ground.setFillColor(Color.BLUE);

        //Create Character
        //Character character = new Character(world, 1,2,7,-4,true);

        Player player = new Player(world,1,2);
        player.setGravityScale(2);

        UserView view = new UserView(world, 800, 600);
        view.setGridResolution(1);

        final JFrame frame = new JFrame("Coursework Game");
        frame.add(view);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        player.setControlFrame(frame);
        world.start();
    }

    public static void main(String[] args) {

        new Game();
    }
}
