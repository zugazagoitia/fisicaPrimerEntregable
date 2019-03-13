
public class Electron {

    private double angulo;
    private double velocidad;

    private double velocidadOrigenX;
    private double velodidadEnX;

    private double velocidadOrigenY;
    private double velocidadEnY;

    public Electron(double angulo, double velocidad){
        this.angulo = angulo;
        this.velocidad = velocidad;

        this.velocidadOrigenX = Math.cos(Math.toRadians(angulo))* velocidad;
        this.velocidadOrigenY = Math.sin(Math.toRadians(angulo))* velocidad;

        this.velodidadEnX = velocidadOrigenX;
    }

    public double getAngulo() {
        return angulo;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public double getVelocidadOrigenX() {
        return velocidadOrigenX;
    }

    public double getVelocidadOrigenY() {
        return velocidadOrigenY;
    }

    private double getVelodidadEnX() {
        return velodidadEnX;
    }


}
