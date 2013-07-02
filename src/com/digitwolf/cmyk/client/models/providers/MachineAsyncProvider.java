package com.digitwolf.cmyk.client.models.providers;

import com.digitwolf.cmyk.client.controllers.DataController;
import com.digitwolf.cmyk.client.models.Machine;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.Range;
import com.google.inject.Inject;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: RyB
 * Date: 24.06.13
 * Time: 16:45
 * To change this template use File | Settings | File Templates.
 */
public class MachineAsyncProvider extends AsyncDataProvider<Machine> {

    /**
     * The key provider that provides the unique ID of a contact.
     */
    public static final ProvidesKey<Machine> KEY_PROVIDER = new ProvidesKey<Machine>() {
        @Override
        public Object getKey(Machine item) {
            return item == null ? null : item.getId();
        }
    };

    private DataController dataController;

    @Inject
    public MachineAsyncProvider(final DataController dataController) {
        this.dataController = dataController;
    }

    @Override
    protected void onRangeChanged(final HasData<Machine> display) {
        final Range range = display.getVisibleRange();

        dataController.loadMachinesAsync(new AsyncCallback<ArrayList<Machine>>() {
            @Override
            public void onFailure(Throwable caught) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onSuccess(ArrayList<Machine> result) {
                display.setRowData(0, result);
            }
        });
    }
}
