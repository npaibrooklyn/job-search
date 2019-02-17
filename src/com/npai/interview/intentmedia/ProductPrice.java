package com.npai.interview.intentmedia;
import java.util.Comparator;

/**
 * Class that encapsulates the price of a product for a particular volume. 
 * For example, this can express, 5 for $10
 * @author npai
 *
 */
public class ProductPrice implements Comparator<ProductPrice> {
	
	private int volume;
	private double price;
	
	public ProductPrice() {
	}
	
	public ProductPrice(int volume, double price) {
		this.volume = volume;
		this.price = price;
	}
	
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	/**
	 * This is used when sorting
	 */
	public int compare(ProductPrice productPrice1, ProductPrice productPrice2) {
		if (productPrice2.getVolume() > productPrice1.getVolume()) {
			return 1;
		} else if (productPrice2.getVolume() < productPrice1.getVolume()) {
			return -1;
		} else {
			return 0;
		}
	}

	
	

}
