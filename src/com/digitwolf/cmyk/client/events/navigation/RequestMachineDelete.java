package com.digitwolf.cmyk.client.events.navigation;

import com.digitwolf.cmyk.client.models.Machine;
import com.google.gwt.event.shared.GwtEvent;

/**
 * Created with IntelliJ IDEA.
 * User: RyB
 * Date: 23.06.13
 * Time: 17:20
 * To change this template use File | Settings | File Templates.
 */
public class RequestMachineDelete extends GwtEvent<RequestMachineDeleteHandler> {
    public static Type<RequestMachineDeleteHandler> TYPE = new Type<RequestMachineDeleteHandler>();

    private final Machine machine;

    public RequestMachineDelete(Machine machine) {
        this.machine = machine;
    }

    public Type<RequestMachineDeleteHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(RequestMachineDeleteHandler handler) {
        handler.onRequestMachineDelete(this);
    }

    public Machine getMachine() {
        return machine;
    }
}
