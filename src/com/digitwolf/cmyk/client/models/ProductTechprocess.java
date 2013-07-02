package com.digitwolf.cmyk.client.models;

import com.google.gwt.user.client.rpc.IsSerializable;

import javax.jdo.annotations.Extension;
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
public class ProductTechprocess implements IsSerializable {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;

    @Persistent
    private Product product;

    @Persistent
    private Techprocess techprocess;

    @Persistent
    private int order;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    public ProductTechprocess() {
    }
}
