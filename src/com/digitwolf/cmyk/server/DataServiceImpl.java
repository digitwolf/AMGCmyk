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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jdo.PersistenceManager;

import com.digitwolf.cmyk.client.DataService;
import com.digitwolf.cmyk.client.models.Machine;
import com.digitwolf.cmyk.server.dal.PMF;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class DataServiceImpl extends RemoteServiceServlet implements DataService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public ArrayList<Machine> getMachines() {
		final String DEFAULT_QUERY = "select e from " + Machine.class.getName() + " as e";
		
		ArrayList<Machine> res = new ArrayList<>();

        for (Machine machine : DataServiceImpl.<Machine>query(DEFAULT_QUERY))
        {
            res.add(machine);
        }

        return res;
    }

    @Override
    public Machine addMachine(Machine machine) {        
    	PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            pm.makePersistent(machine);
        } finally {
            pm.close();
        }
        return machine;
    }
    
    @SuppressWarnings("unchecked")
	private static <T> Collection<T> query(String query) {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            List<T> flights = (List<T>) pm.newQuery(query).execute();
            return pm.detachCopyAll(flights);
        } finally {
            pm.close();
        }
    }

	@Override
	public void deleteMachine(Machine machine) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            pm.deletePersistent(machine);
        } finally {
            pm.close();
        }
	}

	@Override
	public void updateMachine(Machine machine) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            pm.makePersistent(machine);
        } finally {
            pm.close();
        }
	}
}
