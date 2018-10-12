import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
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
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

public class L4ETrainer extends JFrame {
    static L4ETrainer ex = new L4ETrainer();
    JLabel title = new JLabel("L4E Trainer. Remember to realign all slice moves after the scramble");

    final JRadioButton b5 = new JRadioButton("5x5");
    final JRadioButton b6 = new JRadioButton("6x6");
    final JRadioButton b7 = new JRadioButton("7x7");
    JTextArea algDisplay = new JTextArea("Alg:", 5, 30);

    JButton submit = new JButton("Submit");

    JLabel space = new JLabel(" ");
    JCheckBox p = new JCheckBox("Parity");

    GridBagLayout layout = new GridBagLayout();
    JPanel panel = new JPanel();

    public L4ETrainer() {
        initUI();
    }

    private void initUI() {
        GridBagConstraints c;
        panel.setLayout(layout);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 5;
        c.weightx = 1;
        panel.add(title, c);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.2;
        panel.add(p, c);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 0.2;
        panel.add(b5, c);
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 1;
        c.weightx = 0.2;
        panel.add(b6, c);
        c = new GridBagConstraints();
        c.gridx = 3;
        c.gridy = 1;
        c.weightx = 0.2;
        panel.add(b7, c);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 4;
        panel.add(algDisplay, c);
        c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 1;
        c.gridheight = 2;
        c.weightx = 0.2;
        c.fill = GridBagConstraints.BOTH;
        panel.add(submit, c);

        submit.addActionListener((ActionEvent event) -> {
            String alg = "Alg: ";
            if (b5.isSelected())
                alg += AlgGenerator.createAlg5(p.isSelected());
            else if (b6.isSelected())
                alg += AlgGenerator.createAlg6(p.isSelected());
            else if (b7.isSelected())
                alg += AlgGenerator.createAlg7(p.isSelected());
            algDisplay.setText(alg);
            this.repaint();
        });


        b5.setMnemonic(KeyEvent.VK_5);
        b6.setMnemonic(KeyEvent.VK_6);
        b7.setMnemonic(KeyEvent.VK_7);

        ButtonGroup bg = new ButtonGroup();

        bg.add(b5);
        bg.add(b6);
        bg.add(b7);

        algDisplay.setEditable(false);
        algDisplay.setLineWrap(true);

        p.setMnemonic(KeyEvent.VK_C);
        p.setSelected(false);

        setContentPane(panel);
        setTitle("L4E Trainer");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            ex.setVisible(true);
        });
    }
}
