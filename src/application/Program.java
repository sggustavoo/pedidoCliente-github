package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		// Informando os dados do cliente
		
		System.out.println("DIGITE OS DADOS DO CLIENTE:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Data de nascimento (DD/MM/AAAA): ");
		Date dataNascimento = sdf.parse(sc.next());
		
		// Dados do pedido
		
		System.out.println("DIGITE OS DADOS DO PEDIDO:");
		System.out.print("Status: ");
		String status = sc.next();
		Date momentoPedido = new Date();
		
		Order pedido = new Order(momentoPedido, OrderStatus.valueOf(status), new Client(nome, email, dataNascimento));
		
		System.out.print("Quantos itens para este pedido? ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i ++) {
			System.out.println("Digite os dados do item " + i + ":");
			System.out.print("Nome do produto: ");
			sc.nextLine();
			String nomeProduto = sc.nextLine();
			System.out.print("Preço do produto: ");
			double preco = sc.nextDouble();
			System.out.print("Quantidade: ");
			int quantidade = sc.nextInt();
			Product produto = new Product(nomeProduto, preco);
			OrderItem item = new OrderItem(quantidade, preco, produto);
			pedido.addItem(item);
		}
		
		// Resumo do pedido (instante do pedido, status e preços!)
		
		System.out.println();
		System.out.println("RESUMO DO PEDIDO:");
		System.out.println(pedido);
		
		sc.close();
	}
}
