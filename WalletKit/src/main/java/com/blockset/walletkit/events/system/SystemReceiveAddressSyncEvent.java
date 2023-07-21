/*
 * Created by Michael Carrara <michael.carrara@breadwallet.com> on 7/1/19.
 * Copyright (c) 2019 Breadwinner AG.  All right reserved.
*
 * See the LICENSE file at the project root for license information.
 * See the CONTRIBUTORS file at the project root for a list of contributors.
 */
package com.blockset.walletkit.events.system;

import com.blockset.walletkit.WalletManager;

public class SystemReceiveAddressSyncEvent implements SystemEvent {

    public SystemReceiveAddressSyncEvent(WalletManager walletManager) {
        walletManager.receiveAddressSync();
    }

    @Override
    public <T> T accept(SystemEventVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
