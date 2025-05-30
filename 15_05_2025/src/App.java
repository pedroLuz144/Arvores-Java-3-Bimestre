public class App {
    public static void main(String[] args) throws Exception {
        Arvore arvore = new Arvore();
        arvore.raiz = new No("A");

        arvore.raiz.filhoEsquerdo = new No("B");
        arvore.raiz.filhoEsquerdo.filhoEsquerdo = new No("D");
        arvore.raiz.filhoEsquerdo.filhoDireito = new No("E");
        arvore.raiz.filhoEsquerdo.filhoEsquerdo.filhoEsquerdo = new No("H");

        arvore.raiz.filhoDireito = new No("C");
        arvore.raiz.filhoDireito.filhoEsquerdo = new No("F");
        arvore.raiz.filhoDireito.filhoDireito = new No("G");
        // arvore.setRaiz(raiz);
        // raiz.setFilhoEsquerdo(new No("1"));
        // raiz.setFilhoDireito(new No("2"));

        System.out.println();
        arvore.exibirNumeroDeNos();
        System.out.println();
        arvore.preOrder(arvore.raiz);
        System.out.println("\n");
        arvore.emOrder(arvore.raiz);
        System.out.println("\n");
        arvore.posOrder(arvore.raiz);
        System.out.println("\n");
        arvore.emNivel(arvore.raiz);
    }
}
