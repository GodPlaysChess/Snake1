package snake1;

public class Main {
    public static boolean next_level_request = false;
    public static boolean restart_request = true;
    public static boolean game_chose = true;

    public static int level = 1;
    public static int lives = 3;

    public static void main(String[] args) {

        Menu menu = new Menu();
        while (game_chose)
            menu.setVisible(true);


        while (restart_request) {

            restart_request = false;
            next_level_request = false;
            Screen screen = new Screen("Snake", level, 0);
            screen.gameloop();
            screen.dispose();
        }
    }
}

           /*
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });
             */