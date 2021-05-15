package view.gui;

import model.*;

import java.awt.event.*;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class UserWindowAdapter extends WindowAdapter{

    UserCatalog userCatalog;
    String fileName;

    public UserWindowAdapter(UserCatalog userCatalog, String fileName){
        
        this.userCatalog = userCatalog;
        this.fileName = fileName;
    }

    @Override
    public void windowClosing(WindowEvent e){
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(userCatalog);
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch(IOException exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}