package com.blockset.walletkit.brd.systemclient;

import static com.google.common.base.Preconditions.checkNotNull;

import com.blockset.walletkit.SystemClient;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BlocksetNegotiatedTransaction implements SystemClient.NegotiatedTransaction {

    @JsonCreator
    public static BlocksetNegotiatedTransaction create(@JsonProperty("tx") String tx) {
        return new BlocksetNegotiatedTransaction(
                checkNotNull(tx)
        );
    }
    private final String transaction;
    @Override
    @JsonProperty("tx")
    public String getTransaction() {
        return transaction;
    }

    private BlocksetNegotiatedTransaction(String tx) {
        transaction = tx;
    }
}
