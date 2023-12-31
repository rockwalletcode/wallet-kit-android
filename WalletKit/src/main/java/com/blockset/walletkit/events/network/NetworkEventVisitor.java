/*
 * Created by Michael Carrara <michael.carrara@breadwallet.com> on 7/1/19.
 * Copyright (c) 2019 Breadwinner AG.  All right reserved.
*
 * See the LICENSE file at the project root for license information.
 * See the CONTRIBUTORS file at the project root for a list of contributors.
 */
package com.blockset.walletkit.events.network;

public interface NetworkEventVisitor<T> {

    T visit(NetworkCreatedEvent event);

    T visit(NetworkDeletedEvent event);

    T visit(NetworkUpdatedEvent event);

    T visit(NetworkFeesUpdatedEvent event);
}
