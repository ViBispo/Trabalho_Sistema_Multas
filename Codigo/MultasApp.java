package Codigo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MultasApp extends JFrame {
    private BaseDeDados baseDeDados = new BaseDeDados();

    public MultasApp() {
        setTitle("Sistema de Controle de Multas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        JButton cadastrarOcorrencia = new JButton("Cadastrar Ocorrência");
        JButton visualizarMultas = new JButton("Visualizar Multas");

        panel.add(cadastrarOcorrencia);
        panel.add(visualizarMultas);
        add(panel, BorderLayout.CENTER);

        cadastrarOcorrencia.addActionListener(e -> abrirTelaCadastro());
        visualizarMultas.addActionListener(e -> abrirTelaVisualizacao());
    }

    private void abrirTelaCadastro() {
        JFrame frame = new JFrame("Cadastro de Ocorrência");
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 2));

        JTextField tipoField = new JTextField();
        JTextField logradouroField = new JTextField();
        JTextField dataField = new JTextField();
        JTextField placaField = new JTextField();
        JButton salvar = new JButton("Salvar");

        frame.add(new JLabel("Tipo:"));
        frame.add(tipoField);
        frame.add(new JLabel("Logradouro:"));
        frame.add(logradouroField);
        frame.add(new JLabel("Data:"));
        frame.add(dataField);
        frame.add(new JLabel("Placa:"));
        frame.add(placaField);
        frame.add(salvar);

        salvar.addActionListener(e -> {
            Ocorrencia ocorrencia = new Ocorrencia(
                tipoField.getText(),
                logradouroField.getText(),
                dataField.getText(),
                placaField.getText()
            );
            baseDeDados.getOcorrenciasNaoProcessadas().add(ocorrencia);
            JOptionPane.showMessageDialog(frame, "Ocorrência salva com sucesso!");
            frame.dispose();
        });

        frame.setVisible(true);
    }

    private void abrirTelaVisualizacao() {
        JFrame frame = new JFrame("Visualizar Multas");
        frame.setSize(400, 300);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        for (Multa multa : baseDeDados.getMultas()) {
            textArea.append(multa.getDetalhes() + "\n");
        }

        frame.add(new JScrollPane(textArea));
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MultasApp().setVisible(true));
    }
}
