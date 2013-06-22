package com.digitwolf.cmyk.client;

import com.digitwolf.cmyk.client.modules.client.CmykWidgetGinjector;
import com.digitwolf.cmyk.client.presenter.AppPresenter;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CMYK implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	
	private final CmykWidgetGinjector injector = GWT.create(CmykWidgetGinjector.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final AppPresenter appPresenter = injector.getAppPresenter();
        appPresenter.go(RootPanel.get());
	}
}
