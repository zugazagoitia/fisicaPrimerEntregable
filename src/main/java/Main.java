

import javax.swing.JOptionPane;

public class Main {

    private static String temp = "";

    public static void main(String[] args) {
        temp = JOptionPane.showInputDialog(null, "Velocidad", "Datos", JOptionPane.QUESTION_MESSAGE);
        double velocidad = Double.parseDouble(temp);
        temp = JOptionPane.showInputDialog(null, "Angulo", "Datos", JOptionPane.QUESTION_MESSAGE);
        double angulo = Double.parseDouble(temp);
        Calculos calculos = new Calculos();
        calculos.Operaciones(angulo, velocidad);
    }
}
