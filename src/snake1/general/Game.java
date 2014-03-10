package snake1.general;

import snake1.data.GameData;
import snake1.data.GameSettings;
import snake1.graphics.Screen;
import snake1.objects.GameObject;

public final class Game {

    private boolean gameOn;

    private GameData gameData;
    private Screen screen;


    private Game() {
        gameOn = true;
        screen = new Screen("Snake");
        gameData = new GameData();
    }

    public static Game create() {
        return new Game();
    }

    public void start() {
        while (gameOn) {
            doTick();
            screen.render(gameData.getMap());
        }
    }

    private void doTick() {

        for (GameObject object : gameData.getGameObjects()){
            object.event();
        }
    }


    public void restart() {

    }


}
