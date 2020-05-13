package burgener;

import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Game {
    // my constructor
    Player player;

    public Game (Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void saveGame (String filename) {
        Gson gson = new Gson();
        String gameJson = gson.toJson(player);

        try(Writer w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"))) {
            w.write(gameJson);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Game loadGame (String filename) {

        String gameJson = null;

        try {
            byte[] encoded = Files.readAllBytes(Paths.get(filename));
            gameJson = new String(encoded, "UTF-8");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        Player savedPlayer = gson.fromJson(gameJson, Player.class);

        Game newGame = new Game(savedPlayer);

        return newGame;
    }
}
