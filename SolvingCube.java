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

    public void checkBottomYellow() {

        int counter = 0;

        while (true) {
            rightHM1(); // completes right hand move

            if (f6.blocks[0][0].equals("Y")) {
                counter++;
                Main.chooseTurn("UP");
                Main.chooseTurn("D");
            } else {
                Main.chooseTurn("UP");
            }

            if (counter==3) {
                System.out.println("BREAK!");
                break;
            }

        }

        Main.chooseTurn("D");


    }

    //right hand move

    public static void rightHM1() {

        Main.chooseTurn("F");
        Main.chooseTurn("U");
        Main.chooseTurn("FP");

    }

}
