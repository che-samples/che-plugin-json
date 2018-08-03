/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package it.pkg.inject;

import static com.google.inject.multibindings.Multibinder.newSetBinder;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import it.pkg.JsonExampleCompletionService;
import it.pkg.JsonLocService;
import it.pkg.generator.JsonExampleCreateProjectHandler;
import it.pkg.projecttype.JsonExampleProjectType;
import org.eclipse.che.api.project.server.handlers.ProjectHandler;
import org.eclipse.che.api.project.server.type.ProjectTypeDef;
import org.eclipse.che.inject.DynaModule;

/** JSON Example Guice module for setting up project type, project wizard and service bindings. */
@DynaModule
public class JsonExampleGuiceModule extends AbstractModule {

  @Override
  protected void configure() {
    Multibinder<ProjectTypeDef> projectTypeDefMultibinder =
        newSetBinder(binder(), ProjectTypeDef.class);
    projectTypeDefMultibinder.addBinding().to(JsonExampleProjectType.class);

    Multibinder<ProjectHandler> projectHandlerMultibinder =
        newSetBinder(binder(), ProjectHandler.class);
    projectHandlerMultibinder.addBinding().to(JsonExampleCreateProjectHandler.class);

    bind(JsonLocService.class);
    bind(JsonExampleCompletionService.class);
  }
}
