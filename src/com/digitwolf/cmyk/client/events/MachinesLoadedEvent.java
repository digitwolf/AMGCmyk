package com.digitwolf.cmyk.client.events;

import java.util.List;

import com.digitwolf.cmyk.client.models.Machine;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

public class MachinesLoadedEvent extends GwtEvent<MachinesLoadedEvent.Handler> {

	private final List<Machine> machines;
	
	public static final Type<Handler> TYPE = new Type<Handler>();
	 
	public MachinesLoadedEvent(List<Machine> machines) {
		super();
		this.machines = machines;
	}
	
	public interface Handler extends EventHandler {
	    void onMachinesLoaded(MachinesLoadedEvent event);
	  }
	
	 @Override
	  public Type<Handler> getAssociatedType() {
	    return TYPE;
	  }
	
	  @Override
	  protected void dispatch(Handler handler) {
	    handler.onMachinesLoaded(this);
	  }
	  
	  /**
	   * Register event handler
	   * @param eventBus
	   * @param handler
	   * @return
	   */
	  public static HandlerRegistration register(EventBus eventBus, Handler handler) {
		    return eventBus.addHandler(TYPE, handler);
		  }

	  public List<Machine> getMachines() {
		return machines;
	}

}
