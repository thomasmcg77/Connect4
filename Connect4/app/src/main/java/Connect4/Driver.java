package Connect4;

import view.gui.*;
import model.*;
import controller.*;

import java.awt.event.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class Driver {

   public static UserCatalog loadFromFile(String fileName)
   {
      UserCatalog userCatalog = null;

      try {
         FileInputStream fileInputStream = new FileInputStream(fileName);
         ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
         userCatalog = (UserCatalog)objectInputStream.readObject();
         fileInputStream.close();
      }
      catch (IOException e) {
         System.out.println("Error reading from file");
         System.out.println(e.getMessage());
      }
      catch (ClassNotFoundException e) {
         System.out.println("Error loading user catalog object");
         System.out.println(e.getMessage());
      }
      return userCatalog;
   }

   public static void main(String[] args)
   {
      String fileLocation = "userCatalog.dat";
      UserCatalog userCatalog = loadFromFile(fileLocation);
      
      Connect4Table gameTable = new Connect4Table();
      Player redPlayer = new Player(ChipColor.RED);
      Player blackPlayer = new Player(ChipColor.BLACK);
      Connect4Controller gameController = new Connect4Controller(redPlayer, blackPlayer, new Board(redPlayer, blackPlayer), gameTable, userCatalog);
      StartupWindow start = new StartupWindow(gameController, userCatalog);

      // Adds action listeners to each button
      gameTable.setPlaceCol(0, new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            gameController.placeInCol(0);
         }
      });

      gameTable.setPlaceCol(1, new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            gameController.placeInCol(1);
         }
      });

      gameTable.setPlaceCol(2, new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            gameController.placeInCol(2);
         }
      });

      gameTable.setPlaceCol(3, new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            gameController.placeInCol(3);
         }
      });

      gameTable.setPlaceCol(4, new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            gameController.placeInCol(4);
         }
      });

      gameTable.setPlaceCol(5, new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            gameController.placeInCol(5);
         }
      });
      
      gameTable.setPlaceCol(6, new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            gameController.placeInCol(6);
         }
      });

      UserWindowAdapter windowAdapter = new UserWindowAdapter(userCatalog, fileLocation);
      gameTable.addOnCloseListener(windowAdapter);
   }
}
