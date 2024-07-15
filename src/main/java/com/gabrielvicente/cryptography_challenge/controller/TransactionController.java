package com.gabrielvicente.cryptography_challenge.controller;

import com.gabrielvicente.cryptography_challenge.request.CreateTransactionRequest;
import com.gabrielvicente.cryptography_challenge.response.TransactionResponse;
import com.gabrielvicente.cryptography_challenge.service.TransactionService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {

    private final TransactionService transactionService;


    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@RequestBody CreateTransactionRequest request) {
        transactionService.createTransaction(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<TransactionResponse>> listAll(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                             @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<TransactionResponse> response = transactionService.listAll(page, pageSize);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TransactionResponse> findById(@PathVariable Long id) {
        TransactionResponse response = transactionService.findById(id);
        return ResponseEntity.ok(response);
    }


}
