/*
 * Created by Michael Carrara <michael.carrara@breadwallet.com> on 10/28/19.
 * Copyright (c) 2019 Breadwinner AG.  All right reserved.
 *
 * See the LICENSE file at the project root for license information.
 * See the CONTRIBUTORS file at the project root for a list of contributors.
 */
package com.blockset.walletkit;

import com.google.common.base.Optional;

public interface PaymentProtocolPayment {

    Optional<byte[]> encode();
}
