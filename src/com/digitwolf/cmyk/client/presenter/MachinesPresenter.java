package com.digitwolf.cmyk.client.presenter;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.digitwolf.cmyk.client.controllers.DataController;
import com.digitwolf.cmyk.client.events.MachinesLoadedEvent;
import com.digitwolf.cmyk.client.events.navigation.ShowAddMachineDialogEvent;
import com.digitwolf.cmyk.client.models.Machine;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.view.client.HasData;
import com.google.inject.Inject;

public class MachinesPresenter extends WidgetPresenter<MachinesPresenter.Display> implements MachinesLoadedEvent.Handler {
	
	
	
	private DataController dataController;

	@Inject
	public MachinesPresenter(final Display display, final EventBus eventBus, final DataController dataController) {
		super(display, eventBus);
		bind();
		this.dataController = dataController;
		this.dataController.loadMachines();	
		
	}

	public interface Display extends WidgetDisplay{
		HasData<Machine> getMachinesData();
		HasClickHandlers getAddButton();
	}

	@Override
	protected void onBind() {
		registerHandler(eventBus.addHandler(MachinesLoadedEvent.TYPE, this));
		registerHandler(display.getAddButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new ShowAddMachineDialogEvent());				
			}
		}));
	}

	@Override
	protected void onUnbind() {
		
	}

	@Override
	protected void onRevealDisplay() {
		this.dataController.loadMachines();		
	}
		

	@Override
	public void onMachinesLoaded(MachinesLoadedEvent event) {
		this.display.getMachinesData().setRowData(0, event.getMachines());		
	}
	
	

}
