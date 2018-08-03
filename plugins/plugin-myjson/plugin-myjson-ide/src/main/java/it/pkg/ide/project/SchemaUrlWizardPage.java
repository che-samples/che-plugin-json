/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package it.pkg.ide.project;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import org.eclipse.che.ide.api.project.MutableProjectConfig;
import org.eclipse.che.ide.api.wizard.AbstractWizardPage;

/** Simple wizard page that contains the {@link SchemaUrlPageView}. */
public class SchemaUrlWizardPage extends AbstractWizardPage<MutableProjectConfig> {

  private final SchemaUrlPageViewImpl view;

  /**
   * Constructor.
   *
   * @param view the view to be displayed.
   */
  @Inject
  public SchemaUrlWizardPage(SchemaUrlPageViewImpl view) {
    this.view = view;
  }

  @Override
  public void go(AcceptsOneWidget container) {
    container.setWidget(view);
    view.setDelegate(new SchemaUrlChangedDelegate(dataObject));
  }
}
