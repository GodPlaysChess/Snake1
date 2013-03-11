package snake1;

import java.awt.*;

public class Map {
    private int sizeX;         // amount of fields in X and Y direction
    private int sizeY;
    private int map[][];
    private int level;
    private String MapName;

    public static final int allignX = 40;               // For graphics only
    public static final int allignY = 55;

    private boolean is_next_level = false;
    public boolean isNextLevel() {
        return is_next_level;
    }

    private Font LevFont = new Font("Arial", Font.BOLD, 38);


    /* CODES ON MAP */

    public static final int SPACE      = 0;
    public static final int WALL       = 1;
    public static final int SNAKE      = 2;
    public static final int APPLE      = 3;
    public static final int SNAKE_HEAD = 21;


    //default empty map with borders

    public Map(int x, int y) {
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

    public Map(int x, int y, int level) {
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

    public void draw(Graphics2D g) {
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

    private void DrawLevelSign(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setFont(LevFont);
        g.drawString(MapName, 1020, 80);
    }

    public void createWalls(int n) {
        for (int i = 0; i < n; i++) {
            new Wall(sizeX, sizeY, this);
        }

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
            }
        }

        for (int i = sizeX / 4; i < 3 * sizeX / 4; i++) {
            map[i][sizeY / 2 + 1] = 1;
            map[i][sizeY / 2 + 2] = 1;
            map[i][sizeY / 2 + 3] = 1;
            map[i][sizeY / 2 + 4] = 1;
        }

    }

    public boolean notZero(int x, int y) {
        return map[x][y] != 0;
    }

    public void setPoint(int x, int y, int map_code) {
        map[x][y] = map_code;
    }

    public int getPoint(int x, int y) {
        return map[x][y];
    }
}





