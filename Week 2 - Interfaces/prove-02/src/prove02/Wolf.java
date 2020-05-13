package prove02;

import java.awt.*;
import java.util.Random;

public class Wolf extends Creature implements Movable, Aggressor, Aware, Spawner {

    Random _rand;

    /**
     * Creates an wolf with 1 health point.
     */
    public Wolf() {
        _rand = new Random();
        _health = 1;
        _direction = _rand.nextInt(4);
        canSpawn = false;
    }

    public Wolf(Point point) {
        _location = new Point(point.x -1, point.y);
        _rand = new Random();
        _health = 1;
        _direction = _rand.nextInt(4);
        canSpawn = false;
    }

    public Shape getShape() {
        return Shape.Square;
    }

    public Color getColor() {
        return new Color(128, 128, 128);
    }

    public Boolean isAlive() {
        return _health > 0;
    }

    private Boolean canSpawn;

    /**
     * Wolves only attack animal instances and deal 5 points of damage to them.
     *
     * @param target The {@link Creature} we've encountered.
     */
    public void attack(Creature target) {
        // Zombies attack anything other than plants
        // and inflicts 10 damage on target.
        if (target instanceof Animal) {
            target.takeDamage(10);
            canSpawn = true;
        }
    }

    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {

        if (_direction == 0) {
            if (left instanceof Animal) {
                _direction = 0;
            }
            if (above instanceof Animal) {
                _direction = 1;
            }
            if (right instanceof Animal) {
                _direction = 2;
            }
            if (below instanceof Animal) {
                _direction = 3;
            }
        }
        if (_direction == 1) {
            if (above instanceof Animal) {
                _direction = 1;
            }
            if (right instanceof Animal) {
                _direction = 2;
            }
            if (below instanceof Animal) {
                _direction = 3;
            }
            if (left instanceof Animal) {
                _direction = 0;
            }
        }
        if (_direction == 2) {
            if (right instanceof Animal) {
                _direction = 2;
            }
            if (below instanceof Animal) {
                _direction = 3;
            }
            if (left instanceof Animal) {
                _direction = 0;
            }
            if (above instanceof Animal) {
                _direction = 1;
            }
        } else {
            if (below instanceof Animal) {
                _direction = 3;
            }
            if (left instanceof Animal) {
                _direction = 0;
            }
            if (above instanceof Animal) {
                _direction = 1;
            }
            if (right instanceof Animal) {
                _direction = 2;
            }
        }
    }

    /**
     * Move the wolf in it's preferred direction.
     */
    public void move() {

        // Choose a preferred direction when move() is called.
        switch (_direction) {
            case 0:
                _location.x--;
                break;
            case 1:
                _location.y--;
                break;
            case 2:
                _location.x++;
                break;
            case 3:
                _location.y++;
                break;
            default:
                break;
        }
    }

    /**
     * Spawns new wolf once they eat something.
     */
    public Creature spawnNewCreature() {
        if (canSpawn) {
            canSpawn = false;
            return new Wolf(_location);
        }
        return null;
    }
}