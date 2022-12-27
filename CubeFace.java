public class CubeFace {
    String[][][] blocks = new String[3][3][1];
    CubeFace(String color) {

        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j < 3; j++) {
                blocks[i][j][0] = color;
            }
        }
    }

}
