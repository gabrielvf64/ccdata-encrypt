package com.gabrielvicente.cryptography_challenge.response;

import com.gabrielvicente.cryptography_challenge.entity.TransactionEntity;

public record TransactionResponse(Long id,
                                  String userDocument,
                                  String creditCardToken,
                                  Long transactionValue) {

    public static TransactionResponse toJson(TransactionEntity entity) {
        return new TransactionResponse(
                entity.getTransactionId(),
                entity.getUserDocument(),
                entity.getCreditCardToken(),
                entity.getTransactionValue()
        );
    }
}
