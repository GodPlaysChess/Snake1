package snake1.general;

import snake1.graphics.Menu;

public class Main {
    public static boolean nextLevelRequest;
    public static boolean restartRequest;

    public static void main(String[] args) {

        while (true) {
            while (Menu.MENU.isGameChosen()) {
                Game game = Game.create();
                game.start();
               /*
                restartRequest = false;
                nextLevelRequest = false;
                Screen screen = new Screen("Snake");
                screen.gameloop();
                screen.dispose();*/
            }

        }
    }
}

