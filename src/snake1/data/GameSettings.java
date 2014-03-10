package snake1.data;

public final class GameSettings {

    private static boolean timerOff;
    private static int speed, inspeed;
    private static int speedlimit;
    private static int wallrate;

    public static GameType getGametype() {
        return gametype;
    }

    private static GameType gametype;


    private static int level;
    private static int lives;

    public static final GameSettings SETTINGS = new GameSettings();

    public void setGame(GameType gameType) {
        gametype = gameType;
        switch (gameType) {
            case CAMPAIGN: {
                level = 1;
                lives = 3;
                timerOff = true;
                speed = 40;
                speedlimit = 80;
                wallrate = 10;

            }
            break;
            case SURVIVAL: {
                level = 0;
                lives = 0;
                timerOff = true;
                speed = 30;
                speedlimit = 80;
                wallrate = 5;
            }
            break;
            case DUEL: {
                level = 0;
                lives = 0;
                timerOff = false;
                speed = 40;
                speedlimit = 80;
                wallrate = 5;
            }
            break;

        }
        inspeed = speed;
    }

    private GameSettings() {
    }

    public static int getLevel() {
        return level;
    }

    public static void nextLevel(GameType gametype){
        level++;
        if (level > 2){
            timerOff = false;
        }
    }
}
