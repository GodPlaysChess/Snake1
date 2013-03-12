package snake1;

public class Main {
    public static boolean next_level_request = false;
    public static boolean restart_request = true;
    public static int level = 1;
    public static int lives = 3;
    public static void main(String[] args) {

        while(restart_request) {
            restart_request = false;
            next_level_request = false;
            Screen screen = new Screen("Snake", level);
            screen.gameloop();
            screen.dispose();
        }

    }
}

