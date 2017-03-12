package nl.gijsweterings.game;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;

public class GameObject {

    protected float x, y;
    protected Shape hitBox;
    protected Image sprite;

    public GameObject(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float xPos() {
        return x;
    }

    public float yPos() {
        return y;
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