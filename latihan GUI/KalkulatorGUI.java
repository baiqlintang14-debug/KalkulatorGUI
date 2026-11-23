import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KalkulatorGUI extends JFrame implements ActionListener {

    JTextField layar = new JTextField("0");
    double angka1 = 0;
    String operator = "";
    boolean mulaiBaru = true;

    public KalkulatorGUI() {
        setTitle("Kalkulator");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        layar.setEditable(false);
        layar.setHorizontalAlignment(JTextField.RIGHT);
        layar.setFont(new Font("Arial", Font.BOLD, 28));
        layar.setPreferredSize(new Dimension(280, 60));

        JPanel panelTombol = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] isi = {"7", "8", "9", "/", "4", "5", "6", "*",
                        "1", "2", "3", "-", "0", ".", "=", "+"};
        for (String teks : isi) {
            JButton tombol = new JButton(teks);
            tombol.addActionListener(this);
            panelTombol.add(tombol);
        }

        JPanel panelBawah = new JPanel(new FlowLayout());
        JButton clear = new JButton("C");
        clear.setPreferredSize(new Dimension(280, 40));
        clear.addActionListener(this);
        panelBawah.add(clear);

        add(layar, BorderLayout.NORTH);
        add(panelTombol, BorderLayout.CENTER);
        add(panelBawah, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String p = e.getActionCommand();
        if (p.matches("[0-9.]")) {
            if (mulaiBaru) layar.setText(p.equals(".") ? "0." : p);
            else if (!(p.equals(".") && layar.getText().contains(".")))
                layar.setText(layar.getText() + p);
            mulaiBaru = false;
        } else if (p.equals("C")) {
            angka1 = 0;
            operator = "";
            mulaiBaru = true;
            layar.setText("0");
        } else {
            if (!operator.equals("") && !mulaiBaru) hitung();
            angka1 = Double.parseDouble(layar.getText());
            operator = p.equals("=") ? "" : p;
            mulaiBaru = true;
        }
    }

    void hitung() {
        double angka2 = Double.parseDouble(layar.getText());
        double hasil;
        if (operator.equals("+")) hasil = angka1 + angka2;
        else if (operator.equals("-")) hasil = angka1 - angka2;
        else if (operator.equals("*")) hasil = angka1 * angka2;
        else hasil = angka1 / angka2;
        layar.setText(hasil == (long) hasil ? "" + (long) hasil : "" + hasil);
    }

    public static void main(String[] args) {
        new KalkulatorGUI().setVisible(true);
    }
}
