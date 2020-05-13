package burgener;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private String name;
    private int health;
    private int mana;
    private int gold;

    private Map<String, Integer> equipment;

    public Player (String name, int health, int mana, int gold) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.gold = gold;

        this.equipment = new HashMap<>();
    }

    public String toString() {
        return String.format("Name: %s \nHealth: %d \nMana: %d \nGold: %d \nSize of equipment: %d",
                name, health, mana, gold, equipment.size()
        );
    }

    public void addEquipment (String name, int value) {
        equipment.put(name, value);
    }
}


