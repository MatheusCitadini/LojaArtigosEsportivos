import java.util.*;

public class Services {

    public static Integer menu(Scanner scan) {
        System.out.println("1 - Cadastrar um produto (nome e preço)" +
                "\n2 - Listar todos os produtos com seus preços." +
                "\n3 - Mostrar o Produto mais caro" +
                "\n4 - Calcular a média de preços dos produtos" +
                "\n5 - Listar produtos com preço acima da média" +
                "\n6 - Remover produto." +
                "\n0 - Sair do programa");
        int opcao = scan.nextInt();
        return opcao;
    }

    public static void cadastrarProduto(Scanner scan, HashMap<String, Double> listaDeProdutos){
        scan.nextLine();
        System.out.println("Insira o nome do novo produto:");
        String nomeProduto = scan.nextLine();
        if (listaDeProdutos.containsKey(nomeProduto)){
            System.out.println("Esse produto ja está cadastrado.\nInsira um novo item:");
            nomeProduto = scan.nextLine();
        }
        System.out.println("Insira o preço do produto");
        double precoProduto = scan.nextDouble();
        try{
            listaDeProdutos.put(nomeProduto, precoProduto);
            System.out.println("Produto cadastrado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Entrada de dados inválida!");
        }
        catch (Exception e){
            System.out.println("Erro desconhecido: " + e.getMessage());
        }
    }

    public static void listarProdutos(HashMap<String, Double> listaDeProdutos){
        System.out.println("=======LISTA DE PRODUTOS=======");
        for (Map.Entry<String, Double> entry : listaDeProdutos.entrySet()){
            System.out.println("Produto: " + entry.getKey() + " - Valor: R$" + entry.getValue());
        }
    }

    public static void mostrarProdutoMaisCaro(HashMap<String, Double> listaDeProdutos){
        Optional<Map.Entry<String, Double>> maisCaro = listaDeProdutos.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
        maisCaro.ifPresent(stringDoubleEntry -> System.out.println("O Produto mais caro é o(a): " + stringDoubleEntry.getKey() + " - Valor: R$" + stringDoubleEntry.getValue()));
    }

    public static Double calcularMediaDePreco(HashMap<String, Double> listaDeProdutos){
        double total = 0;
        for (Map.Entry<String, Double> entry : listaDeProdutos.entrySet()){
            total += entry.getValue();
        }
        return total / listaDeProdutos.size();
    }

    public static HashMap<String, Double> listarAcimaMedia(HashMap<String, Double> listaDeProdutos){
        HashMap<String, Double> produtosAcimaDaMediaPreco = new HashMap<>();
        System.out.println("=======LISTA DE PRODUTOS COM PREÇO ACIMA DA MÉDIA=======");
        for (Map.Entry<String, Double> entry : listaDeProdutos.entrySet()){
            if (entry.getValue() > calcularMediaDePreco(listaDeProdutos)){
                produtosAcimaDaMediaPreco.put(entry.getKey(), entry.getValue());
            }
        }
        return produtosAcimaDaMediaPreco;
    }

    public static void removerProduto(Scanner scan, HashMap<String, Double> listaDeProdutos){
        try {
            System.out.println("Insira o nome do produto que você deseja remover");
            String produto = scan.next();
            listaDeProdutos.remove(produto);
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida");
        } catch (Exception e){
            System.out.println("Erro desconhecido: " + e.getMessage());
        }
    }
}
