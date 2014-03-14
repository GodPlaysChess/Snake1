package snake1.data;

public final class GameSettings {

    private boolean timerOff = false;
    private int speed, inspeed;
    private int speedlimit;

    private int firstLevel; // -> moveHead to gameData
    private int lives;
    private GameType gametype;
    private int wallrate;

    public int getWallrate() {
        return wallrate;
    }

    private GameSettings() {
    }

    public GameType getGametype() {
        return gametype;
    }

    public int getSpeed() {
        return speed;
    }

    public static GameSettings setGame(GameType gameType) {
        GameSettings settings = new GameSettings();
        settings.gametype = gameType;
        switch (gameType) {
            case CAMPAIGN: {
                settings.firstLevel = 1;
                settings.lives = 3;
                settings.timerOff = true;
                settings.speed = 40;
                settings.speedlimit = 80;
                settings.wallrate = 10;

            }
            break;
            case SURVIVAL: {
                settings.firstLevel = 0;
                settings.lives = 0;
                settings.timerOff = true;
                settings.speed = 30;
                settings.speedlimit = 80;
                settings.wallrate = 5;
            }
            break;
            case DUEL: {
                settings.firstLevel = 0;
                settings.lives = 0;
                settings.timerOff = false;
                settings.speed = 40;
                settings.speedlimit = 80;
                settings.wallrate = 5;
            }
            break;

        }
        return settings;
    }

    public int getFirstLevel() {
        return firstLevel;
    }

    public void incSpeed() {
        if (speed < speedlimit) {
            speed++;
        }
    }

    public void nextLevel() {
        firstLevel++;
        if (firstLevel > 2) {
            timerOff = false;
        }
    }

    public int getLives() {
        return lives;
    }
}
