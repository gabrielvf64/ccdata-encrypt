package com.gabrielvicente.cryptography_challenge.entity;

import com.gabrielvicente.cryptography_challenge.service.CryptoService;
import jakarta.persistence.*;

@Entity
@Table(name = "transaction")
public class TransactionEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column
    private String encryptedUserDocument;

    @Column
    private String encryptedCreditCardToken;

    @Column
    private Long transactionValue;

    @Transient
    private String userDocument;

    @Transient
    private String creditCardToken;

    public TransactionEntity() {
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getEncryptedUserDocument() {
        return encryptedUserDocument;
    }

    public void setEncryptedUserDocument(String encryptedUserDocument) {
        this.encryptedUserDocument = encryptedUserDocument;
    }

    public String getEncryptedCreditCardToken() {
        return encryptedCreditCardToken;
    }

    public void setEncryptedCreditCardToken(String encryptedCreditCardToken) {
        this.encryptedCreditCardToken = encryptedCreditCardToken;
    }

    public Long getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(Long transactionValue) {
        this.transactionValue = transactionValue;
    }

    public String getUserDocument() {
        return userDocument;
    }

    public void setUserDocument(String userDocument) {
        this.userDocument = userDocument;
    }

    public String getCreditCardToken() {
        return creditCardToken;
    }

    public void setCreditCardToken(String creditCardToken) {
        this.creditCardToken = creditCardToken;
    }

    @PrePersist
    public void prePersist() {
        this.encryptedUserDocument = CryptoService.encrypt(this.userDocument);
        this.encryptedCreditCardToken = CryptoService.encrypt(this.creditCardToken);
    }

    @PostLoad
    public void postLoad() {
        this.userDocument = CryptoService.decrypt(this.encryptedUserDocument);
        this.creditCardToken = CryptoService.decrypt(this.encryptedCreditCardToken);
    }
}
