/***
 *** The Discount Tickets
 ***/

import java.awt.*;
import javax.swing.*;

// TheDiscountTicketsクラス
public class TheDiscountTickets extends JFrame {
    
    public TheDiscountTickets() {
        super("The Discount tickets");
        System.out.println("The Discount tickets");
        addNotify();
        Insets insets = getInsets();
        int width = 900 + insets.left + insets.right;
        int height = 600 + insets.top + insets.bottom;
        setSize(width, height);
        setLocation (0, 0);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        
        BackPanel bp = new BackPanel();
        bp.setBounds (0, 0, 600, 900);
        bp.setLayout(null);

        MazePanel mp = new MazePanel();
        mp.setBounds(0, 0, 600, 600);

        TicketsPanel tp = new TicketsPanel();
        tp.setBounds(600, 0, 300, 600);

        bp.add(mp);
        bp.add(tp);
        add(bp);

        GameManager gm = new GameManager (mp, tp, bp);
        mp.setGM (gm);
        tp.setGM(gm);
        bp.setGM(gm);
        
        gm.start();
    }
    
    //メイン
    public static void main(String[] args) {
        (new TheDiscountTickets()).setVisible(true);
    }
}