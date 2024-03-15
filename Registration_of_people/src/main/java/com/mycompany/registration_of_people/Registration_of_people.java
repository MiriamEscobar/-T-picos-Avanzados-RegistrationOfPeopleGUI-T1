
package com.mycompany.registration_of_people;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Registration_of_people extends JFrame implements ActionListener {
    private JTextField nombreField, edadField, pesoField, alturaField, imcField;
    private JTextArea displayArea;
    private JButton guardarButton, buscarButton, atrasButton, siguienteButton, nuevoButton;

    public Registration_of_people() {
        super("Registro de Personas");
        setLayout(new BorderLayout());

        // Panel de entrada de datos
        JPanel entradaPanel = new JPanel();
        entradaPanel.setLayout(new GridLayout(5, 2));

        entradaPanel.add(new JLabel("Nombre:"));
        nombreField = new JTextField(10);
        entradaPanel.add(nombreField);

        entradaPanel.add(new JLabel("Edad:"));
        edadField = new JTextField(10);
        entradaPanel.add(edadField);

        entradaPanel.add(new JLabel("Peso:"));
        pesoField = new JTextField(10);
        entradaPanel.add(pesoField);

        entradaPanel.add(new JLabel("Altura:"));
        alturaField = new JTextField(10);
        entradaPanel.add(alturaField);

        entradaPanel.add(new JLabel("Índice de Masa Corporal:"));
        imcField = new JTextField(10);
        imcField.setEditable(false);
        entradaPanel.add(imcField);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(this);
        buttonPanel.add(guardarButton);

        buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(this);
        buttonPanel.add(buscarButton);

        atrasButton = new JButton("Atrás");
        atrasButton.addActionListener(this);
        buttonPanel.add(atrasButton);

        siguienteButton = new JButton("Siguiente");
        siguienteButton.addActionListener(this);
        buttonPanel.add(siguienteButton);

        nuevoButton = new JButton("Nuevo");
        nuevoButton.addActionListener(this);
        buttonPanel.add(nuevoButton);

        // Panel de visualización
        displayArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(entradaPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guardarButton) {
            guardarInformacion();
        } else if (e.getSource() == nuevoButton) {
            nombreField.setText("");
            edadField.setText("");
            pesoField.setText("");
            alturaField.setText("");
            imcField.setText("");
        } else if (e.getSource() == buscarButton) {
            // Implementa la lógica de búsqueda aquí
        } else if (e.getSource() == atrasButton) {
            // Implementa la lógica de retroceder aquí
        } else if (e.getSource() == siguienteButton) {
            // Implementa la lógica de avanzar aquí
        }
    }

    private void guardarInformacion() {
        String nombre = nombreField.getText();
        int edad = Integer.parseInt(edadField.getText());
        double peso = Double.parseDouble(pesoField.getText());
        double altura = Double.parseDouble(alturaField.getText());
        double imc = calcularIMC(peso, altura);

        // Escribir en el archivo (puedes modificar la ruta)
        try (FileWriter fw = new FileWriter("personas.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(nombre + "," + edad + "," + peso + "," + altura + "," + imc);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(this, "Información guardada correctamente");
    }

    private double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    public static void main(String[] args) {
        Registration_of_people ventana = new Registration_of_people();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300);
        ventana.setVisible(true);
    }
}
