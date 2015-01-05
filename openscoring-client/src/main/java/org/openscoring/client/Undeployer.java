/*
 * Copyright (c) 2014 Villu Ruusmann
 *
 * This file is part of Openscoring
 *
 * Openscoring is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Openscoring is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Openscoring.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.openscoring.client;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openscoring.common.SimpleResponse;

public class Undeployer extends ModelApplication {

	static
	public void main(String... args) throws Exception {
		run(Undeployer.class, args);
	}

	@Override
	public void run() throws Exception {
		System.out.println(undeploy());
	}

	public SimpleResponse undeploy() throws Exception {
		Operation<SimpleResponse> operation = new Operation<SimpleResponse>(){

			@Override
			public SimpleResponse perform(WebTarget target){
				Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildDelete();

				return invocation.invoke(SimpleResponse.class);
			}
		};

		return execute(operation);
	}
}