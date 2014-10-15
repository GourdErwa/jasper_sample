package com.lw.datasource;

/**
 * @author wei.Li by 14/10/13.
 */
public class CustomBean {
    private String city = null;
    private Integer id = null;
    private String name = null;
    private String street = null;

    public CustomBean(String pcity, Integer pid, String pname, String pstreet) {
        city = pcity;
        id = pid;
        name = pname;
        street = pstreet;
    }

    public CustomBean getMe() {
        return this;
    }

    public String getCity() {
        return city;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }
}
