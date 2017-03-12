package nl.gijsweterings.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by gijs on 11-3-17.
 */
public class Player extends Blob {

    private static final float INITIAL_PLAYER_SIZE = 20;

    private InputProvider inputProvider;

    public Player(float x, float y) {
        super(x, y, INITIAL_PLAYER_SIZE);
    }

    public void init(GameContainer container, StateBasedGame game) {
        inputProvider = new InputProvider(container.getInput());
//        inputProvider.addListener(this);
//        inputProvider.bindCommand();

    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        sprite.draw(xPos(), yPos(), size/INITIAL_IMAGE_SIZE);
    }

    public void update(GameContainer container, StateBasedGame game, int delta) {

    }

    public static boolean isAlive() {
        return true;
    }
}
