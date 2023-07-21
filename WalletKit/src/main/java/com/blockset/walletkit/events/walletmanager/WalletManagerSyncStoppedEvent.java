/*
 * Created by Michael Carrara <michael.carrara@breadwallet.com> on 7/1/19.
 * Copyright (c) 2019 Breadwinner AG.  All right reserved.
*
 * See the LICENSE file at the project root for license information.
 * See the CONTRIBUTORS file at the project root for a list of contributors.
 */
package com.blockset.walletkit.events.walletmanager;

import com.blockset.walletkit.WalletManagerSyncStoppedReason;

public final class WalletManagerSyncStoppedEvent implements WalletManagerEvent {

    private final WalletManagerSyncStoppedReason reason;

    public WalletManagerSyncStoppedEvent(WalletManagerSyncStoppedReason reason) {
        this.reason = reason;
    }

    public WalletManagerSyncStoppedReason getReason() {
        return reason;
    }

    @Override
    public <T> T accept(WalletManagerEventVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
