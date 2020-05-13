package prove02;

import java.awt.*;
import java.util.Random;

public class Zombie extends Creature implements Movable, Aggressor {

    Random _rand;

    /**
     * Creates an zombie with 1 health point.
     */
    public Zombie() {
        _rand = new Random();
        _health = 1;
    }

    public Shape getShape() {
        return Shape.Square;
    }

    public Color getColor() {
        return new Color(0, 0, 255);
    }

    public Boolean isAlive() {
        return _health > 0;
    }

    /**
     * If we land on anything other than a plant, we will attack it dealing 10 points of damage.
     * @param target The {@link Creature} we've encountered.
     */
    public void attack(Creature target) {
        // Zombies attack anything other than plants
        // and inflicts 10 damage on target.
        if(target instanceof Animal) {
            target.takeDamage(10);
        }
        if(target instanceof Wolf) {
            target.takeDamage(10);
        }
    }

    /**
     * Move the animal from left to right.
     */
    public void move() {

        // Move the animal to the right each time move is called.
        _location.x++;
    }
}
