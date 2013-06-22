package com.digitwolf.cmyk.client;

import com.digitwolf.cmyk.client.models.LoginInfo;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserServiceAsync {

	void getLoginInfo(AsyncCallback<LoginInfo> callback);

}
