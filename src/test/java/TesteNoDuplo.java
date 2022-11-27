import org.example.ArvoreBinaria;
import org.example.NoDuplo;

import java.util.Random;

public class TesteNoDuplo {
    public static void main(String[] args) {
        Random random = new Random();

        ArvoreBinaria arvore = new ArvoreBinaria();
        for (int i = 1; i <= 10; i++) {
            int n = random.nextInt(10);
            System.out.print(n + " ");
            arvore.insere(n);
        }
        System.out.println();
        arvore.emOrdem();

        if (!arvore.estaVazia()) {
            System.out.println();
            System.out.println("Menor: " + arvore.menor());
            System.out.println("Maior: " + arvore.maior());
            System.out.println("Soma árvore: " + arvore.somaArvore());
            System.out.println("Profundidade: " + arvore.profundidade(arvore.getRaiz()));
            System.out.println("Profundidade professora: " + arvore.profundidadeProfessora());
        }
    }

//    Encontrar a profundidade de uma árvore.
}
