package com.gpai.interview.intentmedia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Class that encapsulates the entire price sheet that contains price offers for all the products
 * that the terminal can possibly scan
 * @author gpai
 *
 */
public class PriceSheet {
	
	private HashMap<String, ArrayList<ProductPrice>> prices = new HashMap<String, ArrayList<ProductPrice>>();
	
	public void addPrice(String productCode, ArrayList<ProductPrice> productPrices) {
		// arrange it such that higher-volume prices (best per unit prices) appear before the others.
		// For e.g., the price offer of 10 for $8, will appear before price offer of 1 for $1
		Collections.sort(productPrices, new ProductPrice());
		prices.put(productCode, productPrices);
		
	}
	
	/**
	 * For the given productCode and volume in which it is bought,
	 * this method returns the price for the product, considering
	 * the various offers in the pricesheet for that product
	 * @param productCode
	 * @param volumeBought
	 * @return
	 */
	public double getPrice(String productCode, int volumeBought) {
		ArrayList<ProductPrice> productPrices = prices.get(productCode);
		double price = 0;
		// Check the higher-volume (best per unit) prices first
		for(int i=0; i<productPrices.size(); i++) {
			int divisor = volumeBought/productPrices.get(i).getVolume();
			// volumeBought is less than the volume in the price offer, so go to a lower-volume price offer
			if(divisor==0) {
				continue;
			}
			// apply the highest volume price that is applicable
			price += divisor*productPrices.get(i).getPrice();
			// the remainder of the volume is used to iterate further
			volumeBought = volumeBought % productPrices.get(i).getVolume();
		}
		
		return price;
	}
	
	

}
