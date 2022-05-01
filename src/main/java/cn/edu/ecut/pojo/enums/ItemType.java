package cn.edu.ecut.pojo.enums;

/**
 * @author huanghl
 */

public enum ItemType
{
    TEXT("text"),
    IMAGE("image");

    private String type;
    private ItemType(String type)
    {
        this.type=type;
    }
}
