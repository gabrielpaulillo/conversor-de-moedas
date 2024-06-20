package br.com.alura;
import java.util.Scanner;

public class Menu {

    public int exibirMenu() {
        Scanner leitura = new Scanner(System.in);
//       Instanciação de um scanner que irá ler qual a entrada do usuário para acessar determinada opção do menu
        System.out.println("\n**********************************************************");
        System.out.println("Digite o número da opção que desejar: ");
        System.out.println("\t1. Conversão Reais → Iene Japonês");
        System.out.println("\t2. Conversão Reais → Dólares");
        System.out.println("\t3. Conversão Reais → Pesos Argentinos");
        System.out.println("\t4. Conversão Reais → Euros");
        System.out.println("\t5. Conversão Reais → Yuan chinês");
        System.out.println("\t0. Sair");
        System.out.println("**********************************************************\n");

        return leitura.nextInt();
    }

    public float lerQuantia() {
        Scanner leitura = new Scanner(System.in);
//        Instanciação de um scanner que faz a leitura da quantia que o usuário deseja converter
        System.out.println("Qual a quantia em reais você deseja converter?");
        return leitura.nextFloat();
    }
}

