/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import models.Category;
import models.Item;
import models.Order;
import models.OrderDetail;
import models.OrderDetails;
import models.ServerObject;
import models.User;

/**
 *
 * @author USER
 */
public class clientHandler {

  private static String ip;

  public clientHandler(String ip) {
    clientHandler.ip = ip;
  }

  public static void setIp(String ip) {
    clientHandler.ip = ip;
  }

  public static Boolean getAuth(models.User user) throws ClassNotFoundException {
    Boolean isauth = false;
    ServerObject ret;
    try ( Socket socket = new Socket(ip, 1234)) {
      ObjectOutputStream out = new ObjectOutputStream(
              socket.getOutputStream());
      ObjectInputStream in
              = new ObjectInputStream(socket.getInputStream());
      ServerObject object = new ServerObject();
      object.setOper(1);
      object.setObject(user);
      out.writeObject(object);
      out.flush();

      ret = (ServerObject) in.readObject();
      isauth = ret.getReturnValue();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return isauth;
  }

  public static Integer createOne(Order items) throws ClassNotFoundException {
    ServerObject ret;
    try ( Socket socket = new Socket(ip, 1234)) {
      ObjectOutputStream out = new ObjectOutputStream(
              socket.getOutputStream());
      ObjectInputStream in
              = new ObjectInputStream(socket.getInputStream());
      ServerObject object = new ServerObject();
      object.setOper(1000);
      object.setObject(items);
      out.writeObject(object);
      out.flush();

      ret = (ServerObject) in.readObject();
      return (Integer) ret.getObject();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return null;
  }

  public static Integer createOneDetails(Integer orderId, ArrayList<OrderDetail> orderedItems) throws ClassNotFoundException {
    ServerObject ret;
    try ( Socket socket = new Socket(ip, 1234)) {
      ObjectOutputStream out = new ObjectOutputStream(
              socket.getOutputStream());
      ObjectInputStream in
              = new ObjectInputStream(socket.getInputStream());
      ServerObject object = new ServerObject();
      object.setOper(1001);
      OrderDetails ob = new OrderDetails();
      ob.setId(orderId);
      ob.setList(orderedItems);
      object.setObject(ob);
      out.writeObject(object);
      out.flush();

      ret = (ServerObject) in.readObject();
      return (Integer) ret.getObject();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return null;
  }

  public static ArrayList<Order> orderGetAll() throws ClassNotFoundException {
    ServerObject ret;
    try ( Socket socket = new Socket(ip, 1234)) {
      ObjectOutputStream out = new ObjectOutputStream(
              socket.getOutputStream());
      ObjectInputStream in
              = new ObjectInputStream(socket.getInputStream());
      ServerObject object = new ServerObject();
      object.setOper(1002);
      out.writeObject(object);
      out.flush();

      ret = (ServerObject) in.readObject();
      return (ArrayList<Order>) ret.getObject();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return null;
  }

  public static ArrayList<OrderDetail> orderGetOneDetails(Integer id) throws ClassNotFoundException {
    ServerObject ret;
    try ( Socket socket = new Socket(ip, 1234)) {
      ObjectOutputStream out = new ObjectOutputStream(
              socket.getOutputStream());
      ObjectInputStream in
              = new ObjectInputStream(socket.getInputStream());
      ServerObject object = new ServerObject();
      object.setOper(1003);
      object.setObject(id);
      out.writeObject(object);
      out.flush();

      ret = (ServerObject) in.readObject();
      return (ArrayList<OrderDetail>) ret.getObject();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return null;
  }

  public static Integer OrderdDeleteOne(Integer id) throws ClassNotFoundException {
    ServerObject ret;
    try ( Socket socket = new Socket(ip, 1234)) {
      ObjectOutputStream out = new ObjectOutputStream(
              socket.getOutputStream());
      ObjectInputStream in
              = new ObjectInputStream(socket.getInputStream());
      ServerObject object = new ServerObject();
      object.setOper(1004);
      object.setObject(id);
      out.writeObject(object);
      out.flush();

      ret = (ServerObject) in.readObject();
      return (Integer) ret.getObject();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return null;
  }

  public static ArrayList<User> userGetAll() throws ClassNotFoundException {
    ServerObject ret;
    try ( Socket socket = new Socket(ip, 1234)) {
      ObjectOutputStream out = new ObjectOutputStream(
              socket.getOutputStream());
      ObjectInputStream in
              = new ObjectInputStream(socket.getInputStream());
      ServerObject object = new ServerObject();
      object.setOper(2000);
      out.writeObject(object);
      out.flush();

      ret = (ServerObject) in.readObject();
      return (ArrayList<User>) ret.getObject();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return null;
  }

  public static User userGetOne(Integer id) throws ClassNotFoundException {
    ServerObject ret;
    try ( Socket socket = new Socket(ip, 1234)) {
      ObjectOutputStream out = new ObjectOutputStream(
              socket.getOutputStream());
      ObjectInputStream in
              = new ObjectInputStream(socket.getInputStream());
      ServerObject object = new ServerObject();
      object.setOper(2001);
      object.setObject(id);
      out.writeObject(object);
      out.flush();

      ret = (ServerObject) in.readObject();
      return (User) ret.getObject();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return null;
  }

  public static Integer userCreateOne(User user) throws ClassNotFoundException {
    ServerObject ret;
    try ( Socket socket = new Socket(ip, 1234)) {
      ObjectOutputStream out = new ObjectOutputStream(
              socket.getOutputStream());
      ObjectInputStream in
              = new ObjectInputStream(socket.getInputStream());
      ServerObject object = new ServerObject();
      object.setOper(2002);
      object.setObject(user);
      out.writeObject(object);
      out.flush();

      ret = (ServerObject) in.readObject();
      return (Integer) ret.getObject();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return null;
  }

  public static Integer userUpdateOne(User user) throws ClassNotFoundException {
    ServerObject ret;
    try ( Socket socket = new Socket(ip, 1234)) {
      ObjectOutputStream out = new ObjectOutputStream(
              socket.getOutputStream());
      ObjectInputStream in
              = new ObjectInputStream(socket.getInputStream());
      ServerObject object = new ServerObject();
      object.setOper(2003);
      object.setObject(user);
      out.writeObject(object);
      out.flush();

      ret = (ServerObject) in.readObject();
      return (Integer) ret.getObject();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return null;
  }

  public static Integer userDeleteOne(Integer id) throws ClassNotFoundException {
    ServerObject ret;
    try ( Socket socket = new Socket(ip, 1234)) {
      ObjectOutputStream out = new ObjectOutputStream(
              socket.getOutputStream());
      ObjectInputStream in
              = new ObjectInputStream(socket.getInputStream());
      ServerObject object = new ServerObject();
      object.setOper(2003);
      object.setObject(id);
      out.writeObject(object);
      out.flush();

      ret = (ServerObject) in.readObject();
      return (Integer) ret.getObject();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return null;
  }

  public static ArrayList<Item> itemGetAll() throws ClassNotFoundException {
    ServerObject ret;
    try ( Socket socket = new Socket(ip, 1234)) {
      ObjectOutputStream out = new ObjectOutputStream(
              socket.getOutputStream());
      ObjectInputStream in
              = new ObjectInputStream(socket.getInputStream());
      ServerObject object = new ServerObject();
      object.setOper(3000);
      out.writeObject(object);
      out.flush();

      ret = (ServerObject) in.readObject();
      return (ArrayList<Item>) ret.getObject();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return null;
  }

  public static ArrayList<Item> itemGetAllByCateory(Integer id) throws ClassNotFoundException {

    ServerObject ret;
    try ( Socket socket = new Socket(ip, 1234)) {
      ObjectOutputStream out = new ObjectOutputStream(
              socket.getOutputStream());
      ObjectInputStream in
              = new ObjectInputStream(socket.getInputStream());
      ServerObject object = new ServerObject();
      object.setOper(3001);
      object.setObject(id);
      out.writeObject(object);
      out.flush();

      ret = (ServerObject) in.readObject();
      return (ArrayList<Item>) ret.getObject();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return null;
  }

  public static Item itemGetOneById(Integer id) throws ClassNotFoundException {
    ServerObject ret;
    try ( Socket socket = new Socket(ip, 1234)) {
      ObjectOutputStream out = new ObjectOutputStream(
              socket.getOutputStream());
      ObjectInputStream in
              = new ObjectInputStream(socket.getInputStream());
      ServerObject object = new ServerObject();
      object.setOper(3002);
      object.setObject(id);
      out.writeObject(object);
      out.flush();

      ret = (ServerObject) in.readObject();
      return (Item) ret.getObject();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return null;
  }

  public static Integer itemCreateOne(Item item) throws ClassNotFoundException {
    ServerObject ret;
    try ( Socket socket = new Socket(ip, 1234)) {
      ObjectOutputStream out = new ObjectOutputStream(
              socket.getOutputStream());
      ObjectInputStream in
              = new ObjectInputStream(socket.getInputStream());
      ServerObject object = new ServerObject();
      object.setOper(3003);
      object.setObject(item);
      out.writeObject(object);
      out.flush();

      ret = (ServerObject) in.readObject();
      return (Integer) ret.getObject();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return null;
  }

  public static Integer itemUpdateOne(Item item) throws ClassNotFoundException {
    ServerObject ret;
    try ( Socket socket = new Socket(ip, 1234)) {
      ObjectOutputStream out = new ObjectOutputStream(
              socket.getOutputStream());
      ObjectInputStream in
              = new ObjectInputStream(socket.getInputStream());
      ServerObject object = new ServerObject();
      object.setOper(3004);
      object.setObject(item);
      out.writeObject(object);
      out.flush();

      ret = (ServerObject) in.readObject();
      return (Integer) ret.getObject();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return null;
  }

  public static Integer itemDeleteOne(Integer id) throws ClassNotFoundException {
    ServerObject ret;
    try ( Socket socket = new Socket(ip, 1234)) {
      ObjectOutputStream out = new ObjectOutputStream(
              socket.getOutputStream());
      ObjectInputStream in
              = new ObjectInputStream(socket.getInputStream());
      ServerObject object = new ServerObject();
      object.setOper(3005);
      object.setObject(id);
      out.writeObject(object);
      out.flush();

      ret = (ServerObject) in.readObject();
      return (Integer) ret.getObject();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return null;
  }

  public static ArrayList<Category> catGetAll() throws ClassNotFoundException {
    ServerObject ret;
    try ( Socket socket = new Socket(ip, 1234)) {
      ObjectOutputStream out = new ObjectOutputStream(
              socket.getOutputStream());
      ObjectInputStream in
              = new ObjectInputStream(socket.getInputStream());
      ServerObject object = new ServerObject();
      object.setOper(4000);
      out.writeObject(object);
      out.flush();

      ret = (ServerObject) in.readObject();
      return (ArrayList<Category>) ret.getObject();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return null;
  }

  public static Category catGetOneById(Integer id) throws ClassNotFoundException {
    ServerObject ret;
    try ( Socket socket = new Socket(ip, 1234)) {
      ObjectOutputStream out = new ObjectOutputStream(
              socket.getOutputStream());
      ObjectInputStream in
              = new ObjectInputStream(socket.getInputStream());
      ServerObject object = new ServerObject();
      object.setOper(4001);
      object.setObject(id);
      out.writeObject(object);
      out.flush();

      ret = (ServerObject) in.readObject();
      return (Category) ret.getObject();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return null;
  }

  public static Integer catCreateOne(Category cat) throws ClassNotFoundException {
    ServerObject ret;
    try ( Socket socket = new Socket(ip, 1234)) {
      ObjectOutputStream out = new ObjectOutputStream(
              socket.getOutputStream());
      ObjectInputStream in
              = new ObjectInputStream(socket.getInputStream());
      ServerObject object = new ServerObject();
      object.setOper(4002);
      object.setObject(cat);
      out.writeObject(object);
      out.flush();

      ret = (ServerObject) in.readObject();
      return (Integer) ret.getObject();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return null;
  }

  public static Integer catUpdateOne(Category cat) throws ClassNotFoundException {
    ServerObject ret;
    try ( Socket socket = new Socket(ip, 1234)) {
      ObjectOutputStream out = new ObjectOutputStream(
              socket.getOutputStream());
      ObjectInputStream in
              = new ObjectInputStream(socket.getInputStream());
      ServerObject object = new ServerObject();
      object.setOper(4003);
      object.setObject(cat);
      out.writeObject(object);
      out.flush();

      ret = (ServerObject) in.readObject();
      return (Integer) ret.getObject();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return null;
  }

  public static Integer catDeleteOne(Integer id) throws ClassNotFoundException {
    ServerObject ret;
    try ( Socket socket = new Socket(ip, 1234)) {
      ObjectOutputStream out = new ObjectOutputStream(
              socket.getOutputStream());
      ObjectInputStream in
              = new ObjectInputStream(socket.getInputStream());
      ServerObject object = new ServerObject();
      object.setOper(4004);
      object.setObject(id);
      out.writeObject(object);
      out.flush();

      ret = (ServerObject) in.readObject();
      return (Integer) ret.getObject();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return null;
  }
}
