/*
 * Created by Michael Carrara <michael.carrara@breadwallet.com> on 11/5/19.
 * Copyright (c) 2019 Breadwinner AG.  All right reserved.
 *
 * See the LICENSE file at the project root for license information.
 * See the CONTRIBUTORS file at the project root for a list of contributors.
 */
package com.blockset.walletkit.brd.systemclient;

import com.blockset.walletkit.errors.SystemClientError;
import com.blockset.walletkit.utility.CompletionHandler;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkState;

/* package */
class GetChunkedCoordinator<ChunkType, ResultType> {

    private final List<List<ChunkType>> chunks;
    private final List<ResultType> transactions;
    private final CompletionHandler<List<ResultType>, SystemClientError> handler;

    private SystemClientError error;

    /* package */
    GetChunkedCoordinator(List<List<ChunkType>> chunks,
                          CompletionHandler<List<ResultType>, SystemClientError> handler) {

        this.chunks = new ArrayList<>(chunks);
        this.transactions = new ArrayList<>();
        this.handler = handler;
    }

    /* package */
    void handleChunkData(List<ChunkType> chunk, List<ResultType> data) {
        boolean transitionToSuccess = false;

        synchronized (this) {
            checkState(!isInSuccessState());

            if (!isInErrorState()) {
                chunks.remove(chunk);
                transactions.addAll(data);
                transitionToSuccess = isInSuccessState();
            }
        }

        if (transitionToSuccess) {
            handleSuccess();
        }
    }

    /* package */
    void handleError(SystemClientError error) {
        boolean transitionToError = false;

        synchronized (this) {
            checkState(!isInSuccessState());

            if (!isInErrorState()) {
                this.error = error;
                transitionToError = isInErrorState();
            }
        }

        if (transitionToError) {
            handleFailure();
        }
    }

    private boolean isInErrorState() {
        return error != null;
    }

    private boolean isInSuccessState() {
        return chunks.isEmpty();
    }

    private void handleSuccess() {
        handler.handleData(transactions);
    }

    private void handleFailure() {
        handler.handleError(error);
    }
}
