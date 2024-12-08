import java.util.ArrayList;

public class BaseDeDados {
    private ArrayList<Ocorrencia> ocorrenciasNaoProcessadas = new ArrayList<>();
    private ArrayList<Ocorrencia> ocorrenciasProcessadas = new ArrayList<>();
    private ArrayList<Multa> multas = new ArrayList<>();
    private ArrayList<RegraMulta> regras = new ArrayList<>();

    public void inicializaRegras() {
        regras.add(new RegraVelocidade(60, "Avenida Washington Luiz"));
        regras.add(new RegraVelocidade(70, "Avenida Nações Unidas"));
        regras.add(new RegraVelocidade(100, "Avenida Santo Amaro"));
    }

    public ArrayList<Ocorrencia> getOcorrenciasNaoProcessadas() {
        return ocorrenciasNaoProcessadas;
    }

    public ArrayList<Multa> getMultas() {
        return multas;
    }

    public void processarOcorrencias() {
        for (Ocorrencia ocorrencia : ocorrenciasNaoProcessadas) {
            for (RegraMulta regra : regras) {
                Multa multa = regra.calcularMulta(ocorrencia);
                if (multa != null) {
                    multas.add(multa);
                }
            }
            ocorrenciasProcessadas.add(ocorrencia);
        }
        ocorrenciasNaoProcessadas.clear();
    }
}



