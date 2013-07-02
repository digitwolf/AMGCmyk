package com.digitwolf.cmyk.client.presenter;

import com.digitwolf.cmyk.client.controllers.DataController;
import com.digitwolf.cmyk.client.events.MachinesLoadedEvent;
import com.digitwolf.cmyk.client.events.navigation.RequestMachineDelete;
import com.digitwolf.cmyk.client.events.navigation.ShowAddMachineDialogEvent;
import com.digitwolf.cmyk.client.events.navigation.ShowMachineEditDialogEvent;
import com.digitwolf.cmyk.client.models.Machine;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.HasData;
import com.google.inject.Inject;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

public class MachinesPresenter extends WidgetPresenter<MachinesPresenter.Display> implements MachinesLoadedEvent.Handler {

    private DataController dataController;

    @Inject
    public MachinesPresenter(final Display display, final EventBus eventBus, final DataController dataController) {
        super(display, eventBus);
        bind();
        this.dataController = dataController;
        this.dataController.loadMachines();

    }

    @Override
    protected void onBind() {
        // Machine list load event handler
        registerHandler(eventBus.addHandler(MachinesLoadedEvent.TYPE, this));

        // Add machine button handler
        registerHandler(display.getAddButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                eventBus.fireEvent(new ShowAddMachineDialogEvent(new AsyncCallback<Machine>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        //todo implement
                    }

                    @Override
                    public void onSuccess(Machine result) {
                        dataController.loadMachines();
                    }
                }));
            }
        }));

        getDisplay().getEditColumn().setFieldUpdater(new FieldUpdater<Machine, String>() {
            @Override
            public void update(int index, Machine object, String value) {
                eventBus.fireEvent(new ShowMachineEditDialogEvent(object, new AsyncCallback<Machine>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        //To change body of implemented methods use File | Settings | File Templates.
                    }

                    @Override
                    public void onSuccess(Machine result) {
                        dataController.loadMachines();
                    }
                }));
            }
        });

        getDisplay().getDeleteColumn().setFieldUpdater(new FieldUpdater<Machine, String>() {
            @Override
            public void update(int index, Machine object, String value) {
                eventBus.fireEvent(new RequestMachineDelete(object, new AsyncCallback<Machine>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        //To change body of implemented methods use File | Settings | File Templates.
                    }

                    @Override
                    public void onSuccess(Machine result) {
                        dataController.loadMachines();
                    }
                }));
            }
        });
    }

    @Override
    protected void onUnbind() {

    }

    @Override
    protected void onRevealDisplay() {
        this.dataController.loadMachines();
    }

    /**
     * Machine list load event handler
     * @param event
     */
    @Override
    public void onMachinesLoaded(MachinesLoadedEvent event) {
        this.display.getMachinesData().setRowData(0, event.getMachines());
    }

    public interface Display extends WidgetDisplay {
        /**
         * Gets the table data object.
         * Can be used for changing data as well.
         * @return table data.
         */
        HasData<Machine> getMachinesData();

        /**
         * Add new machine button
         *
         * @return has click handler object
         */
        HasClickHandlers getAddButton();

        Column<Machine, String> getEditColumn();

        Column<Machine, String> getDeleteColumn();
    }


}
