package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player extends Walker{
    private JFrame frame;
    public Player(World world, float halfWidth, float halfHeight) {
        super(world, new BoxShape(halfWidth, halfHeight));
    }

    public void setControlFrame(JFrame frame){
        this.frame = frame;
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_SPACE) {
                    // Jump when up arrow is pressed
                    jump(10); // You can adjust the jump speed as needed
                } else if (key == KeyEvent.VK_A) {
                    // Start walking left when left arrow is pressed
                    startWalking(-10f); // You can adjust the speed as needed
                } else if (key == KeyEvent.VK_D) {
                    // Start walking right when right arrow is pressed
                    startWalking(10f); // You can adjust the speed as needed
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_D) {
                    stopWalking();
                    // Stop walking when left or right arrow is released
                    setLinearVelocity(new Vec2(0, 0));
                }
            }
        });
    }
}
