package cn.edu.ecut.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Title
{
    private int id;
    private String titleName;
    private Timestamp date;

    public Title(){};

    public Title(String title,long time)
    {
        this.id=id;
        this.titleName=title;
        this.date=new Timestamp(time);
    }
}
