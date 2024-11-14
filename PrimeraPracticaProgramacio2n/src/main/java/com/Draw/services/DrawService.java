package com.Draw.services;

import com.Draw.dao.DrawDAO;
import com.Draw.dao.DrawDAOInMemory;
import com.Draw.dao.UserDAO;
import com.Draw.dao.UserDAOInMemory;
import com.Draw.model.Draw;


public class DrawService {
    DrawDAO drawDAO = new DrawDAOInMemory();
    UserDAO userDAO = new UserDAOInMemory();

    public void deleteByName(String name, String drawingName){
        Draw dibuix = drawDAO.findByName(drawingName);
        if (dibuix.getUser().getName().equals(name)) {
            drawDAO.deleteByName(drawingName);
            System.out.println("Autor dibujo" + dibuix.getUser().getName() + " Nombre del usuario registrado: " + name);
        }



//        boolean delete = drawDAO.matchTitleAndUser(name, drawingName);
//        if(!delete){
//            drawDAO.deleteByName(drawingName);
//        }

        // Has de treure el dibuix des del dao
        // has de verificar que el propietari del dibuix coincideix
        // amb l0usuari que està logeat
    }
}
