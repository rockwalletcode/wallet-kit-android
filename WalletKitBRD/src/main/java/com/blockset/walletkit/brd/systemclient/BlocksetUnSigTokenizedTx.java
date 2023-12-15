package com.blockset.walletkit.brd.systemclient;

import static com.google.common.base.Preconditions.checkNotNull;

import com.blockset.walletkit.SystemClient;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.primitives.UnsignedLong;

public class BlocksetUnSigTokenizedTx implements SystemClient.UnSigTokenizedTx {

    @JsonCreator
    public static BlocksetUnSigTokenizedTx create(@JsonProperty("amount") UnsignedLong amount,
                                                  @JsonProperty("expandedTx") BlocksetNegotiatedTransaction tx,
                                                  @JsonProperty("recipient") String recipient,
                                                  @JsonProperty("threadId") String threadId) {

        return new BlocksetUnSigTokenizedTx(
                amount,
                checkNotNull(tx),
                recipient,
                threadId
        );
    }

    private final SystemClient.NegotiatedTransaction tx;
    private final UnsignedLong amount;
    private final String recipient;
    private final String threadId;

    private BlocksetUnSigTokenizedTx(UnsignedLong amount,
                                     SystemClient.NegotiatedTransaction tx,
                                     String recipient,
                                     String threadId) {
        this.amount = amount;
        this.tx = tx;
        this.recipient = recipient;
        this.threadId = threadId;
    }

    @Override
    public String getTransaction() {
        return tx.getTransaction();
    }

    @JsonProperty("tx")
    public SystemClient.NegotiatedTransaction getTx() {
        return tx;
    }
    @JsonProperty("amount")
    public UnsignedLong getAmount() {
        return amount;
    }

    @JsonProperty("recipient")
    public String getRecipient() {
        return recipient;
    }

    @JsonProperty("threadId")
    public String getThreadId() {
        return threadId;
    }
}
