public class No {
    private No noDireita = null;
    private No noEsquerda = null;
    private String valor;
    private int altura;

    public No (String valor, No noEsquerda, No noDireita) {
        this.noDireita = noDireita;
        this.noEsquerda = noEsquerda;
        this.valor = valor;
        this.altura = 1;
    }

    public No (String valor) {
        this.valor = valor;
        this.altura = 1;
    }

    public void atualizarAltura() {
        int alturaEsquerda = (noEsquerda == null) ? 0 : noEsquerda.getAltura();
        int alturaDireita = (noDireita == null) ? 0 : noDireita.getAltura();
        this.altura = 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    public int getFatorBalanceamento() {
        int alturaEsquerda = (noEsquerda == null) ? 0 : noEsquerda.getAltura();
        int alturaDireita = (noDireita == null) ? 0 : noDireita.getAltura();
        return alturaEsquerda - alturaDireita;
    }

    public No getNoDireita() {
        return noDireita;
    }

    public void setNoDireita(No noDireita) {
        this.noDireita = noDireita;
    }

    public No getNoEsquerda() {
        return noEsquerda;
    }

    public void setNoEsquerda(No noEsquerda) {
        this.noEsquerda = noEsquerda;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}