public class CornerSolution {
    public static void getCorners(CubeFace f1, CubeFace f2, CubeFace f3, CubeFace f4, CubeFace f5, CubeFace f6) {
        CubeFace[] faceList =  {f1,f2,f3,f4};
        //int targets[][] = {{0,0},{0,2},{2,0},{2,2}};
        int targets[][] = {{2,2},{0,2},{0,0},{2,0}};
        int corner = 0;
        while(corner<4){
            String adjCols[] = {"",""};
            int i = 0,targ,k = 0,side = 0;
            String move = "", rmove = "";
            for(i = 0; i<4; i++){
                if(faceList[i].blocks[2][0] == "W" || faceList[i].blocks[2][2] == "W"){
                    if(faceList[i].blocks[2][0] == "W"){
                        adjCols[0] = faceList[i-1 >= 0?i-1:4-1].blocks[2][2];
                        side = 0;
                        move = "D";
                        rmove = "DP";
                    }
                    else if(faceList[i].blocks[2][2] == "W"){
                        adjCols[0] = faceList[i+1 < 4?i+1:0].blocks[2][0];
                        side = 2;
                        move = "DP";
                        rmove = "D";
                    }    
                    Rotate3Block.turnFace(f6, 4-i);
                    adjCols[1] = f6.blocks[0][side];
                    Rotate3Block.turnFace(f6, i);
    
                    while(faceList[k].blocks[1][1] != adjCols[0]){
                        k++;
                    }
    
                    int white = 0;
                    if(side == 0){
                        white = k+1<4?k+1:0;
                    }else{
                        white = k-1>=0?k-1:3;
                    }
                    Rotate3Block.turnFace(f6, 4-k);
                    while(faceList[k].blocks[2][2-side] != adjCols[0] || faceList[white].blocks[2][side] !="W" || f6.blocks[0][2-side] != adjCols[1]){
                        Main.chooseTurn(move);
                    }
                    
                    Rotate3Block.turnFace(f6, k);
    
                    Main.chooseTurn(move);
                    Main.chooseTurn(convertMove(k)[side]);                    
                    Main.chooseTurn(rmove);
                    if(convertMove(k)[side].length() == 2){
                        Main.chooseTurn(convertMove(k)[side].charAt(0)+"");
                    }else{
                        Main.chooseTurn(convertMove(k)[side]+"P");
                    }
                    corner ++;
                    Main.printFaces(f1, f5, f6, f3, f2, f4); // prints new faces
                    break;
                }
            }

            if(i == 4){ //no corner found
                int turns = 0;
                while(turns<4 && f6.blocks[0][0] != "W"){
                    Rotate3Block.turnFace(f6, 1);
                    turns++; 
                }
                Rotate3Block.turnFace(f6, 4-turns+2);//rotate it back and then 90
                if(turns == 4){ //no white
                    Rotate3Block.turnFace(f6, 2);
                }else{
                        for(targ = 0; targ<4; targ++){
                            if(!f5.blocks[targets[targ][0]][targets[targ][1]].equals("W") ){ //choose first block not filled
                                while(!f6.blocks[targets[targ][0]][2-targets[targ][1]].equals("W")){
                                    Main.chooseTurn("D");
                                }
                                break;
                            }
                        }
                    Rotate3Block.turnFace(f6,2);//rotate it back 90
                    switch(targ){
                        case 0:
                            Main.chooseTurn("RP");
                            Main.chooseTurn("D");
                            Main.chooseTurn("R");
                            continue;
                        case 1:
                            Main.chooseTurn("BP");
                            Main.chooseTurn("D");
                            Main.chooseTurn("B");
                            continue;
                        case 2:
                            Main.chooseTurn("B");
                            Main.chooseTurn("DP");
                            Main.chooseTurn("BP");
                            continue;
                        case 3:
                            Main.chooseTurn("L");
                            Main.chooseTurn("DP");
                            Main.chooseTurn("LP");   
                            continue;
                        default:
                            continue;                       
                    }              
                }
            }

            //if neither found blocks    
            if(i == 4){        
                for(i = 0; i<4; i++){
                    if(faceList[i].blocks[0][2].equals("W")){
                        Main.chooseTurn(TopConvert(i));
                        Main.chooseTurn("D");
                        Main.chooseTurn(TopConvert(i)+"P");
                        break;
                    }else if(faceList[i].blocks[0][1].equals("W")){
                        Main.chooseTurn(TopConvert(i)+"P");
                        Main.chooseTurn("D");
                        Main.chooseTurn(TopConvert(i));
                        break;
                    }                
                } 
            }
            //top bottom & side all empty
            if(i==4){
                for(i = 0; i<4; i++){
                    if(!f1.blocks[0][0].equals(f1.blocks[0][1])){
                        Main.chooseTurn("L");
                        Main.chooseTurn("D");
                        Main.chooseTurn("LP");
                        for(int fix = 0; fix<i; fix++){
                            Main.chooseTurn("U");
                        }
                        break;
                    }else if(faceList[i].blocks[0][1].equals("W")){
                        Main.chooseTurn("RP");
                        Main.chooseTurn("DP");
                        Main.chooseTurn("R");
                        for(int fix = 0; fix<i; fix++){
                            Main.chooseTurn("U");
                        }
                        break;
                    }    
                    Main.chooseTurn("UP");
                }
            }
            if(i == 4){ //nothing to do
                break;
            }
        }
    }

    public static String TopConvert(int pos){
        switch(pos){
            case 0:
                return "F";
            case 1:
                return "R";
            case 2:
                return "B";
            case 3:
                return "L";
            default:
                return "";
        }
    }

    public static String[] convertMove(int pos){
        String[] move = {"","_",""};
        switch(pos){
            case 0:
                move[0] = "F";
                move[2] = "FP";
                return move;
            case 1:
                move[0] = "R";//
                move[2] = "RP";
                return move;
            case 2:
                move[0] = "B";
                move[2] = "BP";
                return move;
            case 3:
                move[0] = "L";
                move[2] = "LP";
                return move;
            default:
                return move;
        }
    }
}