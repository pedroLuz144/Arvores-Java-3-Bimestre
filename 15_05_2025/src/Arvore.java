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

        //método para percorrer os nós da árvore em pré-ordem.
        public void preOrder(No raiz) {
                if (raiz != null) {
                        System.out.print(raiz.valor + ", ");
                        preOrder(raiz.filhoEsquerdo);
                        preOrder(raiz.filhoDireito);
                }
        }
        // public void preOrder(No arvore) {
        //         if (arvore == null) {
        //                 System.out.println("Nó vazio"); 
        //         } else {
        //                 System.out.println(arvore);
        //         }
                
        //         if (arvore.raiz.filhoEsquerdo == null) {
        //                 System.out.println("Sem filho esquerdo... Filho direito da raiz = " + raiz + " = " + raiz.filhoEsquerdo);
        //         } else {
        //                 System.out.println("Filho esquerdo da raiz = " + raiz + " = " + raiz.filhoEsquerdo);
        //         }
        // }
}
