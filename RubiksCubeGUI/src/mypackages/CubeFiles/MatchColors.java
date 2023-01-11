package mypackages.CubeFiles;
public class MatchColors {

    static CubeFace f1;
    static CubeFace f2;
    static CubeFace f3;
    static CubeFace f4;
    static CubeFace f5;
    static CubeFace f6;

    MatchColors(CubeFace f1, CubeFace f2, CubeFace f3, CubeFace f4, CubeFace f5, CubeFace f6) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.f4 = f4;
        this.f5 = f5;
        this.f6 = f6;

    }

    public static void checkColor() {

        CubeFace[] faces = {f1, f2, f3, f4};
        int counter = 0;

        for (int i = 0; i < 4; i++) {

            if ((faces[i]).blocks[2][1].equals((faces[i]).blocks[1][1])) {
                counter++;
            }

        }

        if (counter==0) {

            if (f1.blocks[2][1].equals("R")) {
                rotateToMatch(1);
            } else if (f1.blocks[2][1].equals("B")) {
                rotateToMatch(2);
            } else if (f1.blocks[2][1].equals("O")) {
                rotateToMatch(3);
            }

        }

        findOppMatch();


    }

    public static void rotateToMatch(int turns) {

        for (int i = 0; i < turns; i++) {
            Main.chooseTurn("D");
        }
    }

    public static void findOppMatch() {

        while (true ) {

            if ((f1.blocks[2][1].equals(f1.blocks[1][1])) && (f3.blocks[2][1].equals(f3.blocks[1][1]))) {
                sideBackMatch(f1);
                break;
            } else if ((f2.blocks[2][1].equals(f2.blocks[1][1])) && (f4.blocks[2][1].equals(f4.blocks[1][1]))) {
                sideBackMatch(f2);
                break;
            } else {
                getMatch();
                break;
            }

        }
    }

    public static void sideBackMatch(CubeFace face) {

        if (face.equals(f1)) {

            Main.chooseTurn("L");
            Main.chooseTurn("D");
            Main.chooseTurn("LP");
            Main.chooseTurn("D");
            Main.chooseTurn("L");
            Main.chooseTurn("DP");
            Main.chooseTurn("DP");
            Main.chooseTurn("LP");

        } else if (face.equals(f2)) {

            Main.chooseTurn("F");
            Main.chooseTurn("D");
            Main.chooseTurn("FP");
            Main.chooseTurn("D");
            Main.chooseTurn("F");
            Main.chooseTurn("DP");
            Main.chooseTurn("DP");
            Main.chooseTurn("FP");

        }

        getMatch();

    }

    public static void getMatch() {

        if ((f1.blocks[2][1].equals(f1.blocks[1][1])) && (f4.blocks[2][1].equals(f4.blocks[1][1]))) {

            Main.chooseTurn("F");
            Main.chooseTurn("D");
            Main.chooseTurn("FP");
            Main.chooseTurn("D");
            Main.chooseTurn("F");
            Main.chooseTurn("DP");
            Main.chooseTurn("DP");
            Main.chooseTurn("FP");

        } else if ((f2.blocks[2][1].equals(f2.blocks[1][1])) && (f1.blocks[2][1].equals(f1.blocks[1][1]))) {

            Main.chooseTurn("R");
            Main.chooseTurn("D");
            Main.chooseTurn("RP");
            Main.chooseTurn("D");
            Main.chooseTurn("R");
            Main.chooseTurn("DP");
            Main.chooseTurn("DP");
            Main.chooseTurn("RP");

        } else if ((f3.blocks[2][1].equals(f3.blocks[1][1])) && (f2.blocks[2][1].equals(f2.blocks[1][1]))) {

            Main.chooseTurn("B");
            Main.chooseTurn("D");
            Main.chooseTurn("BP");
            Main.chooseTurn("D");
            Main.chooseTurn("B");
            Main.chooseTurn("DP");
            Main.chooseTurn("DP");
            Main.chooseTurn("BP");

        } else if ((f4.blocks[2][1].equals(f4.blocks[1][1])) && (f3.blocks[2][1].equals(f3.blocks[1][1]))) {

            Main.chooseTurn("L");
            Main.chooseTurn("D");
            Main.chooseTurn("LP");
            Main.chooseTurn("D");
            Main.chooseTurn("L");
            Main.chooseTurn("DP");
            Main.chooseTurn("DP");
            Main.chooseTurn("LP");
        } else {
            Main.chooseTurn("D");
            findOppMatch();
        }

        matchColors();

    }

    public static void matchColors() {

        if (f1.blocks[2][1].equals("R")) {
            rotateToMatch(1);
        } else if (f1.blocks[2][1].equals("B")) {
            rotateToMatch(2);
        } else if (f1.blocks[2][1].equals("O")) {
            rotateToMatch(3);
        }

    }

}
