/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.web.attribute.handler;

import javax.servlet.http.HttpServletRequest;

import org.openmrs.customdatatype.CustomDatatype;
import org.openmrs.customdatatype.CustomDatatypeHandler;
import org.openmrs.customdatatype.InvalidCustomValueException;

/**
 * A web-layer extension of {@link CustomDatatypeHandler}, which generates the HTML for a widget, and handles the submission of that widget 
 */
public interface WebDatatypeHandler<DT extends CustomDatatype<T>, T> extends HtmlDisplayableDatatypeHandler<T> {
	
	/**
	 * Generates the HTML for a widget
	 * @param datatype the underlying datatype for this widget
	 * @param formFieldName the name the widget should submit with
	 * @param widgetId a unique id, generated by the web framework, that the widget should use
	 * @param startingValue the initial value for the generated HTML
	 * @return HTML for editing/creating a value of this datatype
	 */
	String getWidgetHtml(DT datatype, String formFieldName, String widgetId, T startingValue);
	
	/**
	 * Handles a form submission including a widget generated by this handler  
	 * @param datatype the underlying datatype for this widget
	 * @param request the submitted HTTP request
	 * @param formFieldName the same value passed to {@link #getWidgetHtml(CustomDatatype, String, String, Object)} when generating this widget
	 * @return a parsed and validated value submitted by the widget
	 * @throws InvalidCustomValueException
	 */
	T getValue(DT datatype, HttpServletRequest request, String formFieldName) throws InvalidCustomValueException;
	
}
