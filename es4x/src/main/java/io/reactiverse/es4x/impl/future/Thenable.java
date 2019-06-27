/*
 * Copyright 2018 Red Hat, Inc.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */
package io.reactiverse.es4x.impl.future;

import org.graalvm.polyglot.Value;

/**
 * Thenable Object.
 */
@FunctionalInterface
public interface Thenable {

  Object then(Value... arguments);

  static Value getFunction(Value[] arguments, int index) {
    if (arguments != null) {
      if (arguments.length > index) {
        Value value = arguments[index];
        if (value.canExecute()) {
          return value;
        }
      }
    }

    return null;
  }
}
