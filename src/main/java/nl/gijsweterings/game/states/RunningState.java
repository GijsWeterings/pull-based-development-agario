package nl.gijsweterings.game.states;

import nl.gijsweterings.Game;
import nl.gijsweterings.entities.Blob;
import nl.gijsweterings.entities.EnemyBlob;
import nl.gijsweterings.entities.Player;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * The default state while the game runs.
 */
public class RunningState extends BasicGameState {

    /**
     * Required state id for Slick2D.
     */
    public static final int ID = 0;

    /**
     * The number of enemy blobs in the game.
     */
    private static final Integer NUMBER_OF_ENEMIES = 5;

    /**
     * The collection of entities in the RunningState game.
     */
    private ArrayList<Blob> entities = new ArrayList<Blob>();

    /**
     * The player's Game object.
     */
    private Player player;

    /**
     * Initialize the running state.
     * This is the default state while the game is running.
     */
    public RunningState() {
        super();
    }

    /**
     * Initialize the game's initial entities.
     *
     * @param gc  - The GameContainer to run the entities in.
     * @param sbg - the StateBasedGame in which the entities play.
     * @throws SlickException
     */
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        entities.clear();

        // Spawn a new player in the middle of the field
        player = new Player(Game.getScreenWidth() / 2.0f, Game.getScreenHeight() / 2.0f);
        entities.add(player);

        Random rand = new Random();
        for (int i = 0; i < NUMBER_OF_ENEMIES; i++) {
            int x = rand.nextInt(Game.getScreenWidth());
            int y = rand.nextInt(Game.getScreenHeight());
            entities.add(new EnemyBlob(x, y));
        }

        entities.forEach(entity -> entity.init(gc, sbg));
    }

    /**
     * Hand all entities the ability to render.
     *
     * @param gc  - GameContainer in which to render the entities in.
     * @param sbg - StateBasedGame running, in which the entities live.
     * @param g   - Graphics hook to draw elements on screen.
     * @throws SlickException
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        entities.forEach((entity) -> entity.render(gc, sbg, g));
    }

    /**
     * Updates game logic while the game runs.
     *
     * @param gc    - The gamecontainer in which the state runs
     * @param sbg   - The game this state is running in.
     * @param delta - Difference in frames.
     * @throws SlickException
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        if (!player.getAlive() || entities.size() == 1) {
            // The player has died, enter the GameOverState.
            // TODO create gameoverstate
            return;
        } else {
            entities.removeIf(blob -> !blob.getAlive());

            entities.forEach(blob -> {
                ArrayList<Blob> collisionsForThisBlob =
                        entities.stream()
                                .filter(b -> b.getAlive())
                                .filter(b -> !blob.equals(b))
                                .filter(b -> blob.collides(b))
                                .collect(Collectors.toCollection(ArrayList::new));
                blob.update(gc, sbg, delta, collisionsForThisBlob);
            });
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
