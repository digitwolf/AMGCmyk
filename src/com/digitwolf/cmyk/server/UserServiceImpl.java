/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.digitwolf.cmyk.server;

import com.digitwolf.cmyk.client.UserService;
import com.digitwolf.cmyk.client.models.LoginInfo;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UserServiceImpl extends RemoteServiceServlet implements UserService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Gets the information about user, login and logout urls.
	 */
	@Override
	public LoginInfo getLoginInfo() {
		com.google.appengine.api.users.UserService userService = UserServiceFactory.getUserService();
		
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setLoggedIn(userService.isUserLoggedIn());
		
		if(userService.isUserLoggedIn()){
			User user = userService.getCurrentUser();
			loginInfo.setDomain(user.getAuthDomain());
			loginInfo.setEmail(user.getEmail());
			loginInfo.setFederatedIdentity(user.getFederatedIdentity());
			loginInfo.setLogin(user.getNickname());
			loginInfo.setUserId(user.getUserId());
			loginInfo.setAdmin(userService.isUserAdmin());
			
			loginInfo.setLogoutUrl(userService.createLogoutURL("/"));
		}else{
			loginInfo.setLoginUrl(userService.createLoginURL("/"));
		}
		
		return loginInfo;
	}
}
