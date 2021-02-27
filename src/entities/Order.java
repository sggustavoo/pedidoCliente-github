package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date momento;
	private OrderStatus status;
	
	private Client cliente;
	private List<OrderItem> itens = new ArrayList<>();
	
	public Order() {
	}

	public Order(Date momento, OrderStatus status, Client cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}

	public List<OrderItem> getItens() {
		return itens;
	}
	
	public void addItem(OrderItem item) {
		itens.add(item);
	}
	
	public void removeItem(OrderItem item) {
		itens.remove(item);
	}
	
	public Double total() {
		
		double soma = 0.0;
		for (OrderItem i : itens) {
			soma += i.subTotal();
		}
		return soma;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Instante do pedido: " + sdf.format(momento) + "\n");
		sb.append("Status do pedido: " + status + "\n");
		sb.append(cliente + "\n");
		sb.append("Itens do pedido:\n");
		for (OrderItem i : itens) {
			sb.append(i + "\n");
		}
		sb.append("Preço Total: R$ " + String.format("%.2f",total()));
		return sb.toString();
	}
}
