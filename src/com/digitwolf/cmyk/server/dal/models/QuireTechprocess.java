package com.digitwolf.cmyk.server.dal.models;


import com.google.appengine.api.datastore.Key;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * An ordered techprocess of the quire.
 * User: RyB
 * Date: 27.06.13
 * Time: 17:26
 * To change this template use File | Settings | File Templates.
 */
public class QuireTechprocess {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key id;

    @Persistent
    private Quire quire;

    @Persistent
    private Techprocess techprocess;

    @Persistent
    private int order;

    @Persistent(dependent = "true")
    private TechprocessParameter parameter;

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }

    public Quire getQuire() {
        return quire;
    }

    public void setQuire(Quire quire) {
        this.quire = quire;
    }

    public Techprocess getTechprocess() {
        return techprocess;
    }

    public void setTechprocess(Techprocess techprocess) {
        this.techprocess = techprocess;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public QuireTechprocess() {
    }
}
