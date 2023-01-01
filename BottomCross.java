import java.util.regex.MatchResult;

import javax.print.attribute.standard.Sides;

public class BottomCross {
    static int[] Rows = {0,1,2,1};
    static int[] Cols = {1,2,1,0};
    public static void BCrossSolution(CubeFace f1,CubeFace f2,CubeFace f3,CubeFace f4,CubeFace f5,CubeFace f6){
        CubeFace[] FaceList = {f1,f2,f3,f4};
        while(countSide(f6) < 4){
            if(countSide(f6) == 2){
                if(f6.blocks[Rows[0]][Cols[0]] == f6.blocks[Rows[2]][Cols[2]] && f6.blocks[Rows[0]][Cols[0]] == "Y" ){
                    Main.chooseTurn("D");
                    continue;
                }else if(!(f6.blocks[Rows[1]][Cols[1]] == f6.blocks[Rows[3]][Cols[3]] && f6.blocks[Rows[1]][Cols[1]] == "Y")){ 
                    if(!(f6.blocks[Rows[1]][Cols[1]] == f6.blocks[Rows[2]][Cols[2]] && f6.blocks[Rows[1]][Cols[1]] == "Y")){ //need 2 more turn
                        Main.chooseTurn("D");
                        continue;
                    }
                }
            }
            Algorithm(0);
        }
        while(matchEdges(FaceList) != 4){
            while(!f4.blocks[1][1].equals(f4.blocks[2][1])){
                Main.chooseTurn("D");
            }
            for(int i = 0; i<matchEdges(FaceList); i++){
                Main.chooseTurn("DP");
            }
            Algorithm(1);
            while(!f4.blocks[1][1].equals(f4.blocks[2][1])){
                Main.chooseTurn("D");
            }
        }
    }

    public static int matchEdges(CubeFace[] FaceList){
        for(int i = 0; i<4; i++){
            if(!FaceList[i].blocks[1][1].equals(FaceList[i].blocks[2][1])){
                return i;
            }
        }
        return 4;
    }

    public static int countSide(CubeFace f6){
        int sides = 0;
        for(int i = 0; i<4; i++){
            if(f6.blocks[Rows[i]][Cols[i]].equals("Y")){
                sides++;
            }
        }
        return sides;
    }

    public static void Algorithm(int which){
        String[][] Turns = {{"F","L","D","LP","DP","FP"},{"L","D","LP","D","L","D","D","LP","D"}};
        for(String i : Turns[which]){
            Main.chooseTurn(i);
        }
    }

}
