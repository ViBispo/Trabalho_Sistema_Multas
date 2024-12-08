import javax.swing.*;
import java.awt.*;

public class MultasApp extends JFrame {
    private BaseDeDados baseDeDados = new BaseDeDados();

    public MultasApp() {
        baseDeDados.inicializaRegras();
        setTitle("Sistema de Controle de Multas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        JButton cadastrarOcorrencia = new JButton("Cadastrar Ocorrência");
        JButton visualizarOcorrencias = new JButton("Visualizar Ocorrências");
        JButton visualizarMultas = new JButton("Visualizar Multas");

        panel.add(cadastrarOcorrencia);
        panel.add(visualizarOcorrencias);
        panel.add(visualizarMultas);
        add(panel, BorderLayout.CENTER);

        cadastrarOcorrencia.addActionListener(_ -> abrirTelaCadastro());
        visualizarOcorrencias.addActionListener(_ -> abrirTelaVisualizacaoOcorrencias());
        visualizarMultas.addActionListener(_ -> abrirTelaVisualizacaoMultas());
    }

    private void abrirTelaCadastro() {
        JFrame frame = new JFrame("Cadastro de Ocorrência");
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(6, 2));

        JComboBox<String> tipoMultaBox = new JComboBox<>(new String[]{"Velocidade", "Rodízio", "Corredor de Ônibus"});
        JComboBox<String> logradouroBox = new JComboBox<>(new String[]{
            "Avenida Washington Luiz", "Avenida Nações Unidas", 
            "Avenida Santo Amaro", "Avenida Bandeirantes", "Avenida 23 de Maio"
        });
        JTextField dataField = new JTextField();
        JTextField placaField = new JTextField();
        JTextField velocidadeField = new JTextField();
        JButton salvar = new JButton("Salvar");

        frame.add(new JLabel("Tipo de Multa:"));
        frame.add(tipoMultaBox);
        frame.add(new JLabel("Logradouro:"));
        frame.add(logradouroBox);
        frame.add(new JLabel("Data (dd/MM/yyyy):"));
        frame.add(dataField);
        frame.add(new JLabel("Placa do Veículo:"));
        frame.add(placaField);
        frame.add(new JLabel("Velocidade (se aplicável):"));
        frame.add(velocidadeField);
        frame.add(new JLabel(""));
        frame.add(salvar);

        salvar.addActionListener(_ -> {
            String tipoMulta = (String) tipoMultaBox.getSelectedItem();
            String logradouro = (String) logradouroBox.getSelectedItem();
            String data = dataField.getText();
            String placa = placaField.getText();
            int velocidade = 0;

            if (tipoMulta.equals("Velocidade")) {
                try {
                    velocidade = Integer.parseInt(velocidadeField.getText().trim());
                    if (velocidade <= 0) {
                        JOptionPane.showMessageDialog(frame, "Velocidade deve ser maior que 0!");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Informe uma velocidade válida!");
                    return;
                }
            }

            Ocorrencia ocorrencia = new Ocorrencia(tipoMulta, logradouro, data, placa, velocidade);
            baseDeDados.getOcorrenciasNaoProcessadas().add(ocorrencia);
            JOptionPane.showMessageDialog(frame, "Ocorrência cadastrada com sucesso!");
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
            textArea.append("Tipo: " + ocorrencia.getTipo() + ", Logradouro: " + ocorrencia.getLogradouro() +
                            ", Velocidade: " + ocorrencia.getVelocidade() + "\n");
        }

        frame.add(new JScrollPane(textArea));
        frame.setVisible(true);
    }

    private void abrirTelaVisualizacaoMultas() {
        baseDeDados.processarOcorrencias();

        JFrame frame = new JFrame("Visualizar Multas");
        frame.setSize(400, 300);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        for (Multa multa : baseDeDados.getMultas()) {
            textArea.append("Tipo: " + multa.getTipo() + ", Nível: " + multa.getNivel() +
                            ", Descrição: " + multa.getDescricao() + "\n");
        }

        frame.add(new JScrollPane(textArea));
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MultasApp().setVisible(true));
    }
}
