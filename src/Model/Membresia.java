package Model;

public abstract class Membresia {
    protected double tarifaBase; // Tarifa base mensual
    protected int duracionMeses; // 1, 3 o 12 meses

    // se inicializa
    public Membresia(double tarifaBase, int duracionMeses) {
        this.tarifaBase = tarifaBase;
        this.duracionMeses = duracionMeses;
    }

    //  calcular el costo de la membresía (usa polimorfismo)
    public abstract double calcularCosto();

    // Getters y Setters
    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    public int getDuracionMeses() {
        return duracionMeses;
    }

    public void setDuracionMeses(int duracionMeses) {
        this.duracionMeses = duracionMeses;
    }
}
