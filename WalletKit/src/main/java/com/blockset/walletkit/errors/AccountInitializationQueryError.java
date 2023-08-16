/*
 * Created by Michael Carrara.
 * Copyright (c) 2019 Breadwinner AG.  All right reserved.
 *
 * See the LICENSE file at the project root for license information.
 * See the CONTRIBUTORS file at the project root for a list of contributors.
 */
package com.blockset.walletkit.errors;

public final class AccountInitializationQueryError extends AccountInitializationError {
    SystemClientError systemClientError;

    public AccountInitializationQueryError(SystemClientError systemClientError) {
        this.systemClientError = systemClientError;
    }

    public SystemClientError getQueryError() {
        return systemClientError;
    }
}
