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

        System.out.println("Usuari logeat: " + name);
        Draw dibuix = drawDAO.findByName(drawingName);
        System.out.println("Propietari del dibuix: " + dibuix.getUser().getName());


        if (dibuix.getUser().getName().equals(name)) {
            // Aquí saps que el dibuix es pot esborar perquè el prp`pietaria
            // és el mateix ususair que esta logeat
            drawDAO.deleteByName(name);
        } else {

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
