package com.Draw.dao;

import com.Draw.model.Draw;
import com.Draw.model.Figure;
import com.Draw.model.User;

import java.util.Date;
import java.util.List;

public interface DrawDAO{
    int  generateDrawId();

    void addDraw(String drawTitle, List<Figure> fig, User user, Date creationDate, Date modificationDate, String backgroundColor);

    List<Draw> findAllDraws();

    Draw findByName(String name);

    Draw findById(int drawId);

    void deleteById(int drawId);

    void updateDraw(int drawId, String drawTitle, List<Figure> fig, String backgroundColor, Date modificationDate);

}
