public class Arvore {
        No raiz;

        public No getRaiz() {
                return raiz;
        }

        public void setRaiz(No raiz) {
                this.raiz = raiz;
        }

        public int contarNos(No raiz) {
                if (raiz == null) {
                        return 0;
                } else {
                        return 1 + contarNos(raiz.filhoDireito) + contarNos(raiz.filhoEsquerdo);
                }
        }

        public void exibirNumeroDeNos() {
        int totalDeNos = contarNos(raiz);
        System.out.println("Essa arvore tem " + totalDeNos + " nós."); 
    }
}
