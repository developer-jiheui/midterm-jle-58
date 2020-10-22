package com.csis3275.controller_jle_58;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.dao_jle_58.OrderDAOImpl_jle_58;
import com.csis3275.model_jle_58.Order_jle_58;

@Controller
public class OrderController_jle_58 {

	// instantiated already cause of autowired
	@Autowired
	OrderDAOImpl_jle_58 orderDAOImp;
	
	@ModelAttribute("order")
	public Order_jle_58 setupAddForm()	{
		return new Order_jle_58();
	}
	
	// EXAMPLE DROP DOWN MENU INITIALIZER
	@ModelAttribute("sizes") 
	public List<String> initializeSizeDropDown() {
		List<String> sizes = new ArrayList<String>();
		sizes.add("Personal");
		sizes.add("Small");
		sizes.add("Medium");
		sizes.add("Large");
		return sizes; 
	}
	
	@GetMapping("/showOrders")
	public String showOrders(HttpSession session, Model model)	{
		//Get a list of students from the database
		List<Order_jle_58> orders = orderDAOImp.getAllOrders();
		double[] prices = new double[orders.size()];
		
		for(int i = 0; i < orders.size(); i++) {
			Order_jle_58 currOrder = orders.get(i);
			double currPrice = 0;
			switch(currOrder.getSize()) {
				case "personal":
					currPrice += 7.99;
					break;
				case "small":
					currPrice += 9.99;
					break;
				case "medium":
					currPrice += 12.99;
					break;
				case "large":
					currPrice += 14.99;
					break;
			}
						
			currPrice += currOrder.getNumToppings() * 1.99;
			currPrice *= 100 - currOrder.getDiscount();
			
			prices[i] = currPrice; 
		}
		
		//Add the list of students to the model to be returned to the view
		model.addAttribute("orderList", orders);
		
		model.addAttribute("priceList", prices);
		
		return "showOrders_jle_58";		
	}
	
	 //Handle Form Post
	 @PostMapping("/createOrder")
	 public String createOrder(@ModelAttribute("order") Order_jle_58 newOrder, Model model) {

		 //Create the student pass the object in.
		 orderDAOImp.createOrder(newOrder);
		 

		 //Get a list of students from the controller
		 List<Order_jle_58> orders = orderDAOImp.getAllOrders();
		 model.addAttribute("orderList", orders);
		 
		 double[] prices = new double[orders.size()];
			
			for(int i = 0; i < orders.size(); i++) {
				Order_jle_58 currOrder = orders.get(i);
				double currPrice = 0;
				switch(currOrder.getSize()) {
					case "personal":
						currPrice += 7.99;
						break;
					case "small":
						currPrice += 9.99;
						break;
					case "medium":
						currPrice += 12.99;
						break;
					case "large":
						currPrice += 14.99;
						break;
				}
							
				currPrice += currOrder.getNumToppings() * 1.99;
				currPrice *= 100 - currOrder.getDiscount();
				
				prices[i] = currPrice; 
			}
		 
			model.addAttribute("priceList", prices);

	
		 return "showOrders_jle_58";
	 }
	
}
