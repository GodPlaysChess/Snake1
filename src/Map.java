import java.awt.*;

public class Map {
    int sizeX;         // amount of fields in X and Y direction
    int sizeY;
    int map[][];
    int level;
    String MapName;

    public static final int allignX = 40;               // For graphics only
    public static final int allignY = 55;

    boolean gamover = false;
    boolean nextlevel = false;

    Font LevFont = new Font("Arial", Font.BOLD, 38);


    /* CODES ON MAP

    0 - SPACE
    1 - WALL
    2 - SNAKE
    3 - APPLE
    21 - SNAKE HEAD

    */


    //default empty map with borders

    Map(int x, int y) {
        sizeX = x;
        sizeY = y;
        map = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 || j == 0 || i == (x - 1) || j == (y - 1))
                    map[i][j] = 1;
                else map[i][j] = 0;
            }
        }
    }

    Map(int x, int y, int level) {
        sizeX = x;
        sizeY = y;
        map = new int[x][y];
        MapName = "Level " + level;
        switch (level) {
            case 1:
                level1(x, y);
                break;
            case 2:
                level2(x, y);
                break;
        }

    }

    void draw(Graphics2D g) {
        DrawLevelSign(g);

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                switch (map[i][j]) {
                    case 0:
                        g.setColor(Color.WHITE);
                        break;
                    case 1:
                        g.setColor(Color.DARK_GRAY);
                        break;
                    case 2:
                        g.setColor(Color.GREEN);
                        break;
                    case 21:
                        g.setColor(Color.BLUE);
                        break;
                    case 3:
                        g.setColor(Color.RED);
                        break;

                }
                g.fillRect(allignX + i * 15, allignY + j * 15, 15, 15);
            }
        }
    }

    private void DrawLevelSign(Graphics2D g){
        g.setColor(Color.BLACK);
        g.setFont(LevFont);
        g.drawString(MapName, 1020, 80);
    }

    void tracksnake(Snake s) {

        map[s.x][s.y] = 21;

        for (int i = 1; i < s.getTail(); i++) {                           //was 0 without head
            map[s.snakeposX.get(i)][s.snakeposY.get(i)] = 2;
        }
        map[s.traceX][s.traceY] = 0;

    }

    void trackapple(Apple a) {
        map[a.x][a.y] = 3;
    }

    void create_walls(int n) {
        for (int i = 0; i < n; i++) {
            Wall W = new Wall(sizeX, sizeY, this);
        }

    }

    void event_check(Snake s, Apple a) {
        if (map[s.x][s.y] == 1)
            s.destroy();

        if (s.x == a.x && s.y == a.y)
            s.manger(a);

        if (s.getTail() > 1) {
            for (int i = 1; i < s.getTail(); i++) {
                if (s.x == s.snakeposX.get(i) && s.y == s.snakeposY.get(i))
                    s.destroy();
            }
        }

        if (s.isdestroyed)
            gamover = true;

    }

    private void level1(int sizeX, int sizeY) {

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (i == 0 || j == 0 || i == (sizeX - 1) || j == (sizeY - 1))
                    map[i][j] = 1;
                else map[i][j] = 0;
            }

        }
    }

    private void level2(int sizeX, int sizeY) {

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                map[i][j] = 0;
            }}

        for (int i = sizeX / 4; i < 3 * sizeX / 4; i++) {
            map[i][sizeY / 2 + 1] = 1;
            map[i][sizeY / 2 + 2] = 1;
            map[i][sizeY / 2 + 3] = 1;
            map[i][sizeY / 2 + 4] = 1;
        }

    }
}





