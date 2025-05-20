public class App {
    public static void main(String[] args) throws Exception {
        Arvore arvore = new Arvore();
        arvore.raiz = new No("A");
        arvore.raiz.filhoEsquerdo = new No("B");
        arvore.raiz.filhoDireito = new No("C");
        // arvore.setRaiz(raiz);
        // raiz.setFilhoEsquerdo(new No("1"));
        // raiz.setFilhoDireito(new No("2"));

        arvore.exibirNumeroDeNos();
        arvore.preOrder(arvore.raiz);
    }
}
