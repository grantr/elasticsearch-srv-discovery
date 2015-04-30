/*
 * Copyright 2015 Grant Rodgers.
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

package org.elasticsearch.discovery.srv;

import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.discovery.Discovery;
import org.elasticsearch.discovery.zen.ZenDiscoveryModule;

/**
 *
 */
public class SrvDiscoveryModule extends ZenDiscoveryModule {

    @Inject
    public SrvDiscoveryModule(Settings settings) {
        addUnicastHostProvider(SrvUnicastHostsProvider.class);
    }

    @Override
    protected void bindDiscovery() {
        bind(Discovery.class).to(SrvDiscovery.class).asEagerSingleton();
    }
}
