package snake1;

public class Main {
    public static boolean restart_request = true;
    public static void main(String[] args) {
        while(restart_request) {
            restart_request = false;
            Screen screen = new Screen("Snake", 1);
            screen.gameloop();
            screen.dispose();
        }
    }
}

