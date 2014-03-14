package snake1.data;

import snake1.objects.Apple;
import snake1.objects.GameObject;
import snake1.objects.Snake;
import snake1.objects.Wall;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameData {
    public static final int MAP_LENGTH = 60;
    public static final int MAP_WIDTH = 40;
    public static final Color PLAYER_SNAKE_COLOR = Color.BLUE;
    public static final Color PLAYER_TAIL_COLOR = Color.GREEN;
    public static final Color ENEMY_SNAKE_COLOR = Color.MAGENTA;
    public static final Color ENEMY_TAIL_COLOR = Color.ORANGE;

    private Arena arena;
    private List<GameObject> gameObjects;
    private Snake player;
    private Snake opponent;
    private Apple apple;
    private GameSettings settings;
    private int currentLevel;
    private int currentLives;

    public Apple getApple() {
        return apple;
    }

    //handle events here.

    public int getCurrentLives() {
        return currentLives;
    }

    public void decreaseLife() {
        currentLives--;
    }

    public GameData(GameSettings settings) {
        gameObjects = new ArrayList<>();
        this.settings = settings;
        currentLevel = settings.getFirstLevel();
        currentLives = settings.getLives();
        this.arena = new Arena(MAP_LENGTH, MAP_WIDTH, settings.getFirstLevel());
        //need to create randomly
        player = new Snake(PLAYER_SNAKE_COLOR);
        gameObjects.add(player);
        apple = new Apple();
        gameObjects.add(apple);
        if (settings.getGametype() == GameType.DUEL) {
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

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public Arena getArena() {
        return arena;
    }

    public void updateMap() {
        //arena.clear(); TODO  need to clear only the objects which moved. Otherwise I destroy the level;
        for (GameObject object : gameObjects) {
            arena.setPoint(object);
        }

    }

    public void addApple() {
        apple = new Apple();
    }

    public void addWall() {
        for (int i = 0; i < settings.getWallrate(); i++) {
            int[] emptyField = arena.getRandomEmptyField();
            arena.setPoint(emptyField[0], emptyField[1], Wall.INSTANCE);
        }
    }

    public void incSpeed() {
        settings.incSpeed();
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void nextLevel() {

    }

    public int getSpeed() {
        return settings.getSpeed();
    }

    private void resurrect() {
        snake.stop();
        snake.makeTomb(map);
        snake = new Snake(length, width, map);
        game.speed = game.inspeed;
    }
}
