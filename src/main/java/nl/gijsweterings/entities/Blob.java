package nl.gijsweterings.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by gijs on 12-3-17.
 */
public abstract class Blob extends Entity {

    public static final String[] sprites = new String[]{
            "images/blob/red.png",
            "images/blob/green.png",
            "images/blob/blue.png",
            "images/blob/yellow.png"
    };

    public static final float INITIAL_IMAGE_SIZE = 400;

    protected float size;

    public Blob(float x, float y, float _size) {
        super(x, y);
        size = _size;
        try {
            this.sprite = new Image(Blob.sprites[0], false, Image.FILTER_NEAREST);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public abstract void init(GameContainer container, StateBasedGame game);
    public abstract void render(GameContainer container, StateBasedGame game, Graphics g);
    public abstract void update(GameContainer container, StateBasedGame game, int delta);

}
