/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package it.pkg.ide.editor;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import it.pkg.ide.JsonExampleResources;
import org.eclipse.che.ide.api.editor.codeassist.CompletionProposal;
import org.eclipse.che.ide.api.icon.Icon;

/**
 * A very simple implementation of a {@link CompletionProposal} that basically only contains a
 * string.
 */
public class SimpleCompletionProposal implements CompletionProposal {

  private String proposal;

  /**
   * Constructor.
   *
   * @param proposal the actual proposal
   */
  public SimpleCompletionProposal(String proposal) {
    this.proposal = proposal;
  }

  @Override
  public void getAdditionalProposalInfo(AsyncCallback<Widget> callback) {
    callback.onSuccess(null);
  }

  @Override
  public String getDisplayString() {
    return proposal;
  }

  @Override
  public Icon getIcon() {
    return new Icon("", JsonExampleResources.INSTANCE.completion());
  }

  @Override
  public void getCompletion(CompletionCallback callback) {
    callback.onCompletion(new SimpleCompletion(proposal));
  }
}
