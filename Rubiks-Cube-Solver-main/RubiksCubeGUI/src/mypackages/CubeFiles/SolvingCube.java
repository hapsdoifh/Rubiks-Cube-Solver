package mypackages.CubeFiles;
public class SolvingCube {

    static CubeFace f1;
    static CubeFace f2;
    static CubeFace f3;
    static CubeFace f4;
    static CubeFace f5;
    static CubeFace f6;

    SolvingCube(CubeFace f1, CubeFace f2, CubeFace f3, CubeFace f4, CubeFace f5, CubeFace f6) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.f4 = f4;
        this.f5 = f5;
        this.f6 = f6;

    }

    public void checkSolvedCube() {

        CubeFace[] faces = {f1, f2, f3, f4, f5, f6};
        int counter = 0;

        for (int i = 0; i < 6; i++) {

            for (int j = 0; j < 3; j++) {

                for (int k = 0; k < 3; k++) {

                    if ((faces[i]).blocks[j][k].equals((faces[i]).blocks[1][1])) {
                        counter++;
                    }

                }

            }

        }

        if (counter != 54) {
            checkBottomYellow();
        }

    }

    public static void checkBottomYellow() {

        int counter = 0;

        while (true) {
            rightHM1(); // completes right hand move

            if (f6.blocks[0][0].equals("Y")) {
                counter++;
                CubeModel.chooseTurn("UP"); // fourth turn
                CubeModel.chooseTurn("D");
            } else {
                CubeModel.chooseTurn("UP");
            }

            if (counter==4) {
                System.out.println("BREAK!");
                break;
            }

        }


        switch (f1.blocks[1][1]) {
            case "G":
                rHM(0);
                break;
            case "R":
                rHM(1);
                break;
            case "B":
                rHM(2);
                break;
            case "O":
                rHM(3);
                break;

        }

    }
    
public static void rHM(int num) {

        for (int i = 0 ; i < num; i++) {
            CubeModel.chooseTurn("D");
        }
    }

    //right hand move

    public static void rightHM1() {

        CubeModel.chooseTurn("F");
        CubeModel.chooseTurn("U");
        CubeModel.chooseTurn("FP");

    }

}