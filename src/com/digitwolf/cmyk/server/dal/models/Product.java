package com.digitwolf.cmyk.server.dal.models;

import javax.jdo.annotations.*;
import java.util.List;

/**
 * Complete product. ie. book
 * User: RyB
 * Date: 27.06.13
 * Time: 17:03
 * To change this template use File | Settings | File Templates.
 */
public class Product {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key id;

    @Persistent
    private String name;

    /**
     * A set of blocks, which are combined together into the product.
     */
    @Persistent(mappedBy = "product")
    private List<Block> blocks;

    public Product() {
    }
}
