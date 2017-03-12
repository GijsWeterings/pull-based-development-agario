package nl.gijsweterings.game.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by gijs on 11-3-17.
 */
public class GameOverState extends BasicGameState {

    // Required state id for Slick2D
    public static final int ID = 1;

    private InputProvider inputProvider;

    /**
     * Initialize the game over state.
     * This state is shown when the player is dead.
     */
    public GameOverState() {
        super();
    }

    // init-method for initializing all resources
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

    }

    // render-method for all the things happening on-screen
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawString("INSERT COIN TO CONTINUE", 50, 50);
    }

    /**
     * Updates interaction with the game during this screen.
     * @param gc - The gamecontainer in which the state runs
     * @param sbg -
     * @param arg2
     * @throws SlickException
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int arg2) throws SlickException {
        Input input = gc.getInput();

        if(input.isKeyDown(Input.KEY_SPACE)) {
            sbg.getState(0).init(gc, sbg);
            sbg.enterState(0);
        }
    }

    /**
     * Returns the GameState ID for the GameOverState.
     */
    @Override
    public int getID() {
        return ID;
    }

}
