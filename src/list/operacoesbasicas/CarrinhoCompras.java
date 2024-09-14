package list.operacoesbasicas;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class CarrinhoCompras {
    private List<Item> itemList;

    public CarrinhoCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        Item item = new Item(nome, preco, quantidade);
        this.itemList.add(item);
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(i);
                }
            }
            itemList.removeAll(itensParaRemover);
        } else {
            System.out.println("LISTA DE COMPRAS VAZIA");
        }
    }

    public double calcularValorTotal() {
        double valorTotal = 0.0;
        if (!itemList.isEmpty()) {
            for (Item item : itemList) {
                double valorItem = item.getPreco() * item.getQuantidade();
                valorTotal += valorItem;
            }
            return valorTotal;
        } else {
            throw new RuntimeException("LISTA DE COMPRAS VAZIA");
        }
    }

    public void exibirItens() {
        if (!itemList.isEmpty()) {
            System.out.println(this.itemList);
        } else {
            System.out.println("LISTA DE COMPRAS VAZIA");
        }
    }

        public String toString() {
            return "CarrinhoCompras{" + "ITENS=" + itemList + '}';
        }
    public static void main(String[] args) {
        CarrinhoCompras carrinhoCompras = new CarrinhoCompras();

        carrinhoCompras.adicionarItem("ALFACE", 4.00, 1);
        carrinhoCompras.adicionarItem("ABACAXI", 8.00, 1);
        carrinhoCompras.adicionarItem("TOMATE", 0.50, 6);
        carrinhoCompras.adicionarItem("LARANJA", 0.20, 8);

        carrinhoCompras.exibirItens();

        carrinhoCompras.removerItem("TOMATE");

        carrinhoCompras.exibirItens();

        System.out.println("TOTAL DA COMPRA= " + carrinhoCompras.calcularValorTotal());
    }


}



