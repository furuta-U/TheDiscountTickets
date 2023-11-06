/***
 *** ゲームキャラクター
 ***/

 public abstract class GameChar {
    protected int px,py; // 位置
    protected int cx, cy; // 判定領域の中心
    protected int cw,ch; // 判定領域の大きさ
    
    // 生成
    public GameChar(){
      this(0,0);
    }
    
    public GameChar(int x, int y){
      px=x; py=y;
      cx=x; cy=y;
      cw=ch=0; // 最初の大きさは0x0
    }
    
    // 判定領域の中心の設定
    public void setCenter(int dx, int dy){
      cx = dx;
      cy = dy;
    }
    
    // 大きさ設定
    public void setSize(int w, int h){
      cw=w;
      ch=h;
    }
    
    // 位置を得る
    public double getX(){ return px; }
    public double getY(){ return py; }
    
    // 重なり判定
    public boolean overlap(GameChar c){
      double x11=cx-cw/2,y11=cy-ch/2;
      double x12=cx+cw/2,y12=cy+ch/2;
      double x21=c.cx-c.cw/2,y21=c.cy-c.ch/2;
      double x22=c.cx+c.cw/2,y22=c.cy+c.ch/2;
      return
      (((x11<=x21 && x21<x12)||(x21<=x11 && x11<x22)) &&
       ((y11<=y21 && y21<y12)||(y21<=y11 && y11<y22)));
    }
}
