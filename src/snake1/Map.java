package snake1;

import java.awt.*;

public class Map {
    private int sizeX;         // amount of fields in X and Y direction
    private int sizeY;
    private int map[][];

    private String MapName;

    public static final int allignX = 40;               // For graphics only
    public static final int allignY = 55;

    private Font LevFont = new Font("Arial", Font.BOLD, 38);


    /* CODES ON MAP */

    public static final int SPACE = 0;
    public static final int WALL = 1;
    public static final int SNAKE = 2;
    public static final int APPLE = 3;
    public static final int SNAKE_HEAD = 21;
    public static final int SNAKE2_HEAD = 41;
    public static final int SNAKE2 = 4;

    //default empty map with borders

    public Map(int x, int y, int level) {
        sizeX = x;
        sizeY = y;
        map = new int[x][y];
        MapName = "Level " + level;
        switch (level) {
            case 0:
                level0(x, y);
                break;

            case 1:
                level1(x, y);
                break;
            case 2:
                level2(x, y);
                break;
            case 3:
                level3(x, y);
                break;
            case 4:
                level4(x, y);
                break;
            case 5:
                level5(x, y);
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
                    case SNAKE2_HEAD:
                        g.setColor(Color.MAGENTA);
                        break;
                    case SNAKE2:
                        g.setColor(Color.ORANGE);

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
        map[0][0] = 1;
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

    private void level3(int sizeX, int sizeY) {

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                map[i][j] = 0;
            }
        }

        for (int i = sizeX / 4; i < 3 * sizeX / 4; i++) {
            map[i][sizeY / 8] = 1;
            map[i][7 * sizeY / 8] = 1;
        }
        for (int i = sizeY / 8; i < 3 * sizeY / 8; i++) {
            map[sizeX / 4][i] = 1;
            map[3 * sizeX / 4][i] = 1;
        }
        for (int i = 5 * sizeY / 8; i <= 7 * sizeY / 8; i++) {
            map[sizeX / 4][i] = 1;
            map[3 * sizeX / 4][i] = 1;
        }
    }

    private void level4(int sizeX, int sizeY) {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                map[i][j] = 0;
            }
        }

        for (int i = sizeX / 2; i < sizeX; i++) {
            map[i][0] = 1;
        }
        for (int i = 0; i < sizeX / 3; i++) {
            map[i][sizeY / 2] = 1;
        }
        for (int i = 2 * sizeX / 3; i < sizeX; i++) {
            map[i][sizeY / 2] = 1;
        }

        for (int i = sizeY / 2; i < sizeY; i++) {
            map[0][i] = 1;
        }

        for (int i = 0; i < sizeY / 3; i++) {
            map[sizeX / 2][i] = 1;
        }

        for (int i = 2 * sizeY / 3; i < sizeY; i++) {
            map[sizeX / 2][i] = 1;
        }

        for (int i = sizeX / 5; i < 3 * sizeX / 10; i++) {
            map[i][11] = 1;
            map[i][6] = 1;
            map[i][7] = 1;
            map[i][8] = 1;
            map[i][9] = 1;
            map[i][10] = 1;

            map[i][31] = 1;
            map[i][32] = 1;
            map[i][33] = 1;
            map[i][28] = 1;
            map[i][29] = 1;
            map[i][30] = 1;
        }

        for (int i = 7 * sizeX / 10; i < 8 * sizeX / 10; i++) {
            map[i][11] = 1;
            map[i][6] = 1;
            map[i][7] = 1;
            map[i][8] = 1;
            map[i][9] = 1;
            map[i][10] = 1;
            map[i][31] = 1;
            map[i][32] = 1;
            map[i][33] = 1;
            map[i][28] = 1;
            map[i][29] = 1;
            map[i][30] = 1;
        }


    }

    private void level5(int sizeX, int sizeY) {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                map[i][j] = 0;
            }
        }
        ////////////////////////////// Initializing

        for (int i = 0; i < sizeX / 2; i++) {
            map[i][10] = 1;
        }
        for (int i = 0; i < 3 * sizeX / 8; i++) {
            map[i][20] = 1;
        }
        for (int i = sizeX * 3 / 4; i < 7 * sizeX / 8; i++) {
            map[i][18] = 1;
        }
        for (int i = sizeX / 2; i < sizeX * 7 / 8 + 1; i++) {
            map[i][32] = 1;
        }

        for (int i = 10; i < 19; i++) {
            map[sizeX/2][i] = 1;
        }

        for (int i = 0; i < 19; i++) {
            map[sizeX*3/4][i] = 1;
        }

        for (int i = 20; i < 33; i++) {
            map[sizeX*3/8][i] = 1;
        }

        for (int i = 32; i < 37; i++) {
            map[sizeX*7/8+1][i] = 1;
            map[sizeX/2][i] = 1;
        }



    }

    private void level0(int sizeX, int sizeY) {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                map[i][j] = 0;
            }
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


    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }


}





