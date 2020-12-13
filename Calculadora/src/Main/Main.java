package Main;
import Calculadora.Calculadora;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame aplicacion = new JFrame();
        // Configuracion de la ventana por defecto
        aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aplicacion.setTitle("Dozom Calculator");
        aplicacion.setResizable(true);
        // Main Panel Configuration
        aplicacion.setLayout(new GridBagLayout());
        aplicacion.setSize(250,300);

        GridBagConstraints gbc = new GridBagConstraints();

        Calculadora c = new Calculadora();

        gbc.gridx=0;
        gbc.gridy=0;
        aplicacion.getContentPane().add(c.getPanelTitulo(), gbc);

        gbc.gridx=0;
        gbc.gridy=1;

        aplicacion.getContentPane().add(c.getPanelInput(), gbc);

        gbc.gridx=0;
        gbc.gridy=2;

        aplicacion.getContentPane().add(c.getPanelNumeros(), gbc);
        aplicacion.getContentPane().setBackground(Color.decode("#7ba858"));
        aplicacion.setVisible(true);

    }
}
