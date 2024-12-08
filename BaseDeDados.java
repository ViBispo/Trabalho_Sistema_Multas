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
        regras.add(new RegraRodizio(2, "Avenida Bandeirantes", "Avenida Washington Luiz", 2, 1)); // Configuração de rodízio
    regras.add(new RegraCorredorOnibus(6, 23, "Avenida Santo Amaro")); // Configuração de corredor
    }

    public ArrayList<Ocorrencia> getOcorrenciasNaoProcessadas() {
        return ocorrenciasNaoProcessadas;
    }

    public ArrayList<Multa> getMultas() {
        return multas;
    }

    public void processarOcorrencias() {
        System.out.println("Processando ocorrências...");
        for (Ocorrencia ocorrencia : ocorrenciasNaoProcessadas) {
            boolean regraAplicada = false;
            for (RegraMulta regra : regras) {
                System.out.println("Verificando regra: " + regra.obterDescricaoMulta());
                Multa multa = regra.calcularMulta(ocorrencia);
                if (multa != null) {
                    System.out.println("Regra aplicada: " + regra.obterDescricaoMulta());
                    System.out.println("Multa gerada: " + multa.getDescricao());
                    multas.add(multa);
                    regraAplicada = true;
                }
            }
            if (!regraAplicada) {
                System.out.println("Nenhuma regra foi aplicada para a ocorrência: " 
                                    + ocorrencia.getTipo() 
                                    + " em " 
                                    + ocorrencia.getLogradouro());
            }
            ocorrenciasProcessadas.add(ocorrencia);
        }
        ocorrenciasNaoProcessadas.clear();
    }
}



