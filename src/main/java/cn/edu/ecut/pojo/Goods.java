package cn.edu.ecut.pojo;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author haunghl
 */
@Data
public class Goods
{
    private int id;
    private String address;
    private String phoneNumber;
    private String urgentGoods;
    private String isComplete;
    private Timestamp requestTime;
    private Timestamp completeTime;
}
