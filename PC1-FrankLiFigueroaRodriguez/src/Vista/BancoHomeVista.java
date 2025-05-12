package Vista;

import Modelo.*;
import javax.swing.*;

public class BancoHomeVista extends JFrame {
    private final ServicioBancario servicio;

    public BancoHomeVista() {
        servicio = new ServicioBancario();

        setTitle("Sistema Bancario");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Crear Cuenta", new CrearCuentaVista(servicio));
        tabbedPane.addTab("Transferencias", new TransferenciaVista(servicio));
        tabbedPane.addTab("Movimientos", new MovimientoVista(servicio));

        add(tabbedPane);
        setVisible(true);
    }
}
