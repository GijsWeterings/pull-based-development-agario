package nl.gijsweterings.game;

import nl.gijsweterings.Game;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;

/**
 * A general object for use in the game.
 */
public class GameObject {

    /**
     * The minimal coordinate for the horizontal movement.
     */
    private static final float LEFT_SCREEN_COORDINATE = 0;

    /**
     * The maximal coordinate for the horizontal movement.
     */
    private static final float RIGHT_SCREEN_COORDINATE = Game.getScreenWidth() - 5;

    /**
     * The minimal coordinate for the vertical movement.
     * Vertical goes from top to bottom.
     */
    private static final float TOP_SCREEN_COORDINATE = 0;

    /**
     * The maximal coordinate for the vertical movement.
     * Vertical goes from top to bottom.
     */
    private static final float BOTTOM_SCREEN_COORDINATE = Game.getScreenHeight() - 5;

    /**
     * The x and y coordinates of the GameObject.
     */
    private float x, y;

    /**
     * A Shape representing the hitbox of the object.
     * All physics calculations will be done based on this shape.
     */
    private Shape hitBox = null;


    /**
     * The image rendered on screen for this object.
     */
    private Image sprite = null;

    /**
     * Creates an object in the game, based on the x and y coordinates given.
     * @param argX The x coordinate where the object spawns.
     * @param argY The y coordinate where the object spawns.
     */
    public GameObject(float argX, float argY) {
        this.x = argX;
        this.y = argY;
    }

    /**
     * The horizontal position of the object in the game.
     * @return the x-coordinate of this object.
     */
    public float xPos() {
        return x;
    }

    /**
     * The vertical position of the object in the game.
     * @return the y-coordinate of this object.
     */
    public float yPos() {
        return y;
    }

    /**
     * Sets the horizontal position of this GameObject.
     * This method has a side effect that bounds the coordinates to somewhere inside the Game's field.
     * No exception will be thrown!
     * @param newX - The x-coordinate to set the GameObject to.
     */
    public void setXPos(float newX) {
        this.x = Math.max(LEFT_SCREEN_COORDINATE, Math.min(RIGHT_SCREEN_COORDINATE, newX));
    }

    /**
     * Sets the vertical position of this GameObject.
     * This method has a side effect that bounds the coordinates to somewhere inside the Game's field.
     * No exception will be thrown!
     * @param newY - The y-coordinate to set the GameObject to.
     */
    public void setYPos(float newY) {
        this.y = Math.max(TOP_SCREEN_COORDINATE, Math.min(BOTTOM_SCREEN_COORDINATE, newY));
    }


    /**
     * The image that should be rendered for this GameObject.
     * @return and Image object containing the correct sprite.
     */
    public Image getSprite() {
        return sprite;
    }

    /**
     * Change the sprite of this GameObject to a new image.
     * @param newSprite The new image to assume.
     */
    public void setSprite(Image newSprite) {
        this.sprite = newSprite;
    }

    /**
     * Returns the Shape object representing the Game Object in physics simulations.
     * @return the Shape object describing the object
     */
    public Shape getHitBox() {
        return hitBox;
    }

    /**
     * Sets the hitbox of the GameObject to a new hitbox.
     * Warning! Setting the hitbox without changing the sprite as well may have unexpected effects for the player.
     * @param shape - The new shape the physics of the GameObject will consider.
     */
    public void setHitBox(Shape shape) {
        this.hitBox = shape;
    }

    /**
     * Checks if the GameObject collides with another GameObject.
     * @param object - The object to check hitboxes against.
     * @return true iff the hitboxes intersect.
     */
    public boolean collides(GameObject object) {
        return this.hitBox.intersects(object.hitBox);
    }
}
