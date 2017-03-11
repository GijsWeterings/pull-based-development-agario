package nl.gijsweterings;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * A game using Slick2d
 */
public class Game extends BasicGame {

    /** Screen width */
    private static final int WIDTH = 800;
    /** Screen height */
    private static final int HEIGHT = 600;

    public Game() {
        super("Agar.io clone");
    }

    public void render(GameContainer container, Graphics g) throws SlickException {
        g.drawString("Welcome to Agar.io!", 50, 50);
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        // TODO set up world, spawn entities
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        // TODO listen for keyboard input, apply movement vector
    }

    
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Game());
        app.setDisplayMode(WIDTH, HEIGHT, false);
        app.setForceExit(false);
        app.start();
    }

}
