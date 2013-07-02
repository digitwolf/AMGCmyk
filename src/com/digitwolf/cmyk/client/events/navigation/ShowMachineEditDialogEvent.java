package com.digitwolf.cmyk.client.events.navigation;

import com.digitwolf.cmyk.client.models.Machine;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created with IntelliJ IDEA.
 * User: RyB
 * Date: 23.06.13
 * Time: 16:42
 * To change this template use File | Settings | File Templates.
 */
public class ShowMachineEditDialogEvent extends GwtEvent<ShowMachineEditDialogEventHandler> {
    public static Type<ShowMachineEditDialogEventHandler> TYPE = new Type<ShowMachineEditDialogEventHandler>();

    final private Machine machine;
    private AsyncCallback<Machine> callback;

    public ShowMachineEditDialogEvent(Machine machine) {
        this.machine = machine;
    }

    public ShowMachineEditDialogEvent(Machine machine, AsyncCallback<Machine> callback) {
        this.machine = machine;
        this.callback = callback;
    }

    public Type<ShowMachineEditDialogEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(ShowMachineEditDialogEventHandler handler) {
        handler.onShowMachineEditDialog(this);
    }

    public Machine getMachine() {
        return machine;
    }

    public AsyncCallback<Machine> getCallback() {
        return callback;
    }
}
