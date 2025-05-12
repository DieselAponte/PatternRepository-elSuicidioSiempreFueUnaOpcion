package Controlador;

import Modelo.*;

public class CrearCuentaControlador {
    private ServicioBancario servicio;

    public CrearCuentaControlador(ServicioBancario servicio) {
        this.servicio = servicio;
    }

    public void crearCuenta(String tipo, double saldoInicial, String dniTitular, String nombreTitular) {
        // Validar campos obligatorios
        if (dniTitular == null || dniTitular.trim().isEmpty() ||
                nombreTitular == null || nombreTitular.trim().isEmpty()) {
            throw new IllegalArgumentException("DNI y Nombre son obligatorios");
        }

        Cuenta cuenta = switch (tipo) {
            case "Ahorro" -> new CuentaAhorro(
                    servicio.getCuentas().size() + 1,
                    saldoInicial,
                    dniTitular,
                    nombreTitular);
            case "Corriente" -> new CuentaCorriente(
                    servicio.getCuentas().size() + 1,
                    saldoInicial,
                    1000, // límite
                    dniTitular,
                    nombreTitular);
            default -> throw new IllegalArgumentException("Tipo no válido");
        };
        servicio.agregarCuenta(cuenta);
    }
}
