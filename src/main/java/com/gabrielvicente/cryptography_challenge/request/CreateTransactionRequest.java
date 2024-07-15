package com.gabrielvicente.cryptography_challenge.request;

public record CreateTransactionRequest(String userDocument,
                                       String creditCardToken,
                                       Long transactionValue) {
}
