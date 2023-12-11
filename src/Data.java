import java.util.ArrayList;


public class Data {
	
	private ArrayList<Product> stocks1 = new ArrayList<Product>();
	private ArrayList<Ticket> tickets1 = new ArrayList<Ticket>();
	private ArrayList<Product> stocks2 = new ArrayList<Product>();
	private ArrayList<Ticket> tickets2 = new ArrayList<Ticket>();
	private ArrayList<Product> allProducts = new ArrayList<Product>();
	private ArrayList<FloristShop> floristerias = new ArrayList<FloristShop>();
	
	
	public void loadShop() {
		FloristShop fh1 = new FloristShop("Rosas del valle", stocks1, tickets1);
		FloristShop fh2 = new FloristShop("Rosas del bosque", stocks2, tickets2);
		floristerias.add(fh1);
		floristerias.add(fh2);
		
	}
	

	public void loadStocks() {
		stocks1.add(new Tree("pino", 5, 9));
		stocks1.add(new Flower("rosa", 8, "red"));
		stocks1.add(new Flower("periwinkle", 6, "violet"));
		stocks1.add(new Tree("palmera", 12, 23));
		stocks1.add(new Decoration("mueble", 40, "madera"));
		
		stocks2.add(new Tree("christmas tree", 78, 50));
		stocks2.add(new Flower("tulipan", 8, "yellow"));
		stocks2.add(new Flower("girasol", 6, "orange"));
		stocks2.add(new Tree("almendro", 12, 23));
		stocks2.add(new Decoration("escritorio", 27, "madera"));
		
	}
	
	public void loadProducts() {
		
		allProducts.add(new Tree("pino", 5, 9));
		allProducts.add(new Flower("rosa", 8, "red"));
		allProducts.add(new Flower("periwinkle", 6, "violet"));
		allProducts.add(new Tree("palmera", 12, 23));
		allProducts.add(new Decoration("mueble", 40, "madera"));
		
		allProducts.add(new Tree("christmas tree", 78, 50));
		allProducts.add(new Flower("tulipan", 8, "yellow"));
		allProducts.add(new Flower("girasol", 6, "orange"));
		allProducts.add(new Tree("almendro", 12, 23));
		allProducts.add(new Decoration("escritorio", 27, "madera"));
	}
	
	public void loadTicket() {
		tickets1.add(new Ticket(1, allProducts, 50));
		tickets2. add(new Ticket(2, allProducts, 100));
	}


	public ArrayList<Product> getStocks1() {
		return stocks1;
	}


	public ArrayList<Ticket> getTickets1() {
		return tickets1;
	}


	public ArrayList<Product> getStocks2() {
		return stocks2;
	}


	public ArrayList<Ticket> getTickets2() {
		return tickets2;
	}


	public ArrayList<Product> getAllProducts() {
		return allProducts;
	}


	public ArrayList<FloristShop> getFloristerias() {
		return floristerias;
	}
	
	
	

}