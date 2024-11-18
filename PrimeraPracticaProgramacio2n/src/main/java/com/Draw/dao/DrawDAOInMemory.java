package com.Draw.dao;

import com.Draw.model.Draw;
import com.Draw.model.Figure;
import com.Draw.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DrawDAOInMemory implements DrawDAO{

    private static List<Draw> draws = new ArrayList<>();
    private int ids = 1;

    static {
        UserDAO userDAO = new UserDAOInMemory();
        Date date = new Date(System.currentTimeMillis());

        List<Figure> figure = new ArrayList<>();
        figure.add(new Figure("cuadrado", 12,34, 4, 76, null, "#000000", "#FFF050"));
        figure.add(new Figure("estrella", 100,97, 124, 156, null, "#00F000", "#FFF550"));
        draws.add(new Draw("Estrellada", figure, userDAO.findByUsername("bill"), date, date, "#FFFFF1"));
    }

    @Override
    public int generateDrawId() {
        int drawID = ids;
        ids++;
        return drawID;
    }

    @Override
    public void addDraw(String drawTitle, List<Figure> fig, User user, Date creationDate, Date modificationDate, String backgroundColor) {
        Draw draw = new Draw(drawTitle, fig, user, creationDate, modificationDate, backgroundColor);
        draw.setDrawId(generateDrawId());
        draws.add(draw);
        System.out.println(draw);
    }

    @Override
    public List<Draw> findAllDraws() {
        return draws;
    }

    @Override
    public Draw findByName(String name) {
        for(Draw draw : draws){
            if(draw.getDrawTitle().equals(name)) {
                return draw;
            }
        }
        return null;
    }

    @Override
    public Draw findById(int drawId) {
        for (Draw draw: draws)
            if(draw.getDrawId() == drawId){
                return draw;
            }
        return null;
    }

    @Override
    public void deleteById(int drawId) {
        draws.removeIf(draw -> draw.getDrawId() == drawId);
        for (Draw list: draws){
            System.out.println(list);
        }

    }
}
