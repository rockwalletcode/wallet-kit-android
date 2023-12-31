/*
 * Created by Michael Carrara <michael.carrara@breadwallet.com> on 7/1/19.
 * Copyright (c) 2019 Breadwinner AG.  All right reserved.
*
 * See the LICENSE file at the project root for license information.
 * See the CONTRIBUTORS file at the project root for a list of contributors.
 */
package com.blockset.walletkit.brd.systemclient;

import com.blockset.walletkit.SystemClient.SubscriptionEndpoint;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.google.common.base.Preconditions.checkNotNull;

public class BlocksetSubscriptionEndpoint implements SubscriptionEndpoint {

    // creators

    @JsonCreator
    public static BlocksetSubscriptionEndpoint create(@JsonProperty("kind") String kind,
                                                      @JsonProperty("environment") String environment,
                                                      @JsonProperty("value") String value) {
        return new BlocksetSubscriptionEndpoint(
                checkNotNull(kind),
                checkNotNull(environment),
                checkNotNull(value)
        );
    }

    // fields

    private final String kind;
    private final String environment;
    private final String value;

    private BlocksetSubscriptionEndpoint(String kind,
                                         String environment,
                                         String value) {
        this.kind = kind;
        this.environment = environment;
        this.value = value;
    }

    // getters

    @Override
    @JsonProperty("environment")
    public String getEnvironment() {
        return environment;
    }

    @Override
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @Override
    @JsonProperty("value")
    public String getValue() {
        return value;
    }
}
