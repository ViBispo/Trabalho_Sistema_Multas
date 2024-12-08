package Codigo;

public class Ocorrencia {
    private String tipo;
    private String logradouro;
    private String data;
    private String placa;

    public Ocorrencia(String tipo, String logradouro, String data, String placa) {
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.data = data;
        this.placa = placa;
    }

    // Getters e Setters
    public String getTipo() { return tipo; }
    public String getLogradouro() { return logradouro; }
    public String getData() { return data; }
    public String getPlaca() { return placa; }
}
