/*******************************************************************************
 * oltpbenchmark.com
 *  
 *  Project Info:  http://oltpbenchmark.com
 *  Project Members:    Carlo Curino <carlo.curino@gmail.com>
 *              Evan Jones <ej@evanjones.ca>
 *              DIFALLAH Djellel Eddine <djelleleddine.difallah@unifr.ch>
 *              Andy Pavlo <pavlo@cs.brown.edu>
 *              CUDRE-MAUROUX Philippe <philippe.cudre-mauroux@unifr.ch>  
 *                  Yang Zhang <yaaang@gmail.com> 
 * 
 *  This library is free software; you can redistribute it and/or modify it under the terms
 *  of the GNU General Public License as published by the Free Software Foundation;
 *  either version 3.0 of the License, or (at your option) any later version.
 * 
 *  This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *  See the GNU Lesser General Public License for more details.
 ******************************************************************************/
package com.oltpbenchmark.catalog;

/**
 * 
 * @author Carlo A. Curino (carlo@curino.us)
 */
public class IntegrityConstraintsExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public IntegrityConstraintsExistsException() {
		// TODO Auto-generated constructor stub
	}

	public IntegrityConstraintsExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public IntegrityConstraintsExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public IntegrityConstraintsExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
