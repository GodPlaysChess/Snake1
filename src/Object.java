
public class Object {
    int x;
    int y;

                                          // 1st way is to add random modifier (true/false) to create in fixed or random position.
    Object(int maxX, int maxY, Map m) {

        do {
            x = (int) (Math.random() * maxX);
            y = (int) (Math.random() * maxY);
        }
        while (m.map[x][y] != 0);

    }
}


