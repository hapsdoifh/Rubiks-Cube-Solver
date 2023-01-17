
package mypackages.CubeFiles;

public class Rotate3Block {
    static String[] temp_column = new String[3];
    static String[][] temp_face = new String[3][3];
    public static void turnColumn(CubeFace f1, CubeFace f5, CubeFace f6, CubeFace f3, int i1, int i2) {

        for (int i = 0; i < 3; i++) {
            temp_column[i] = f5.blocks[i][i1];
            f5.blocks[i][i1] = f1.blocks[i][i1];
            f1.blocks[i][i1] = f6.blocks[i][i1];
            f6.blocks[i][i1] = f3.blocks[~(i - 1) + 2][i2];
        }

        for (int i = 0; i < 3; i++) {
            f3.blocks[i][i2] = temp_column[~(i - 1) + 2];
        }
    }
    public static void turnFace(CubeFace f2, int turns) {
        for (int n = 0; n < turns; n++) {

            //temporarily stores the new orientation of columns and rows
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    temp_face[i][j] = f2.blocks[~(j - 1) + 2][i];
                }
            }

            //updates the face with the correct and original orientation
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    f2.blocks[i][j] = temp_face[i][j];
                }
            }
        }
    }
}