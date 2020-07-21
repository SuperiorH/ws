package com.example.ws;

public enum ColorEnum {

    RED("com.sap.red", 1),
    GREEN("com.sap.green", 2),
    BLUE("com.sap.blue", 3),
    ;

    private String name;
    private Integer code;

    ColorEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public static void main(String[] args) {
        String name1 = ColorEnum.RED.getName();
        String name2 = ColorEnum.GREEN.getName();
        String name3 = ColorEnum.BLUE.getName();
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
    }

}
