public class App {
    public static void main(String[] args) throws Exception {
        Arvore arvore = new Arvore();
        No raiz = new No("raiz");
        arvore.setRaiz(raiz);
        raiz.setFilhoEsquerdo(new No("1"));
        raiz.setFilhoDireito(new No("2"));

        arvore.exibirNumeroDeNos();
    }
}
