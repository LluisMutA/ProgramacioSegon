package com.Draw.services;

import com.Draw.dao.DrawDAO;
import com.Draw.dao.DrawDAOInMemory;
import com.Draw.dao.UserDAO;
import com.Draw.dao.UserDAOInMemory;
import com.Draw.model.Draw;


public class DrawService {
    DrawDAO drawDAO = new DrawDAOInMemory();
    UserDAO userDAO = new UserDAOInMemory();

    public void deleteByDrawId(String username, int drawId) {
        Draw dibuix = drawDAO.findById(drawId);

        if (dibuix == null) {
            System.out.println("Dibujo con ID " + drawId + " no encontrado.");
            return;
        }

        System.out.println("Usuario registrado: " + username);
        System.out.println("Autor del dibujo (username): " + dibuix.getUser().getUsername());

        if (dibuix.getUser().getUsername().equals(username)) {
            drawDAO.deleteById(drawId);
            System.out.println("Dibujo eliminado: ID " + drawId);
        } else {
            System.out.println("Usuario no autorizado para eliminar este dibujo.");
        }
    }

}
