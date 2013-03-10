import javax.script.ScriptEngine;

public class Main {
    public static void main(String[] args) {

        while (true) {

            if (Screen.restart_request) {

                Screen.restart_request = false;
                Screen screen = new Screen("Snake", 1);
                screen.dispose();
            }


        }


    }
}

