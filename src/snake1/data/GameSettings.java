package snake1.data;

public final class GameSettings {

    private static boolean timer_off;
    private static int speed, inspeed;
    private static int speedlimit;
    private static int wallrate;
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
                timer_off = true;
                speed = 40;
                speedlimit = 80;
                wallrate = 10;

            }
            break;
            case SURVIVAL: {
                level = 0;
                lives = 0;
                timer_off = true;
                speed = 30;
                speedlimit = 80;
                wallrate = 5;
            }
            break;
            case DUEL: {
                level = 0;
                lives = 0;
                timer_off = false;
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
}
