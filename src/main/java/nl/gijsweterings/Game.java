package nl.gijsweterings;

import nl.gijsweterings.game.states.RunningState;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * A game using Slick2d.
 */
public class Game extends StateBasedGame {

    /** Screen width. */
    private static final int WIDTH = 800;
    /** Screen height. */
    private static final int HEIGHT = 600;
    /** Desired framerate. */
    private static final int TARGET_FRAME_RATE = 60;

    /**
     * Launches the game.
     */
    public Game() {
        super("Agar.io clone");
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new RunningState());
    }

    /**
     * The width of the game.
     * @return the width of the game screen in px.
     */
    public static int getScreenWidth() {
        return Game.WIDTH;
    }

    /**
     * The height of the game.
     * @return the height of the game screen in px.
     */
    public static int getScreenHeight() {
        return Game.HEIGHT;
    }

    /**
     * Launches the application.
     * @param args Arguments supplied to the JVM
     * @throws SlickException if Slick fails to start the app.
     */
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Game());
        app.setDisplayMode(WIDTH, HEIGHT, false);
        app.setTargetFrameRate(TARGET_FRAME_RATE);
        app.setForceExit(false);
        app.start();
    }

}
