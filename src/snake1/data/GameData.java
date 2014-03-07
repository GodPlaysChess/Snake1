package snake1.data;

import snake1.objects.GameObject;
import snake1.objects.Snake;

import java.util.ArrayList;

public class GameData {
    private Map map;
    private ArrayList<GameObject> gameObjects;
    private Snake player;
    private Snake opponent;


    public Snake getOpponent() {
        return opponent;
    }

    public Snake getPlayer() {
        return player;
    }

    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

    public Map getMap() {
        return map;
    }


}
