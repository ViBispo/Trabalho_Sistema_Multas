public abstract class RegraMulta {
    protected String descricao;

    public abstract Multa calcularMulta(Ocorrencia ocorrencia);

    public String obterDescricaoMulta() {
        return descricao;
    }
}
