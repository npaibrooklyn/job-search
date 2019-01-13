package com.gpai.interview.intentmedia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class that encapsulates the terminal and provides scan and total calculation functionality
 * @author gpai
 *
 */
public class Terminal {
	
	private PriceSheet priceSheet  = null;	
	
	private HashMap<String, Integer> productsBought = null;

	/**
	 * Constructor that takes in a price sheet for the terminal to use
	 * @param priceSheet
	 */
	public Terminal(PriceSheet priceSheet) {
		this.priceSheet = priceSheet;
		productsBought = new HashMap<String, Integer>();
	}
	
	/**
	 * Reset the products bought so far, so a new scan can be performed
	 */
	public void reset() {
		productsBought = new HashMap<String, Integer>();
	}

	public PriceSheet getPriceSheet() {
		return priceSheet;
	}

	public void setPriceSheet(PriceSheet priceSheet) {
		this.priceSheet = priceSheet;
	}
	
	/**
	 * Method to add the scanned product into the Map of products built up so far
	 * @param productCode
	 */
	public void scan(String productCode) {
		Integer count = productsBought.get(productCode);
		if(count==null) {
			productsBought.put(productCode, 1);
		} else {
			productsBought.put(productCode, count.intValue()+1);
		}
	}
	
	/**
	 * Return the total price for the items scanned so far, given the price sheet
	 * @return
	 */
	public double total() {
		Iterator<String> iter = productsBought.keySet().iterator();
		double total = 0;
		while(iter.hasNext()) {
			String productCode = iter.next();
			int volumeBought =  productsBought.get(productCode).intValue();
			total += priceSheet.getPrice(productCode, volumeBought);
		}
		
		return total;
	}
	
	
	
	public static void main(String args[]) {
		// Form a new price sheet
		PriceSheet priceSheet = new PriceSheet();
		
		// Set prices for product A
		ProductPrice productPriceA1 = new ProductPrice(1, 2); // 1 for $2
		ProductPrice productPriceA2 = new ProductPrice(4, 7); // 4 for $7
		ArrayList<ProductPrice> productPricesA = new ArrayList<ProductPrice>();
		productPricesA.add(productPriceA1);
		productPricesA.add(productPriceA2);
		priceSheet.addPrice("A", productPricesA);
		
		// Set prices for product B
		ProductPrice productPriceB1 = new ProductPrice(1, 12); // 1 for $12
		ArrayList<ProductPrice> productPricesB = new ArrayList<ProductPrice>();
		productPricesB.add(productPriceB1);
		priceSheet.addPrice("B", productPricesB);
		
		// Set prices for product C
		ProductPrice productPriceC1 = new ProductPrice(1, 1.25); // 1 for $1.25
		ProductPrice productPriceC2 = new ProductPrice(6, 6); // 6 for 6
		ArrayList<ProductPrice> productPricesC = new ArrayList<ProductPrice>();
		productPricesC.add(productPriceC1);
		productPricesC.add(productPriceC2);
		priceSheet.addPrice("C", productPricesC);
		
		// Set prices for product D
		ProductPrice productPriceD1 = new ProductPrice(1, 0.15); // 1 for $0.15
		ArrayList<ProductPrice> productPricesD = new ArrayList<ProductPrice>();
		productPricesD.add(productPriceD1);
		priceSheet.addPrice("D", productPricesD);
		
		
		Terminal terminal = new Terminal(priceSheet);
		// Scan these items in this order: ABCDABAA
		terminal.scan("A");
		terminal.scan("B");
		terminal.scan("C");
		terminal.scan("D");
		terminal.scan("A");
		terminal.scan("B");
		terminal.scan("A");
		terminal.scan("A");
		System.out.println(terminal.total()); // 32.40
		
		terminal.reset();
		
		// Scan these items in this order: CCCCCCC
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		System.out.println(terminal.total()); //7.25
		
		terminal.reset();
		
		
		// Scan these items in this order: ABCD
		terminal.scan("A");
		terminal.scan("B");
		terminal.scan("C");
		terminal.scan("D");
		System.out.println(terminal.total()); // 15.4
		
		
		
		
	}
	
	

}
