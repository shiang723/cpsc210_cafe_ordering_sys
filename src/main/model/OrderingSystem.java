package model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

// This [class/method] references code from these [repo/website]
// Link: [https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git]
//Represents the process of Ordering
//totalPrice >= 0
public class OrderingSystem {

    private ArrayList<MenuItem> cart;
    private Integer totalPrice;
    private Integer numOfItems;


    //EFFECTS: creates new Ordering System
    //         and OrderingSystem declares cart as a new ArrayList, and make totalPrice = 0 and numOfItems = 0
    public OrderingSystem() {
        this.cart = new ArrayList<>();
        this.totalPrice = 0;
        this.numOfItems = 0;
    }

    // MODIFIES: this
    // EFFECTS: add the given item to the cart ArrayList and return the changed Ordering System
    //          as well as add to the totalPrice and numOfItems
    public OrderingSystem addItemToCart(MenuItem item) {
        this.cart.add(item);
        this.totalPrice = totalPrice + item.getPrice();
        this.numOfItems++;
        return this;
    }

    // EFFECTS: returns the numOfItems
    public Integer getNumOfItems() {
        return numOfItems;
    }

    // EFFECTS: returns the totalPrice
    public Integer getTotalPrice() {
        return totalPrice;
    }

    // EFFECTS: returns the cart
    public ArrayList<MenuItem> getCart() {
        return cart;
    }

    // EFFECTS: returns a receipt that includes the name of the item ordered, the number of items and the total price
    public String receipt() {
        ArrayList<String> finalOrder = new ArrayList<>();
        for (MenuItem menuItem : cart) {
            finalOrder.add((menuItem.getName()));
        }
        return "You have ordered: " + finalOrder + "." + "Which is "
                + numOfItems + " item(s). That will be " + totalPrice + " cents.";

    }

    // EFFECTS: returns this as JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("cart", itemsToJson());
        return json;
    }

    // EFFECTS: returns items in this OrderingSystem as a JSON array
    private JSONArray itemsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (MenuItem m : cart) {
            jsonArray.put(m.toJson());
        }

        return jsonArray;
    }

}
