public class RegraRodizio extends RegraMulta {

    private String logradouro1;
    private String logradouro2;
    private int placaFinal;
    private int nivel; // Adicionado: nível da multa

    public RegraRodizio(int diaSemana, String logradouro1, String logradouro2, int placaFinal, int nivel) {

        this.logradouro1 = logradouro1;
        this.logradouro2 = logradouro2;
        this.placaFinal = placaFinal;
        this.nivel = nivel; // Inicialização do nível
        this.descricao = "Rodízio de veículos em " + logradouro1 + " e " + logradouro2;
    }

    @Override
    public Multa calcularMulta(Ocorrencia ocorrencia) {
        if (ocorrencia.getTipo().equalsIgnoreCase("Rodízio") &&
            (ocorrencia.getLogradouro().equalsIgnoreCase(logradouro1) || 
             ocorrencia.getLogradouro().equalsIgnoreCase(logradouro2))) {
            
            int finalPlaca = Integer.parseInt(ocorrencia.getPlaca().substring(ocorrencia.getPlaca().length() - 1));
            if (finalPlaca == placaFinal) {
                return new Multa("Rodízio", nivel, descricao);
            }
        }
        return null;
    }
}



