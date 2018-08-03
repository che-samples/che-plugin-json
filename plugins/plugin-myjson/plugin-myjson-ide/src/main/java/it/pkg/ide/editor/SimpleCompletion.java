/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package it.pkg.ide.editor;

import org.eclipse.che.ide.api.editor.codeassist.Completion;
import org.eclipse.che.ide.api.editor.document.Document;
import org.eclipse.che.ide.api.editor.text.LinearRange;

public class SimpleCompletion implements Completion {

  private final String proposal;

  public SimpleCompletion(String proposal) {
    this.proposal = proposal;
  }

  @Override
  public void apply(Document document) {
    document.replace(document.getCursorOffset(), proposal.length(), proposal);
  }

  @Override
  public LinearRange getSelection(Document document) {
    return null;
  }
}
