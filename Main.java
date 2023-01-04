import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    static CubeFace f1;
    static CubeFace f2;
    static CubeFace f3;
    static CubeFace f4;
    static CubeFace f5;
    static CubeFace f6;

    static Rotate3Block r;

    public static void main(String[] args) {

        f1 = new CubeFace("G");

        f1.blocks[0][0] = "O";
        f1.blocks[0][1] = "B";
        f1.blocks[0][2] = "G";
 
        f1.blocks[1][0] = "R";
        f1.blocks[1][1] = "G";
        f1.blocks[1][2] = "R";
 
        f1.blocks[2][0] = "G";
        f1.blocks[2][1] = "G";
        f1.blocks[2][2] = "R";
 
        f2 = new CubeFace("R");
 
        f2.blocks[0][0] = "R";
        f2.blocks[0][1] = "B";
        f2.blocks[0][2] = "B";

        f2.blocks[1][0] = "Y";
        f2.blocks[1][1] = "R";
        f2.blocks[1][2] = "R";
 
        f2.blocks[2][0] = "Y";
        f2.blocks[2][1] = "O";
        f2.blocks[2][2] = "W";
 
        f3 = new CubeFace("B");
 
        f3.blocks[0][0] = "R";
        f3.blocks[0][1] = "O";
        f3.blocks[0][2] = "O";
 
        f3.blocks[1][0] = "G";
        f3.blocks[1][1] = "B";
        f3.blocks[1][2] = "W";
 
        f3.blocks[2][0] = "B";
        f3.blocks[2][1] = "O";
        f3.blocks[2][2] = "G";
 
        f4 = new CubeFace("O");
 
        f4.blocks[0][0] = "W";
        f4.blocks[0][1] = "B";
        f4.blocks[0][2] = "Y";
 
        f4.blocks[1][0] = "G";
        f4.blocks[1][1] = "O";
        f4.blocks[1][2] = "W";
 
        f4.blocks[2][0] = "O";
        f4.blocks[2][1] = "G";
        f4.blocks[2][2] = "O";
 
        f5 = new CubeFace("W");
 
        f5.blocks[0][0] = "B";
        f5.blocks[0][1] = "B";
        f5.blocks[0][2] = "Y";

        f5.blocks[1][0] = "W";
        f5.blocks[1][1] = "W";
        f5.blocks[1][2] = "Y";
 
        f5.blocks[2][0] = "B";
        f5.blocks[2][1] = "R";
        f5.blocks[2][2] = "W";
 
        f6 = new CubeFace("Y");
 
        f6.blocks[0][0] = "Y";
        f6.blocks[0][1] = "O";
        f6.blocks[0][2] = "G";

        f6.blocks[1][0] = "Y";
        f6.blocks[1][1] = "Y";
        f6.blocks[1][2] = "W";
 
        f6.blocks[2][0] = "W";
        f6.blocks[2][1] = "Y";
        f6.blocks[2][2] = "R";


        r = new Rotate3Block();

        WhiteCross w = new WhiteCross(f1, f2, f3, f4, f5, f6);

        SecondLayer s = new SecondLayer(f1, f2, f3, f4, f5, f6);

        System.out.println("Original:");

        printFaces(f1, f5, f6, f3, f2, f4); // prints original faces

        // solution
        w.checkWhiteCross(); // white cross phase

        System.out.println("White cross: ");

        printFaces(f1, f5, f6, f3, f2, f4); // prints white corners faces
        
        CornerSolution.getCorners(f1, f2, f3, f4, f5, f6); // white corners phase

        System.out.println("White corners: ");

        printFaces(f1, f5, f6, f3, f2, f4); // prints new faces

        s.checkBottomYellow();

        System.out.println("Second layer: ");

        printFaces(f1, f5, f6, f3, f2, f4); // prints new faces

        BottomCross.BCrossSolution(f1, f2, f3, f4, f5, f6);
        printFaces(f1, f5, f6, f3, f2, f4); // prints new faces

        CornerSwap.SwapCorner(f1, f2, f3, f4, f5, f6);
        printFaces(f1, f5, f6, f3, f2, f4); // prints new faces


        // user chooses turn

//        while (true) {
//            chooseTurn(r3, f1, f5, f6, f3, f4, f2);
//            System.out.println("Stop? ");
//            String stop = in.nextLine();
//            if (stop.equals("y")) {
//                printFaces(f1, f5, f6, f3, f2, f4); // prints faces after each turn
//            }
//        }

        // Rotate3Block r, CubeFace f1, CubeFace f5, CubeFace f6, CubeFace f3, CubeFace f4, CubeFace f2
    }
    public static void chooseTurn(String t) {
//        System.out.println("What turn? ");
//        String turn = in.nextLine();

        String turn = t;

        if (turn.equals("R") || turn.equals("RP") || turn.equals("L") || turn.equals("LP") || turn.equals("M") || turn.equals("MP")) {
            switch (turn) {
                case "R":
                    r.turnColumn(f1, f5, f6, f3, 2, 0);//turn R
                    r.turnFace(f2, 1);
                    break;
                case "RP":
                    r.turnColumn(f1, f6, f5, f3, 2, 0); //turn R'
                    r.turnFace(f2, 3);
                    break;
                case "L":
                    r.turnColumn(f1, f6, f5, f3, 0, 2); //turn L
                    r.turnFace(f4, 1);
                    break;
                case "LP":
                    r.turnColumn(f1, f5, f6, f3, 0, 2); //turn L'
                    r.turnFace(f4, 3);
                    break;
                case "M":
                    r.turnColumn(f1, f6, f5, f3, 1, 1); //turn M
                    break;
                case "MP":
                    r.turnColumn(f1, f5, f6, f3, 1, 1); //turn M'
                    break;
            }

        } else if (turn.equals("U") || turn.equals("UP") || turn.equals("D") || turn.equals("DP") || turn.equals("E") || turn.equals("EP")) {

            r.turnFace(f1, 1);
            r.turnFace(f4, 1);
            r.turnFace(f2, 1);
            r.turnFace(f3, 3);

            switch (turn) {
                case "U":
                    r.turnColumn(f1, f4, f2, f3, 2, 0);//turn U
                    r.turnFace(f5, 1);
                    break;
                case "UP":
                    r.turnColumn(f1, f2, f4, f3, 2, 0); //turn U'
                    r.turnFace(f5, 3);
                    break;
                case "D":
                    r.turnColumn(f1, f2, f4, f3, 0, 2); //turn D
                    r.turnFace(f6, 1);
                    break;
                case "DP":
                    r.turnColumn(f1, f4, f2, f3, 0, 2); //turn D'
                    r.turnFace(f6, 3);
                    break;
                case "E":
                    r.turnColumn(f1, f2, f4, f3, 1, 1); //turn E
                    break;
                case "EP":
                    r.turnColumn(f1, f4, f2, f3, 1, 1); //turn E'
                    break;
            }

            r.turnFace(f1, 3);
            r.turnFace(f4, 3);
            r.turnFace(f2, 3);
            r.turnFace(f3, 1);

        } else if (turn.equals("B") || turn.equals("BP") || turn.equals("F") || turn.equals("FP") || turn.equals("S") || turn.equals("SP")) {

            r.turnFace(f5, 1); // turns entire face clockwise
            r.turnFace(f6, 3); // turns entire face counter-clockwise

            switch (turn) {
                case "B":
                    r.turnColumn(f2, f5, f6, f4, 2, 0); // turn B
                    r.turnFace(f3, 1);
                    break;
                case "BP":
                    r.turnColumn(f2, f6, f5, f4, 2, 0); // turn B'
                    r.turnFace(f3, 3);
                    break;
                case "F":
                    r.turnColumn(f2, f6, f5, f4, 0, 2); // turn F
                    r.turnFace(f1, 1);
                    break;
                case "FP":
                    r.turnColumn(f2, f5, f6, f4, 0, 2); // turn F'
                    r.turnFace(f1, 3);
                    break;
                case "S":
                    r.turnColumn(f2, f6, f5, f3, 1, 1); // turn S
                    break;
                case "SP":
                    r.turnColumn(f2, f5, f6, f3, 1, 1); // turn S'
                    break;

            }

            r.turnFace(f5, 3);
            r.turnFace(f6, 1);
        }

    }

    public static void printFaces(CubeFace f1, CubeFace f5, CubeFace f6, CubeFace f3, CubeFace f2, CubeFace f4) {
        System.out.println("\nFront:");
        printF(f1);
        System.out.println("\nTop:");
        printF(f5);
        System.out.println("\nBottom:");
        printF(f6);
        System.out.println("\nBack:");
        printF(f3);
        System.out.println("\nRight:");
        printF(f2);
        System.out.println("\nLeft:");
        printF(f4);
        System.out.println("---------------------------");
    }

    public static void printF(CubeFace face) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(face.blocks[i][j] + " ");
            }
            System.out.println();
        }
    }
}