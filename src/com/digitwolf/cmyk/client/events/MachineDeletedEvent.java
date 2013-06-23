package com.digitwolf.cmyk.client.events;

import com.digitwolf.cmyk.client.models.Machine;
import com.google.gwt.event.shared.GwtEvent;

/**
 * Created with IntelliJ IDEA.
 * User: RyB
 * Date: 23.06.13
 * Time: 17:28
 * To change this template use File | Settings | File Templates.
 */
public class MachineDeletedEvent extends GwtEvent<MachineDeletedEventHandler> {
    public static Type<MachineDeletedEventHandler> TYPE = new Type<MachineDeletedEventHandler>();

    private final Machine machine;

    public MachineDeletedEvent(Machine machine) {
        this.machine = machine;
    }

    public Type<MachineDeletedEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(MachineDeletedEventHandler handler) {
        handler.onMachineDeleted(this);
    }

    public Machine getMachine() {
        return machine;
    }
}
