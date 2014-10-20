/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd.battle.aid;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Trinity Bass
 */
public class BattleAid implements ActionListener{
    JLabel d20, d20out, playerSt, playerDx, weaponModifier, description1, description2;
    JLabel babLabel, attack1Out1, attack1Out2, attack1Out3, attack2Out1, attack2Out2, attack2Out3;
    JTextField stLabel, dxLabel, atk1mod1, atk1mod2, atk2mod1, atk2mod2, babInput1, babInput2, babInput3, weaponEnchantment, attackFeat, damageFeat, critical;
    JTextField numberOfDice, diceType, diceModifier, wildOut;
    JLabel space1, space2, space3, space4, attackFeatModifier, damageFeatModifier, critRange, numberOfDie, dLabel, plusLabel;
    JButton rollD20, rollWild, attack1Button, attack2Button;
    JPanel panel, weaponInfoPanel,playerInfoPanel,d20Panel, attackPanel, miscRollPanel;
    JPanel stHolder, dxHolder, babHolder;
    int windowWidth = 300;
     
    //add misc die roller under d20
    //add damage roller(s) under attack rollers
      //start with basic rollers with drop down menus
    
    BattleAid(){
        panel = new JPanel(new GridLayout(0, 1));
        
        //D20
        d20Panel = new JPanel(new FlowLayout());
        //d20Panel.setSize(windowWidth, 30);//width - height
        rollD20 = new JButton("roll D20");
        //rollD20.setSize(40, 30);
        d20 = new JLabel("1 D20");
        d20out = new JLabel("0");
        space2 = new JLabel("2");//add 'variable die rolling
        //rollWild = new JButton("roll");
        
  
        d20Panel.add(rollD20);
        d20Panel.add(d20);
        d20Panel.add(d20out);
        d20Panel.add(space2);
        rollD20.addActionListener((ActionListener) this);
        
        miscRollPanel = new JPanel(new FlowLayout());
        
        rollWild = new JButton("roll wild");
        rollWild.addActionListener((ActionListener) this);
        numberOfDie = new JLabel("# dice");
        numberOfDice = new JTextField("0");
        numberOfDice.setColumns(2);
        dLabel = new JLabel("D");
        diceType = new JTextField("6");
        diceType.setColumns(2);
        plusLabel = new JLabel("+");
        diceModifier = new JTextField("0");
        diceModifier.setColumns(2);
        wildOut = new JTextField("total");
        wildOut.setColumns(2);
        
        miscRollPanel.add(rollWild);
        miscRollPanel.add(numberOfDie);
        miscRollPanel.add(numberOfDice);
        miscRollPanel.add(dLabel);
        miscRollPanel.add(diceType);
        miscRollPanel.add(plusLabel);
        miscRollPanel.add(diceModifier);
        miscRollPanel.add(wildOut);
        
        d20Panel.add(miscRollPanel);
        
        //player info
        playerInfoPanel = new JPanel(new GridLayout(2, 2));
        stHolder = new JPanel(new FlowLayout());//GridLayout(1, 2)
        dxHolder = new JPanel(new FlowLayout());
 
        playerSt = new JLabel("ST:");
        stLabel = new JTextField(5);
        stLabel.setText("0");
        playerDx = new JLabel("DX:");
        dxLabel = new JTextField(5);
        dxLabel.setText("0");
        description1 = new JLabel("St = melee");
        description2 = new JLabel("Dx = range");
        
        stHolder.add(playerSt);
        stHolder.add(stLabel);
        dxHolder.add(playerDx);
        dxHolder.add(dxLabel);
        
        playerInfoPanel.add(description1);
        playerInfoPanel.add(description2);
        playerInfoPanel.add(stHolder);
        playerInfoPanel.add(dxHolder);
        playerInfoPanel.setSize(windowWidth, 30);
        
        babHolder = new JPanel(new FlowLayout());//GridLayout(0, 4)        
        babLabel = new JLabel("BAB");
        babInput1 = new JTextField("0");
        babInput1.setColumns(3);
        babInput2 = new JTextField("0");
        babInput2.setColumns(3);
        babInput3 = new JTextField("0");
        babInput3.setColumns(3);
       //space1 = new JLabel("");

        babHolder.add(babLabel);        
        babHolder.add(babInput1); 
        babHolder.add(babInput2);
        babHolder.add(babInput3); 
        //babHolder.add(space1); 

        babHolder.setSize(windowWidth, 30);
        
        weaponInfoPanel = new JPanel(new GridLayout(0, 2));
        weaponModifier = new JLabel("Weapon bonus");
        //this one affects attk AND dmg 
        weaponEnchantment = new JTextField("Enchantment bonus");
        attackFeatModifier = new JLabel("Feat atk mod");
        attackFeat = new JTextField("+atk");
        damageFeatModifier = new JLabel("Feat dmg mod");
        damageFeat = new JTextField("+Dmg");
        critRange = new JLabel("Lowest Crit #");
        critical = new JTextField("20");
       
        weaponInfoPanel.add(weaponModifier);
        weaponInfoPanel.add(weaponEnchantment);
        weaponInfoPanel.add(attackFeatModifier);
        weaponInfoPanel.add(attackFeat);
        weaponInfoPanel.add(damageFeatModifier);
        weaponInfoPanel.add(damageFeat);
        weaponInfoPanel.add(critRange);
        weaponInfoPanel.add(critical);

        //attack rolls
        attackPanel = new JPanel();        
        attack1Button = new JButton("Melee");
        attack1Button.addActionListener((ActionListener)this);
        atk1mod1 = new JTextField("0", 5);
        atk1mod2 = new JTextField("0", 5);
        attack1Out1 = new JLabel("0");
        attack1Out2 = new JLabel("0");
        attack1Out3 = new JLabel("0");
        
        attackPanel.add(attack1Button);
        attackPanel.add(atk1mod1); 
        attackPanel.add(atk1mod2);
        attackPanel.add(attack1Out1);
        attackPanel.add(attack1Out2);
        attackPanel.add(attack1Out3);
        
        attack2Button = new JButton("Range");
        attack2Button.addActionListener((ActionListener)this);
        atk2mod1 = new JTextField("0", 5);
        atk2mod2 = new JTextField("0", 5);
        attack2Out1 = new JLabel("0");
        attack2Out2 = new JLabel("0");
        attack2Out3 = new JLabel("0");
        //at least one attack
        attackPanel.add(attack2Button);
        attackPanel.add(atk2mod1); 
        attackPanel.add(atk2mod2);
        attackPanel.add(attack2Out1);
        attackPanel.add(attack2Out2);
        attackPanel.add(attack2Out3);
        
        panel.add(d20Panel);
        panel.add(playerInfoPanel);
        panel.add(babHolder);
        panel.add(weaponInfoPanel);
        panel.add(attackPanel);
        panel.setSize(windowWidth, 225);
        panel.setVisible(true);
        
        //panel.validate();
        //add(panel);
        
        
}
    int roll(int r){//rolls d amount of dice for each attribute
            
            int roll = new Random().nextInt(r) + 1;
            return roll;
    }
    public String toString(int i){
		return(i + "");
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rollD20){
            d20out.setText(toString(roll(20)));
            
        }
        else if (e.getSource() == attack1Button){
            int mod1;
            int mod2;
            int bab1 = Integer.parseInt(babInput1.getText());
            int bab2 = Integer.parseInt(babInput2.getText());
            int bab3 = Integer.parseInt(babInput3.getText());
            int d20Result;
            
            int attributeModifier = Integer.parseInt(stLabel.getText());
            if (atk1mod1.getText()!= null){
                mod1 = Integer.parseInt(atk1mod1.getText());
            }
            else
                mod1 = 0;
            if (atk1mod2.getText() != null){
                mod2 = Integer.parseInt(atk1mod2.getText());
            }
            else
                mod2 = 0;
            
            if (Integer.parseInt(babInput1.getText()) > 0){
                d20Result = roll(20);
                attack1Out1.setForeground(Color.BLACK);
                attack1Out1.setText(String.valueOf(d20Result + (bab1 + mod1 + mod2 + attributeModifier)));
                if (d20Result >= Integer.parseInt(critical.getText()))
                  attack1Out1.setForeground(Color.red);
            }
            if (Integer.parseInt((babInput2.getText())) > 0){
                d20Result = roll(20);
                attack1Out2.setForeground(Color.BLACK);
                attack1Out2.setText(String.valueOf(d20Result + (bab2 + mod1 + mod2 + attributeModifier)));
                if (d20Result >= Integer.parseInt(critical.getText()))
                  attack1Out2.setForeground(Color.red);
            }    
            if (Integer.parseInt((babInput3.getText())) > 0){
                d20Result = roll(20);
                attack1Out3.setForeground(Color.BLACK);
                attack1Out3.setText(String.valueOf(d20Result + (bab3 + mod1 + mod2 + attributeModifier)));
                if (d20Result >= Integer.parseInt(critical.getText()))
                  attack1Out3.setForeground(Color.red);
            }
        }
        else if (e.getSource() == attack2Button){
            //ranged attack, modified by Dx
            //criticals(red) when d20 = 20, but total < 20 ** only Ranged attacks
            //most frequently on 3rd attack, less so on 2nd, 1st seems good.
            //testing indicates that errors are localized to individual attacks.
            int mod1;
            int mod2;
            int bab1 = Integer.parseInt(babInput1.getText());
            int bab2 = Integer.parseInt(babInput2.getText());
            int bab3 = Integer.parseInt(babInput3.getText());
            int d20Result;
            
            int attributeModifier = Integer.parseInt(dxLabel.getText());
            if (atk2mod1.getText()!= null){
                mod1 = Integer.parseInt(atk2mod1.getText());
            }
            else
                mod1 = 0;
            if (atk2mod1.getText() != null){
                mod2 = Integer.parseInt(atk2mod2.getText());
            }
            else
                mod2 = 0; 
            out(babInput1.getText());
            out(babInput2.getText());
            out(babInput3.getText());
            if (Integer.parseInt(babInput1.getText()) > 0){
                d20Result = roll(20);
                attack2Out1.setForeground(Color.BLACK);
                attack2Out1.setText(String.valueOf(d20Result+ (bab1 + mod1 + mod2 + attributeModifier)));
                if (d20Result >= Integer.parseInt(critical.getText()))
                  attack2Out1.setForeground(Color.red);  
            }
                
            if (Integer.parseInt((babInput2.getText())) > 0){
                d20Result = roll(20);
                attack2Out2.setForeground(Color.BLACK);
                attack2Out2.setText(String.valueOf(d20Result + (bab2 + mod1 + mod2 + attributeModifier)));
                if (d20Result >= Integer.parseInt(critical.getText()))
                  attack2Out2.setForeground(Color.red);
                rollsOut();
            }
      
            if ("".equals(babInput3.getText())){
                
            } else {
                d20Result = roll(20);
                attack2Out3.setForeground(Color.BLACK);
                attack2Out3.setText(String.valueOf(d20Result + (bab3 + mod1 + mod2 + attributeModifier)));
                if (d20Result >= Integer.parseInt(critical.getText())){
                  attack2Out3.setForeground(Color.red); 
                }
            }   
        }
        else if (e.getSource() == rollWild ){
            int numDice = Integer.parseInt(numberOfDice.getText());
            int diceSides = Integer.parseInt(diceType.getText());
            int staticModifier = Integer.parseInt(diceModifier.getText());
            int total = 0;
            
            int i = 0;
            while( i <= numDice && numDice > 0){
                total += roll(diceSides);
                i++;
            }
            total += staticModifier;
            wildOut.setText(total + "");
            
        }
    }
    
    private void out (String s){
        System.out.println(s);
    }

    private void rollsOut() {
        
    }
    
}
