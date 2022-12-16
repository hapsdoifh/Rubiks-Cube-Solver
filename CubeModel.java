import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedTransferQueue;

import javax.xml.namespace.QName;

public class javatest {

    class ThreeBlock{
        oneBlock[] blockRef = new oneBlock[3];
        ThreeBlock adjA = new block();
        ThreeBlock adjB = new block();
        CubeFace adjFace = new CubeFace();
    }
    class oneBlock{
        int color = 0;
    }
    class CubeFace{
        public CubeFace(int clr){
            for(oneBlock[] i: face){
                for(oneBlock j: i){
                    j.color = clr;
                }
            }
            for(int i = 0; i<3; i++){
                ColumnL.blockRef[i] = face[i][0];
                ColumnR.blockRef[i] = face[i][2];
                RowT.blockRef[i] = face[0][i];
                RowB.blockRef[i] = face[2][i];
            }
        }
        oneBlock[][] face = new oneBlock[3][3];
        ThreeBlock ColumnL = new ThreeBlock();
        ThreeBlock ColumnR = new ThreeBlock();
        ThreeBlock RowT = new ThreeBlock();
        ThreeBlock RowB = new ThreeBlock();
    }
    public static void LinkFace(CubeFace faceA, CubeFace faceB, int relation){
        switch(relation){
            case 0: //face B top of A
                faceA.ColumnL.adjA = faceB.ColumnL;
                faceA.ColumnR.adjA = faceB.ColumnR;
                faceB.ColumnL.adjB = faceA.ColumnL;
                faceB.ColumnR.adjB = faceA.ColumnL;
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
            default:
                break;
        }
    }

    public static void movethree(ThreeBlock toMove, int direction){
        ThreeBlock origin = toMove;
        if(direction == 1){//fwd -> right/up          
            oneblock[] copy = new oneBlock[3];
            for(oneBlock i : copy){
                i = new oneBlock();
                i.color = toMove.blockRef[i].color;
            }
            toMove = toMove.adjB;
            while(toMove != origin){
                for(i = 0; i<3; i++){
                    toMove.adjA.blockRef[i] = toMove.blockRef[i];
                }
            }
        }
    }
    public static void main(String[] args){
        CubeFace FrontFace = new CubeFace();
        CubeFace BackFace = new CubeFace();
        CubeFace TopFace = new CubeFace();
        CubeFace BottomFace = new CubeFace();
        CubeFace LeftFace = new CubeFace();
        CubeFace RightFace = new CubeFace();
        LinkFace(FrontFace,BottomFace,0);
        LinkFace(TopFace, FrontFace, 0);
        LinkFace(BottomFace, BackFace,0);
        LinkFace(BackFace,TopFace, 0);

        LinkFace(LeftFace, FrontFace, 1);
        LinkFace(FrontFace, RightFace, 1);
        LinkFace(RightFace, BackFace, 1);
        LinkFace(BackFace, LeftFace, 1);

        LinkFace(TopFace, LeftFace, 2);
        LinkFace(RightFace, TopFace, 2);
        LinkFace(BottomFace, RightFace, 2);
        LinkFace(LeftFace, BottomFace, 2);

    }

}
