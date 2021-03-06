/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package it.pkg.ide.project;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;

/** Implementation of the {@link SchemaUrlPageView}. */
class SchemaUrlPageViewImpl extends Composite implements SchemaUrlPageView {

  @UiField TextBox schemaUrl;
  private SchemaUrlChangedDelegate delegate;

  /**
   * Constructor.
   *
   * @param uiBinder the UI binder that initializes the page
   */
  @Inject
  public SchemaUrlPageViewImpl(JsonExamplePageViewUiBinder uiBinder) {
    initWidget(uiBinder.createAndBindUi(this));
  }

  /** {@inheritDoc} */
  @Override
  public void setDelegate(SchemaUrlChangedDelegate delegate) {
    this.delegate = delegate;
  }

  /**
   * Update handler for the schema URL field.
   *
   * @param event the event that caused the schemaUrl field to update
   */
  @UiHandler("schemaUrl")
  void onSchemaUrlChanged(KeyUpEvent event) {
    delegate.schemaUrlChanged(schemaUrl.getValue());
  }

  /** UI binder for our page. */
  interface JsonExamplePageViewUiBinder extends UiBinder<DockLayoutPanel, SchemaUrlPageViewImpl> {}
}
