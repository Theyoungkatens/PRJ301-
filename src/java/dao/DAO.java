/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Cart;
import dto.Mobile;
import dto.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBUtils;

/**
 *
 * @author Tony
 */
public class DAO {
    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean addToCart(String userId, String mobileId) {
        String sql = "INSERT INTO tbl_Cart (userId, mobileId, quantity) VALUES (?, ?, 1);";
        boolean response = true;
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, mobileId);
            response = ps.executeUpdate() > 0 ? true : false;
        } catch (Exception ex) {
        }
        return response;
    }
    
    public boolean removeFromCart(int cartId) {
        String sql = "DELETE FROM tbl_Cart WHERE cartId = ?;";
        boolean response = true;
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, cartId);
            response = ps.executeUpdate() > 0 ? true : false;
        } catch (Exception ex) {
        }
        return response;
    }
    
     public List<Cart> getCart() {
        List<Cart> cartList = new ArrayList<Cart>();
        Cart cart;
        String sql = "SELECT * FROM tbl_Cart;";
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cart = new Cart(rs.getInt("cartId"), rs.getString("userId"), rs.getString("mobileId"), rs.getInt("quantity"));
                cartList.add(cart);
            }
        } catch (Exception ex) {
        }
        
        return cartList;
    }
    
    public boolean deleteMobile(String mobileId) {
        String sql = "DELETE FROM tbl_Mobile WHERE mobileId = ?;";
        boolean response = true;
        
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, mobileId);
            response = ps.executeUpdate() > 0 ? true : false;
        } catch (Exception ex) {}
        
        return response;
    }
    
    public boolean createMobile(Mobile mobile) {
        String sql = "INSERT INTO tbl_Mobile VALUES (?, ?, ?, ?, ?, ?, ?);";
        boolean response = true;
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, mobile.getMobileId());
            ps.setString(2, mobile.getDescription());
            ps.setFloat(3, mobile.getPrice());
            ps.setString(4, mobile.getMobileName());
            ps.setInt(5, mobile.getYearOfProduction());
            ps.setInt(6, mobile.getQuantity());
            ps.setInt(7, mobile.getNotSale());
            response = ps.executeUpdate() > 0 ? true : false;
        } catch (Exception ex) {
        }
        return response;
    }
    
     public boolean updateMobile(String mobileId, float price, String description, int quantity, int notSaleInt) {
        String sql = "UPDATE tbl_Mobile SET price = ?, description = ?, quantity = ?, notSale = ? WHERE mobileId = ?;";
        boolean response = true;
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setFloat(1, price);
            ps.setString(2, description);
            ps.setInt(3, quantity);
            ps.setInt(4, notSaleInt);
            ps.setString(5, mobileId);
            response = ps.executeUpdate() > 0 ? true : false;
        } catch (Exception ex) {
        }
        return response;
    }
    
    public User getUser(String userId, Integer password) {
        User user = null;
        String sql = "SELECT * FROM tbl_User WHERE userId = ? AND password = ?";
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setInt(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getString("userId"), rs.getInt("password"), rs.getString("fullName"), rs.getInt("role"));
                return user;
            }
        } catch (Exception ex) {
        }
        
        return user;
    }
    
    public List<Mobile> getAllMobiles() {
        List<Mobile> mobileList = new ArrayList<Mobile>();
        Mobile mobile;
        String sql = "SELECT * FROM tbl_Mobile;";
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                mobile = new Mobile(
                        rs.getString("mobileId"), 
                        rs.getString("description"), 
                        rs.getFloat("price"), 
                        rs.getString("mobileName"), 
                        rs.getInt("yearOfProduction"), 
                        rs.getInt("quantity"), 
                        rs.getInt("notSale")
                );
                mobileList.add(mobile);
            }
        } catch (Exception ex) {
        }
        
        return mobileList;
    }
    
    public List<Mobile> getAllMobilesWithCondition(float minPrice, float maxPrice) {
        List<Mobile> mobileList = new ArrayList<Mobile>();
        Mobile mobile;
        String sql = "SELECT * FROM tbl_Mobile WHERE price >= ? AND price <= ?;";
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setFloat(1, minPrice);
            ps.setFloat(2, maxPrice);
            rs = ps.executeQuery();
            while (rs.next()) {
                mobile = new Mobile(
                        rs.getString("mobileId"), 
                        rs.getString("description"), 
                        rs.getFloat("price"), 
                        rs.getString("mobileName"), 
                        rs.getInt("yearOfProduction"), 
                        rs.getInt("quantity"), 
                        rs.getInt("notSale")
                );
                mobileList.add(mobile);
            }
        } catch (Exception ex) {
        }
        
        return mobileList;
    }
    
    public List<Mobile> getAllByIdAndName(String id, String name) {
        List<Mobile> mobileList = new ArrayList<Mobile>();
        Mobile mobile;
        String sql = "SELECT * FROM tbl_Mobile WHERE mobileId LIKE ? OR mobileName LIKE ?;";
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, '%' + id + '%');
            ps.setString(2, '%' + name + '%');
            rs = ps.executeQuery();
            while (rs.next()) {
                mobile = new Mobile(
                        rs.getString("mobileId"), 
                        rs.getString("description"), 
                        rs.getFloat("price"), 
                        rs.getString("mobileName"), 
                        rs.getInt("yearOfProduction"), 
                        rs.getInt("quantity"), 
                        rs.getInt("notSale")
                );
                mobileList.add(mobile);
            }
        } catch (Exception ex) {
        }
        
        return mobileList;
    }
}
