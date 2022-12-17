

public class CubeModel {

    public static void LinkFace(CubeFace faceA, CubeFace faceB, int relation){
        switch(relation){
            case 0: //face B top of A
                faceA.ColumnL.adjA = faceB.ColumnL;
                faceA.ColumnR.adjA = faceB.ColumnR;
                faceB.ColumnL.adjB = faceA.ColumnL;
                faceB.ColumnR.adjB = faceA.ColumnR;
                faceA.RowT.adjFace = faceB;
                faceB.RowB.adjFace = faceA;
                break;
            case 1: //face B  left of A
                faceA.RowT.adjA = faceB.RowT;
                faceA.RowB.adjA = faceB.RowB;
                faceB.RowT.adjB = faceA.RowT;
                faceB.RowB.adjB = faceA.RowB;
                faceA.ColumnL.adjFace = faceB;
                faceB.ColumnR.adjFace = faceA;
                break;
            case 2: //left face & top face
                faceA.ColumnL.adjA = faceB.RowT;
                faceA.ColumnR.adjA = faceB.RowB;
                faceB.RowT.adjB = faceA.ColumnL;
                faceB.RowB.adjB = faceA.ColumnR;
                faceA.RowT.adjFace = faceB;
                faceB.ColumnL.adjFace=faceA;
            case 3: //right face & top face
                faceB.RowT.adjA = faceA.ColumnR;
                faceB.RowB.adjA = faceA.ColumnL;
                faceA.ColumnL.adjB = faceB.RowB;
                faceA.ColumnR.adjB = faceB.RowT;
                faceA.RowT.adjFace = faceB;
                faceB.ColumnR.adjFace=faceA;
                break;
        }
    }

    public static void movethree(ThreeBlock toMove, int direction){
        ThreeBlock origin = toMove;
        if(direction == 1){//fwd -> right/up          
            oneBlock[] copy = new oneBlock[3];
            for(int i = 0; i<3; i++){   
                copy[i] = new oneBlock();             
                copy[i].color = toMove.blockRef[i].color;
            }
            do{
                for(int i = 0; i<3; i++){
                    if(toMove.adjB.isback || toMove.isback){
                        toMove.blockRef[2-i].color = toMove.adjB.blockRef[i].color;
                    }else{
                        toMove.blockRef[i].color = toMove.adjB.blockRef[i].color;
                    }
                }
                toMove = toMove.adjB;
            }while(toMove != origin.adjA);            
            for(int i = 0; i<3; i++){
                if(toMove.adjB.isback || toMove.isback){
                    toMove.blockRef[2-i].color = copy[i].color;
                }else{
                    toMove.blockRef[i].color = copy[i].color;
                }
            }
            //move related face      
            oneBlock[][] cpy = new oneBlock[3][3];
            toMove = origin;
            CubeFace tempFace = toMove.adjFace;
            for(int k = 0; k<tempFace.direction; k++){
                for(int i = 0; i<3; i++){             
                    for(int j = 0; j<3; j++){
                        cpy[i][j] = new oneBlock();
                        cpy[i][j].color = tempFace.face[i][j].color;
                    }
                }
                for(int i =0; i<3;i++){
                    tempFace.face[i][0].color = cpy[2][i].color;
                    tempFace.face[0][i].color = cpy[2-i][0].color;
                    tempFace.face[i][2].color = cpy[0][i].color;
                    tempFace.face[2][i].color = cpy[2-i][2].color;
                }   

            }         
        }
    }

    public static void printFace(CubeFace src){
        for(oneBlock[] i : src.face){
            for(oneBlock j : i){
                System.out.print(" "+j.color);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args){
        CubeFace FrontFace = new CubeFace("B");
        CubeFace BackFace = new CubeFace("G");
        CubeFace TopFace = new CubeFace("W");
        CubeFace BottomFace = new CubeFace("Y");
        CubeFace LeftFace = new CubeFace("R");
        CubeFace RightFace = new CubeFace("O");
        LeftFace.direction = 3;
        TopFace.direction = 3;


        LinkFace(FrontFace, TopFace, 0);
        LinkFace(BottomFace,FrontFace,0);
        LinkFace(BackFace, BottomFace,0);
        LinkFace(TopFace,BackFace, 0);

        LinkFace(LeftFace, FrontFace, 1);
        LinkFace(FrontFace, RightFace, 1);
        LinkFace(RightFace, BackFace, 1);
        LinkFace(BackFace, LeftFace, 1);

        LinkFace(LeftFace, TopFace, 2);
        LinkFace(RightFace, BottomFace, 2);
        LinkFace(RightFace, TopFace, 3);
        LinkFace(LeftFace, BottomFace, 3);
        BackFace.RowT.adjFace = TopFace;
        BackFace.RowB.adjFace = BottomFace;

        BackFace.ColumnR.adjA = BottomFace.ColumnL;
        BackFace.ColumnR.adjB = TopFace.ColumnL;
        BackFace.ColumnL.adjA = BottomFace.ColumnR;
        BackFace.ColumnL.adjB = TopFace.ColumnR;
        TopFace.ColumnL.adjA = BackFace.ColumnR;
        TopFace.ColumnR.adjA = BackFace.ColumnL;

        BottomFace.ColumnL.adjB = BackFace.ColumnR;
        BottomFace.ColumnR.adjB = BackFace.ColumnL;

        BackFace.ColumnL.isback = true;
        BackFace.ColumnR.isback = true;

        movethree(TopFace.RowT, 1);
        outputSituation(FrontFace,TopFace,BottomFace,BackFace,LeftFace,RightFace);

        movethree(TopFace.ColumnL,1);
        outputSituation(FrontFace,TopFace,BottomFace,BackFace,LeftFace,RightFace);

        movethree(FrontFace.RowT, 1);
        outputSituation(FrontFace,TopFace,BottomFace,BackFace,LeftFace,RightFace);

    }

    public static void outputSituation(CubeFace FrontFace,CubeFace TopFace,CubeFace BottomFace,CubeFace BackFace,CubeFace LeftFace,CubeFace RightFace){        
        System.out.println("top:");
        printFace(TopFace);
        System.out.println("front:");
        printFace(FrontFace);
        System.out.println("bottom:");
        printFace(BottomFace);
        System.out.println("back:");
        printFace(BackFace);
        System.out.println("left:");
        printFace(LeftFace);
        System.out.println("right:");
        printFace(RightFace);
        System.out.println("---------------------------");
    }

}
