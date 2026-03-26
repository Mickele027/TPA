import colecao.Icolecao;
import dominio.Produto;
import java.util.Scanner;
import listaencadeada.ListaEncadeada;

public class Main {
    public static void main(String[] args) {
        Icolecao<Produto> lista = new ListaEncadeada<>();
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Remover produto");
            System.out.println("3 - Pesquisar produto");
            System.out.println("4 - Listar todos");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // limpa buffer
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();
                    lista.adicionar(new Produto(id, nome, preco));
                    System.out.println("Produto adicionado!");
                    break;

                case 2:
                    System.out.print("ID do produto a remover: ");
                    int idRemover = sc.nextInt();
                    boolean removido = lista.remover(new Produto(idRemover, "", 0));
                    System.out.println(removido ? "Removido!" : "Produto não encontrado.");
                    break;

                case 3:
                    System.out.print("ID do produto a pesquisar: ");
                    int idPesquisar = sc.nextInt();
                    Produto encontrado = lista.pesquisar(new Produto(idPesquisar, "", 0));
                    System.out.println(encontrado != null ? encontrado : "Produto não encontrado.");
                    break;

                case 4:
                    System.out.println("Lista: " + lista);
                    System.out.println("Total: " + lista.quantidadeNos() + " produto(s)");
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}