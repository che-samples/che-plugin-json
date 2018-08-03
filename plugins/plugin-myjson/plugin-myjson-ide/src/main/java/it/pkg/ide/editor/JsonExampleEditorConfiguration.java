/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package it.pkg.ide.editor;

import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.che.ide.api.editor.codeassist.CodeAssistProcessor;
import org.eclipse.che.ide.api.editor.editorconfig.DefaultTextEditorConfiguration;
import org.eclipse.che.ide.api.editor.partition.DocumentPartitioner;

public class JsonExampleEditorConfiguration extends DefaultTextEditorConfiguration {

  private Map<String, CodeAssistProcessor> codeAssist;

  public JsonExampleEditorConfiguration(
      JsonExampleCodeAssistProcessor jsonExampleCodeAssistProcessor) {
    codeAssist = new LinkedHashMap<>();

    codeAssist.put(DocumentPartitioner.DEFAULT_CONTENT_TYPE, jsonExampleCodeAssistProcessor);
  }

  @Override
  public Map<String, CodeAssistProcessor> getContentAssistantProcessors() {
    return codeAssist;
  }
}
