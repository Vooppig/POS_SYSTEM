package models;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Order implements Serializable {

  /**
   * Constants
   */
  private Integer id;
  private Integer status;
  private Date date;
  private ArrayList<OrderDetail> details;

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public ArrayList<OrderDetail> getDetails() {
    return this.details;
  }

  public void setDetails(ArrayList<OrderDetail> details) {
    this.details = details;
  }

}
