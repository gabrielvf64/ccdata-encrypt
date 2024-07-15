package com.gabrielvicente.cryptography_challenge.service;

import com.gabrielvicente.cryptography_challenge.entity.TransactionEntity;
import com.gabrielvicente.cryptography_challenge.repository.TransactionRepository;
import com.gabrielvicente.cryptography_challenge.request.CreateTransactionRequest;
import com.gabrielvicente.cryptography_challenge.response.TransactionResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void createTransaction(CreateTransactionRequest request) {
        TransactionEntity entity = new TransactionEntity();
        entity.setUserDocument(request.userDocument());
        entity.setCreditCardToken(request.creditCardToken());
        entity.setTransactionValue(request.transactionValue());
        transactionRepository.save(entity);
    }

    public Page<TransactionResponse> listAll(int page, int pageSize) {
        Page<TransactionEntity> transactions = transactionRepository.findAll(PageRequest.of(page, pageSize));
        return transactions.map(TransactionResponse::toJson);
    }

    public TransactionResponse findById(Long id) {
        TransactionEntity entity = transactionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return TransactionResponse.toJson(entity);
    }
}
