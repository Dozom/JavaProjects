package Calculadora;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

public class Calculadora {

    private List<JButton> listaTeclasGui = new ArrayList<>();
    private JPanel panelNumeros;
    private JPanel panelInput = new JPanel();
    private JPanel panelTitulo = new JPanel();
    private JTextField textPantallaInput;

    /* Constructor de la Calculadora */
    public Calculadora(){
        this.addTituloPanel();
        this.addPantallaInput();
        this.addTecladoGui();
    }

    private void addTituloPanel(){
         JLabel labelCalculadora = new JLabel("Introduce la Operación");
         Font myFont = new Font("Serif", Font.BOLD, 18);
         labelCalculadora.setFont(myFont);
         this.panelTitulo.add(labelCalculadora);
         this.panelTitulo.setBackground(Color.green);

    }
    /* GUI */
    private void setTeclas(){
        List<JButton> listaTeclasGui = new ArrayList<>();

        String[] operadores = new String[]{"x", "+", "-"};
        String operador;

        for (int numero = 0; numero < 10; numero++){

            if( numero >= 3 && numero % 3 == 0){
                operador = operadores[ (numero/3 == 1) ? 0 : (numero/3)-1 ];
                listaTeclasGui.add(addTecla("" + operador + ""));
            }

            listaTeclasGui.add(addTecla("" + numero + ""));

        }
        listaTeclasGui.add(addTecla("/"));
        listaTeclasGui.add(addTecla("="));

        this.listaTeclasGui = listaTeclasGui;

    }

    private JButton addTecla(String tecla, int column) {
        JButton btn = new JButton(tecla);
        btn.setBackground(Color.black);
        btn.setForeground(Color.black);
        return btn;
    }
    private JButton addTecla(String tecla) {
        JButton btn = new JButton(tecla);
        Font myFont = new Font("Serif", Font.BOLD, 18);
        btn.setFont(myFont);
        btn.setBackground(Color.decode("#a4db79"));
        btn.setForeground(Color.black);
        return btn;
    }

    private void addTecladoGui(){
        JPanel panelNumeros = new JPanel(new GridBagLayout());
        this.setTeclas();

        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy = 0;
        for ( JButton numero : listaTeclasGui){

            if(c.gridx == 2 && c.gridy == 3){
                c.gridwidth = 2;
                panelNumeros.add(numero,c);

            } else panelNumeros.add(numero,c);

            if(c.gridx < 3)
                c.gridx++;
            else {
                c.gridx = 0;
                c.gridy++;
            }

        }

        this.eventosBotones();
        this.panelNumeros = panelNumeros;
    }

    private void addPantallaInput(){
        JPanel panelInput = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField textPantallaInput = new JTextField("Opera...                     ");
        textPantallaInput.setEditable(false);
        Font myFont = new Font("Serif", Font.ITALIC, 18);
        textPantallaInput.setFont(myFont);
        textPantallaInput.setBackground(Color.decode("#a4db79"));
        panelInput.add(textPantallaInput);
        this.textPantallaInput = textPantallaInput;
        this.panelInput = panelInput;
    }

    public JPanel getPanelNumeros() {
        this.panelNumeros.setBackground(Color.decode("#7ba858"));
        return panelNumeros;
    }

    public JPanel getPanelInput(){
        this.panelInput.setBackground(Color.decode("#7ba858"));
        return panelInput;
    }

    public JPanel getPanelTitulo(){
        this.panelTitulo.setBackground(Color.decode("#7ba858"));
        return panelTitulo;
    }

    /* EVENTOS DE BOTONES */

    private void eventosBotones(){
        for (JButton boton : listaTeclasGui){
            boton.addActionListener(e -> {
                if (this.textPantallaInput.getText().equals("Opera...                     ")){
                    this.textPantallaInput.setText(boton.getText());
                }
                else{
                    if ("=".equals(boton.getText())) {
                        this.operar(this.textPantallaInput.getText());
                    } else {
                        this.textPantallaInput.setText(this.textPantallaInput.getText() + boton.getText());
                    }
                }
            });
        }
    }

    /* OPERACIONES */

    private int sumar(int anterior, int actual){
        return anterior + actual;
    }

    private int restar(int anterior, int actual){
        return anterior - actual;
    }

    private int dividir(int anterior, int actual){
        return anterior / actual;
    }

    private int multiplicar(int anterior, int actual){
        return anterior * actual;
    }

    /* OPERAR CON LAS OPERACIONES */
    private void operar(String inputUsuario){
        List<Integer> numeros = new ArrayList<>();
        List<Character> operaciones = new ArrayList<>();
        int inicio = 0;
        int acumulado = 0;
        int numeroAnterior;
        int numeroActual;

        String simbolos = "+-*x/";

        for (int operador = 0; operador < inputUsuario.length(); operador++){

            if(simbolos.contains(
                    String.valueOf(inputUsuario.charAt(operador))
                )){
                    numeros.add(Integer.parseInt(inputUsuario.substring(inicio,operador)));
                    operaciones.add(inputUsuario.charAt(operador));
                    inicio = operador+1;
                }
            else if(operador == inputUsuario.length()-1){
                numeros.add(Integer.parseInt(inputUsuario.substring(inicio)));
            }

        }

        int cont=0;
        int op=0;
        for (int numero = numeros.size()-1; numero > 0; numero--){
            if (numero != numeros.size()-1){
                // 5 + 4 + 3
                numeroAnterior = acumulado;
                numeroActual = numeros.get(++cont);
            }else{
                numeroAnterior = numeros.get(cont);
                numeroActual = numeros.get(++cont);
            }

            switch (operaciones.get(op)) {
                case '+' -> acumulado = this.sumar(numeroAnterior, numeroActual);
                case '-' -> acumulado = this.restar(numeroAnterior, numeroActual);
                case 'x', '*' -> acumulado = this.multiplicar(numeroAnterior, numeroActual);
                case '/' -> acumulado = this.dividir(numeroAnterior, numeroActual);
            }
            if(op < numeros.size()-2){
                op++;
            }
        }

        this.textPantallaInput.setText(String.valueOf(acumulado));
    }


}