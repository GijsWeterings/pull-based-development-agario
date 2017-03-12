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

    // Arbitrarily chosen seed for Random.
    private static final int SEED = 121561651;

    public static final float MAX_ENEMY_SIZE = 30f;

    public EnemyBlob(float x, float y) {
        super(x, y, new Random(SEED).nextFloat() * MAX_ENEMY_SIZE);
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
