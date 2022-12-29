import javax.xml.transform.stax.StAXResult;

class CubeFace{
    static final int Fsize = 4;
    public CubeFace(String clr, String id){
        FaceId = id;
        for(int i = 0; i<Fsize; i++){
            for(int j = 0; j<Fsize; j++){
                face[i][j] = clr;
            }
        }
    }
    String[][] face = new String[Fsize][Fsize];
    CubeFace[] nexts = new CubeFace[2];
    int[] ThisRotations = new int[2];
    int[] NextRotations = new int[2];
    String FaceId;
    boolean isLR = false;
}