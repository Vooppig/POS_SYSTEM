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
import models.Order;
import models.OrderDetail;
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
      ArrayList ob = new ArrayList();
      ob.add(orderId);
      ob.add(orderedItems);
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

  public static ArrayList orderGetAll() throws ClassNotFoundException {
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
      return (ArrayList) ret.getObject();
    } catch (IOException e) {
      System.out.println("IOException");
    }
    return null;
  }

  public static ArrayList getOneDetails(Integer id) throws ClassNotFoundException {
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
      return (ArrayList) ret.getObject();
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
}
