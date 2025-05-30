import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Arvore {
        No raiz;

        public Arvore() {
        }

        public Arvore(No raiz) {
                this.raiz = raiz;
        }

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

        // Código do professor
        public int contarNosComPilha (No raiz) {
                if (raiz == null) return 0;

                Stack<No> pilha = new Stack<>();
                pilha.push(raiz);

                int contador = 0;

                while (!pilha.isEmpty()) {
                        No atual = pilha.pop();
                        contador++;

                        if(atual.filhoDireito != null) pilha.push(atual.filhoDireito);
                        if(atual.filhoEsquerdo != null) pilha.push(atual.filhoEsquerdo);
                }

                return contador;
        }

        public int contarNosComFila (No raiz) {
                if (raiz == null) return 0;

                Queue<No> fila = new LinkedList<>();
                fila.add(raiz);

                int contador = 0;

                while (!fila.isEmpty()) {
                        No atual = fila.poll();
                        contador++;

                        if(atual.filhoDireito != null) fila.add(atual.filhoDireito);
                        if(atual.filhoEsquerdo != null) fila.add(atual.filhoEsquerdo);
                }

                return contador;
        }

        public void exibirNumeroDeNos() {
                int totalDeNos = contarNos(raiz);
                System.out.println("Essa arvore tem " + totalDeNos + " nós.");
        }

        // método para percorrer os nós da árvore em pré-ordem.
        public void preOrder(No raiz) {
                if (raiz != null) {
                        System.out.print(raiz.valor + ", ");
                        preOrder(raiz.filhoEsquerdo);
                        preOrder(raiz.filhoDireito);
                }
        }
        // public void preOrder(No arvore) {
        // if (arvore == null) {
        // System.out.println("Nó vazio");
        // } else {
        // System.out.println(arvore);
        // }

        // if (arvore.raiz.filhoEsquerdo == null) {
        // System.out.println("Sem filho esquerdo... Filho direito da raiz = " + raiz +
        // " = " + raiz.filhoEsquerdo);
        // } else {
        // System.out.println("Filho esquerdo da raiz = " + raiz + " = " +
        // raiz.filhoEsquerdo);
        // }
        // }

        public void emOrder(No raiz) {
                if (raiz != null) {
                        emOrder(raiz.filhoEsquerdo);
                        System.out.print(raiz.valor + ", ");
                        emOrder(raiz.filhoDireito);
                }
        }

        public void posOrder(No raiz) {
                if (raiz != null) {
                        posOrder(raiz.filhoEsquerdo);
                        posOrder(raiz.filhoDireito);
                        System.out.print(raiz.valor + ", ");
                }
        }

        public void emNivel(No raiz) {
                int lado = 1;
                No raiz2, raiz3;
                System.out.print(raiz.valor + ", ");
                do {
                        if (raiz != null) {
                                if (lado == 1) {
                                        System.out.print(raiz.filhoEsquerdo.valor + ", ");
                                        System.out.print(raiz.filhoDireito.valor + ", ");
                                        raiz2 = raiz.filhoEsquerdo;
                                        lado = 2;
                                        if (lado == 2) {
                                                System.out.print(raiz2.filhoEsquerdo.valor + ", ");
                                                System.out.print(raiz2.filhoDireito.valor + ", ");
                                                raiz3 = raiz.filhoDireito;
                                                lado = 3;
                                                if (lado == 3) {
                                                        System.out.print(raiz3.filhoEsquerdo.valor + ", ");
                                                        System.out.print(raiz3.filhoDireito.valor + ", ");
                                                        raiz = raiz2.filhoEsquerdo;
                                                        lado = 1;
                                                }
                                        }
                                }
                        } else {
                                lado = 0;
                        }

                } while (lado != 0);
        }
}