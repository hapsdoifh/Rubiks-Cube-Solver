
package mypackages.CubeFiles;

public class SecondLayer {

    static CubeFace f1;
    static CubeFace f2;
    static CubeFace f3;
    static CubeFace f4;
    static CubeFace f5;
    static CubeFace f6;
    static boolean flag = false;
    SecondLayer(CubeFace f1, CubeFace f2, CubeFace f3, CubeFace f4, CubeFace f5, CubeFace f6) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.f4 = f4;
        this.f5 = f5;
        this.f6 = f6;
    }

        public static boolean checkSecondLayer() {

        int counter = 0;

        for (int i = 0; i < 3; i++) {

            if (f1.blocks[1][i].equals("G")) {
                counter++;
            }

            if (f2.blocks[1][i].equals("R")) {
                counter++;
            }

            if (f3.blocks[1][i].equals("B")) {
                counter++;
            }

            if (f4.blocks[1][i].equals("O")) {
                counter++;
            }

        }

        if (counter != 12) {
            return false;
        } else {
            return true;
        }

    }
    public static void checkBottomYellow() {

        flag = false;
        while (flag==false) {
            checkFlippedEdge();
            checkYellowEdge();

            if (!f6.blocks[0][1].equals("Y") && !f1.blocks[2][1].equals("Y")) {
                checkIfMatching("[0][1]");
                CubeModel.printFaces(f1, f5, f6, f3, f2, f4);
            }

            if (!f6.blocks[1][0].equals("Y") && !f4.blocks[2][1].equals("Y")) {
                checkIfMatching("[1][0]");
                CubeModel.printFaces(f1, f5, f6, f3, f2, f4);

            }

            if (!f6.blocks[1][2].equals("Y") && !f2.blocks[2][1].equals("Y")) {
                checkIfMatching("[1][2]");
                CubeModel.printFaces(f1, f5, f6, f3, f2, f4);
            }

            if (!f6.blocks[2][1].equals("Y") && !f3.blocks[2][1].equals("Y")) {
                checkIfMatching("[2][1]");
                CubeModel.printFaces(f1, f5, f6, f3, f2, f4);
            }

            checkFlippedEdge();
            checkYellowEdge();
            flag = checkSecondLayer();
        }


    }


    public static void checkFlippedEdge() {

        for (int i = 0; i < 4; i++) {
            if (f1.blocks[1][0].equals("O") && f4.blocks[1][2].equals("G")) {
                CubeModel.chooseTurn("D");
                CubeModel.chooseTurn("L");
                CubeModel.chooseTurn("D");
                CubeModel.chooseTurn("LP");
                CubeModel.chooseTurn("DP");

                CubeModel.chooseTurn("FP");
                CubeModel.chooseTurn("DP");
                CubeModel.chooseTurn("F");
                CubeModel.chooseTurn("D");

            } else if (f2.blocks[1][0].equals("G") && f1.blocks[1][2].equals("R")) {
                CubeModel.chooseTurn("D");
                CubeModel.chooseTurn("F");
                CubeModel.chooseTurn("D");
                CubeModel.chooseTurn("FP");
                CubeModel.chooseTurn("DP");

                CubeModel.chooseTurn("RP");
                CubeModel.chooseTurn("DP");
                CubeModel.chooseTurn("R");
                CubeModel.chooseTurn("D");

            } else if (f3.blocks[1][0].equals("R") && f2.blocks[1][2].equals("B")) {
                CubeModel.chooseTurn("D");
                CubeModel.chooseTurn("R");
                CubeModel.chooseTurn("D");
                CubeModel.chooseTurn("RP");
                CubeModel.chooseTurn("DP");

                CubeModel.chooseTurn("BP");
                CubeModel.chooseTurn("DP");
                CubeModel.chooseTurn("B");
                CubeModel.chooseTurn("D");

            } else if (f4.blocks[1][0].equals("B") && f3.blocks[1][2].equals("O")) {
                CubeModel.chooseTurn("D");
                CubeModel.chooseTurn("B");
                CubeModel.chooseTurn("D");
                CubeModel.chooseTurn("BP");
                CubeModel.chooseTurn("DP");

                CubeModel.chooseTurn("LP");
                CubeModel.chooseTurn("DP");
                CubeModel.chooseTurn("L");
                CubeModel.chooseTurn("D");

            }
        }


    }

     public static void checkYellowEdge() {

        for (int i = 0; i < 4; i++) {

            if (f1.blocks[1][2].equals("Y") || f4.blocks[1][0].equals("Y")) {
                CubeModel.chooseTurn("D");
                CubeModel.chooseTurn("L");
                CubeModel.chooseTurn("D");
                CubeModel.chooseTurn("LP");
                CubeModel.chooseTurn("DP");

                CubeModel.chooseTurn("FP");
                CubeModel.chooseTurn("DP");
                CubeModel.chooseTurn("F");
                CubeModel.chooseTurn("D");

            } else if (f2.blocks[1][2].equals("Y") || f1.blocks[1][0].equals("Y")) {
                CubeModel.chooseTurn("D");
                CubeModel.chooseTurn("F");
                CubeModel.chooseTurn("D");
                CubeModel.chooseTurn("FP");
                CubeModel.chooseTurn("DP");

                CubeModel.chooseTurn("RP");
                CubeModel.chooseTurn("DP");
                CubeModel.chooseTurn("R");
                CubeModel.chooseTurn("D");

            } else if (f3.blocks[1][2].equals("Y") || f2.blocks[1][0].equals("Y")) {
                CubeModel.chooseTurn("D");
                CubeModel.chooseTurn("R");
                CubeModel.chooseTurn("D");
                CubeModel.chooseTurn("RP");
                CubeModel.chooseTurn("DP");

                CubeModel.chooseTurn("BP");
                CubeModel.chooseTurn("DP");
                CubeModel.chooseTurn("B");
                CubeModel.chooseTurn("D");

            } else if (f4.blocks[1][2].equals("Y") || f3.blocks[1][0].equals("Y")) {
                CubeModel.chooseTurn("D");
                CubeModel.chooseTurn("B");
                CubeModel.chooseTurn("D");
                CubeModel.chooseTurn("BP");
                CubeModel.chooseTurn("DP");

                CubeModel.chooseTurn("LP");
                CubeModel.chooseTurn("DP");
                CubeModel.chooseTurn("L");
                CubeModel.chooseTurn("D");

            }

        }
     }

    public static void checkIfMatching(String bottomBlock) {

        int rot_num = 0;

//            if (!colorCompared.equals(f1.blocks[1][1])) {
//                rot_num = calcRotNum(colorCompared, f1.blocks[1][1]);
//                matchAdjToMid(rot_num, bottomBlock);
//
//            }
//
//            if (!colorCompared.equals(f4.blocks[1][1])) {
//                rot_num = calcRotNum(colorCompared, f4.blocks[1][1]);
//                matchAdjToMid(rot_num, bottomBlock);
//
//            }
//
//            if (!colorCompared.equals(f2.blocks[1][1])) {
//                rot_num = calcRotNum(colorCompared, f2.blocks[1][1]);
//                matchAdjToMid(rot_num, bottomBlock);
//
//            }
//
//            if (!colorCompared.equals(f3.blocks[1][1])) {
//                rot_num = calcRotNum(colorCompared, f3.blocks[1][1]);
//                matchAdjToMid(rot_num, bottomBlock);
//
//            }

        switch (bottomBlock) {
            case "[0][1]":

                if (!f1.blocks[2][1].equals(f1.blocks[1][1])) {

                    rot_num = calcRotNum(f1.blocks[2][1], f1.blocks[1][1]);
                    matchAdjToMid(rot_num, f1.blocks[1][1]);

                }
                break;

            case "[1][0]":

                    rot_num = calcRotNum(f4.blocks[2][1], f4.blocks[1][1]);
                    matchAdjToMid(rot_num, f4.blocks[1][1]);

                break;

            case "[1][2]":
                if (!f2.blocks[2][1].equals(f2.blocks[1][1])) {

                }

                    rot_num = calcRotNum(f2.blocks[2][1], f2.blocks[1][1]);
                    matchAdjToMid(rot_num, f2.blocks[1][1]);

                break;

            case "[2][1]":
                if (!f3.blocks[2][1].equals(f3.blocks[1][1])) {
                }

                    rot_num = calcRotNum(f3.blocks[2][1], f3.blocks[1][1]);
                    matchAdjToMid(rot_num, f3.blocks[1][1]);
                break;
        }
    }

    public static int calcRotNum(String adjColor, String midColor) {

        switch (midColor) {

            case "G":

                switch (adjColor) {

                    case "R":
                        return 1;
                    case "B":
                        return 2;
                    case "O":
                        return 3;
                }

                break;
            case "R":

                switch (adjColor) {

                    case "B":
                        return 1;
                    case "O":
                        return 2;
                    case "G":
                        return 3;
                }

                break;
            case "O":

                switch (adjColor) {

                    case "G":
                        return 1;
                    case "R":
                        return 2;
                    case "B":
                        return 3;
                }

                break;
            case "B":

                switch (adjColor) {

                    case "O":
                        return 1;
                    case "G":
                        return 2;
                    case "R":
                        return 3;
                }

                break;

        }

        return 0;

    }

    public static void matchAdjToMid(int rN, String midColor) {

        for (int i = 0; i < rN; i++) {
            CubeModel.chooseTurn("D");
        }


        switch (midColor) {

            case "G":

                switch (rN) {

                    case 0:
                        specMoves("[0][1]", "G");
                        break;
                    case 1:
                        specMoves("[1][2]", "R");
                        break;
                    case 2:
                        specMoves("[2][1]", "B");
                        break;
                    case 3:
                        specMoves("[1][0]", "O");
                        break;
                }
                break;

            case "R":

                switch (rN) {

                    case 0:
                        specMoves("[1][2]", "R");
                        break;
                    case 1:
                        specMoves("[2][1]", "B");
                        break;
                    case 2:
                        specMoves("[1][0]", "O");
                        break;
                    case 3:
                        specMoves("[0][1]", "G");
                        break;
                }
                break;

            case "B":

                switch (rN) {

                    case 0:
                        specMoves("[2][1]", "B");
                        break;
                    case 1:
                        specMoves("[1][0]", "O");
                        break;
                    case 2:
                        specMoves("[0][1]", "G");
                        break;
                    case 3:
                        specMoves("[1][2]", "R");
                        break;
                }

                break;
            case "O":

                switch (rN) {

                    case 0:
                        CubeModel.printFaces(f1, f5, f6, f3, f2, f4);
                        specMoves("[1][0]", "O");
                        break;
                    case 1:
                        specMoves("[0][1]", "G");
                        break;
                    case 2:
                        specMoves("[1][2]", "R");
                        break;
                    case 3:
                        specMoves("[2][1]", "B");
                        break;
                }
                break;

        }

    }

    public static void specMoves(String bottomPos, String midColor) {

        switch (bottomPos) {

            case "[0][1]":

                switch (f6.blocks[0][1]) {

                    case "R":
                        CubeModel.chooseTurn("DP");
                        CubeModel.chooseTurn("RP");
                        CubeModel.chooseTurn("DP");
                        CubeModel.chooseTurn("R");
                        CubeModel.chooseTurn("D");
                        continuedMoves(midColor, "R");
                        break;

                    case "O":
                        CubeModel.chooseTurn("D");
                        CubeModel.chooseTurn("L");
                        CubeModel.chooseTurn("D");
                        CubeModel.chooseTurn("LP");
                        CubeModel.chooseTurn("DP");
                        continuedMoves(midColor, "O");
                        break;
                }

                break;

            case "[1][0]":

                switch (f6.blocks[1][0]) {

                    case "G":
                        CubeModel.chooseTurn("DP");
                        CubeModel.chooseTurn("FP");
                        CubeModel.chooseTurn("DP");
                        CubeModel.chooseTurn("F");
                        CubeModel.chooseTurn("D");
                        CubeModel.printFaces(f1, f5, f6, f3, f2, f4);
                        continuedMoves(midColor, "G");
                        break;

                    case "B":
                        CubeModel.chooseTurn("D");
                        CubeModel.chooseTurn("B");
                        CubeModel.chooseTurn("D");
                        CubeModel.chooseTurn("BP");
                        CubeModel.chooseTurn("DP");
                        CubeModel.printFaces(f1, f5, f6, f3, f2, f4);
                        continuedMoves(midColor, "B");
                        break;
                }

                break;

            case "[1][2]":

                switch (f6.blocks[1][2]) {

                    case "B":
                        CubeModel.chooseTurn("DP");
                        CubeModel.chooseTurn("BP");
                        CubeModel.chooseTurn("DP");
                        CubeModel.chooseTurn("B");
                        CubeModel.chooseTurn("D");
                        continuedMoves(midColor, "B");
                        break;

                    case "G":
                        CubeModel.chooseTurn("D");
                        CubeModel.chooseTurn("F");
                        CubeModel.chooseTurn("D");
                        CubeModel.chooseTurn("FP");
                        CubeModel.chooseTurn("DP");
                        continuedMoves(midColor, "G");
                        break;
                }

                break;

            case "[2][1]":

                switch (f6.blocks[2][1]) {

                    case "O":
                        CubeModel.chooseTurn("DP");
                        CubeModel.chooseTurn("LP");
                        CubeModel.chooseTurn("DP");
                        CubeModel.chooseTurn("L");
                        CubeModel.chooseTurn("D");
                        continuedMoves(midColor, "O");
                        break;

                    case "R":
                        CubeModel.chooseTurn("D");
                        CubeModel.chooseTurn("R");
                        CubeModel.chooseTurn("D");
                        CubeModel.chooseTurn("RP");
                        CubeModel.chooseTurn("DP");
                        continuedMoves(midColor, "R");
                        break;
                }
                break;

        }

    }


    public static void continuedMoves(String midColor, String bottomColor) {

        switch (midColor) {

            case "G":

                switch (bottomColor) {

                    case "R":
                        CubeModel.chooseTurn("F");
                        CubeModel.chooseTurn("D");
                        CubeModel.chooseTurn("FP");
                        CubeModel.chooseTurn("DP");
                        break;
                    case "O":
                        CubeModel.chooseTurn("FP");
                        CubeModel.chooseTurn("DP");
                        CubeModel.chooseTurn("F");
                        CubeModel.chooseTurn("D");
                        break;
                }

                break;

            case "O":

                switch (bottomColor) {

                    case "B":
                        CubeModel.chooseTurn("LP");
                        CubeModel.chooseTurn("DP");
                        CubeModel.chooseTurn("L");
                        CubeModel.chooseTurn("D");
                        CubeModel.printFaces(f1, f5, f6, f3, f2, f4);
                        break;
                    case "G":
                        CubeModel.chooseTurn("L");
                        CubeModel.chooseTurn("D");
                        CubeModel.chooseTurn("LP");
                        CubeModel.chooseTurn("DP");
                        CubeModel.printFaces(f1, f5, f6, f3, f2, f4);
                        break;
                }

                break;

            case "B":

                switch (bottomColor) {

                    case "O":
                        CubeModel.chooseTurn("B");
                        CubeModel.chooseTurn("D");
                        CubeModel.chooseTurn("BP");
                        CubeModel.chooseTurn("DP");
                        break;
                    case "R":
                        CubeModel.chooseTurn("BP");
                        CubeModel.chooseTurn("DP");
                        CubeModel.chooseTurn("B");
                        CubeModel.chooseTurn("D");
                        break;
                }
                break;


            case "R":

                switch (bottomColor) {

                    case "G":
                        CubeModel.chooseTurn("RP");
                        CubeModel.chooseTurn("DP");
                        CubeModel.chooseTurn("R");
                        CubeModel.chooseTurn("D");
                        break;
                    case "B":
                        CubeModel.chooseTurn("R");
                        CubeModel.chooseTurn("D");
                        CubeModel.chooseTurn("RP");
                        CubeModel.chooseTurn("DP");
                        break;
                }

                break;
        }

    }
}