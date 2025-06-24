import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Double> listaDeProdutos = new HashMap<>();

        listaDeProdutos.size();
        while (true){
            int op = menu(scan);
            if (op == 0) break;
            switch (op){
                case 1:
                    cadastrarProduto(scan, listaDeProdutos);
            }
        }
    }

    public static Integer menu(Scanner scan) {
        System.out.println("1 - Cadastrar um produto (nome e preço)" +
                "\n2 - Listar todos os produtos com seus preços." +
                "\n3 - Mostrar o Produto mais caro" +
                "\n4 - Calcular a média de preços dos produtos" +
                "\n5 - Listar produtos com preço acima da média" +
                "\n0 - Sair do programa");
        int opcao = scan.nextInt();
        return opcao;
    }

    public static void cadastrarProduto(Scanner scan, HashMap<String, Double> listaProdutos){
        System.out.println("Insira o nome do novo produto:");
        String nomeProduto = scan.next();
        System.out.println("Insira o preço do produto");
        double precoProduto = scan.nextDouble();
        try{
            listaProdutos.put(nomeProduto, precoProduto);
            System.out.println("Produto cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mostrarProdutoMaisCaro(HashMap<String, Double> listaProdutos){

    }




}