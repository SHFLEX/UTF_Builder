import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

class Main extends JFrame implements ActionListener {
   private static boolean mState = true;
   private List<String> wheels = Arrays.asList("STARTER", "STANDARD", "LIGHT", "SUPERLIGHT");
   private List<String> chassis = Arrays.asList("DIRTBIKE", "MOTOCROSS", "ENDURO", "TRIAL");
   private List<String> engines = Arrays.asList("50", "70", "100", "150");
   Clip hiphop;
   JLabel lab;
   JButton buildR;
   JButton buildC;
   JButton playMusic;
   Font rbFont = new Font("Quicksand", 1, 20);
   Font lbFont = new Font("Quicksand", 1, 20);
   ButtonGroup bg1 = new ButtonGroup();
   ButtonGroup bg2 = new ButtonGroup();
   ButtonGroup bg3 = new ButtonGroup();

   Main() {
      JLabel lb = new JLabel("WHEELS");
      lb.setForeground(Color.WHITE);
      lb.setFont(this.lbFont);
      lb.setHorizontalAlignment(0);
      lb.setVerticalAlignment(1);
      JLabel lb2 = new JLabel("CHASSIS");
      lb2.setForeground(Color.WHITE);
      lb2.setFont(this.lbFont);
      lb2.setHorizontalAlignment(0);
      lb2.setVerticalAlignment(1);
      JLabel lb3 = new JLabel("ENGINES");
      lb3.setForeground(Color.WHITE);
      lb3.setFont(this.lbFont);
      lb3.setHorizontalAlignment(0);
      lb3.setVerticalAlignment(1);
      JRadioButton rb = new JRadioButton("STARTER");
      rb.setFont(this.rbFont);
      JRadioButton rb2 = new JRadioButton("STANDARD");
      rb2.setFont(this.rbFont);
      JRadioButton rb3 = new JRadioButton("LIGHT");
      rb3.setFont(this.rbFont);
      JRadioButton rb4 = new JRadioButton("SUPERLIGHT");
      rb4.setFont(this.rbFont);
      JRadioButton rb5 = new JRadioButton("DIRTBIKE");
      rb5.setFont(this.rbFont);
      JRadioButton rb6 = new JRadioButton("MOTOCROSS");
      rb6.setFont(this.rbFont);
      JRadioButton rb7 = new JRadioButton("ENDURO");
      rb7.setFont(this.rbFont);
      JRadioButton rb8 = new JRadioButton("TRIAL");
      rb8.setFont(this.rbFont);
      JRadioButton rb9 = new JRadioButton("50");
      rb9.setFont(this.rbFont);
      JRadioButton rb10 = new JRadioButton("70");
      rb10.setFont(this.rbFont);
      JRadioButton rb11 = new JRadioButton("100");
      rb11.setFont(this.rbFont);
      JRadioButton rb12 = new JRadioButton("150");
      rb12.setFont(this.rbFont);
      this.bg1.add(rb);
      this.bg1.add(rb2);
      this.bg1.add(rb3);
      this.bg1.add(rb4);
      this.bg2.add(rb5);
      this.bg2.add(rb6);
      this.bg2.add(rb7);
      this.bg2.add(rb8);
      this.bg3.add(rb9);
      this.bg3.add(rb10);
      this.bg3.add(rb11);
      this.bg3.add(rb12);
      this.buildR = new JButton("BUILD BIKE RANDOMLY");
      this.buildR.addActionListener(this);
      this.buildR.setFont(new Font("Algerian", 1, 20));
      this.buildC = new JButton("BUILD CUSTOM BIKE");
      this.buildC.addActionListener(this);
      this.buildC.setFont(new Font("Algerian", 1, 20));
      this.playMusic = new JButton("PLAY/STOP MUSIC");
      this.playMusic.addActionListener(this);
      this.playMusic.setFont(new Font("Algerian", 1, 20));
      this.lab = new JLabel("BUILD YOUR OWN BIKE FROM Urban Trial Freestyle game!");
      this.lab.setForeground(Color.WHITE);
      this.lab.setFont(new Font("Algerian", 0, 26));
      this.lab.setHorizontalAlignment(0);
      this.lab.setVerticalAlignment(1);
      ImageIcon logo = new ImageIcon("utflogo.png");
      this.setVisible(true);
      this.setDefaultCloseOperation(3);
      this.setResizable(true);
      this.setTitle("UTF BIKE BUILDER");
      this.setIconImage(logo.getImage());
      this.setLayout(new GridLayout(0, 1));
      this.setSize(800, 550);
      this.getContentPane().setBackground(Color.BLACK);
      this.add(this.lab);
      this.add(lb);
      this.add(rb);
      this.add(rb2);
      this.add(rb3);
      this.add(rb4);
      this.add(lb2);
      this.add(rb5);
      this.add(rb6);
      this.add(rb7);
      this.add(rb8);
      this.add(lb3);
      this.add(rb9);
      this.add(rb10);
      this.add(rb11);
      this.add(rb12);
      this.add(this.buildR);
      this.add(this.buildC);
      this.add(this.playMusic);
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == this.buildR) {
         String c = "";

         for(int i = 0; i < 3; ++i) {
            c = c + (int)(Math.random() * 4.0D) + "";
         }

         System.out.println(c);
         JOptionPane.showMessageDialog((Component)null, "", "YOUR BIKE", 1, new ImageIcon(c + ".png"));
      } else if (e.getSource() == this.buildC) {
         JOptionPane.showMessageDialog((Component)null, "", "YOUR BIKE", 1, new ImageIcon(this.wheels.indexOf(getButtonText(this.bg1)) + "" + this.chassis.indexOf(getButtonText(this.bg2)) + "" + this.engines.indexOf(getButtonText(this.bg3)) + ".png"));
      } else if (e.getSource() == this.playMusic) {
         try {
            if (this.hiphop == null) {
               AudioInputStream ais = AudioSystem.getAudioInputStream(new File("hiphop.wav"));
               this.hiphop = AudioSystem.getClip();
               this.hiphop.open(ais);
            }

            if (mState && !this.hiphop.isRunning()) {
               this.hiphop.start();
               mState = false;
            } else {
               this.hiphop.stop();
               mState = true;
            }
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }

   }

   public static String getButtonText(ButtonGroup bg) {
      Enumeration buttons = bg.getElements();

      AbstractButton btn;
      do {
         if (!buttons.hasMoreElements()) {
            return "choose the element";
         }

         btn = (AbstractButton)buttons.nextElement();
      } while(!btn.isSelected());

      return btn.getText();
   }

   public static void main(String[] args) {
      new Main();
   }
}
