public class Ocorrencia {
    private String tipo;
    private String logradouro;
    private String data;
    private String placa;
    private int velocidade;
    private String horario; // Novo campo

    public Ocorrencia(String tipo, String logradouro, String data, String placa, int velocidade, String horario) {
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.data = data;
        this.placa = placa;
        this.velocidade = velocidade;
        this.horario = horario;
    }

    public String getTipo() {
        return tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getData() {
        return data;
    }

    public String getPlaca() {
        return placa;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public String getHorario() {
        return horario;
    }
}




