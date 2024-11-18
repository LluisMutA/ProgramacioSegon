package com.Draw.services;

import com.Draw.dao.DrawDAO;
import com.Draw.dao.DrawDAOInMemory;
import com.Draw.dao.UserDAO;
import com.Draw.dao.UserDAOInMemory;
import com.Draw.model.Draw;


public class DrawService {
    DrawDAO drawDAO = new DrawDAOInMemory();
    UserDAO userDAO = new UserDAOInMemory();

    public void deleteByDrawId(String name, int drawId){
        Draw dibuix = drawDAO.findById(drawId);
        if (dibuix.getUser().getName().equals(name)) {
            drawDAO.deleteById(drawId);
            System.out.println("Autor dibujo" + dibuix.getUser().getName() + " Nombre del usuario registrado: " + name);
        }
    }
}
