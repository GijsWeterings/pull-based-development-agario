package nl.gijsweterings.entities;

import nl.gijsweterings.game.GameObject;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Base entity for all game objects.
 */
public abstract class Entity extends GameObject {

    public Entity(float x, float y) {
        super(x, y);
    }

    public abstract void init(GameContainer container, StateBasedGame game);
    public abstract void render(GameContainer container, StateBasedGame game, Graphics g);
    public abstract void update(GameContainer container, StateBasedGame game, int delta);
}
