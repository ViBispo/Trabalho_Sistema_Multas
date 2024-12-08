public class RegraCorredorOnibus extends RegraMulta {
    private int horarioInicio; // Exemplo: 6 (6h)
    private int horarioFim; // Exemplo: 23 (23h)
    private String logradouro;

    public RegraCorredorOnibus(int horarioInicio, int horarioFim, String logradouro) {
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.logradouro = logradouro;
        this.descricao = "Tráfego ilegal em corredor de ônibus na " + logradouro;
    }

    @Override
    public Multa calcularMulta(Ocorrencia ocorrencia) {
        if (ocorrencia.getTipo().equalsIgnoreCase("Corredor de Ônibus") &&
            ocorrencia.getLogradouro().equalsIgnoreCase(logradouro)) {
            
            // Extração do horário da ocorrência
            String horarioOcorrencia = ocorrencia.getHorario();
            int hora = Integer.parseInt(horarioOcorrencia.split(":")[0]);
            int minuto = Integer.parseInt(horarioOcorrencia.split(":")[1]);
            int horarioTotalOcorrencia = hora * 60 + minuto;

            // Converte o início e fim em minutos totais
            int horarioTotalInicio = horarioInicio * 60; // 6h
            int horarioTotalFim = horarioFim * 60; // 23h

            if (horarioTotalOcorrencia >= horarioTotalInicio && horarioTotalOcorrencia <= horarioTotalFim) {
                return new Multa("Corredor de Ônibus", 2, descricao + ". Horário registrado: " + horarioOcorrencia);
            }
        }
        return null;
    }
}



