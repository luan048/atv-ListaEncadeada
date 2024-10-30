class Produto {
    String produto;
    int quantidade;

    Produto proximo;

    public Produto(String produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.proximo = null;
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
}

public class FastFood {
    public static void main(String[] args) {
        Pedidos pedidos = new Pedidos();

        pedidos.criarPedidos("Hamburguer", 2);
        pedidos.criarPedidos("Pizza", 3);
        pedidos.criarPedidos("X-burguer", 5);

        pedidos.listarPedidos();
    }
}


// Falta adicionar uma lista para armazenar status dos PRODUTOS EM PRODUÇÃO e PRODUTOS EM ENTREGA