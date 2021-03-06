/**
 * Copyright 2011 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtplatform.samples.tab.client.application.ui.tabs;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.TabData;
import com.gwtplatform.mvp.client.proxy.Gatekeeper;
import com.gwtplatform.samples.tab.client.application.adminarea.TabDataExt;
import com.gwtplatform.samples.tab.client.application.ui.linkmenu.LinkMenu;

/**
 * A {@link BaseTabPanel} styled to contain {@link RoundTab}.
 * <p/>
 * Look at {@link LinkMenu} to see how we can use this widget within a UiBinder file even though its constructor relies
 * on dependency injection.
 */
public class RoundTabPanel extends BaseTabPanel {
    public interface Binder extends UiBinder<Widget, RoundTabPanel> {
    }

    private final TabFactory tabFactory;

    @Inject
    RoundTabPanel(Binder binder,
            TabFactory tabFactory) {
        this.tabFactory = tabFactory;

        initWidget(binder.createAndBindUi(this));
    }

    @Override
    protected BaseTab createNewTab(TabData tabData) {
        Gatekeeper gatekeeper = null;
        if (tabData instanceof TabDataExt) {
            TabDataExt tabDataExt = (TabDataExt) tabData;
            gatekeeper = tabDataExt.getGatekeeper();
        }

        return tabFactory.createRoundTab(tabData, gatekeeper);
    }
}
