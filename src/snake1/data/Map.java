package snake1.data;

import snake1.objects.GameObject;
import snake1.objects.GameObjectType;
import snake1.objects.Space;
import snake1.objects.Wall;

import java.awt.*;

public class Map {
    private int sizeX;         // amount of fields in X and Y direction
    private int sizeY;
    private GameObject[][] map;

    private String mapName;

    public static final int ALIGN_X = 40;               // For graphics only
    public static final int ALIGN_Y = 55;

    private static final Font LEV_FONT = new Font("Arial", Font.BOLD, 38);

    //default empty map with borders

    public Map(int x, int y, int level) {
        sizeX = x;
        sizeY = y;
        map = new GameObject[x][y];
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
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                map[i][j].draw(g);
                    /*case 0:
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
                        g.setColor(Color.ORANGE);*/


            }
        }
    }

    private void drawLevelSign(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setFont(LEV_FONT);
        g.drawString(mapName, 1020, 80);
    }

    private void createWalls(int n) {
        for (int i = 0; i < n; i++) {
            new Wall(sizeX, sizeY);
        }

    }

    private void level1() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (i == 0 || j == 0 || i == (sizeX - 1) || j == (sizeY - 1))
                    map[i][j] = new Wall(i, j);
                else map[i][j] = new Space(i, j);
            }
        }
    }

    private void level2() {

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

    private void level3() {

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

    private void level4() {
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

    private void level5() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                map[i][j] = 0;
            }
        }

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
            map[sizeX / 2][i] = 1;
        }

        for (int i = 0; i < 19; i++) {
            map[sizeX * 3 / 4][i] = 1;
        }

        for (int i = 20; i < 33; i++) {
            map[sizeX * 3 / 8][i] = 1;
        }

        for (int i = 32; i < 37; i++) {
            map[sizeX * 7 / 8 + 1][i] = 1;
            map[sizeX / 2][i] = 1;
        }
    }

    private void level0() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                map[i][j] = 0;
            }
        }
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

    private int[] getRandomEmptyField() {
        int x, y;
        do {
            x = (int) (Math.random() * sizeX);
            y = (int) (Math.random() * sizeY);
        } while (map[x][y].getType() != GameObjectType.SPACE);
        return new int[]{x, y};
    }


}





