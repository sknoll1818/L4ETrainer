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
  static L4ETrainer ex = new L4ETrainer();
  JLabel title = new JLabel("L4E Trainer. Remeber to realign all slice moves after the scramble");
  JButton ref = new JButton("Refresh");
  final JRadioButton b5 = new JRadioButton("5x5");
  final JRadioButton b6 = new JRadioButton("6x6");
  final JRadioButton b7 = new JRadioButton("7x7");

  JLabel space = new JLabel(" ");
  JCheckBox p = new JCheckBox("Parity");
  String s;

  public L4ETrainer() {
    initUI();
  }

  private void initUI() {
    createLayout(title);
    title.setBounds(200, 200, 1000, 30);
    s = "                      Alg:  ";
    createLayout(space);
    space.setBounds(0, 0, 0, 0);
    JButton submit = new JButton("Submit");

    submit.addActionListener((ActionEvent event) -> {
      String alg = "";
      if (b5.isSelected()) alg = AlgGenerator.createAlg5(p.isSelected());
      else if (b6.isSelected()) alg = AlgGenerator.createAlg6(p.isSelected());
      else if (b7.isSelected()) alg = AlgGenerator.createAlg7(p.isSelected());
      createLayout(new JLabel(alg));
    });

    ref.addActionListener((ActionEvent event) -> {
      L4ETrainer ex1 = new L4ETrainer();
      ex1.setVisible(true);
      ex.setVisible(false);
    });
    createLayout(ref);
    ref.setBounds(0, 400, 100, 60);
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

    gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(arg[0]));

    gl.setVerticalGroup(gl.createSequentialGroup().addComponent(arg[0]));
  }

  public static void main(String[] args) {

    EventQueue.invokeLater(() -> {
      ex.setVisible(true);
    });
  }
}
