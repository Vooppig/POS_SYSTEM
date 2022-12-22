/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class OrderDetails implements Serializable {

  private Integer id;
  private ArrayList list;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ArrayList getList() {
    return list;
  }

  public void setList(ArrayList list) {
    this.list = list;
  }

}
