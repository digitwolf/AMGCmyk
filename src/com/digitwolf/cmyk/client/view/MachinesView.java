/**
 * 
 */
package com.digitwolf.cmyk.client.view;

import com.digitwolf.cmyk.client.models.Machine;
import com.digitwolf.cmyk.client.models.providers.MachineAsyncProvider;
import com.digitwolf.cmyk.client.presenter.MachinesPresenter.Display;
import com.github.gwtbootstrap.client.ui.*;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.AsyncHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;

/**
 * @author RyB
 *
 */
public class MachinesView extends Composite implements Display{

	private static MachinesViewUiBinder uiBinder = GWT
			.create(MachinesViewUiBinder.class);
    FieldUpdater<Machine, String> editButtonClickHandler;
    FieldUpdater<Machine, String> deleteButtonClickHandler;

	@UiField
	CellTable<Machine> table;
    @UiField
    DataGrid<Machine> dataGrid;
    @UiField
    SimplePager pager;
	@UiField
	Button addButton;
    private Column<Machine, String> editColumn;
    private Column<Machine, String> deleteColumn;


    public MachinesView() {
		initWidget(uiBinder.createAndBindUi(this));
		initColumns();
        initGrid();
	}
	
    private void initGrid() {
        /*
     * Do not refresh the headers every time the data is updated. The footer
     * depends on the current data, so we do not disable auto refresh on the
     * footer.
     */
        dataGrid.setAutoHeaderRefreshDisabled(true);

        // Set the message to display when the table is empty.
        dataGrid.setEmptyTableWidget(new Label("There are no entries."));
        pager.setDisplay(dataGrid);


        // Add a selection model so we can select cells.
        final SelectionModel<Machine> selectionModel =
                new MultiSelectionModel<Machine>(MachineAsyncProvider.KEY_PROVIDER);
        dataGrid.setSelectionModel(selectionModel, DefaultSelectionEventManager.<Machine> createCheckboxManager());

        // Initialize the columns.
        initTableColumns(selectionModel);
    }

    /**
     * Add the columns to the table.
     */
    private void initTableColumns(final SelectionModel<Machine> selectionModel) {
        // First name.
        Column<Machine, String> nameColumn =
                new Column<Machine, String>(new EditTextCell()) {
                    @Override
                    public String getValue(Machine object) {
                        return object.getName();
                    }
                };
        nameColumn.setSortable(true);

        dataGrid.addColumn(nameColumn, "Название");
//        firstNameColumn.setFieldUpdater(new FieldUpdater<Machine, String>() {
//            @Override
//            public void update(int index, Machine object, String value) {
//                // Called when the user changes the value.
//                object.setFirstName(value);
//                ContactDatabase.get().refreshDisplays();
//            }
//        });
        dataGrid.setColumnWidth(nameColumn, 20, Style.Unit.PCT);

    }

    // TODO move to presenter
	private void initColumns() {

		TextColumn<Machine> nameColumn = new TextColumn<Machine>() {

			@Override
			public String getValue(Machine object) {
				return object.getName();
			}
		};
        nameColumn.setSortable(true);
		table.addColumn(nameColumn, "Название");

		table.addColumn(new TextColumn<Machine>() {

			@Override
			public String getValue(Machine object) {
				return object.getDescription();
			}
		},"Описание");

        // Edit button
        ButtonCell editButtonCell = new ButtonCell(IconType.EDIT);
		editColumn = new Column<Machine, String>(editButtonCell) {
			  @Override
			  public String getValue(Machine object) {
			    // the caption of the button
			    return "";
			  }
		};
		table.addColumn(editColumn, "Изменить");

		//You can then set a FieldUpdater on the Column to be notified of clicks.
		editColumn.setFieldUpdater(this.editButtonClickHandler);



        ButtonCell deleteButtonCell = new ButtonCell();
		deleteButtonCell.setIcon(IconType.REMOVE);
		deleteColumn = new Column<Machine, String>(deleteButtonCell) {
		  @Override
		  public String getValue(Machine object) {
		    // The value to display in the button.
		    return "";
		  }
		};
		table.addColumn(deleteColumn, "Удалить");
        table.setRowCount(20);


		// Add a ColumnSortEvent.AsyncHandler to connect sorting to the
	    // AsyncDataPRrovider.
		AsyncHandler columnSortHandler = new AsyncHandler(table);

	    table.addColumnSortHandler(columnSortHandler);

	    // We know that the data is sorted alphabetically by default.
	    table.getColumnSortList().push(nameColumn);
	}

	@Override
	public HasData<Machine> getMachinesData() {
		return this.table;
	}

	@Override
	public HasClickHandlers getAddButton() {
		return this.addButton;
	}

    @Override
    public Column<Machine, String> getEditColumn() {
        return this.editColumn;
    }

    @Override
    public Column<Machine, String> getDeleteColumn() {
        return this.deleteColumn;
    }

    interface MachinesViewUiBinder extends UiBinder<Widget, MachinesView> {
	}

}
