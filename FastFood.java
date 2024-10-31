/* Uso de lista ligada/encadeada sem cabeça, pois o primeiro elemento
 * já contém um dado, e nesse caso, com inserção no final, já que está
 * sempre percorendo todos os elementos da lista para realizar operações
*/

class Produto {
    String produto;
    int quantidade;
    String status;

    Produto proximo;

    public Produto(String produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.status = "Na fila de pedidos"; //Status inicial de todos os novos produtos
        this.proximo = null;
    }

    public void produzir() {
        status = "Em produção...";
    }

    public void entregar() {
        status = "Saiu para entrega!";
    }

    public void exibirStatus() {
        System.out.println("Status do pedido de " + quantidade + " " + produto + ": " + status);
    }
}

class Pedidos {
    private Produto inicio;

    public Pedidos() {
        this.inicio = null;
    }

    public void criarPedidos(String produto, int quantidade) {
        Produto novoPedido = new Produto(produto, quantidade); // É uma instância da class produto

        if(inicio == null) {
            inicio = novoPedido;
        }
        else {
            Produto atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoPedido; //Quando o atual.proximo nao for true no loop, o valor não será alterado, por isso o atual.proximo que recebe o valor novoPedido
        }

        System.out.println("Pedido " + quantidade + " " + produto + " feito com sucesso!");
    }

    public void listarPedidos() {
        if(inicio == null) {
            System.out.println("Sem pedidos por agora!");
            return;
        }
        System.out.println("Pedidos criados: ");
        Produto atual = inicio;
        while (atual != null) {
            System.out.println("- " + atual.quantidade + " " + atual.produto);
            atual = atual.proximo;
        }
    }

    public void iniciarProducao(String produto) { // Método para colocar o status de iniciado no produto
        Produto atual = inicio;
        while(atual != null) {
            if(atual.produto.equals(produto)) { // Compara o valor da instância com o que foi criado e está na lista inicialmente
                atual.produzir();
                System.out.println("Produção do produto: " + produto + " iniciado");
                return;
            }
            atual = atual.proximo;
        }
        System.out.println("Produto " + produto + " não encontrado nos pedidos...");
    }

    public void entregarProduto(String produto) { // Método para status de entrega
        Produto atual = inicio;
        while (atual != null) {
            if(atual.produto.equals(produto)) {
                atual.entregar();
                System.out.println("O produto" + produto + " saiu para entrega");
            }
            atual = atual.proximo;
        }
    }

    public void statusProduto(String produto) { // Método para listar o status
        Produto atual = inicio;
        while (atual != null) {
            if(atual.produto.equals(produto)) {
                System.out.println(produto + " está em produção");
                atual.exibirStatus();
            }
            atual = atual.proximo;
        }
    }
}

public class FastFood {
    public static void main(String[] args) {
        Pedidos pedidos = new Pedidos();

        pedidos.criarPedidos("Hamburguer", 2);
        pedidos.criarPedidos("Pizza", 3);
        pedidos.criarPedidos("X-burguer", 5);
        System.out.println("--------------------------------------------");
        pedidos.iniciarProducao("Pizza");
        pedidos.statusProduto("Pizza");
        pedidos.entregarProduto("Pizza");
        pedidos.statusProduto("Pizza");
    }
}