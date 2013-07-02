package com.digitwolf.cmyk.server.dal.models;

import javax.jdo.annotations.*;

/**
 * Created with IntelliJ IDEA.
 * User: RyB
 * Date: 27.06.13
 * Time: 17:31
 * To change this template use File | Settings | File Templates.
 */
public class Paper {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key id;

    @Persistent
    private String name;

    @Persistent
    private String description;

    /**
     * g/cm2
     */
    @Persistent
    private int density;

    /**
     * Milimeters
     */
    @Persistent
    private int length;

    /**
     * Milimeters
     */
    @Persistent
    private int width;

    /**
     * Micron
     */
    @Persistent
    private int height;

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Paper() {
    }
}
