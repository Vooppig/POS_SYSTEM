package models;

import java.io.Serializable;

public class OrderDetail extends Item implements Serializable {

  /**
   * Constants
   */
  public static final String SMALL = "SMALL";
  public static final String MEDIUM = "MEDIUM";
  public static final String LARGE = "LARGE";

  private Integer quantity;
  private String size;
  private double subTotal;
  private double orderPrice;
  private Integer orderId;

  public Integer getQuantity() {
    return this.quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public String getSize() {
    return this.size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public double getOrderPrice() {
    return this.orderPrice;
  }

  public void setOrderPrice(double orderPrice) {
    this.orderPrice = orderPrice;
  }

  public Integer getOrderId() {
    return this.orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public void setSubTotal(double subTotal) {
    this.subTotal = subTotal;
  }

  public double getSubTotal() {
    return this.subTotal;
  }

}
