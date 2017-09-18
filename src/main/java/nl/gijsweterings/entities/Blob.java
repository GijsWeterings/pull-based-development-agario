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

    /**
     * Different sprites for a various rendering in blobs.
     */
    private static final String[] SPRITES = new String[]{
            "images/blob/red.png",
            "images/blob/green.png",
            "images/blob/blue.png",
            "images/blob/yellow.png"
    };

    /**
     * The initial image size for the sprite.
     */
    private static final float INITIAL_IMAGE_SIZE = 400;

    /**
     * The size of the blob.
     */
    private float size;

    /**
     * The alive state of the blob.
     */
    private boolean isAlive;

    /**
     * The movement vector for the blob.
     */
    private Vector2f movementVector;

    /**
     * A blob in the game, represetned as a circle of a certain size.
     *
     * @param x       - the horizontal coordinate
     * @param y       - the vertical coordinate
     * @param argSize - the size of the blob
     */
    public Blob(float x, float y, float argSize) {
        super(x, y);
        size = argSize;
        isAlive = true;
        Random rand = new Random();
        try {
            setSprite(new Image(SPRITES[rand.nextInt(SPRITES.length)], false, Image.FILTER_NEAREST));
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the size of this blob.
     *
     * @return The size of the blob
     */
    public float getSize() {
        return size;
    }

    /**
     * Update the size of this blob.
     *
     * @param newSize the new size of the blob
     */
    public void setSize(float newSize) {
        this.size = newSize;
    }

    /**
     * Process the collisions between the different blobs, based on their hitbox.
     *
     * @param collisions - the list of blobs to check for collisions
     */
    public void checkCollisions(ArrayList<Blob> collisions) {
        collisions
                .stream()
                .filter(Blob::getAlive)
                .forEach(blob -> {
                    if (blob.getSize() > this.getSize()) {
                        this.setAlive(false);
                        blob.setSize(getSize() + blob.getSize());
                    } else {
                        blob.setAlive(false);
                        this.setSize(getSize() + blob.getSize());
                    }
                });
    }

    /**
     * The new state for the life of this blob.
     *
     * @param alive true iff alive, else false
     */
    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }

    /**
     * Get the alive state of this blob.
     * @return true iff the blob is still alive
     */
    public boolean getAlive() {
        return isAlive;
    }

    /**
     * Return the movement vector of this blob.
     * @return the movement vector
     */
    public Vector2f getMovementVector() {
        return movementVector;
    }

    /**
     * Set the movementvector of the blob.
     * @param newVector the new vector.
     */
    public void setMovementVector(Vector2f newVector) {
        movementVector = newVector;
    }

    /**
     * Initialize the blob in the game, set up the hitbox.
     * @param container - the gamecontainer in which to run the game.
     * @param game - the game in which the blob should exist.
     */
    public void init(GameContainer container, StateBasedGame game) {
        movementVector = new Vector2f(0, 0);
        setHitBox(new Circle(xPos(), yPos(), size));
    }

    /**
     * Render the blob in the game.
     * @param container - the gamecontainer in which to run the game
     * @param game - The state based game
     * @param g - The graphics hook to render items
     */
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        if (isAlive) {
            getSprite().draw(xPos(), yPos(), size / INITIAL_IMAGE_SIZE);
        }
    }

    /**
     * Update the logical component of the blob.
     * @param container - the gamecontainer in which to run the game
     * @param game - The state based game
     * @param delta - Amount of skipped frames
     * @param collisions - the list of collisions
     */
    public void update(GameContainer container, StateBasedGame game, int delta, ArrayList<Blob> collisions) {
        checkCollisions(collisions);
        setHitBox(new Circle(xPos(), yPos(), size));
    }

}
