package org.example;

public class ArvoreBinaria {
    private NoDuplo raiz;
    public ArvoreBinaria() {
        this.raiz = null;
    }

    public NoDuplo getRaiz() {
        return raiz;
    }

    public void setRaiz(NoDuplo raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia() {
        return raiz==null;
    }

    public void insere(int i) {
        NoDuplo novo = new NoDuplo(i);
        if(estaVazia()) {
            setRaiz(novo);
        } else {
            insereRec(raiz, novo);

        }
    }

    private void insereRec(NoDuplo atual, NoDuplo novo) {
        if(novo.getInfo() > atual.getInfo()) {
            if(atual.getFilhoDireito() == null) {
                atual.setFilhoDireito(novo);
            } else {
                insereRec(atual.getFilhoDireito(), novo);
            }

        } else {
            if(atual.getFilhoEsquerdo() == null) {
                atual.setFilhoEsquerdo(novo);
            } else {
                insereRec(atual.getFilhoEsquerdo(), novo);
            }
        }
    }

    public void emOrdem() {
        System.out.print("árvore: ");
        if (estaVazia()) {
            System.out.println("vazia");
        } else {
            emOrdemRec(raiz);
        }
    }

    private void emOrdemRec(NoDuplo atual) {
        if(atual != null) {
            emOrdemRec(atual.getFilhoEsquerdo());
            System.out.print(atual.getInfo() + " ");
            emOrdemRec(atual.getFilhoDireito());
        }
    }

    public int profundidade(NoDuplo raiz) {
        if(raiz == null) {
            return 0;
        }

        int esquerdo = profundidade(raiz.getFilhoEsquerdo());
        int direito = profundidade(raiz.getFilhoDireito());

        if(esquerdo > direito) {
            return (esquerdo + 1);
        } else {
            return (direito + 1);
        }
    }

    public int profundidadeProfessora() {
        if(estaVazia()) {
            return 0;
        } else {
            return profundidadeProfessoraRec(raiz) - 1;
        }
    }

    private static int maximo(int primeiro, int segundo) {
        if (primeiro > segundo) {
            return primeiro;
        }
        return segundo;
    }
    private int profundidadeProfessoraRec(NoDuplo atual) {
        if(atual.getFilhoDireito() == null && atual.getFilhoEsquerdo() == null) {
            return 0;
        } else {
            int nivelEsquerdo = atual.getFilhoEsquerdo() != null ? profundidadeProfessoraRec(atual.getFilhoEsquerdo()) : 1;
            int nivelDireito = atual.getFilhoDireito() != null ? profundidadeProfessoraRec(atual.getFilhoDireito()) : 1;

//            return maximo(profundidadeProfessoraRec(atual.getFilhoEsquerdo()), profundidadeProfessoraRec(atual.getFilhoDireito())) + 1;
            return maximo(nivelEsquerdo, nivelDireito) + 1;
        }
    }

    public int somaArvore() {
        if(estaVazia()) {
            return 0;
        } else {
            return somaEmOrdemRec(raiz);
        }
    }

    private int somaEmOrdemRec(NoDuplo atual) {
        if (atual == null) {
            return 0;
        }
        return somaEmOrdemRec(atual.getFilhoEsquerdo()) + atual.getInfo() + somaEmOrdemRec((atual.getFilhoDireito()));
    }
    public int menor() {
        NoDuplo atual = raiz;
        while(atual.getFilhoEsquerdo() != null) {
            atual = atual.getFilhoEsquerdo();
        }
        return atual.getInfo();
    }

    public int maior() {
        NoDuplo atual = raiz;
        while(atual.getFilhoDireito() != null) {
            atual = atual.getFilhoDireito();
        }

        return atual.getInfo();
    }
}
