package snake1;

public class GameSettings {

    public boolean timer_off;
    public int speed, inspeed;
    public int speedlimit;
    public int wallrate;
    public int gametype;


    GameSettings(int gametype) {
        switch (gametype) {
            case Main.CAMPAIGN: {
                timer_off = true;
                speed = 50;
                speedlimit = 80;
                wallrate = 10;
                this.gametype = Main.CAMPAIGN;
            }
            break;
            case Main.SURVIVAL: {
                Main.level = 0;
                Main.lives = 0;
                timer_off = true;
                speed = 40;
                speedlimit = 80;
                wallrate = 5;
                this.gametype = Main.SURVIVAL;
            }
            break;
            case Main.DUEL: {
                Main.level = 0;
                Main.lives = 0;
                timer_off = false;
                speed = 50;
                speedlimit = 80;
                wallrate = 5;
                this.gametype = Main.DUEL;
            }
            break;

        }
        inspeed = speed;
    }
}
