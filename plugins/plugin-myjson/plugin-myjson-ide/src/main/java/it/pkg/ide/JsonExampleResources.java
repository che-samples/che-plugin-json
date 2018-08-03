/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package it.pkg.ide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import org.vectomatic.dom.svg.ui.SVGResource;

public interface JsonExampleResources extends ClientBundle {

  JsonExampleResources INSTANCE = GWT.create(JsonExampleResources.class);

  @Source("svg/icon.svg")
  SVGResource icon();

  @Source("svg/completion.svg")
  SVGResource completion();
}
