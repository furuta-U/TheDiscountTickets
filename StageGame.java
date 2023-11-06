/***
 *** ゲームステージ
 ***/
import java.awt.*;
import java.awt.event.*;

public class StageGame extends Stage {

  // 生成
  public StageGame(GameManager gm){
    super(gm);
    stageN = 2;
  }
  
  // 進行
  public boolean proceed(long t){
    if(lap==0){
        gm.msgs.clear();
      gm.addMessage(new MsgBrink("3",200,Color.cyan,100));
    }
    if(lap==1){
        gm.msgs.clear();
      gm.addMessage(new MsgBrink("2",200,Color.cyan,100));
    }
    if(lap==2){
        gm.msgs.clear();
      gm.addMessage(new MsgBrink("1",200,Color.cyan,100));
    }
    if(lap==3){
        gm.msgs.clear();
      gm.addMessage(new MsgBrink("Start!!",200,Color.cyan,100));
    }
    if(lap == 4){
        gm.msgs.clear();
        gm.addMessage(new MsgBrink("",200,Color.cyan,100));
    }
    lap++;
    return checkTime(gm.day, gm.hour, gm.minute) && gm.money > 0;
  }

  // 次のステージ
  public Stage next(){
    return new StageStart(gm);
  }

  // 制限時間の確認
  private boolean checkTime(int day, int hour, int minute){
    return !(day >=4 && hour >= 6 && minute >= 0);
  }

  // キーリスナー
  public void keyPressed(KeyEvent ev){}
  public void keyReleased(KeyEvent ev){}
  public void keyTyped(KeyEvent ev){}

}
