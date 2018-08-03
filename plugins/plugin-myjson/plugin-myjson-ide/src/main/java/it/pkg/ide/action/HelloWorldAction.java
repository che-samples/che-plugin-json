/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package it.pkg.ide.action;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.api.app.AppContext;
import org.eclipse.che.ide.api.notification.NotificationManager;
import org.eclipse.che.ide.api.notification.StatusNotification;

/** Action for showing a string via the {@link NotificationManager}. */
@Singleton
public class HelloWorldAction extends JsonExampleProjectAction {

  private NotificationManager notificationManager;

  /**
   * Constructor.
   *
   * @param appContext the IDE application context
   * @param notificationManager the notification manager used to display 'Hello World'
   */
  @Inject
  public HelloWorldAction(AppContext appContext, NotificationManager notificationManager) {
    super(appContext, "Say Hello World", "Say Hello World Action", null);
    this.notificationManager = notificationManager;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    this.notificationManager.notify(
        "Hello World",
        StatusNotification.Status.SUCCESS,
        StatusNotification.DisplayMode.FLOAT_MODE);
  }
}
