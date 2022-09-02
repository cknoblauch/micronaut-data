/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.data.cosmos.config;

import com.azure.cosmos.CosmosClientBuilder;
import io.micronaut.context.annotation.ConfigurationBuilder;
import io.micronaut.context.annotation.ConfigurationProperties;

import static io.micronaut.data.cosmos.config.CosmoClientConfiguration.PREFIX;

/**
 * The default Azure Cosmo configuration class.
 *
 * @author Denis Stepanov
 * @since TODO
 */
@ConfigurationProperties(PREFIX)
public final class CosmoClientConfiguration {

    public static final String PREFIX = "azure.cosmos";

    @ConfigurationBuilder(prefixes = "")
    protected CosmosClientBuilder cosmosClientBuilder = new CosmosClientBuilder();

    private boolean defaultGatewayMode;

    private boolean endpointDiscoveryEnabled;

    private boolean useThroughput;

    private boolean manualThroughput;

    private int throughputRate;

    private String databaseName;

    public CosmosClientBuilder getCosmosClientBuilder() {
        return cosmosClientBuilder;
    }

    public boolean isDefaultGatewayMode() {
        return defaultGatewayMode;
    }

    public void setDefaultGatewayMode(boolean defaultGatewayMode) {
        this.defaultGatewayMode = defaultGatewayMode;
        if (defaultGatewayMode) {
            cosmosClientBuilder.gatewayMode();
        }
    }

    public boolean isEndpointDiscoveryEnabled() {
        return endpointDiscoveryEnabled;
    }

    public void setEndpointDiscoveryEnabled(boolean endpointDiscoveryEnabled) {
        this.endpointDiscoveryEnabled = endpointDiscoveryEnabled;
        this.cosmosClientBuilder.endpointDiscoveryEnabled(endpointDiscoveryEnabled);
    }

    public void setUseThroughput(boolean useThroughput) {
        this.useThroughput = useThroughput;
    }

    public void setManualThroughput(boolean manualThroughput) {
        this.manualThroughput = manualThroughput;
    }

    public void setThroughputRate(int throughputRate) {
        this.throughputRate = throughputRate;
    }

    public ThroughputConfiguration getThroughputConfiguration() {
        return new ThroughputConfiguration(useThroughput, manualThroughput, throughputRate);
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
}
