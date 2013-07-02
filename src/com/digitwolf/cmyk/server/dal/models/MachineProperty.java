package com.digitwolf.cmyk.server.dal.models;

import com.google.gwt.user.client.rpc.IsSerializable;

import javax.jdo.annotations.*;

/**
 * Created with IntelliJ IDEA.
 * User: Руслан
 * Date: 16.06.13
 * Time: 20:35
 * To change this template use File | Settings | File Templates.
 */

@PersistenceCapable(detachable = "true", identityType = IdentityType.APPLICATION)
public class MachineProperty implements IsSerializable {

	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
    @PrimaryKey
    private Key id;

    @Persistent
    private String name;

    @Persistent
    private String description;

    @Persistent
    private String value;

    @Persistent
    private Machine machine;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }
}
