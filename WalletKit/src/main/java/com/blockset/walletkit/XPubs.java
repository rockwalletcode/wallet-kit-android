package com.blockset.walletkit;

public class XPubs {
    private String receiver;
    private String change;

    public XPubs(String receiver, String change) {
        this.receiver = receiver;
        this.change = change;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getChange() {
        return change;
    }
}
