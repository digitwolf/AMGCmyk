/**
 * 
 */
package com.digitwolf.cmyk.client.view;

import com.digitwolf.cmyk.client.DataService;
import com.digitwolf.cmyk.client.DataServiceAsync;
import com.digitwolf.cmyk.client.models.Machine;
import com.digitwolf.cmyk.client.presenter.MachinesPresenter.Display;
import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.ButtonCell;
import com.github.gwtbootstrap.client.ui.CellTable;
import com.github.gwtbootstrap.client.ui.Label;
import com.github.gwtbootstrap.client.ui.Modal;
import com.github.gwtbootstrap.client.ui.ModalFooter;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.AsyncHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.HasData;

/**
 * @author RyB
 *
 */
public class MachinesView extends Composite implements Display{

	private static MachinesViewUiBinder uiBinder = GWT
			.create(MachinesViewUiBinder.class);

	interface MachinesViewUiBinder extends UiBinder<Widget, MachinesView> {
	}
	
	@UiField
	CellTable<Machine> table;

	@UiField
	Button addButton;
	
	public MachinesView() {
		initWidget(uiBinder.createAndBindUi(this));
		initColumns();		
	}

	// TODO move to presenter
	private void initColumns() {
		
		TextColumn<Machine> nameColumn = new TextColumn<Machine>() {

			@Override
			public String getValue(Machine object) {			
				return object.getName();
			}
		};
		
		table.addColumn(nameColumn,"Название");	
			
		
		table.addColumn(new TextColumn<Machine>() {

			@Override
			public String getValue(Machine object) {			
				return object.getDescription();
			}
		},"Описание");	
		
		ButtonCell editButtonCell = new ButtonCell(IconType.EDIT);
		
		Column<Machine, String> editColumn = new Column<Machine, String>(editButtonCell) {
			  @Override
			  public String getValue(Machine object) {
			    // The value to display in the button.
			    return "";
			  }
			};
			table.addColumn(editColumn, "Изменить");

			//You can then set a FieldUpdater on the Column to be notified of clicks.
			editColumn.setFieldUpdater(new FieldUpdater<Machine, String>() {
			  public void update(final int index, final Machine object, final String value) {
			    				  
				  // TODO fire ShowMachineAddDialogEvent
			  }
			});
		
			
			
		ButtonCell deleteButtonCell = new ButtonCell();
		deleteButtonCell.setIcon(IconType.REMOVE);
		Column<Machine, String> buttonColumn = new Column<Machine, String>(deleteButtonCell) {
		  @Override
		  public String getValue(Machine object) {
		    // The value to display in the button.
		    return "";
		  }
		};
		table.addColumn(buttonColumn, "Удалить");

		//You can then set a FieldUpdater on the Column to be notified of clicks.
		buttonColumn.setFieldUpdater(new FieldUpdater<Machine, String>() {
		  public void update(final int index, final Machine object, final String value) {
		    // Value is the button value.  Object is the row object.
			
			  final Modal confirmDelete = new Modal(true, true);
			  confirmDelete.setTitle("Подтвердите удаление");
			  confirmDelete.add(new Label("Удалить "+object.getName()+"?"));
			  
			  confirmDelete.add(new ModalFooter(new Button("Да",IconType.OK, new ClickHandler() {
				
					@Override
					public void onClick(final ClickEvent event) {
						
						confirmDelete.hide();					
					}
				} )));
			 
			  confirmDelete.show(); 
		  }
		});
		//table.addColumn(deleteColumn);
		
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

}
