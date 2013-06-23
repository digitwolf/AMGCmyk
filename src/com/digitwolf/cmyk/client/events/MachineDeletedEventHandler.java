package com.digitwolf.cmyk.client.events;

import com.google.gwt.event.shared.EventHandler;

/**
 * Created with IntelliJ IDEA.
 * User: RyB
 * Date: 23.06.13
 * Time: 17:28
 * To change this template use File | Settings | File Templates.
 */
public interface MachineDeletedEventHandler extends EventHandler {
    void onMachineDeleted(MachineDeletedEvent event);
}
