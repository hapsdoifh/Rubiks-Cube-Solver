import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static String[] temp_column = new String[3];
    static String[][] temp_face = new String[3][3];

    public static void main(String[] args) {

       CubeFace f1 = new CubeFace("R");

       f1.blocks[0][0][0] = "Y";
       f1.blocks[1][0][0] = "Y";
       f1.blocks[2][0][0] = "B";

       f1.blocks[0][1][0] = "R";
       f1.blocks[1][1][0] = "B";
       f1.blocks[2][1][0] = "O";

       f1.blocks[0][2][0] = "R";
       f1.blocks[1][2][0] = "B";
       f1.blocks[2][2][0] = "G";

       CubeFace f2 = new CubeFace("W");

        f2.blocks[0][0][0] = "O";
        f2.blocks[1][0][0] = "R";
        f2.blocks[2][0][0] = "B";

        f2.blocks[0][1][0] = "G";
        f2.blocks[1][1][0] = "R";
        f2.blocks[2][1][0] = "B";

        f2.blocks[0][2][0] = "Y";
        f2.blocks[1][2][0] = "Y";
        f2.blocks[2][2][0] = "G";

       CubeFace f3 = new CubeFace("O");

        f3.blocks[0][2][0] = "W";
        f3.blocks[1][2][0] = "R";
        f3.blocks[2][2][0] = "R";

        f3.blocks[0][1][0] = "R";
        f3.blocks[1][1][0] = "R";
        f3.blocks[2][1][0] = "W";

        f3.blocks[0][0][0] = "O";
        f3.blocks[1][0][0] = "G";
        f3.blocks[2][0][0] = "R";

       CubeFace f4 = new CubeFace("B");

        f4.blocks[0][0][0] = "G";
        f4.blocks[1][0][0] = "W";
        f4.blocks[2][0][0] = "Y";

        f4.blocks[0][1][0] = "Y";
        f4.blocks[1][1][0] = "R";
        f4.blocks[2][1][0] = "B";

        f4.blocks[0][2][0] = "O";
        f4.blocks[1][2][0] = "W";
        f4.blocks[2][2][0] = "W";

       CubeFace f5 = new CubeFace("G");

        f5.blocks[0][0][0] = "R";
        f5.blocks[1][0][0] = "B";
        f5.blocks[2][0][0] = "B";

        f5.blocks[0][1][0] = "W";
        f5.blocks[1][1][0] = "G";
        f5.blocks[2][1][0] = "Y";

        f5.blocks[0][2][0] = "G";
        f5.blocks[1][2][0] = "O";
        f5.blocks[2][2][0] = "O";

       CubeFace f6 = new CubeFace("Y");

        f6.blocks[0][0][0] = "O";
        f6.blocks[1][0][0] = "G";
        f6.blocks[2][0][0] = "W";

        f6.blocks[0][1][0] = "O";
        f6.blocks[1][1][0] = "G";
        f6.blocks[2][1][0] = "Y";

        f6.blocks[0][2][0] = "G";
        f6.blocks[1][2][0] = "G";
        f6.blocks[2][2][0] = "Y";

        // TEST CASE 1:
//        printFaces(f1, f5, f6, f3, f2, f4);
//        turnColumn(f1, f5, f6, f3, f2, 1,2, 0);//turn R
//        turnColumn(f1, f6, f5, f3, f4, 1, 0, 2); //turn L
//        printFaces(f1, f5, f6, f3, f2, f4);
//        turnColumn(f1, f5, f6, f3, f4, 3, 0, 2); //turn L'
//        turnColumn(f1, f6, f5, f3, f2, 3, 2, 0); //turn R'
//        turnColumn(f1, f6, f5, f3, 1, 1); //turn M
//        turnColumn(f1, f5, f6, f3, 1, 1); //turn M'
//        turnFace(f5, 4);

        printFaces(f1, f5, f6, f3, f2, f4);

        // TEST CASE 2:
//        //re-adjustments
//        turnFace(f5, 1); // turns entire face clockwise
//        turnFace(f6, 3); // turns entire face counter-clockwise
//
//        //actual turn
//        turnColumn(f2, f5, f6, f4, 2, 0); // turn B
//        turnFace(f3, 1);
//        turnColumn(f2, f6, f5, f4, 2, 0); // turn B'
//        turnFace(f3, 3);
//
//        turnColumn(f2, f5, f6, f4, 0, 2); // turn F'
//        turnFace(f1, 3);

//        //re-adjustments
//        turnFace(f5, 3);
//        turnFace(f6, 1);

        chooseTurn(f1, f5, f6, f3, f4, f2);
        printFaces(f1, f5, f6, f3, f2, f4);
    }

    public static void chooseTurn(CubeFace f1, CubeFace f5, CubeFace f6, CubeFace f3, CubeFace f4, CubeFace f2) {
        System.out.println("What turn? ");
        String turn = in.nextLine();

        if (turn.equals("R") || turn.equals("RP") || turn.equals("L") || turn.equals("LP") || turn.equals("M") || turn.equals("MP")) {
            switch (turn) {
                case "R":
                    turnColumn(f1, f5, f6, f3, 2, 0);//turn R
                    turnFace(f2, 1);
                    break;
                case "RP":
                    turnColumn(f1, f6, f5, f3, 2, 0); //turn R'
                    turnFace(f2, 3);
                    break;
                case "L":
                    turnColumn(f1, f6, f5, f3, 0, 2); //turn L
                    turnFace(f4, 1);
                    break;
                case "LP":
                    turnColumn(f1, f5, f6, f3, 0, 2); //turn L'
                    turnFace(f4, 3);
                    break;
                case "M":
                    turnColumn(f1, f6, f5, f3, 1, 1); //turn M
                    break;
                case "MP":
                    turnColumn(f1, f5, f6, f3, 1, 1); //turn M'
                    break;
            }

        } else if (turn.equals("U") || turn.equals("UP") || turn.equals("D") || turn.equals("DP") || turn.equals("E") || turn.equals("EP")) {
            turnFace(f1, 1);
            turnFace(f4, 1);
            turnFace(f2, 1);
            turnFace(f3, 3);

            switch (turn) {
                case "U":
                    turnColumn(f1, f4, f2, f3, 2, 0);//turn U
                    turnFace(f5, 1);
                    break;
                case "UP":
                    turnColumn(f1, f2, f4, f3, 2, 0); //turn U'
                    turnFace(f5, 3);
                    break;
                case "D":
                    turnColumn(f1, f2, f4, f3, 0, 2); //turn D
                    turnFace(f6, 1);
                    break;
                case "DP":
                    turnColumn(f1, f4, f2, f3, 0, 2); //turn D'
                    turnFace(f6, 3);
                    break;
                case "E":
                    turnColumn(f1, f2, f4, f3, 1, 1); //turn E
                    break;
                case "EP":
                    turnColumn(f1, f4, f2, f3, 1, 1); //turn E'
                    break;
            }

            turnFace(f1, 3);
            turnFace(f4, 3);
            turnFace(f2, 3);
            turnFace(f3, 1);

        } else if (turn.equals("B") || turn.equals("BP") || turn.equals("F") || turn.equals("FP") || turn.equals("S") || turn.equals("SP")) {

            turnFace(f5, 1); // turns entire face clockwise
            turnFace(f6, 3); // turns entire face counter-clockwise

            switch (turn) {
                case "B":
                    turnColumn(f2, f5, f6, f4, 2, 0); // turn B
                    turnFace(f3, 1);
                    break;
                case "BP":
                    turnColumn(f2, f6, f5, f4, 2, 0); // turn B'
                    turnFace(f3, 3);
                    break;
                case "F":
                    turnColumn(f2, f6, f5, f4, 0, 2); // turn F
                    turnFace(f1, 1);
                    break;
                case "FP":
                    turnColumn(f2, f5, f6, f4, 0, 2); // turn F'
                    turnFace(f1, 3);
                    break;
                case "S":
                    turnColumn(f2, f6, f5, f3, 1, 1); // turn S
                    break;
                case "SP":
                    turnColumn(f2, f5, f6, f3, 1, 1); // turn S'
                    break;

            }

            turnFace(f5, 3);
            turnFace(f6, 1);
        }

    }

    public static void printFaces(CubeFace f1, CubeFace f5, CubeFace f6, CubeFace f3, CubeFace f2, CubeFace f4) {
        printF(f1);
        System.out.println();
        printF(f5);
        System.out.println();
        printF(f6);
        System.out.println();
        printF(f3);
        System.out.println();
        printF(f2);
        System.out.println();
        printF(f4);
        System.out.println("---------------------------");
    }

    public static void printF(CubeFace face) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(face.blocks[i][j][0] + " ");
            }
            System.out.println();
        }
    }


    //1, 4, 2, 3
    public static void turnColumn(CubeFace f1, CubeFace f5, CubeFace f6, CubeFace f3, int i1, int i2) {

        for (int i = 0; i < 3; i++) {
            temp_column[i] = f5.blocks[i][i1][0];
            f5.blocks[i][i1][0] = f1.blocks[i][i1][0];
            f1.blocks[i][i1][0] = f6.blocks[i][i1][0];
            f6.blocks[i][i1][0] = f3.blocks[~(i - 1) + 2][i2][0];
        }

        for (int i = 0; i < 3; i++) {
            f3.blocks[i][i2][0] = temp_column[~(i - 1) + 2];
        }
    }

    public static void turnFace(CubeFace f2, int turns) {
        for (int n = 0; n < turns; n++) {

            //temporarily stores the new orientation of columns and rows
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    temp_face[i][j] = f2.blocks[~(j - 1) + 2][i][0];
                }
            }

            //updates the face with the correct and original orientation
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    f2.blocks[i][j][0] = temp_face[i][j];
                }
            }
        }
    }

//    public static void turnFaceCounterClockwise(CubeFace f5, int turns) {
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                temp_face[i][j] = f5.blocks[j][~(i - 1) + 2][0];
//            }
//        }
//
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                f5.blocks[i][j][0] = temp_face[i][j];
//            }
//        }
//    }

}