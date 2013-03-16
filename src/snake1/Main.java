package snake1;

public class Main {
    public static boolean next_level_request = false;
    public static boolean restart_request = true;
    public static boolean game_chose = true;
    public static int gametype = 0;

    public static int level = 1;
    public static int lives = 3;

    public static final int CAMPAIGN = 1;
    public static final int SURVIVAL = 2;
    public static final int DUEL = 3;

    public static void main(String[] args) {

        Menu menu = new Menu();
        while (game_chose)
            menu.setVisible(true);


        while (restart_request) {
            restart_request = false;
            next_level_request = false;
            Screen screen = new Screen("Snake", gametype);
            screen.gameloop();
            screen.dispose();
        }
    }

}