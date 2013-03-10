
public class Wall extends Object{

    Wall(int maxX, int maxY, Map m){
        super(maxX, maxY, m);
        m.map[x][y]=1;
    }
}

