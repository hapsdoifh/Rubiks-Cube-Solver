package mypackages.CubeFiles;

import javax.print.DocFlavor.STRING;

public class CornerSwap {
    public static void SwapCorner(CubeFace f1,CubeFace f2,CubeFace f3,CubeFace f4,CubeFace f5,CubeFace f6){
        CubeFace[] FaceList = {f1,f2,f3,f4};
        int[] CorR = {0,2,2,0}, CorC = {2,2,0,0};
        int ca = 4;
        while(ca == 4){
            for(ca = 0; ca<4; ca++){
                String CornerColor = FaceList[ca].blocks[2][2]+FaceList[ca+1<4?ca+1:0].blocks[2][0]+f6.blocks[CorR[ca]][CorC[ca]];
                String FaceColor = "Y"+FaceList[ca].blocks[1][1]+FaceList[ca+1<4?ca+1:0].blocks[1][1];
                if(IsGoodCorner(CornerColor,FaceColor)){ //if the color is the right color
                    break;
                }
            }
            if(ca == 4){ // corner exists
                BottomAlgo(0);
            }
        }
        ca = ca+1 < 4?ca+1:0;
        boolean AllFour = false;
        while(!AllFour){
            AllFour = true;
            for(int i = 0; i<4; i++){
                String CornerColor = FaceList[i].blocks[2][2]+FaceList[i+1<4?i+1:0].blocks[2][0]+f6.blocks[CorR[i]][CorC[i]];
                String FaceColor = "Y"+FaceList[i].blocks[1][1]+FaceList[i+1<4?i+1:0].blocks[1][1];
                if(!IsGoodCorner(CornerColor,FaceColor)){ //if the color is the right color
                    AllFour= false;            
                    BottomAlgo(ca);
                    break;
                }
            }    

        }
    }

    public static boolean IsGoodCorner(String corner, String faces){
        int matches = 0;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(corner.charAt(i) == faces.charAt(j)){
                    matches++;
                }
            }
        }
        return matches==3; //if < 3 it's not a good corner
    }

    public static void BottomAlgo(int which){
        String[] Turns = {"D","L","DP","RP","D","LP","DP","R"};
        for(String s : Turns){
            String Monitor = convertTurns(s, which);
            Main.chooseTurn(Monitor);
        }
    }

    public static String convertTurns(String turn, int face){
        String reverse = "";
        if(turn.length() == 2){
            reverse = "P";
        }
        switch(face){
            case 1:
                switch(turn.charAt(0)){
                    case 'L':
                        return "F" + reverse;
                    case 'R':
                        return "B" + reverse;
                    default:
                        return turn;
                }
            case 2:
                switch(turn.charAt(0)){
                    case 'L':
                        return "R" + reverse;
                    case 'R':
                        return "L" + reverse;
                    default:
                        return turn;
                }
            case 3:
                switch(turn.charAt(0)){
                    case 'L':
                        return "B" + reverse;
                    case 'R':
                        return "F" + reverse;
                    default:
                        return turn;
                }
            default:
                return turn;
        }
    }
    

}
