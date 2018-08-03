/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package it.pkg.ide.editor;

import com.google.inject.Inject;
import javax.inject.Provider;

/**
 * Guice Provider for HTML Editor configuration.
 *
 * @author Florent Benoit
 */
public class JsonExampleEditorConfigurationProvider
    implements Provider<JsonExampleEditorConfiguration> {

  @Inject private JsonExampleCodeAssistProcessor jsonExampleCodeAssistProcessor;

  /**
   * Build a new instance of HtmlEditor Configuration
   *
   * @return
   */
  @Override
  public JsonExampleEditorConfiguration get() {
    return new JsonExampleEditorConfiguration(jsonExampleCodeAssistProcessor);
  }
}
