package com.digitwolf.cmyk.client.controllers;

import com.digitwolf.cmyk.client.DataServiceAsync;
import com.digitwolf.cmyk.client.events.MachineCreatedEvent;
import com.digitwolf.cmyk.client.events.MachineDeletedEvent;
import com.digitwolf.cmyk.client.events.MachinesLoadedEvent;
import com.digitwolf.cmyk.client.events.navigation.*;
import com.digitwolf.cmyk.client.models.Machine;
import com.digitwolf.cmyk.client.modules.client.CmykWidgetGinjector;
import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.Label;
import com.github.gwtbootstrap.client.ui.Modal;
import com.github.gwtbootstrap.client.ui.ModalFooter;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import net.customware.gwt.presenter.client.EventBus;

import java.util.ArrayList;

public class DataController {

    private DataServiceAsync dataServiceAsync;
    private EventBus eventBus;
    private CmykWidgetGinjector ginjector;

    @Inject
    public DataController(final DataServiceAsync dataServiceAsync, final EventBus eventBus,
                          final CmykWidgetGinjector ginjector) {
        this.dataServiceAsync = dataServiceAsync;
        this.eventBus = eventBus;
        this.ginjector = ginjector;
        bind();
    }

    public void addMachine(Machine machine) {
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

    public void loadMachines() {
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
                ginjector.getMachineEditPresenter().createNewMachine();
            }
        });

        eventBus.addHandler(ShowMachineEditDialogEvent.TYPE, new ShowMachineEditDialogEventHandler() {
            @Override
            public void onShowMachineEditDialog(ShowMachineEditDialogEvent event) {
                ginjector.getMachineEditPresenter().editMachine(event.getMachine());
            }
        });

        eventBus.addHandler(RequestMachineDelete.TYPE, new RequestMachineDeleteHandler() {
            @Override
            public void onRequestMachineDelete(final RequestMachineDelete deleteEvent) {
                final Modal confirmDelete = new Modal(true, true);
                confirmDelete.setTitle("Подтвердите удаление");
                confirmDelete.add(new Label("Удалить " + deleteEvent.getMachine().getName() + "?"));

                confirmDelete.add(new ModalFooter(new Button("Да", IconType.OK, new ClickHandler() {

                    @Override
                    public void onClick(final ClickEvent event) {
                        dataServiceAsync.deleteMachine(deleteEvent.getMachine(), new AsyncCallback<Void>() {
                            @Override
                            public void onFailure(Throwable caught) {
                                // TODO handle error
                            }

                            @Override
                            public void onSuccess(Void result) {
                                eventBus.fireEvent(new MachineDeletedEvent(deleteEvent.getMachine()));
                            }
                        });
                        confirmDelete.hide();
                    }
                }),
                new Button("Нет", IconType.OK, new ClickHandler() {
                    @Override
                    public void onClick(final ClickEvent event) {
                        confirmDelete.hide();
                    }
                })));

                confirmDelete.show();
            }
        });
    }
}
