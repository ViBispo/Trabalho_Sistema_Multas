public class Multa {
    private String tipo;
    private int nivel;
    private String descricao;

    public Multa(String tipo, int nivel, String descricao) {
        this.tipo = tipo;
        this.nivel = nivel;
        this.descricao = descricao;
    }

    // Getters
    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDetalhes() {
        return "Tipo: " + tipo + ", Nível: " + nivel + ", Descrição: " + descricao;
    }
}

