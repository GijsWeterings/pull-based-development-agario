package nl.gijsweterings.entities;

import nl.gijsweterings.game.GameObject;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by gijs on 12-3-17.
 */
public abstract class Blob extends GameObject {

    public static final String[] sprites = new String[]{
            "images/blob/red.png",
            "images/blob/green.png",
            "images/blob/blue.png",
            "images/blob/yellow.png"
    };

    public static final float INITIAL_IMAGE_SIZE = 400;

    protected float size;
    protected boolean isAlive;
    protected Vector2f movementVector;

    public Blob(float x, float y, float _size) {
        super(x, y);
        size = _size;
        isAlive = true;
        Random rand = new Random();
        try {
            this.sprite = new Image(Blob.sprites[rand.nextInt(Blob.sprites.length)], false, Image.FILTER_NEAREST);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }


    public void checkCollisions(ArrayList<Blob> collisions) {
        collisions
                .stream()
                .filter(e -> e.getAlive())
                .forEach(blob -> {
                    if (blob.getSize() > this.getSize()) {
                        this.setAlive(false);
                        blob.setSize(getSize() + blob.getSize());
                    }
                    else {
                        blob.setAlive(false);
                        this.setSize(getSize() + blob.getSize());
                    }
                });
    }

    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }

    public boolean getAlive() {
        return isAlive;
    }

    public void init(GameContainer container, StateBasedGame game) {
        movementVector = new Vector2f(0,0);
        setHitBox(new Circle(xPos(), yPos(), size));
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        if(isAlive)
            sprite.draw(xPos(), yPos(), size / INITIAL_IMAGE_SIZE);
    }

    public void update(GameContainer container, StateBasedGame game, int delta, ArrayList<Blob> collisions) {
        checkCollisions(collisions);
        setHitBox(new Circle(xPos(), yPos(), size));
    }


}
