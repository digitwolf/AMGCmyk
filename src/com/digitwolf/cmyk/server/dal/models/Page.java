package com.digitwolf.cmyk.server.dal.models;

import javax.jdo.annotations.*;

/**
 * Print page
 * User: RyB
 * Date: 27.06.13
 * Time: 17:03
 * To change this template use File | Settings | File Templates.
 */
public class Page {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private Key id;

    @Persistent
    private Quire quire;

    public Page() {
    }
}
