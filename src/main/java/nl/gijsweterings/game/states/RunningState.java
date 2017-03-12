package nl.gijsweterings.game.states;

import nl.gijsweterings.Game;
import nl.gijsweterings.entities.Entity;
import nl.gijsweterings.entities.Player;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

/**
 * The default state while the game runs.
 */
public class RunningState extends BasicGameState {

    // Required state id for Slick2D
    public static final int ID = 0;

    private ArrayList<Entity> entities = new ArrayList<Entity>();

    /**
     * Initialize the running state.
     * This is the default state while the game is running.
     */
    public RunningState() {
        super();
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

    }

    /**
     * Returns the GameState ID.
     */
    @Override
    public int getID() {
        return ID;
    }

}
