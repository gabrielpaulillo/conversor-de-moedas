package br.com.alura;
import java.io.IOException;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
//        Cria uma instância da classe TaxasDeCambioService()
        TaxasDeCambioService service = new TaxasDeCambioService();
//        Cria uma instância da classe TaxasDeCambio() e atribui à ela o retorno da função 'obterTaxasDeCambio()',
//        essa que tem um retorno do tipo 'TaxasDeCambio', consequentemente atribuindo os dados da requisição Http
//        convertidos do formato '.json' para objeto Java e, finalmente, podendo acessar e manipular os dados atribuidos.
        TaxasDeCambio taxasDeCambio = service.obterTaxasDeCambio();

//        Cria uma instância da classe Menu()
        Menu menu = new Menu();
//        Cria uma instância da classe ConversorDeMoeda()
        ConversorDeMoeda conversor = new ConversorDeMoeda();

        String mensagemDefault = "Opção inserida inválida!\nInsira valores entre 0 e 5.";

        while (true) {
            try {
//                Inicialização da variável 'opcaoEscolhida' e atribui à ela o retorno da função ".exibirMenu()",
//                que o usuário inseriu.
                int opcaoEscolhida = menu.exibirMenu();

                if (opcaoEscolhida == 0) {
                    break;
                }
//                Inicialização da variável 'quantiaReais' e atribuição do retorno da função '.lerQuantia()',
//                que o usuário inseriu.
                float quantiaReais = menu.lerQuantia();
                float resultadoConversao;

                switch (opcaoEscolhida) {
                    case 1:
                        resultadoConversao = conversor.converterParaMoeda(quantiaReais, taxasDeCambio.getConversion_rates().getJPY());
                        System.out.printf("\nR$ %.2f convertidos em Iene Japonês: %.0f ienes\n", quantiaReais, resultadoConversao);
                        break;
                    case 2:
                        resultadoConversao = conversor.converterParaMoeda(quantiaReais, taxasDeCambio.getConversion_rates().getUSD());
                        System.out.printf("R$ %.2f convertidos em dólares americanos: %.2f dólares\n", quantiaReais, resultadoConversao);
                        break;
                    case 3:
                        resultadoConversao = conversor.converterParaMoeda(quantiaReais, taxasDeCambio.getConversion_rates().getARS());
                        System.out.printf("R$ %.2f convertidos em pesos argentinos: %.2f pesos argentinos\n", quantiaReais, resultadoConversao);
                        break;
                    case 4:
                        resultadoConversao = conversor.converterParaMoeda(quantiaReais, taxasDeCambio.getConversion_rates().getEUR());
                        System.out.printf("R$ %.2f convertidos em euros: %.2f euros\n", quantiaReais, resultadoConversao);
                        break;
                    case 5:
                        resultadoConversao = conversor.converterParaMoeda(quantiaReais, taxasDeCambio.getConversion_rates().getCNY());
                        System.out.printf("R$ %.2f convertidos em yuan chinês: %.2f yuans\n", quantiaReais, resultadoConversao);
                        break;
                    default:
                        System.out.println(mensagemDefault);
                }
            } catch (InputMismatchException e) {
                System.out.println(mensagemDefault);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
