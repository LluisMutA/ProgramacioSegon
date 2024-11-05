package com.Draw.dao;

import com.Draw.model.Draw;
import com.Draw.model.Figure;
import com.Draw.model.User;

import java.util.Date;
import java.util.List;

public interface DrawDAO{
    void addDraw(String drawTitle, List<Figure> fig, User user, Date creationDate, Date modificationDate, String backgroundColor);

    List<Draw> findAllDraws();

    Draw findByName(String name);

    boolean matchTitleAndUser(String name, String title);

    void deleteByName(String name);
}
