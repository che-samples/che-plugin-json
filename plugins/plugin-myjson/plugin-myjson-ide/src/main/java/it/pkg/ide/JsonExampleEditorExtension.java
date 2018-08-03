/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package it.pkg.ide;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import it.pkg.ide.editor.JsonExampleEditorProvider;
import org.eclipse.che.ide.api.editor.EditorRegistry;
import org.eclipse.che.ide.api.extension.Extension;
import org.eclipse.che.ide.api.filetypes.FileType;

/** The editor extension for the JSON Example */
@Extension(title = "JSON Example Editor")
public class JsonExampleEditorExtension {

  /**
   * Constructor.
   *
   * @param editorRegistry the {@link EditorRegistry} for registering our editor
   * @param jsonFile the {@link FileType} that is associated with our editor
   * @param editorProvider the editor provider
   */
  @Inject
  public JsonExampleEditorExtension(
      final EditorRegistry editorRegistry,
      final @Named("JsonFileType") FileType jsonFile,
      final JsonExampleEditorProvider editorProvider) {
    editorRegistry.registerDefaultEditor(jsonFile, editorProvider);
  }
}
