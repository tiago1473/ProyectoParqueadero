package controller;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private List<String> vehiculos; // Se guardarán las placas de los vehículos del cliente

    // se inicializa
    
    public Cliente(String identificacion, String nombre, String telefono, String correo) {
        super(identificacion, nombre, telefono, correo);
        this.vehiculos = new ArrayList<>();
    }

    //  para gestionar vehiculos de un cliente
    public void agregarVehiculo(String placa) {
        vehiculos.add(placa);
    }

    public void eliminarVehiculo(String placa) {
        vehiculos.remove(placa);
    }

    public List<String> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<String> vehiculos) {
        this.vehiculos = vehiculos;
    }

    // para mostrar los vehiculos de un cliente
    
    public String listarVehiculos() {
        if (vehiculos.isEmpty()) {
            return "El cliente no tiene vehículos registrados.";
        }
        StringBuilder sb = new StringBuilder("Vehículos del cliente:\n");
        for (String placa : vehiculos) {
            sb.append("- ").append(placa).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Cliente{" +
               "Identificación='" + getIdentificacion() + '\'' +
               ", Nombre='" + getNombre() + '\'' +
               ", Teléfono='" + getTelefono() + '\'' +
               ", Correo='" + getCorreo() + '\'' +
               ", Vehículos=" + vehiculos +
               '}';
    }
}
