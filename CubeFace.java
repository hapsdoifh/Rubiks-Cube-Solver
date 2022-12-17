class CubeFace{
    public CubeFace(String clr){
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                face[i][j] = new oneBlock();
                face[i][j].color = clr;
            }
        }
        for(int i = 0; i<3; i++){
            ColumnL.blockRef[2-i] = face[i][0];
            ColumnR.blockRef[2-i] = face[i][2];
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