package nl.gijsweterings.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by gijs on 11-3-17.
 */
public class Player extends Blob {

    public static final float MOVEMENT_SLOWDOWN_FACTOR = 0.99f;
    public static final float MOVEMENT_ACCELERATION_CAP = 1;

    public static final float INITIAL_PLAYER_SIZE = 20;

    public Player(float x, float y) {
        super(x, y, INITIAL_PLAYER_SIZE);
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
        handleMovement(container);
    }

    private void handleMovement(GameContainer container) {
        Input input = container.getInput();
        movementVector.scale(MOVEMENT_SLOWDOWN_FACTOR);
        Vector2f newMovementVector = new Vector2f(0,0);

        if(input.isKeyDown(input.KEY_D))
            newMovementVector.add(new Vector2f(MOVEMENT_ACCELERATION_CAP, 0));

        if(input.isKeyDown(input.KEY_W))
            newMovementVector.add(new Vector2f(0, -MOVEMENT_ACCELERATION_CAP));

        if(input.isKeyDown(input.KEY_A))
            newMovementVector.add(new Vector2f(-MOVEMENT_ACCELERATION_CAP, 0));

        if(input.isKeyDown(input.KEY_S))
            newMovementVector.add(new Vector2f(0, MOVEMENT_ACCELERATION_CAP));

        movementVector.add(newMovementVector.getNormal());

        setXPos(xPos() + movementVector.getX());
        setYPos(yPos() + movementVector.getY());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(movementVector, player.movementVector);
    }
}
