public class Ocorrencia {
    private String tipo;
    private String logradouro;
    private String data; // Para armazenar a data
    private String placa; // Para armazenar a placa
    private int velocidade;

    public Ocorrencia(String tipo, String logradouro, String data, String placa, int velocidade) {
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.data = data;
        this.placa = placa;
        this.velocidade = velocidade;
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
}



