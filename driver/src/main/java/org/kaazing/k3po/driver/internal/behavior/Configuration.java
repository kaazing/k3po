/*
 * Copyright 2014, Kaazing Corporation. All rights reserved.
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

package org.kaazing.k3po.driver.internal.behavior;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.el.ExpressionFactory;

import org.jboss.netty.channel.ChannelPipeline;
import org.kaazing.k3po.driver.internal.netty.bootstrap.ClientBootstrap;
import org.kaazing.k3po.driver.internal.netty.bootstrap.LazyClientBootstrap;
import org.kaazing.k3po.driver.internal.netty.bootstrap.ServerBootstrap;
import org.kaazing.k3po.lang.internal.RegionInfo;

public class Configuration {

    private List<ServerBootstrap> serverBootstraps;
    private List<ClientBootstrap> clientBootstraps;
    private List<LazyClientBootstrap> lazyClientBootstraps;
    private List<ChannelPipeline> pipelines;
    private Set<Barrier> barriers;
    private ExpressionFactory factory;
    private Map<RegionInfo, List<ChannelPipeline>> serverPipelinesByRegion;

    public List<ChannelPipeline> getClientAndServerPipelines() {
        if (pipelines == null) {
            pipelines = new ArrayList<ChannelPipeline>();
        }
        return pipelines;
    }

    public List<ChannelPipeline> getServerPipelines(RegionInfo regionInfo) {
        if (serverPipelinesByRegion == null) {
            serverPipelinesByRegion = new HashMap<RegionInfo, List<ChannelPipeline>>();
        }

        List<ChannelPipeline> serverPipelines = serverPipelinesByRegion.get(regionInfo);
        if (serverPipelines == null) {
            serverPipelines = new ArrayList<ChannelPipeline>();
            serverPipelinesByRegion.put(regionInfo, serverPipelines);
        }
        return serverPipelines;
    }

    public ExpressionFactory getExpressionFactory() {
        if (factory == null) {
            factory = ExpressionFactory.newInstance();
        }

        return factory;
    }

    public List<ServerBootstrap> getServerBootstraps() {
        if (serverBootstraps == null) {
            serverBootstraps = new ArrayList<ServerBootstrap>();
        }

        return serverBootstraps;
    }

    public List<ClientBootstrap> getClientBootstraps() {
        if (clientBootstraps == null) {
            clientBootstraps = new ArrayList<ClientBootstrap>();
        }

        return clientBootstraps;
    }

    public List<LazyClientBootstrap> getLazyClientBootstraps() {
        if (lazyClientBootstraps == null) {
            lazyClientBootstraps = new ArrayList<LazyClientBootstrap>();
        }

        return lazyClientBootstraps;
    }

    public Set<Barrier> getBarriers() {
        if (barriers == null) {
            barriers = new HashSet<Barrier>();
        }
        return barriers;
    }

}