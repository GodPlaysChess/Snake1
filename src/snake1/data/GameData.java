package snake1.data;

import snake1.objects.Apple;
import snake1.objects.GameObject;
import snake1.objects.Snake;

import java.awt.*;
import java.util.ArrayList;

public class GameData {
    public static final int MAP_LENGTH = 60;
    public static final int MAP_WIDTH = 40;
    public static final Color PLAYER_SNAKE_COLOR = Color.BLUE;
    public static final Color PLAYER_TAIL_COLOR = Color.GREEN;
    public static final Color ENEMY_SNAKE_COLOR = Color.MAGENTA;
    public static final Color ENEMY_TAIL_COLOR = Color.ORANGE;

    private Map map;
    private ArrayList<GameObject> gameObjects;
    private Snake player;
    private Snake opponent;

    //handle events here.

    public GameData() {
        this.map = new Map(MAP_LENGTH, MAP_WIDTH, GameSettings.getLevel());
        //need to create randomly
        player = new Snake(PLAYER_SNAKE_COLOR);
        gameObjects.add(player);
        gameObjects.add(new Apple(MAP_LENGTH, MAP_WIDTH));
        if (GameSettings.getGametype() == GameType.DUEL){
            opponent = new Snake(ENEMY_SNAKE_COLOR);
            gameObjects.add(opponent);
        }
    }

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

    private void updateMap(){
        clearMap(); //or can just delete last position
        for (GameObject object : gameObjects){
            map.setPoint(object);
        }
             //goes through gameobjects updating positions on the map
    }


}
