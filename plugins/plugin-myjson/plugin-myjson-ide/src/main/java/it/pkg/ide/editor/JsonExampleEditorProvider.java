/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package it.pkg.ide.editor;

import javax.inject.Inject;
import org.eclipse.che.ide.api.editor.EditorProvider;
import org.eclipse.che.ide.api.editor.defaulteditor.AbstractTextEditorProvider;
import org.eclipse.che.ide.api.editor.editorconfig.TextEditorConfiguration;

/** The JSON Example specific {@link EditorProvider}. */
public class JsonExampleEditorProvider extends AbstractTextEditorProvider {

  private JsonExampleEditorConfigurationProvider jsonExampleEditorConfigurationProvider;

  /**
   * @param jsonExampleEditorConfigurationProvider the JSON Example Editor configuration provider
   */
  @Inject
  public JsonExampleEditorProvider(
      final JsonExampleEditorConfigurationProvider jsonExampleEditorConfigurationProvider) {
    this.jsonExampleEditorConfigurationProvider = jsonExampleEditorConfigurationProvider;
  }

  @Override
  public String getId() {
    return "JsonExampleEditor";
  }

  @Override
  public String getDescription() {
    return "JSON Example Editor";
  }

  @Override
  protected TextEditorConfiguration getEditorConfiguration() {
    return jsonExampleEditorConfigurationProvider.get();
  }
}
