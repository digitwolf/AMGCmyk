package com.digitwolf.cmyk.server.dal.models;

import com.google.appengine.api.datastore.Key;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Created with IntelliJ IDEA.
 * User: RyB
 * Date: 27.06.13
 * Time: 17:00
 * To change this template use File | Settings | File Templates.
 */
public class Techcard {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key id;

    @Persistent
    private String name;
    public Techcard() {
    }
}
