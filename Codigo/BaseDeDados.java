package Codigo;

import java.util.ArrayList;

public class BaseDeDados {
    private ArrayList<Ocorrencia> ocorrenciasProcessadas = new ArrayList<>();
    private ArrayList<Ocorrencia> ocorrenciasNaoProcessadas = new ArrayList<>();
    private ArrayList<RegraMulta> regras = new ArrayList<>();
    private ArrayList<Multa> multas = new ArrayList<>();

    public void inicializaRegras() {
        regras.add(new RegraVelocidade(60, "Avenida Washington Luiz"));
        // Adicionar mais regras
    }

    public ArrayList<Ocorrencia> getOcorrenciasNaoProcessadas() {
        return ocorrenciasNaoProcessadas;
    }

    public ArrayList<Multa> getMultas() {
        return multas;
    }

    public void carregarDados(String arquivo) {
        // Lógica para carregar dados do arquivo
    }

    public void salvarDados(String arquivo) {
        // Lógica para salvar dados em arquivo
    }
}
