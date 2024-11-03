package com.Draw.dao;

import com.Draw.model.Draw;
import com.Draw.model.Figure;
import com.Draw.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DrawDAOInMemory implements DrawDAO{

    private static List<Draw> draws = new ArrayList<>();

    @Override
    public void addDraw(String drawTitle, List<Figure> fig, User user, Date creationDate, Date modificationDate) {
        draws.add(new Draw(drawTitle, fig, user, creationDate, modificationDate));
    }

    @Override
    public List<Draw> findAllDraws() {
        return draws;
    }
}
