package com.luxoft.msa.controllers

import com.luxoft.msa.repositories.WalletRepository
import com.luxoft.msa.services.WalletService
import entities.Wallet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/wallets")
class WalletController(val repo: WalletRepository) {

    @Autowired
    private lateinit var walletService: WalletService

    @GetMapping
    fun getAll() = repo.findAll()

    @GetMapping("/{id}")
    fun getByLastName(@PathVariable id: Long) = repo.findWallet(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody wallet: Wallet) = repo.save(wallet)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) = repo.deleteById(id)

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun replenish(@PathVariable id: Long, balance: BigDecimal) = walletService.replenish(id, balance)
}