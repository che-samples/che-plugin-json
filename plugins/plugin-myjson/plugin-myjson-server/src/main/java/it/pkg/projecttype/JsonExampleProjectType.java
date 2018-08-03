/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package it.pkg.projecttype;

import static it.pkg.shared.Constants.JSON_EXAMPLE_LANG;
import static it.pkg.shared.Constants.JSON_EXAMPLE_PROJECT_TYPE_ID;
import static it.pkg.shared.Constants.LANGUAGE;

import com.google.inject.Inject;
import it.pkg.shared.Constants;
import org.eclipse.che.api.project.server.type.ProjectTypeDef;

/** The JSON Example project type. */
public class JsonExampleProjectType extends ProjectTypeDef {

  /** Constructor for the JSON example project type. */
  @Inject
  public JsonExampleProjectType() {
    super(JSON_EXAMPLE_PROJECT_TYPE_ID, JSON_EXAMPLE_PROJECT_TYPE_ID, true, false);
    addConstantDefinition(LANGUAGE, LANGUAGE, JSON_EXAMPLE_LANG);
    addVariableDefinition(
        Constants.JSON_EXAMPLE_SCHEMA_REF_ATTRIBUTE, "Referenced base schema", /*required*/ true);
  }
}
