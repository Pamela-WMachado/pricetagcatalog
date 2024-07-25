package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList();
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Enter number of products: ");
		int n = sc.nextInt();
		
		for(int i = 1; i<=n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported? (c, u, i) ");
			char answer = sc.next().charAt(0);
			
			if(answer == 'c') {
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				
				list.add(new Product (name, price));
				
			} else if (answer == 'u') {
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Manufacture date: (DD/MM/YYYY)");
				sc.nextLine();
				String date = sc.nextLine();
				
				list.add(new UsedProduct(name, price, LocalDate.parse(date, fmt)));
				
			} else if(answer == 'i') {
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Customs fee:");
				double fee = sc.nextDouble();
				
				list.add(new ImportedProduct(name, price, fee));
			}
		}
		System.out.println();
		System.out.println("PRICE TAGS");
	
		for (Product prod : list) {
			System.out.println(prod.priceTag());
		}

	}

}
