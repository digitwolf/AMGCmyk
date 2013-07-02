package com.digitwolf.cmyk.server.dal.models;

import com.google.appengine.api.datastore.Key;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.util.List;

/**
 * A set of same quires.
 * User: RyB
 * Date: 27.06.13
 * Time: 17:00
 * To change this template use File | Settings | File Templates.
 */
public class Block {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key id;

    @Persistent
    private String name;

    @Persistent
    private Product product;

    @Persistent(mappedBy = "block")
    private List<Quire> quires;

    @Persistent(mappedBy = "block")
    private List<BlockTechprocess> techprocesses;

    @Persistent
    private Paper paper;

    public Block() {
    }
}
