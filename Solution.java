public class Solution {

    public static void checkWhite(CubeFace f1, CubeFace f2, CubeFace f3, CubeFace f4) {

        CubeFace[] faces = {f1, f2, f3, f4};

        // code below for half of the cross completed
        for (int i = 0; i < 1; i++) {

            if ((faces[i]).blocks[1][0] ==  "W") {
                moveToTop("f" + (i+1), 0);
            }

            if ((faces[i]).blocks[1][2] ==  "W") {
                moveToTop("f" + (i+1), 2);
            }
        }
    }

    public static void moveToTop(String face, int column) {

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

}
