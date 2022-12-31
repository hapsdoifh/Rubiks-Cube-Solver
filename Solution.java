public class Solution {

    static CubeFace f1;
    static CubeFace f2;
    static CubeFace f3;
    static CubeFace f4;
    static CubeFace f6;

    static boolean isWhite = false;

    Solution(CubeFace f1, CubeFace f2, CubeFace f3, CubeFace f4, CubeFace f6) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.f4 = f4;
        this.f6 = f6;

    }

    public void checkWhiteBottom() {
    }

    public static void checkWhite() {

        boolean flag = true;
        CubeFace[] faces = {f1, f2, f3, f4};

        // code below for half of the cross completed

        boolean MLBool;
        boolean MRBool;
        boolean MTBool;
        boolean MBBool;
        do {

            MLBool = checkMidLeft(faces);
            MRBool = checkMidRight(faces);
            MTBool = checkMidTop(faces);
            MBBool = checkMidBottom(faces);

        } while (MLBool == false && MRBool == false && MTBool == false && MBBool == false);


//        for (int i = 0; i < 4; i++) {
//
//            if ((faces[i]).blocks[1][0].equals("W")) {
//                moveEdgeToBottom("f" + (i + 1), 0);
//            }
//
//            if ((faces[i]).blocks[1][2].equals("W")) {
//                moveEdgeToBottom("f" + (i + 1), 2);
//            }
//
//            if ((faces[i]).blocks[0][1].equals("W")) {
//                System.out.println("Checks white:" + i);
//                moveMidToBottom("f" + (i + 1), "");
//            }
//
//            if ((faces[i]).blocks[2][1].equals("W")) {
//                moveMidToBottom("f" + (i + 1), "P");
//            }
//
//            findTopAdjColor();
//
//        }
    }

    public static boolean checkMidLeft(CubeFace[] faces) {
        for (int i = 0; i < 4; i++) {

            if ((faces[i]).blocks[1][0].equals("W")) {
                moveEdgeToBottom("f" + (i + 1), 0);
                findTopAdjColor();
                isWhite = true;
            }
        }

        return isWhite;
    }

    public static boolean checkMidRight(CubeFace[] faces) {
        for (int i = 0; i < 4; i++) {

            if ((faces[i]).blocks[1][2].equals("W")) {
                moveEdgeToBottom("f" + (i + 1), 2);
                findTopAdjColor();
                isWhite = true;
            }
        }

        return isWhite;
    }

    public static boolean checkMidTop(CubeFace[] faces) {
        for (int i = 0; i < 4; i++) {

            if ((faces[i]).blocks[0][1].equals("W")) {
                System.out.println("Checks white:" + i);
                moveMidToBottom("f" + (i + 1), "");
                findTopAdjColor();
                isWhite = true;
            }
        }

        return isWhite;
    }

    public static boolean checkMidBottom(CubeFace[] faces) {
        for (int i = 0; i < 4; i++) {

            if ((faces[i]).blocks[2][1].equals("W")) {
                moveMidToBottom("f" + (i + 1), "P");
                findTopAdjColor();
                isWhite = true;
            }
        }

        return isWhite;
    }

    public static void moveEdgeToBottom(String face, int column) {

        switch (column) {
            case 0:

                switch (face) {
                    case "f1":
                        Main.chooseTurn("L");
                        Main.chooseTurn("D");
                        Main.chooseTurn("LP");
                        Main.chooseTurn("DP");
                        break;
                    case "f2":
                        Main.chooseTurn("F");
                        Main.chooseTurn("D");
                        Main.chooseTurn("FP");
                        Main.chooseTurn("DP");
                        break;
                    case "f3":
                        Main.chooseTurn("R");
                        Main.chooseTurn("D");
                        Main.chooseTurn("RP");
                        Main.chooseTurn("DP");
                        break;
                    case "f4":
                        Main.chooseTurn("B");
                        Main.chooseTurn("D");
                        Main.chooseTurn("BP");
                        Main.chooseTurn("DP");
                        break;

                }

            case 2:

                switch (face) {
                    case "f1":
                        Main.chooseTurn("RP");
                        Main.chooseTurn("DP");
                        Main.chooseTurn("R");
                        Main.chooseTurn("D");
                        break;
                    case "f2":
                        Main.chooseTurn("BP");
                        Main.chooseTurn("DP");
                        Main.chooseTurn("B");
                        Main.chooseTurn("D");
                        break;
                    case "f3":
                        Main.chooseTurn("LP");
                        Main.chooseTurn("DP");
                        Main.chooseTurn("L");
                        Main.chooseTurn("D");
                        break;
                    case "f4":
                        Main.chooseTurn("FP");
                        Main.chooseTurn("DP");
                        Main.chooseTurn("F");
                        Main.chooseTurn("D");
                        break;
                }

        }

    }

    public static void moveMidToBottom(String face, String isPrime) {

        // if isPrime = P then the white block is in last row position; if isPrime is empty then the white block is in top row position

        switch (face) {
            case "f1":
                Main.chooseTurn("F" + isPrime); //isPrime checks if the white block is in the top or bottom position
                Main.chooseTurn("RP");
                Main.chooseTurn("DP");
                Main.chooseTurn("R");
                System.out.println("Moved to bottom!");
                break;
            case "f2":
                Main.chooseTurn("R" + isPrime);
                Main.chooseTurn("BP");
                Main.chooseTurn("DP");
                Main.chooseTurn("B");
                break;
            case "f3":
                Main.chooseTurn("B" + isPrime);
                Main.chooseTurn("LP");
                Main.chooseTurn("DP");
                Main.chooseTurn("L");
                break;
            case "f4":
                Main.chooseTurn("L" + isPrime);
                Main.chooseTurn("FP");
                Main.chooseTurn("DP");
                Main.chooseTurn("F");
                break;
        }

    }

    public static void findTopAdjColor() {

        String color = "";

        if (f6.blocks[0][1].equals("W")) {
            System.out.println("It's white!");
            color = f1.blocks[2][1];
            checkIfMatching(f1.blocks[2][1], f1.blocks[1][1], "f1");
        }

        if (f6.blocks[1][0].equals("W")) {
            color = f4.blocks[2][1];
            checkIfMatching(f4.blocks[2][1], f4.blocks[1][1], "f4");
        }

        if (f6.blocks[1][2].equals("W")) {
            color = f2.blocks[2][1];
            checkIfMatching(f2.blocks[2][1], f2.blocks[1][1], "f2");
        }

        if (f6.blocks[2][1].equals("W")) {
            color = f3.blocks[2][1];
            checkIfMatching(f3.blocks[2][1], f2.blocks[1][1], "f3");
        }

    }

    public static void checkIfMatching(String cAdj, String cMiddle, String face) {

        int rot_num = 0;

        if (!cAdj.equals(cMiddle)) {
            System.out.println(cAdj + ", " + cMiddle);
            System.out.println("Not matching!");
            rot_num = calcRotationNumber(face, cAdj);
            rotateColorMatch(rot_num);
        }

        moveToTop(face, rot_num);

//        if (cAdj.equals(cMiddle)) { // if the adjacent top block color matches the middle block color
//            moveToTop(face);
//
//        } else {
//            int rot_num = calcRotationNumber(face, cAdj);
//            rotateColorMatch(rot_num);
//        }
    }

    public static int calcRotationNumber (String face, String cAdj) {

        switch (face) {

            case "f1":

                switch (cAdj) {

                    case "R":
                        return 1;
                    case "B":
                        return 2;
                    case "O":
                        return 3;
                }

                break;

            case "f2":

                switch (cAdj) {

                    case "B":
                        return 1;
                    case "O":
                        return 2;
                    case "G":
                        return 3;
                }

                break;

            case "f3":

                switch (cAdj) {

                    case "O":
                        return 1;
                    case "G":
                        return 2;
                    case "R":
                        return 3;
                }

                break;

            case "f4":

                switch (cAdj) {

                    case "G":
                        return 1;
                    case "R":
                        return 2;
                    case "B":
                        return 3;
                }

                break;

        }

        return 0;

    }

    public static void rotateColorMatch (int num) {

        for (int i = 0; i < num; i++) {
            Main.chooseTurn("D");
        }

    }

    public static void moveToTop(String face, int rot_num) {

        for (int i = 0; i < 2; i++) {

            switch (face) {

                case "f1":

                    switch (rot_num) {
                        case 0:
                            Main.chooseTurn("F");
                            break;
                        case 1:
                            Main.chooseTurn("R");
                            break;
                        case 2:
                            Main.chooseTurn("B");
                            break;
                        case 3:
                            Main.chooseTurn("L");
                            break;
                    }

//                    Main.chooseTurn("F");
                    break;
                case "f2":

                    switch (rot_num) {
                        case 0:
                            System.out.println("Turned R!");
                            Main.chooseTurn("R");
                            break;
                        case 1:
                            Main.chooseTurn("B");
                            break;
                        case 2:
                            Main.chooseTurn("L");
                            break;
                        case 3:
                            Main.chooseTurn("F");
                            break;
                    }

//                    Main.chooseTurn("R");
                    break;
                case "f3":

                    switch (rot_num) {
                        case 0:
                            Main.chooseTurn("B");
                            break;
                        case 1:
                            Main.chooseTurn("L");
                            break;
                        case 2:
                            Main.chooseTurn("F");
                            break;
                        case 3:
                            Main.chooseTurn("R");
                            break;
                    }

//                    Main.chooseTurn("B");
                    break;
                case "f4":

                    switch (rot_num) {
                        case 0:
                            Main.chooseTurn("L");
                            break;
                        case 1:
                            Main.chooseTurn("F");
                            break;
                        case 2:
                            Main.chooseTurn("R");
                            break;
                        case 3:
                            Main.chooseTurn("B");
                            break;
                    }

//                    Main.chooseTurn("L");
                    break;

            }
        }
    }
}
