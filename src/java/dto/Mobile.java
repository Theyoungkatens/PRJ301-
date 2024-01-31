/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Tony
 */
public class Mobile {
    private String mobileId;
    private String description;
    private float price;
    private String mobileName;
    private Integer yearOfProduction;
    private Integer quantity;
    private Integer notSale;

    public Mobile(String mobileId, String description, float price, String mobileName, Integer yearOfProduction, Integer quantity, Integer notSale) {
        this.mobileId = mobileId;
        this.description = description;
        this.price = price;
        this.mobileName = mobileName;
        this.yearOfProduction = yearOfProduction;
        this.quantity = quantity;
        this.notSale = notSale;
    }

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getNotSale() {
        return notSale;
    }

    public void setNotSale(Integer notSale) {
        this.notSale = notSale;
    }
    
    
}
