package com.blockset.walletkit.brd.systemclient;

import static com.google.common.base.Preconditions.checkNotNull;

import com.blockset.walletkit.SystemClient;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BlocksetNegTxThreadID implements SystemClient.NegTxThreadID {

    @JsonCreator
    public static BlocksetNegTxThreadID create(@JsonProperty("threadId") String id) {
        return new BlocksetNegTxThreadID(
                checkNotNull(id)
        );
    }

    private final String id;
    @Override
    @JsonProperty("threadId")
    public String getID() {
        return id;
    }

    private BlocksetNegTxThreadID(String id) {
        this.id = id;
    }
}
