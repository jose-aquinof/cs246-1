package burgener;

public class Main {

    public static void main(String[] args) {
        Player p = new Player("Wes", 5, 10, 10);
        p.addEquipment("Knife", 2);
        p.addEquipment("Crossbow", 5);
        p.addEquipment("Bomb", 10);
        System.out.println(p);

        Game g = new Game(p);
        g.saveGame("/Users/wes/Documents/School/SP20/team-03/src/main/java/burgener/saveGame.txt");

        System.out.println("Loading Game...");

        Game loadGame = g.loadGame("/Users/wes/Documents/School/SP20/team-03/src/main/java/burgener/saveGame.txt");
        System.out.println(loadGame.getPlayer());
    }
}
