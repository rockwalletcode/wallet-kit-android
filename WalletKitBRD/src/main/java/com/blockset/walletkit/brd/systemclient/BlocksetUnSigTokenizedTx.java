package com.blockset.walletkit.brd.systemclient;

import static com.google.common.base.Preconditions.checkNotNull;

import com.blockset.walletkit.SystemClient;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BlocksetUnSigTokenizedTx implements SystemClient.UnSigTokenizedTx {

    @JsonCreator
    public static BlocksetUnSigTokenizedTx create(@JsonProperty("expandedTx") SystemClient.NegotiatedTransaction tx) {
        return new BlocksetUnSigTokenizedTx(
                checkNotNull(tx)
        );
    }

    private final SystemClient.NegotiatedTransaction tx;

    private BlocksetUnSigTokenizedTx(SystemClient.NegotiatedTransaction tx) {
        this.tx = tx;
    }

    @Override
    public String getTransaction() {
        return tx.getTransaction();
    }
}
