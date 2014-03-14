package snake1.data;

import snake1.objects.GameObject;
import snake1.objects.Space;
import snake1.objects.Wall;

import java.awt.*;

public class Arena {
    private int width;         // amount of fields in X and Y direction
    private int height;
    private GameObject[][] map;

    private final String mapName;

    public static final int ALIGN_X = 40;               // For graphics only
    public static final int ALIGN_Y = 55;

    private static final Font LEV_FONT = new Font("Arial", Font.BOLD, 38);

    //default empty map with borders

    public Arena(int width, int height, int level) {
        this.width = width;
        this.height = height;
        map = new GameObject[width][height];
        mapName = "Level " + level;
        switch (level) {
            case 1:
                level1();
                break;
            case 2:
                level2();
                break;
            case 3:
                level3();
                break;
            case 4:
                level4();
                break;
            case 5:
                level5();
                break;
            default:
                level0();
        }
    }


    public void draw(Graphics2D g) {
        drawLevelSign(g);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                map[i][j].draw(g);
            }
        }
    }

    private void drawLevelSign(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setFont(LEV_FONT);
        g.drawString(mapName, 1020, 80);
    }

    private void level1() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (i == 0 || j == 0 || i == (width - 1) || j == (height - 1))
                    map[i][j] = Wall.INSTANCE;
                else map[i][j] = Space.INSTANCE;
            }
        }
    }

    private void level2() {
        clear();
        for (int i = width / 4; i < 3 * width / 4; i++) {
            map[i][height / 2 + 1] = Wall.INSTANCE;
            map[i][height / 2 + 2] = Wall.INSTANCE;
            map[i][height / 2 + 3] = Wall.INSTANCE;
            map[i][height / 2 + 4] = Wall.INSTANCE;
        }

    }

    private void level3() {

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                map[i][j] = Space.INSTANCE;
            }
        }

        for (int i = width / 4; i < 3 * width / 4; i++) {
            map[i][height / 8] = Wall.INSTANCE;
            map[i][7 * height / 8] = Wall.INSTANCE;
        }
        for (int i = height / 8; i < 3 * height / 8; i++) {
            map[width / 4][i] = Wall.INSTANCE;
            map[3 * width / 4][i] = Wall.INSTANCE;
        }
        for (int i = 5 * height / 8; i <= 7 * height / 8; i++) {
            map[width / 4][i] = Wall.INSTANCE;
            map[3 * width / 4][i] = Wall.INSTANCE;
        }
    }

    private void level4() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                map[i][j] = Space.INSTANCE;
            }
        }

        for (int i = width / 2; i < width; i++) {
            map[i][0] = Wall.INSTANCE;
        }
        for (int i = 0; i < width / 3; i++) {
            map[i][height / 2] = Wall.INSTANCE;
        }
        for (int i = 2 * width / 3; i < width; i++) {
            map[i][height / 2] = Wall.INSTANCE;
        }

        for (int i = height / 2; i < height; i++) {
            map[0][i] = Wall.INSTANCE;
        }

        for (int i = 0; i < height / 3; i++) {
            map[width / 2][i] = Wall.INSTANCE;
        }

        for (int i = 2 * height / 3; i < height; i++) {
            map[width / 2][i] = Wall.INSTANCE;
        }

        for (int i = width / 5; i < 3 * width / 10; i++) {
            map[i][11] = Wall.INSTANCE;
            map[i][6] = Wall.INSTANCE;
            map[i][7] = Wall.INSTANCE;
            map[i][8] = Wall.INSTANCE;
            map[i][9] = Wall.INSTANCE;
            map[i][10] = Wall.INSTANCE;

            map[i][31] = Wall.INSTANCE;
            map[i][32] = Wall.INSTANCE;
            map[i][33] = Wall.INSTANCE;
            map[i][28] = Wall.INSTANCE;
            map[i][29] = Wall.INSTANCE;
            map[i][30] = Wall.INSTANCE;
        }

        for (int i = 7 * width / 10; i < 8 * width / 10; i++) {
            map[i][11] = Wall.INSTANCE;
            map[i][6] = Wall.INSTANCE;
            map[i][7] = Wall.INSTANCE;
            map[i][8] = Wall.INSTANCE;
            map[i][9] = Wall.INSTANCE;
            map[i][10] = Wall.INSTANCE;
            map[i][31] = Wall.INSTANCE;
            map[i][32] = Wall.INSTANCE;
            map[i][33] = Wall.INSTANCE;
            map[i][28] = Wall.INSTANCE;
            map[i][29] = Wall.INSTANCE;
            map[i][30] = Wall.INSTANCE;
        }


    }

    private void level5() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                map[i][j] = Space.INSTANCE;

            }
        }

        for (int i = 0; i < width / 2; i++) {
            map[i][10] = Wall.INSTANCE;
        }
        for (int i = 0; i < 3 * width / 8; i++) {
            map[i][20] = Wall.INSTANCE;
        }
        for (int i = width * 3 / 4; i < 7 * width / 8; i++) {
            map[i][18] = Wall.INSTANCE;
        }
        for (int i = width / 2; i < width * 7 / 8 + 1; i++) {
            map[i][32] = Wall.INSTANCE;
        }

        for (int i = 10; i < 19; i++) {
            map[width / 2][i] = Wall.INSTANCE;
        }

        for (int i = 0; i < 19; i++) {
            map[width * 3 / 4][i] = Wall.INSTANCE;
        }

        for (int i = 20; i < 33; i++) {
            map[width * 3 / 8][i] = Wall.INSTANCE;
        }

        for (int i = 32; i < 37; i++) {
            map[width * 7 / 8 + 1][i] = Wall.INSTANCE;
            map[width / 2][i] = Wall.INSTANCE;
        }
    }

    private void level0() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                map[i][j] = Space.INSTANCE;
            }
        }
    }


    public void setPoint(GameObject gameObject) {
        map[gameObject.getX()][gameObject.getY()] = gameObject;
    }

    public GameObject getPoint(int x, int y) {
        return map[x][y];
    }

    public int[] getRandomEmptyField() {
        int x, y;
        do {
            x = (int) (Math.random() * width);
            y = (int) (Math.random() * height);
        } while (!map[x][y].equals(Space.INSTANCE));
        return new int[]{x, y};
    }


    public void clear() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                map[i][j] = Space.INSTANCE;
            }
        }
    }

    public void setPoint(int x, int y, GameObject gameObject) {
        map[x][y] = gameObject;
    }
}





