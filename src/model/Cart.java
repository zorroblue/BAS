package model;

import java.util.ArrayList;

//This class contains all aspects related to the functioning of the cart
public class Cart {
//As cart is a session-bases setup and is not to be saved as such, it is not persisted to database
	
	ArrayList<CartItem> cart;
	
	public Cart()
	{
		cart=new ArrayList<CartItem>();
	}
	public ArrayList<CartItem> getCart() {
		return cart;
	}
	
	public void setCart(ArrayList<CartItem> cart) {
		this.cart = cart;
	}
	
	public void generateBill()
	{
		//		TODO
		// GENERATE PDF
	}
	public void deleteCartItem(CartItem cartItem)
	{
		cart.remove(cartItem);
	}
	
	public void clearCart()
	{
		try
		{
			cart.clear();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
