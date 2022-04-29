package cn.edu.ecut.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Message
{
    private int id;
    private String message;
    private Timestamp timestamp;
}
