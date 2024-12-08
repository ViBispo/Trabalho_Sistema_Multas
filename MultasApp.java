import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MultasApp extends JFrame {
    private BaseDeDados baseDeDados = new BaseDeDados();
    private ArrayList<String> logradouros; // Lista fixa de logradouros para evitar erros de digitação

    public MultasApp() {
        setTitle("Sistema de Controle de Multas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Inicializando os logradouros
        logradouros = new ArrayList<>();
        logradouros.add("Avenida Washington Luiz");
        logradouros.add("Avenida Nações Unidas");
        logradouros.add("Avenida Bandeirantes");
        logradouros.add("Avenida 23 de Maio");
        logradouros.add("Avenida Santo Amaro");
        logradouros.add("Avenida Vereador José Diniz");
        logradouros.add("Avenida Paulista");
        logradouros.add("Rua Vergueiro");
        logradouros.add("Avenida Rebouças");
        logradouros.add("Avenida Faria Lima");

        // Painel principal com botões
        JPanel panel = new JPanel();
        JButton cadastrarOcorrencia = new JButton("Cadastrar Ocorrência");
        JButton visualizarOcorrencias = new JButton("Visualizar Ocorrências");
        JButton visualizarMultas = new JButton("Visualizar Multas");

        panel.add(cadastrarOcorrencia);
        panel.add(visualizarOcorrencias);
        panel.add(visualizarMultas);
        add(panel, BorderLayout.CENTER);

        // Ações dos botões
        cadastrarOcorrencia.addActionListener(e -> abrirTelaCadastro());
        visualizarOcorrencias.addActionListener(e -> abrirTelaVisualizacaoOcorrencias());
        visualizarMultas.addActionListener(e -> abrirTelaVisualizacaoMultas());
    }

    private void abrirTelaCadastro() {
        JFrame frame = new JFrame("Cadastro de Ocorrência");
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(5, 2));

        JTextField tipoField = new JTextField();
        JComboBox<String> logradouroBox = new JComboBox<>(logradouros.toArray(new String[0]));
        JTextField dataField = new JTextField();
        JTextField placaField = new JTextField();
        JButton salvar = new JButton("Salvar");

        frame.add(new JLabel("Tipo de Ocorrência:"));
        frame.add(tipoField);
        frame.add(new JLabel("Logradouro:"));
        frame.add(logradouroBox);
        frame.add(new JLabel("Data (dd/MM/yyyy):"));
        frame.add(dataField);
        frame.add(new JLabel("Placa do Veículo:"));
        frame.add(placaField);
        frame.add(new JLabel(""));
        frame.add(salvar);

        salvar.addActionListener(e -> {
            String tipo = tipoField.getText();
            String logradouro = (String) logradouroBox.getSelectedItem();
            String data = dataField.getText();
            String placa = placaField.getText();

            // Validação simples
            if (tipo.isEmpty() || logradouro == null || data.isEmpty() || placa.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Todos os campos devem ser preenchidos!");
                return;
            }

            Ocorrencia ocorrencia = new Ocorrencia(tipo, logradouro, data, placa);
            baseDeDados.getOcorrenciasNaoProcessadas().add(ocorrencia);
            JOptionPane.showMessageDialog(frame, "Ocorrência salva com sucesso!");
            frame.dispose();
        });

        frame.setVisible(true);
    }

    private void abrirTelaVisualizacaoOcorrencias() {
        JFrame frame = new JFrame("Visualizar Ocorrências");
        frame.setSize(400, 300);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        for (Ocorrencia ocorrencia : baseDeDados.getOcorrenciasNaoProcessadas()) {
            textArea.append("Tipo: " + ocorrencia.getTipo() + ", Logradouro: " + ocorrencia.getLogradouro()
                    + ", Data: " + ocorrencia.getData() + ", Placa: " + ocorrencia.getPlaca() + "\n");
        }

        frame.add(new JScrollPane(textArea));
        frame.setVisible(true);
    }

    private void abrirTelaVisualizacaoMultas() {
        JFrame frame = new JFrame("Visualizar Multas");
        frame.setSize(400, 300);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        for (Multa multa : baseDeDados.getMultas()) {
            textArea.append("Tipo: " + multa.getTipo() + ", Nível: " + multa.getNivel() + ", Descrição: "
                    + multa.getDescricao() + "\n");
        }

        frame.add(new JScrollPane(textArea));
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MultasApp().setVisible(true));
    }
}


