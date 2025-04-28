package Model;

public class MembresiaCarro extends Membresia {

    public MembresiaCarro(int duracionMeses) {
        super(40000, duracionMeses); // aca se pone lo que queremos cueste la mensualidad del carro aca 40000
    }

    @Override
    public double calcularCosto() {
        return tarifaBase * duracionMeses;
    }
}
