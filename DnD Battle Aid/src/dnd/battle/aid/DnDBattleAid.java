package dnd.battle.aid;



import javax.swing.JFrame;


/**
 *
 * @author Trinity Bass
 */
public class DnDBattleAid extends JFrame{
    // TODO code application logic here
    // 2 Attack rolls: BAB, ST/DX (radio), Feats(single radio), other mod 1, other mod 2
    // 2 DMG rolls: " (+ 2 dice fields, 2 modifier fields)
    public static void main(String[] args) throws Exception {
        
        JFrame frame = new JFrame("Roll Initiative!");
        PrintToFile file = new PrintToFile("characterNameAttackStats");
        
    	//DnDBattleAid app = new DnDBattleAid();
        BattleAid app = new BattleAid();
        frame.add(app.panel);
        //frame.add(app);
        frame.setSize(280, 400);
        //app.add(frame);
    	
    	frame.setLocationRelativeTo(null);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
        //frame.add();
        file.close();
       // frame.pack();
        //frame.validate();
    }

}
//JFrame frame = new JFrame("Roll 'em up!");
//    	rollWindowV1 win1 = new rollWindowV1();
//        frame.add(win1);
//        frame.setSize(800, 600);
//
//    	win1.setLocationRelativeTo(null);
//    	win1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    	win1.setVisible(true);
//        win1.pack();