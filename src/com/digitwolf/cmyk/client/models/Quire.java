package com.digitwolf.cmyk.client.models;

import com.google.gwt.user.client.rpc.IsSerializable;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.util.List;

/**
 * A sheet of paper
 * User: RyB
 * Date: 27.06.13
 * Time: 17:03
 * To change this template use File | Settings | File Templates.
 */
public class Quire implements IsSerializable {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;

    @Persistent
    private String name;

    @Persistent
    private Block block;

    @Persistent(mappedBy = "quire")
    private List<QuireTechprocess> techprocesses;

    @Persistent(mappedBy = "quire")
    private List<Page> pages;

    public Quire() {
    }
}
