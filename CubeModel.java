

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
            case 3: //left face & top face
                faceB.RowT.adjA = faceA.ColumnL;
                faceB.RowB.adjA = faceA.ColumnR;
                faceA.ColumnL.adjB = faceB.RowT;
                faceA.ColumnR.adjB = faceB.RowB;
                faceA.RowB.adjFace = faceB;
                faceB.ColumnR.adjFace=faceA;
            default:
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
                    toMove.blockRef[i].color = toMove.adjB.blockRef[i].color;
                }
                toMove = toMove.adjB;
            }while(toMove != origin.adjA);            
            for(int i = 0; i<3; i++){
                toMove.blockRef[i].color = copy[i].color;
            }
        }else{ //back       
            oneBlock[] copy = new oneBlock[3];
            for(int i = 0; i<3; i++){      
                copy[i] = new oneBlock();             
                copy[i].color = toMove.blockRef[i].color;
            }
            do{
                for(int i = 0; i<3; i++){
                    toMove.blockRef[i].color = toMove.adjA.blockRef[i].color;
                }
                toMove = toMove.adjB;
            }while(toMove != origin.adjB);            
            for(int i = 0; i<3; i++){
                toMove.blockRef[i].color = copy[i].color;
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
        CubeFace FrontFace = new CubeFace(1);
        CubeFace BackFace = new CubeFace(2);
        CubeFace TopFace = new CubeFace(3);
        CubeFace BottomFace = new CubeFace(4);
        CubeFace LeftFace = new CubeFace(5);
        CubeFace RightFace = new CubeFace(6);
        LinkFace(TopFace, FrontFace, 0);
        LinkFace(FrontFace,BottomFace,0);
        LinkFace(BottomFace, BackFace,0);
        LinkFace(BackFace,TopFace, 0);

        LinkFace(LeftFace, FrontFace, 1);
        LinkFace(FrontFace, RightFace, 1);
        LinkFace(RightFace, BackFace, 1);
        LinkFace(BackFace, LeftFace, 1);

        LinkFace(LeftFace, TopFace, 2);
        LinkFace(RightFace, BottomFace, 2);
        LinkFace(RightFace, TopFace, 3);
        LinkFace(LeftFace, BottomFace, 3);

        movethree(TopFace.RowT, 1);
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


    }

}
