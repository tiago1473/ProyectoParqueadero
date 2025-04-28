package Model;

public class MembresiaMoto extends Membresia {

    public MembresiaMoto(int duracionMeses) {
        super(20000, duracionMeses); // aca ponemos la tarifa mensual de la moto
    }

    @Override
    public double calcularCosto() {
        return tarifaBase * duracionMeses;
    }
}
