/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Tony
 */
public class Cart {
    private Integer cartId;
    private String userId;
    private String mobileId;
    private Integer quantity;

    public Cart(Integer cartId, String userId, String mobileId, Integer quantity) {
        this.cartId = cartId;
        this.userId = userId;
        this.mobileId = mobileId;
        this.quantity = quantity;
    }
    
//    public static HashMap<String, List<Mobile>> cart = new HashMap<>();
//    
//    public boolean addToCart(String userId, List<Mobile> mobiles) {
//        return cart.put(userId, mobiles) != null ? true : false;
//    }
//    
//    public static boolean addToCart(String userId, Mobile mobile) {
//        List<Mobile> mobiles = getCartByUserId(userId);
//        if (mobiles == null) {
//            mobiles.add(mobile);
//            cart.put(userId, mobiles);
//            return true;
//        }
//        
//        cart.remove(userId);
//        mobiles.add(mobile);
//        cart.put(userId, mobiles);
//        return true;
//    }
//    
//    public static boolean updateCart(String userId, List<Mobile> mobiles) {
//        boolean hasCart = cart.containsKey(userId);
//        
//        if (!hasCart) {
//            return false;
//        }
//        
//        cart.remove(userId);
//        return cart.put(userId, mobiles) != null ? true : false;
//    }
//    
//    public static List<Mobile> getCartByUserId(String userId) {
//        boolean hasCart = cart.containsKey(userId);
//        
//        if (!hasCart) {
//            return null;
//        }
//        
//        return cart.get(userId);
//    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
