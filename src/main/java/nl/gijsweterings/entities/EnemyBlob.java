package nl.gijsweterings.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by gijs on 12-3-17.
 */
public class EnemyBlob extends Blob {

    /**
     * Arbitrarily chosen seed for Random.
     */
    private static final int SEED = 121561651;

    /**
     * The maximum size an EnemyBlob can be.
     * This limits the random size on creation only!
     */
    public static final float MAX_ENEMY_SIZE = 30f;

    /**
     * Random seed generator.
     */
    private static final Random GENERATOR = new Random(SEED);

    /**
     * Constructs an Enemy blob, which has a random size between 0 and MAX_ENEMY_SIZE.
     * @param x - x-coordinate where blob will spawn
     * @param y - y-coordinate where enemy will spawn
     */
    public EnemyBlob(final float x, final float y) {
        super(x, y, GENERATOR.nextFloat() * MAX_ENEMY_SIZE);
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) {
        super.init(container, game);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        super.render(container, game, g);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta, ArrayList<Blob> collisions) {
        super.update(container, game, delta, collisions);

    }
}
