/*
 * Copyright 2000-2013 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.tools;

import com.intellij.openapi.actionSystem.ex.ActionManagerEx;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.StoragePathMacros;
import com.intellij.openapi.options.SchemeProcessor;
import com.intellij.openapi.options.SchemesManagerFactory;
import org.jetbrains.annotations.NotNull;

/**
 * @author traff
 */
public class ToolManager extends BaseToolManager<Tool> {
  public ToolManager(ActionManagerEx actionManagerEx,
                     SchemesManagerFactory factory) {
    super(actionManagerEx, factory);
  }

  @Override
  protected String getSchemesPath() {
    return StoragePathMacros.ROOT_CONFIG + "/tools";
  }

  @Override
  protected SchemeProcessor<ToolsGroup<Tool>> createProcessor() {
    return new ToolsProcessor<Tool>() {

      @Override
      protected ToolsGroup<Tool> createToolsGroup(String groupName) {
        return new ToolsGroup<Tool>(groupName);
      }

      @Override
      protected Tool createTool() {
        return new Tool();
      }
    };
  }

  @Override
  protected String getActionIdPrefix() {
    return Tool.ACTION_ID_PREFIX;
  }

  public static ToolManager getInstance() {
    return ApplicationManager.getApplication().getComponent(ToolManager.class);
  }

  @Override
  @NotNull
  public String getComponentName() {
    return "ToolManager";
  }
}
