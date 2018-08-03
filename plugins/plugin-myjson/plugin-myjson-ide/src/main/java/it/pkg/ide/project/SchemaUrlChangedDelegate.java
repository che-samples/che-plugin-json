/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package it.pkg.ide.project;

import it.pkg.shared.Constants;
import java.util.Collections;
import org.eclipse.che.api.workspace.shared.dto.ProjectConfigDto;
import org.eclipse.che.ide.api.project.MutableProjectConfig;

/** Simple delegate for updating the value of the schema URL. */
public class SchemaUrlChangedDelegate {

  private MutableProjectConfig dataObject;

  /**
   * Constructor that expects the {@link ProjectConfigDto} data object of the project being created.
   *
   * @param dataObject the {@link ProjectConfigDto} data object that holds the current value of the
   *     schema URL
   */
  public SchemaUrlChangedDelegate(MutableProjectConfig dataObject) {
    this.dataObject = dataObject;
  }

  /**
   * Updates the current value of the schema URL.
   *
   * @param url the new URL value
   */
  public void schemaUrlChanged(String url) {
    dataObject
        .getAttributes()
        .put(Constants.JSON_EXAMPLE_SCHEMA_REF_ATTRIBUTE, Collections.singletonList(url));
  }
}
