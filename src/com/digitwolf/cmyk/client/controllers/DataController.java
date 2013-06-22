package com.digitwolf.cmyk.client.controllers;

import java.util.ArrayList;

import net.customware.gwt.presenter.client.EventBus;

import com.digitwolf.cmyk.client.DataServiceAsync;
import com.digitwolf.cmyk.client.events.MachineCreatedEvent;
import com.digitwolf.cmyk.client.events.MachinesLoadedEvent;
import com.digitwolf.cmyk.client.events.navigation.ShowAddMachineDialogEvent;
import com.digitwolf.cmyk.client.models.Machine;
import com.digitwolf.cmyk.client.view.MachineEditView;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

public class DataController {

	private DataServiceAsync dataServiceAsync;
	private EventBus eventBus;

	@Inject
	public DataController(final DataServiceAsync dataServiceAsync, final EventBus eventBus) {
		this.dataServiceAsync = dataServiceAsync;
		this.eventBus = eventBus;	
		bind();
	}
	
	public void addMachine(Machine machine){
		this.dataServiceAsync.addMachine(machine, new AsyncCallback<Machine>() {
			
			@Override
			public void onSuccess(Machine result) {
				eventBus.fireEvent(new MachineCreatedEvent(result));
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	public void loadMachines(){
		this.dataServiceAsync.getMachines(new AsyncCallback<ArrayList<Machine>>() {
			
			@Override
			public void onSuccess(ArrayList<Machine> result) {
				eventBus.fireEvent(new MachinesLoadedEvent(result));				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	private void bind() {
		eventBus.addHandler(ShowAddMachineDialogEvent.TYPE, new ShowAddMachineDialogEvent.Handler() {
			
			@Override
			public void ShowAddMachineDialog(ShowAddMachineDialogEvent event) {
				MachineEditView editView = new MachineEditView();
				editView.show();
			}
		});
	}
}
