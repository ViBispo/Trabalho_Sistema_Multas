public class RegraRodizio extends RegraMulta {
    private int diaSemana; // Declarando o atributo
    private String logradouro1;
    private String logradouro2;
    private int placaFinal;
    private int nivel;

    public RegraRodizio(int diaSemana, String logradouro1, String logradouro2, int placaFinal, int nivel) {
        this.diaSemana = diaSemana; // Inicializando a variável
        this.logradouro1 = logradouro1;
        this.logradouro2 = logradouro2;
        this.placaFinal = placaFinal;
        this.nivel = nivel;
        this.descricao = "Rodízio de veículos em " + logradouro1 + " e " + logradouro2;
    }

    @Override
    public Multa calcularMulta(Ocorrencia ocorrencia) {
        if (ocorrencia.getTipo().equalsIgnoreCase("Rodízio") &&
            (ocorrencia.getLogradouro().equalsIgnoreCase(logradouro1) || 
             ocorrencia.getLogradouro().equalsIgnoreCase(logradouro2))) {
            
            // Verifica o dia da semana
            int diaAtual = 2; // Simule o dia atual (2 = Segunda-feira)
            if (diaAtual != diaSemana) {
                return null; // Não aplica multa se não for o dia correto
            }

            // Verifica o final da placa
            int finalPlaca = Integer.parseInt(ocorrencia.getPlaca().substring(ocorrencia.getPlaca().length() - 1));
            if (finalPlaca == placaFinal) {
                return new Multa("Rodízio", nivel, descricao + ". Placa final: " + finalPlaca);
            }
        }
        return null;
    }
}




