/*
 * Created by Michael Carrara <michael.carrara@breadwallet.com> on 9/18/19.
 * Copyright (c) 2018 Breadwinner AG.  All right reserved.
 *
 * See the LICENSE file at the project root for license information.
 * See the CONTRIBUTORS file at the project root for a list of contributors.
 */
package com.blockset.walletkit.nativex;

public enum WKTransferSubmitErrorType {

    UNKNOWN {
        @Override
        public int toCore() {
            return UNKNOWN_VALUE;
        }
    },

    POSIX {
        @Override
        public int toCore() {
            return POSIX_VALUE;
        }
    },

    AUTHENTICATOR {
        @Override
        public int toCore() {
            return AUTHENTICATOR_VALUE;
        }
    },

    EMAIL {
        @Override
        public int toCore() {
            return EMAIL_VALUE;
        }
    };

    private static final int UNKNOWN_VALUE = 11;
    private static final int POSIX_VALUE = 20;
    private static final int AUTHENTICATOR_VALUE = 12;
    private static final int EMAIL_VALUE = 13;

    public static WKTransferSubmitErrorType fromCore(int nativeValue) {
        switch (nativeValue) {
            case UNKNOWN_VALUE: return UNKNOWN;
            case POSIX_VALUE:   return POSIX;
            case AUTHENTICATOR_VALUE: return AUTHENTICATOR;
            case EMAIL_VALUE: return EMAIL;
            default: throw new IllegalArgumentException("Invalid core value");
        }
    }

    public abstract int toCore();
}
