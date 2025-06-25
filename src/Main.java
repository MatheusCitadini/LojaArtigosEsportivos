import java.sql.ClientInfoStatus;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Double> listaDeProdutos = new HashMap<>();

            try {
                while (true) {
                    String op = Services.menu(scan);
                    if (op.equals("0")) break;
                    switch (op) {
                        case "1":
                            Services.cadastrarProduto(scan, listaDeProdutos);
                            break;
                        case "2":
                            Services.listarProdutos(listaDeProdutos);
                            break;
                        case "3":
                            Services.mostrarProdutoMaisCaro(listaDeProdutos);
                            break;
                        case "4":
                            double media = Services.calcularMediaDePreco(listaDeProdutos);
                            if (Services.calcularMediaDePreco(listaDeProdutos).isNaN()){
                                System.out.println("Não foi possível calcular a média, pois a lista está vazia!");
                            } else {
                                System.out.println("A média de preços é: R$" + Services.calcularMediaDePreco(listaDeProdutos));
                            }
                            break;
                        case "5":
                            HashMap<String, Double> produtosAcimaDaMediaPreco = Services.listarAcimaMedia(listaDeProdutos);
                            for (Map.Entry<String, Double> entry : produtosAcimaDaMediaPreco.entrySet()) {
                                System.out.println("Produto: " + entry.getKey() + " - Valor: R$" + entry.getValue());
                            }
                            break;
                        case "6":
                            Services.removerProduto(scan, listaDeProdutos);
                            break;
                        case "7":
                            Services.atualizarPreco(scan, listaDeProdutos);
                            break;
                        case "8":
                            System.out.println("O valor total da lista de Produtos é: R$" + Services.exibirValorTotal(listaDeProdutos));
                        default:
                            System.out.println("Entrada inválida");
                            break;
                    }
                }
            }catch (InputMismatchException e){
                System.out.println("Entrada de dados inválida!");
            }catch (Exception e){
                System.out.println("Erro desconhecido: " + e.getMessage());
            }
    }
}