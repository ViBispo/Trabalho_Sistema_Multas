public class RegraVelocidade extends RegraMulta {
    private int velocidadeMaxima;
    private String logradouro;

    public RegraVelocidade(int velocidadeMaxima, String logradouro) {
        this.velocidadeMaxima = velocidadeMaxima;
        this.logradouro = logradouro;
        this.descricao = "Excesso de velocidade em " + logradouro;
    }

    @Override
    public Multa calcularMulta(Ocorrencia ocorrencia) {
        if (ocorrencia.getLogradouro().equalsIgnoreCase(logradouro) && ocorrencia.getTipo().equalsIgnoreCase("Velocidade")) {
            int velocidade = ocorrencia.getVelocidade();
            if (velocidade > velocidadeMaxima) {
                return new Multa("Velocidade", 1, descricao + ". Velocidade registrada: " + velocidade);
            }
        }
        return null;
    }
}




