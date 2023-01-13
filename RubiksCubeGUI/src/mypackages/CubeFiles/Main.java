package mypackages.CubeFiles;
import mypackages.*;

import java.util.Scanner;
import java.util.*;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static CubeFace f1;
    public static CubeFace f2;
    public static CubeFace f3;
    public static CubeFace f4;
    public static CubeFace f5;
    public static CubeFace f6;
    public static CubeFace[] FaceList = new CubeFace[6];
    static MainPage GUIref;
    static Rotate3Block r;
    public static ArrayList<CubeFace[]> TurnRecord = new ArrayList<CubeFace[]>();
    
    public static void InitCube(MainPage parentFrame){
        GUIref = parentFrame;
        f1 = new CubeFace("G"); 
        f2 = new CubeFace("R");
        f3 = new CubeFace("B");
        f4 = new CubeFace("O");
        f5 = new CubeFace("W");
        f6 = new CubeFace("Y");
        FaceList[0] = f1;        
        FaceList[1] = f2;
        FaceList[2] = f3;
        FaceList[3] = f4;
        FaceList[4] = f5;
        FaceList[5] = f6;
    }


    public static CubeFace[] SolveProcess(MainPage parentFrame) {
        
        GUIref = parentFrame;
        
        r = new Rotate3Block();

        WhiteCross w = new WhiteCross(f1, f2, f3, f4, f5, f6);

        SecondLayer s = new SecondLayer(f1, f2, f3, f4, f5, f6);

        MatchColors m = new MatchColors(f1, f2, f3, f4, f5, f6);

        SolvingCube c = new SolvingCube(f1, f2, f3, f4, f5, f6);

        System.out.println("Original:");

        printFaces(f1, f5, f6, f3, f2, f4); // prints original faces
        //parentFrame.updateCube(FaceList);
        
        // solution
        WhiteCross.checkWhiteCross(); // white cross phase
        System.out.println("White cross: ");
        printFaces(f1, f5, f6, f3, f2, f4); // prints white corners faces
        
        CornerSolution.getCorners(f1, f2, f3, f4, f5, f6); // white corners phase
        System.out.println("White corners: ");
        printFaces(f1, f5, f6, f3, f2, f4); // prints new faces

        SecondLayer.checkBottomYellow();
        System.out.println("Second layer: ");
        printFaces(f1, f5, f6, f3, f2, f4); // prints new faces
        //parentFrame.updateCube(FaceList);

        BottomCross.BCrossSolution(f1, f2, f3, f4, f5, f6);
        printFaces(f1, f5, f6, f3, f2, f4); // prints new faces
        //parentFrame.updateCube(FaceList);

        s.checkBottomYellow();

        System.out.println("Second layer: ");

        printFaces(f1, f5, f6, f3, f2, f4); // prints new faces

        m.checkColor();

        printFaces(f1, f5, f6, f3, f2, f4); // prints faces for matching colors

        System.out.println("Corners");

        CornerSwap.SwapCorner(f1, f2, f3, f4, f5, f6);

        printFaces(f1, f5, f6, f3, f2, f4); // prints new faces
      
        c.checkBottomYellow();

        printFaces(f1, f5, f6, f3, f2, f4); // prints new faces
        //parentFrame.updateCube(FaceList);


        return FaceList;
    }
    
    public static void CopyCube(CubeFace[] dest, CubeFace[] src){
        for(int i =0; i<6; i++){
            dest[i] = new CubeFace("0");
            for(int y = 0; y<3; y++){
                for(int x = 0; x<3; x++){
                    dest[i].blocks[y][x] = src[i].blocks[y][x];
                }
            }
        }
        
    }
    
    public static void chooseTurn(String t) {
//        System.out.println("What turn? ");
//        String turn = in.nextLine();

        String turn = t;
        CubeFace[] FaceList = {f1,f2,f3,f4,f5,f6};

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

            }

            r.turnFace(f5, 3);
            r.turnFace(f6, 1);
        }
        CubeFace[] temp = new CubeFace[6];
        CopyCube(temp,FaceList);
        TurnRecord.add(temp);
        //GUIref.updateCube(FaceList);
        
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