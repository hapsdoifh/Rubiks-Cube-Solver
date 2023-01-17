/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mypackages.CubeFiles;
import static mypackages.CubeFiles.CubeModel.printFaces;

/**
 *
 * @author zuhan
 */
public class SolveCube {
    
    public static void CompleteSolve(CubeFace f1, CubeFace f2, CubeFace f3, CubeFace f4, CubeFace f5, CubeFace f6) {
        
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
        
        WhiteCorners.getCorners(f1, f2, f3, f4, f5, f6); // white corners phase
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
    }
            
    
}
