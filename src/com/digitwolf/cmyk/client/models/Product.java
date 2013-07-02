package com.digitwolf.cmyk.client.models;

import com.google.gwt.user.client.rpc.IsSerializable;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.util.List;

/**
 * Complete product. ie. book
 * User: RyB
 * Date: 27.06.13
 * Time: 17:03
 * To change this template use File | Settings | File Templates.
 */
public class Product implements IsSerializable {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;

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
