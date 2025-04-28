package Model;

public class MembresiaCamion extends Membresia {

    public MembresiaCamion(int duracionMeses) {
        super(60000, duracionMeses); // se pone el precio que queremos para camion
    }

    @Override
    public double calcularCosto() {
        return tarifaBase * duracionMeses;
    }
}
