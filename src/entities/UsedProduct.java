package entities;

import java.time.LocalDate;

public class UsedProduct extends Product{
	private LocalDate manufactureDate;
	
	public UsedProduct( ) {
		super();
	}

	public UsedProduct(String name, Double price, LocalDate manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}
	
	@Override
	public String priceTag() {
		return name + "(used)" + " $" + String.format("%.2f", price) + 
				"Manufacture date " + manufactureDate;
	}
	
}
