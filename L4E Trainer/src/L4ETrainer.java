import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class L4ETrainer extends JFrame {
	JLabel title = new JLabel("L4E Trainer");
	 final JRadioButton b5 = new JRadioButton("5x5");
     final JRadioButton b6 = new JRadioButton("6x6");
     final JRadioButton b7 = new JRadioButton("7x7");
     
     
	JLabel space = new JLabel(" ");
	 JCheckBox p = new JCheckBox("Parity");
	String s;
	
	
	String[] slice5 = new String[] {
			"u", "e", "d","E",
			"u'", "e'", "d'", "E'"
	};
	
	String[] slice7 = new String[] {
			"u", "e", "d","E","2u", "2d","3e", 
			"u'", "e'", "d'","E'","2u'", "2d'","3e'"
	};
	
	String[] slice6 = new String[] {
			"u", "e", "d","E","2u", "2d",
			"u'", "e'", "d'","E'","2u'", "2d'"
	};
	
	String[] flips = new String[] {
			" R U2 R' F U' F' ", " R L' U R' L U F' U' F2 U2 F' ", " R L U R' L' U F B U' F' B' "
	};
			
    public L4ETrainer() {

        initUI();
    }
    private void createComm() {
    	
    
    	if(b5.isSelected()) {
    	for(int i = 0; i<=2; i++) {
    Random rand = new Random();
    	int sliceR = rand.nextInt((6) + 1) + 0;
    	int flipR = rand.nextInt(1+1) + 0;
    	if(sliceR >=4 ) {
    	s+= slice5[sliceR] + flips[flipR] + slice5[sliceR-4]+" y ";
    	}
    	else 
    		s+= slice5[sliceR] + flips[flipR] + slice5[sliceR]+"' y ";
}
    	if (p.isSelected()) {
    s+= " z Rw U2 x Rw U2 Rw U2' Rw' U2 Lw U2 3Rw' U2' Rw U2 Rw' U2' Rw' R z' ";
   }
    	
    	JLabel gen = new JLabel(s);
    	createLayout(gen);
    	s="                      Alg:  ";
    	
    }
    	else if(b7.isSelected()) {
    		for(int i = 0; i<=4; i++) {
    		 Random rand = new Random();
    	    	int sliceR = rand.nextInt((13) + 1) + 0;
    	    	int flipR = rand.nextInt(2+1) + 0;
    	    	if(sliceR >=6) {
    	    	s+= slice7[sliceR] + flips[flipR] + slice7[sliceR-7]+" y ";
    	    	}
    	    	else 
    	    		s+= slice7[sliceR] + flips[flipR] + slice7[sliceR]+"' y ";
    		}
    	    	if (p.isSelected()) {
    	    s+= " z Rw U2 x Rw U2 Rw U2' Rw' U2 Lw U2 3Rw' U2' Rw U2 Rw' U2' Rw' R z' ";
    	   }
    	    	
    	    	JLabel gen = new JLabel(s);
    	    	createLayout(gen);
    	    	s="                      Alg:  ";
    			
    	}
    	else if(b6.isSelected()) {
    		for(int i = 0; i<=4; i++) {
   		 Random rand = new Random();
   	    	int sliceR = rand.nextInt((11) + 1) + 0;
   	    	int flipR = rand.nextInt(1+1) + 0;
   	    	if(sliceR >=5 ) {
   	    	s+= slice6[sliceR] + flips[flipR] + slice6[sliceR-6]+" y ";
   	    	}
   	    	else 
   	    		s+= slice6[sliceR] + flips[flipR] + slice6[sliceR]+"' y ";
    		}
   	    	if (p.isSelected()) {
   	    s+= " z Rw U2 x Rw U2 Rw U2' Rw' U2 Lw U2 3Rw' U2' Rw U2 Rw' U2' Rw' R z' ";
   	   }
   	    	
   	    	JLabel gen = new JLabel(s);
   	    	createLayout(gen);
   	    	s="                      Alg:  ";
   	    	
   	    	
   	
    	}
    }
    
    
    private void initUI() {
    	createLayout(title);
    	s = "                      Alg:  ";
    	createLayout(space);
        JButton submit = new JButton("Submit");

        submit.addActionListener((ActionEvent event) -> {
            createComm();
        });
        
       createLayout(submit);
       submit.setBounds(0, 300, 100, 60);
       
      

       b5.setMnemonic(KeyEvent.VK_5);
       b6.setMnemonic(KeyEvent.VK_6);
       b7.setMnemonic(KeyEvent.VK_7);
       
       ButtonGroup bg = new ButtonGroup();
       
       bg.add(b5);
       bg.add(b6);
       bg.add(b7);
      
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
       