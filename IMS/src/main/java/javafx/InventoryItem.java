package javafx;

public class InventoryItem {
	private String itemID;
	private String itemName;
	private int quantity;
	private double price;

	

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public InventoryItem(String itemID, String itemName, int quantity, double price) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}

}