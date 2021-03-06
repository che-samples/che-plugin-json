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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.che.ide.api.editor.codeassist.CodeAssistCallback;
import org.eclipse.che.ide.api.editor.codeassist.CodeAssistProcessor;
import org.eclipse.che.ide.api.editor.codeassist.CompletionProposal;
import org.eclipse.che.ide.api.editor.texteditor.TextEditor;
import org.eclipse.che.ide.rest.AsyncRequestCallback;
import org.eclipse.che.ide.rest.Unmarshallable;

/** JSON Example specific code assist processor. */
public class JsonExampleCodeAssistProcessor implements CodeAssistProcessor {

  private final JsonExampleCodeAssistClient client;
  private final Unmarshallable<List<String>> unmarshaller;
  private String errorMessage;

  /**
   * Constructor.
   *
   * @param client the client for retrieving completions
   */
  @Inject
  public JsonExampleCodeAssistProcessor(final JsonExampleCodeAssistClient client) {
    this.client = client;
    this.unmarshaller = new StringListUnmarshaller();
    this.errorMessage = null;
  }

  @Override
  public void computeCompletionProposals(
      final TextEditor editor,
      final int offset,
      final boolean triggered,
      final CodeAssistCallback callback) {
    final List<CompletionProposal> proposals = new ArrayList<>();

    proposals.addAll(
        Arrays.asList(
            new SimpleCompletionProposal("firstName"),
            new SimpleCompletionProposal("lastName"),
            new SimpleCompletionProposal("age")));

    client.computeProposals(
        new AsyncRequestCallback<List<String>>(unmarshaller) {
          @Override
          protected void onSuccess(List<String> additionalProposals) {
            errorMessage = null;

            for (String additionalProposal : additionalProposals) {
              proposals.add(new SimpleCompletionProposal(additionalProposal));
            }
            callback.proposalComputed(proposals);
          }

          @Override
          protected void onFailure(Throwable exception) {
            errorMessage = exception.getMessage();
          }
        });
  }

  @Override
  public String getErrorMessage() {
    return errorMessage;
  }
}
