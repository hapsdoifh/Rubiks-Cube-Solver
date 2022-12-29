import java.util.*;

public class CubeModel {

    public static void LinkFace(CubeFace faceA, CubeFace faceN, int orient, int thisR, int nextR){
        faceA.nexts[orient] = faceN;
        faceA.ThisRotations[orient] = thisR;
        faceA.NextRotations[orient] = nextR;       
    }

    public static CubeFace TurnFace(CubeFace src, int turn){
        CubeFace temp = new CubeFace("_","");
        int layer = 0,lim = CubeFace.Fsize-1;
        copyFace(temp, src);
        for(int j = 0; j<turn; j++){
            for(layer = 0; (float)layer < ((float)lim)/2; layer++){
                for(int i = layer; i<lim-layer; i++){ //counter-clockwise
                    temp.face[layer][i] = src.face[i][lim-layer]; //top row
                    temp.face[i][lim-layer] = src.face[lim-layer][lim-layer-i]; //right col
                    temp.face[lim-layer][lim-layer-i] = src.face[lim-layer-i][layer]; //bottom row
                    temp.face[lim-layer-i][layer] = src.face[layer][i];
                }                        
            }
            copyFace(src, temp);
        }
        return src;
    }

    public static void moveblocks(CubeFace ReverseStart,CubeFace nextBlock,int Dir, int RowCol){
        ReverseStart = TurnFace(ReverseStart, ReverseStart.ThisRotations[Dir]);
        nextBlock = TurnFace( nextBlock,  ReverseStart.NextRotations[Dir]);

        for(int i = 0; i<CubeFace.Fsize; i++){
            ReverseStart.face[RowCol][i] = nextBlock.face[RowCol][i];
        }           
        ReverseStart = TurnFace(ReverseStart, 4-ReverseStart.ThisRotations[Dir]);
        nextBlock = TurnFace(nextBlock,  4-ReverseStart.NextRotations[Dir]);
    }

    public static int isTB(CubeFace store, CubeFace ReverseStart, int Dir){
        if(ReverseStart.isLR && (store.FaceId.equals("T")||store.FaceId.equals("D"))){
            return 1-Dir;
        }else if((ReverseStart.FaceId.equals("T")||ReverseStart.FaceId.equals("D")) && store.isLR){
            return 1-Dir;    
        }else {
            return Dir;
        }
    }

    public static CubeFace moveRowCol(CubeFace Archive, CubeFace ReverseStart,CubeFace Origin, int Dir, int DirStore, int RowCol){
        int turns;
        CubeFace Face;
        if(ReverseStart.nexts[Dir] == Origin ){
            if(RowCol == 0 || RowCol == CubeFace.Fsize-1){                
                moveblocks(ReverseStart, Archive ,Dir, RowCol);
                Dir = 1-DirStore;
                if(RowCol == 0){    
                    ReverseStart = Origin;
                    while(ReverseStart.nexts[Dir]!=Origin){
                        CubeFace store = ReverseStart;
                        ReverseStart=ReverseStart.nexts[Dir];
                        Dir = isTB(store, ReverseStart, Dir);
                    }
                    Face = ReverseStart;
                    turns = 3;
                }else{        
                    Face = Origin.nexts[Dir];  
                    turns = 1; 
                }
                if(Face.FaceId.equals("L") || Face.FaceId.equals("R")){
                    turns = 4 - turns;
                }
                copyFace(Face, TurnFace(Face, turns)); 
            }
            return null;
        }else{
            if(ReverseStart == Origin){
                Archive = new CubeFace(" ",Origin.FaceId);
                copyFace(Archive, Origin);
            }
            moveblocks(ReverseStart,ReverseStart.nexts[Dir], Dir, RowCol);
            
            CubeFace store = ReverseStart;
            ReverseStart = ReverseStart.nexts[Dir];
            Dir = isTB(store, ReverseStart, Dir);
            return moveRowCol(Archive, ReverseStart, Origin, Dir, DirStore, RowCol);
        }
    }

    public static void copyFace(CubeFace dest, CubeFace src){
        for(int i = 0; i<CubeFace.Fsize; i++){
            for(int j = 0; j<CubeFace.Fsize; j++){
                dest.face[i][j] = src.face[i][j];
            }
        }
    }

    public static void printFace(CubeFace src){
        for(int i = 0; i<CubeFace.Fsize; i++){
            for(int j = 0; j<CubeFace.Fsize; j++){
                System.out.print(src.face[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void repeatTurns(int WhichWay,CubeFace src,int Dir, int RowCol){
        for(int i = 0; i<WhichWay; i++){
            moveRowCol(null, src, src, Dir, Dir, RowCol);
        }
    }

    public static void main(String[] args){
        CubeFace FrontFace = new CubeFace("B","F");
        CubeFace BackFace = new CubeFace("G","B");
        CubeFace TopFace = new CubeFace("Y","T");
        CubeFace BottomFace = new CubeFace("W","D");
        CubeFace LeftFace = new CubeFace("O","L");
        LeftFace.isLR = true;
        CubeFace RightFace = new CubeFace("R","R");
        RightFace.isLR = true;

        LinkFace(LeftFace, TopFace, 0, 3,0); //1 is clockwise 90 itself
        LinkFace(TopFace, RightFace, 1, 0,1);
        LinkFace(RightFace, BottomFace, 0, 1,2);
        LinkFace(BottomFace, LeftFace, 1, 2,3);
        
        LinkFace(TopFace, FrontFace, 0, 3,3);
        LinkFace(BackFace, TopFace, 0, 1,3);
        LinkFace(BottomFace, BackFace, 0, 3,1);
        LinkFace(FrontFace, BottomFace, 0, 3,3);

        LinkFace(LeftFace, FrontFace, 1, 0, 0); //0:vertical, 
        LinkFace(FrontFace, RightFace, 1, 0, 0);
        LinkFace(RightFace, BackFace, 1,  0, 0);
        LinkFace(BackFace, LeftFace, 1,  0, 0);

        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        while(!temp.equals("quit")){
            int rpt = 4-temp.charAt(2)+'0';
            switch(temp.charAt(0)+""+temp.charAt(1)){
                case "FL":
                    repeatTurns(rpt,FrontFace, 0, 0);
                    break;
                case "FR":
                    repeatTurns(rpt,FrontFace, 0, 2);
                    break;
                case "FT":
                    repeatTurns(rpt, FrontFace, 1, 0);
                    break;
                case "FB":
                    repeatTurns(rpt, FrontFace, 1, 2);
                    break;
                case "TT":
                    repeatTurns(rpt, TopFace, 1, 0);
                    break;
                case "TB":
                    repeatTurns(rpt, TopFace, 1, 2);
                    break;
            }
            outputSituation(FrontFace,TopFace,BottomFace,BackFace,LeftFace,RightFace);
            temp = sc.nextLine();
        }
    }

    public static void outputSituation(CubeFace FrontFace,CubeFace TopFace,CubeFace BottomFace,CubeFace BackFace,CubeFace LeftFace,CubeFace RightFace){        
        System.out.println("left:");
        printFace(LeftFace);
        System.out.println("front:");
        printFace(FrontFace);
        System.out.println("right:");
        printFace(RightFace);
        System.out.println("back:");
        printFace(BackFace);
        System.out.println("top:");
        printFace(TopFace);
        System.out.println("bottom:");
        printFace(BottomFace);
        System.out.println("---------------------------");
    }
}

