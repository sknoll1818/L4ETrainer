import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class L4ETrainer extends JFrame {
	 JCheckBox p = new JCheckBox("Parity");
	String s;
	String[] slice = new String[] {
			"u", "e", "d", "u'", "e'", "d'", "E", "E'"
	};
	
	String[] flips = new String[] {
			"R U2 R' F U' F' ", " R L' U R' L U F' U' F2 U2 F' ", "R L U R' L' U F B U' F' B' "
	};
			
    public L4ETrainer() {

        initUI();
    }
    private void createComm() {
    	
    	for(int i = 0; i<=2; i++) {
    Random rand = new Random();
    	int sliceR = rand.nextInt((6) + 1) + 0;
    	int flipR = rand.nextInt(1+1) + 0;
    	s+= slice[sliceR] + flips[flipR] + slice[sliceR]+"' y ";
}
    	if (p.isSelected()) {
    s+= " z Rw U2 x Rw U2 Rw U2' Rw' U2 Lw U2 3Rw' U2' Rw U2 Rw' U2' Rw' R z' ";
   }
    	JLabel gen = new JLabel(s);
    	JLabel gen2 = new JLabel(s);
    	System.out.println(s);
    	createLayout(gen);
    	createLayout(gen2);
    	gen2.setLocation(270, 200);
    }
    private void initUI() {
    	
    	s = "";
        JButton submit = new JButton("Submit");

        submit.addActionListener((ActionEvent event) -> {
            createComm();
        });
        
       createLayout(submit);
       submit.setBounds(0, 300, 100, 60);
       
       final JRadioButton b5 = new JRadioButton("5x5");
       final JRadioButton b6 = new JRadioButton("6x6");
       final JRadioButton b7 = new JRadioButton("7x7");

       b5.setMnemonic(KeyEvent.VK_C);
       b6.setMnemonic(KeyEvent.VK_M);
       b7.setMnemonic(KeyEvent.VK_P);
       
       createLayout(b5);
       createLayout(b6);
       createLayout(b7);
       
       
       // x,y,width, height
       b5.setBounds(50, 50, 100, 100);
       b6.setBounds(50, 100, 100, 100);
       b7.setBounds(50, 150, 100, 100);
       
    
        p.setMnemonic(KeyEvent.VK_C); 
        p.setSelected(false);
        createLayout(p);
        setTitle("L4E Trainer");
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        
        
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );
        
    }
   
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            L4ETrainer ex = new L4ETrainer();
            ex.setVisible(true);
        });
    }
}
       