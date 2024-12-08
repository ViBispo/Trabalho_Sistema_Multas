public class RegraCorredorOnibus extends RegraMulta {
    private int horarioInicio;
    private int horarioFim;
    private String logradouro;

    public RegraCorredorOnibus(int horarioInicio, int horarioFim, String logradouro) {
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.logradouro = logradouro;
        this.descricao = "Tráfego ilegal em corredor de ônibus na " + logradouro;
    }

    @Override
    public Multa calcularMulta(Ocorrencia ocorrencia) {
        if (ocorrencia.getTipo().equals("Corredor de Ônibus") && ocorrencia.getLogradouro().equals(logradouro)) {
            // Exemplo de lógica de horário
            int horaOcorrencia = 10; // Substituir pela lógica para capturar o horário real
            if (horaOcorrencia >= horarioInicio && horaOcorrencia <= horarioFim) {
                return new Multa("Corredor de Ônibus", 2, descricao);
            }
        }
        return null;
    }
}    

