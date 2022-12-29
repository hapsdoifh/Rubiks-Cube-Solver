import javax.xml.transform.stax.StAXResult;

class CubeFace{
    static final int Fsize = 3;
    public CubeFace(String clr){
        for(int i = 0; i<Fsize; i++){
            for(int j = 0; j<Fsize; j++){
                face[i][j] = clr;
            }
        }
    }
    String[][] face = new String[Fsize][Fsize];
    CubeFace[] nexts = new CubeFace[2];
    CubeFace[] prevs = new CubeFace[2];
    int[] ThisRotations = new int[2];
    int[] NextRotations = new int[2];
    boolean isLR = false;
}