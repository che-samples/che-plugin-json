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
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.che.ide.api.app.AppContext;
import org.eclipse.che.ide.rest.AsyncRequestCallback;
import org.eclipse.che.ide.rest.AsyncRequestFactory;
import org.eclipse.che.ide.ui.loaders.request.LoaderFactory;

/** Client for retrieving a list of valid completions from a server service. */
@Singleton
public class JsonExampleCodeAssistClient {

  private final AppContext appContext;
  private final AsyncRequestFactory asyncRequestFactory;
  private final LoaderFactory loaderFactory;

  /**
   * Constructor.
   *
   * @param appContext the IDE application context
   * @param asyncRequestFactory asynchronous request factory for creating the server request
   * @param loaderFactory the loader factory for displaying a message during loading
   */
  @Inject
  public JsonExampleCodeAssistClient(
      AppContext appContext, AsyncRequestFactory asyncRequestFactory, LoaderFactory loaderFactory) {
    this.appContext = appContext;
    this.asyncRequestFactory = asyncRequestFactory;
    this.loaderFactory = loaderFactory;
  }

  public void computeProposals(AsyncRequestCallback<List<String>> callback) {
    String url = appContext.getWsAgentServerApiEndpoint() + "/json-example-completions/";
    asyncRequestFactory
        .createGetRequest(url, false)
        .loader(loaderFactory.newLoader("Loading example completions..."))
        .send(callback);
  }
}
