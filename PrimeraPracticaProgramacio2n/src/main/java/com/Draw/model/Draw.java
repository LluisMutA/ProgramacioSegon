package com.Draw.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Draw {
    private String drawTitle;
    private List<Figure> fig = new ArrayList<>();
    private User user;
    private Date creationDate;
    private Date modificationDate;
    private String backgroundColor;


    public Draw(String drawTitle, List<Figure> fig, User user, Date creationDate, Date modificationDate, String backgroundColor) {
        this.drawTitle = drawTitle;
        this.fig = fig;
        this.user = user;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.backgroundColor = backgroundColor;
    }

    @Override
    public String toString() {
        return "Draw{" +
                "drawTitle='" + drawTitle + '\'' +
                ", fig=" + fig +
                ", user=" + user +
                ", creationDate=" + creationDate +
                ", modificationDate=" + modificationDate +
                ", backgroundColor='" + backgroundColor + '\'' +
                '}';
    }

    public String getDrawTitle() {
        return drawTitle;
    }

    public void setDrawTitle(String drawTitle) {
        this.drawTitle = drawTitle;
    }

    public List<Figure> getFig() {
        return fig;
    }

    public void setFig(List<Figure> fig) {
        this.fig = fig;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
