package nl.gijsweterings.game;

import nl.gijsweterings.Game;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;

public class GameObject {

    public float LEFT_SCREEN_COORDINATE = 0;
    public float RIGHT_SCREEN_COORDINATE = Game.getScreenWidth() - 5;
    public float TOP_SCREEN_COORDINATE = 0;
    public float BOTTOM_SCREEN_COORDINATE = Game.getScreenHeight() - 5;

    protected float x, y;
    protected Shape hitBox;
    protected Image sprite;

    public GameObject(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float xPos() { return x; }

    public float yPos() {
        return y;
    }

    public void setXPos(float newX) {
        this.x = Math.max(LEFT_SCREEN_COORDINATE, Math.min(RIGHT_SCREEN_COORDINATE, newX));
    }

    public void setYPos(float newY) {
        this.y = Math.max(TOP_SCREEN_COORDINATE, Math.min(BOTTOM_SCREEN_COORDINATE, newY));
    }

    public Shape getHitBox() {
        return hitBox;
    }

    public void setHitBox(Shape shape) {
        this.hitBox = shape;
    }

    public boolean collides(GameObject object) {
        return this.hitBox.intersects(object.hitBox);
    }
}