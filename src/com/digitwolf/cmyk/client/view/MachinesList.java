package com.digitwolf.cmyk.client.view;

import com.digitwolf.cmyk.client.DataService;
import com.digitwolf.cmyk.client.models.Machine;
import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Руслан
 * Date: 10.06.13
 * Time: 17:21
 * To change this template use File | Settings | File Templates.
 */
public class MachinesList extends Composite {
    interface MachinesListUiBinder extends UiBinder<Widget, MachinesList> {
    }

    private static MachinesListUiBinder ourUiBinder = GWT.create(MachinesListUiBinder.class);

    @UiField
    ListBox listBox;

    @UiField
    Button addButton;

    @UiHandler("addButton")
    public void handleClick(ClickEvent event) {
        Machine machine = new Machine();
        machine.setName("Test1");
        
		DataService.Util.getInstance().addMachine(machine, new AsyncCallback<Machine>() {
            @Override
            public void onFailure(Throwable caught) {
                //To change body of implemented methods use File | Settings | File Templates.
            	
            }

            @Override
            public void onSuccess(Machine result) {
                loadMachines();
            }
        });
    }

    public MachinesList() {
        initWidget(ourUiBinder.createAndBindUi(this));

        loadMachines();
    }

    private void loadMachines() {
        DataService.Util.getInstance().getMachines(new AsyncCallback<ArrayList<Machine>>() {
            @Override
            public void onFailure(Throwable caught) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onSuccess(ArrayList<Machine> result) {
                listBox.clear();

                for (Machine machine : result) {
                    listBox.addItem(machine.getName());
                }
            }
        });

    }


}