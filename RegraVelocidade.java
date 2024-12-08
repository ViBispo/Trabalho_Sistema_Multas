public class RegraVelocidade extends RegraMulta {
    private int velocidadeMaxima;
    private String logradouro;

    public RegraVelocidade(int velocidadeMaxima, String logradouro) {
        this.velocidadeMaxima = velocidadeMaxima;
        this.logradouro = logradouro;
        this.descricao = "Regra de Velocidade Máxima em " + logradouro;
    }

    @Override
    public Multa calcularMulta(Ocorrencia ocorrencia) {
        // Utilize velocidadeMaxima e logradouro na lógica aqui
        if (ocorrencia.getLogradouro().equals(logradouro)) {
            // Simular lógica de verificação da velocidade
            int nivel = 1; // Exemplo
            return new Multa("Velocidade", nivel, "Excedeu a velocidade máxima em " + logradouro);
        }
        return null; // Sem multa
    }
}
