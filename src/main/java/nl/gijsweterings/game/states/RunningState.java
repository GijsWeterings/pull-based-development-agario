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

    /**
     * Initialize the game's initial entities.
     * @param gc - The GameContainer to run the entities in.
     * @param sbg - the StateBasedGame in which the entities play.
     * @throws SlickException
     */
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        // Spawn a new player in the middle of the field
        Entity player = new Player(Game.getScreenWidth() / 2, Game.getScreenHeight() / 2);
        entities.add(player);

        // TODO spawn enemies

        entities.forEach(entity -> entity.init(gc, sbg));
    }

    /**
     * Hand all entities the ability to render.
     * @param gc - GameContainer in which to render the entities in.
     * @param sbg - StateBasedGame running, in which the entities live.
     * @param g - Graphics hook to draw elements on screen.
     * @throws SlickException
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        entities.forEach((entity) -> entity.render(gc, sbg, g));
    }

    /**
     * Updates game logic while the game runs.
     * @param gc - The gamecontainer in which the state runs
     * @param sbg - The game this state is running in.
     * @param delta
     * @throws SlickException
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        if(!Player.isAlive()) {
            // The player has died, enter the GameOverState.
            sbg.enterState(1);
        }
        else {
            entities.forEach(entity -> entity.update(gc, sbg, delta));
        }
    }

    /**
     * Returns the GameState ID.
     */
    @Override
    public int getID() {
        return ID;
    }

}
