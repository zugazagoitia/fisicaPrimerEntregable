import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import javax.swing.JOptionPane;
import java.util.ArrayList;

import static java.lang.Math.*;

public class Calculos {

    double Angulo;
    double Altura;
    double Velocidadi;
    double Distancia;
    double Velocidadx;
    double Velocidady;
    double Velocidadf;
    double Tiempo;

    public static final double CAMPO = 3.5E3;
    public static final double MASA_ELECTRON = 9.11E-31;
    public static final double CARGA_ELECTRON = 1.6E-19;

    public static final double ACELERACION = (CAMPO*CARGA_ELECTRON)/MASA_ELECTRON;

    public void Operaciones(double angulo, double velocidad) {
        Angulo = angulo;
        Velocidadi = velocidad;
        System.out.println(ACELERACION);
        JOptionPane.showMessageDialog(null, "Distancia recorrida : " + Distancia()*100 + " cm"
                + "\nEn un tiempo de : " + Tiempo() + " s"
                + "\n\nA una velocidad de  : " + Velocidad() + " m/s"
                + "\n\nCon una altura maxima de : " + Altura()*100+ " cm"
                + "\nA los: "+tiempoEnAltMax(Altura) + " s"
                + "\nEn la X: "+posX(tiempoEnAltMax(Altura))*100 + " cm");
        ArrayList<Double> xDatos = new ArrayList<Double>();
        ArrayList<Double> yDatos = new ArrayList<Double>();
        for (double i = 0; i <= Distancia*100; i+=Distancia*100/1000) {
            xDatos.add(i);
        }
        for (double d:xDatos) {
            yDatos.add(funcion(d/100)*100);
        }
        XYChart chart = QuickChart.getChart("Trayectoria", "X", "Y", "Posición", xDatos, yDatos);
        new SwingWrapper(chart).displayChart();
    }

    double Distancia() {
        Distancia = ((pow(Velocidadi, 2) * (sin(toRadians(Angulo * 2)))) / ACELERACION);
        return Distancia;
    }

    double Tiempo() {
        Tiempo = ((2 * Velocidadi) * (sin(toRadians(Angulo)))) / ACELERACION;
        return Tiempo;
    }

    double posX(double tiempo){
        return Velocidadx*tiempo;
    }

    double tiempoEnAltMax(double altura){

        return Velocidadi * sin(toRadians(Angulo))/ACELERACION;

    }

    double funcion(double x){
        return x* tan(toRadians(Angulo)) -((ACELERACION* pow(x,2))/(2* pow(Velocidadi,2)* pow(cos(toRadians(Angulo)),2)));
    }

    double Velocidad() {
        Velocidadx = (Velocidadi * cos(toRadians(Angulo)));
        Velocidady = (Velocidadi * sin(toRadians(Angulo)) - ACELERACION * Tiempo);
        Velocidadf = (sqrt(pow(Velocidadx, 2) + pow(Velocidady, 2)));
        return Velocidadf;
    }

    double Altura() {
        Altura = ((pow(Velocidadi, 2) * pow(sin(toRadians(Angulo)), 2)) / (ACELERACION * 2));
        return Altura;
    }
}