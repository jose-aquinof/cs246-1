package prove02;

import java.awt.*;
import java.util.Random;

/**
*  Plants sit there and look green, waiting to be eaten. They are represented by green circles.
* <p>
* @author  Brother Falin
* @version 1.0
* @since   2016-12-08 
* @see Creature
*/
public class ZombieEatingPlant extends Creature implements Aggressor, Movable {

	/**
	* Creates a plant with 1 health point.
	*/
	Random _rand;

	public ZombieEatingPlant() {
		_rand = new Random();
		_health = 1;
	}
	
	// No javadocs are necessary for these methods because they will inherit the 
	// documentation from the superclass. We only need to add docs here if we are
	// doing something non-obvious in our overridden version.

	public Shape getShape() {
		return Shape.Square;
	}
	
	public Color getColor() {
		return new Color(255, 255, 0);
	}	
	
	public Boolean isAlive() {
		return _health > 0;
	}

	/**
	 * If a zombie lands on the plant, it will be attacked.
	 * @param target The {@link Creature} we've encountered.
	 */
	public void attack(Creature target) {
		// Zombies attack anything other than plants
		// and inflicts 10 damage on target.
		if(target instanceof Zombie) {
			target.takeDamage(10);
		}
	}

	/**
	 * Move the zombie eating plant in a random direction.
	 */
	public void move() {

		// Choose a random direction each time move() is called.
		switch(_rand.nextInt(4)) {
			case 0:
				_location.x++;
				break;
			case 1:
				_location.x--;
				break;
			case 2:
				_location.y++;
				break;
			case 3:
				_location.y--;
				break;
			default:
				break;
		}
	}
}