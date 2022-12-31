public class Solution {

    static CubeFace f1;
    static CubeFace f2;
    static CubeFace f3;
    static CubeFace f4;
    static CubeFace f6;

    Solution (CubeFace f1, CubeFace f2, CubeFace f3, CubeFace f4, CubeFace f6) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.f4 = f4;
        this.f6 = f6;
    }

    public void checkWhiteBottom() {
    }

    public static void checkWhite() {

        CubeFace[] faces = {f1, f2, f3, f4};

        // code below for half of the cross completed
        for (int i = 0; i < 1; i++) {

            if ((faces[i]).blocks[1][0] ==  "W") {
                moveEdgeToBottom("f" + (i+1), 0);
            }

            if ((faces[i]).blocks[1][2] ==  "W") {
                moveEdgeToBottom("f" + (i+1), 2);
            }

            if ((faces[i]).blocks[0][1] ==  "W") {
                moveMidToBottom("f" + (i+1), "");
            }

            if ((faces[i]).blocks[2][1] ==  "W") {
                moveMidToBottom("f" + (i+1), "P");
            }

        }
    }

    public static void moveEdgeToBottom(String face, int column) {

        switch (column) {
            case 0:

                switch (face) {
                    case "f1":
                        Main.chooseTurn("L");
                        break;
                    case "f2":
                        Main.chooseTurn("F");
                        break;
                    case "f3":
                        Main.chooseTurn("R");
                        break;
                    case "f4":
                        Main.chooseTurn("B");
                        break;

                }

            case 2:

                switch (face) {
                    case "f1":
                        Main.chooseTurn("RP");
                        System.out.println("done RP");
                        break;
                    case "f2":
                        Main.chooseTurn("BP");
                        break;
                    case "f3":
                        Main.chooseTurn("LP");
                        break;
                    case "f4":
                        Main.chooseTurn("FP");
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

    }

    public static void rotateColorMatch() {

    }


}
