package nl.gijsweterings;

import nl.gijsweterings.game.states.GameOverState;
import nl.gijsweterings.game.states.RunningState;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * A game using Slick2d
 */
public class Game extends StateBasedGame {

    /** Screen width */
    private static final int WIDTH = 800;
    /** Screen height */
    private static final int HEIGHT = 600;
    /** Desired framerate */
    private static final int TARGET_FRAME_RATE = 60;

    public Game() {
        super("Agar.io clone");
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new RunningState());
        addState(new GameOverState());
    }

    public static int getScreenWidth() {
        return Game.WIDTH;
    }

    public static int getScreenHeight() {
        return Game.HEIGHT;
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Game());
        app.setDisplayMode(WIDTH, HEIGHT, false);
        app.setTargetFrameRate(TARGET_FRAME_RATE);
        app.setForceExit(false);
        app.start();
    }

}
