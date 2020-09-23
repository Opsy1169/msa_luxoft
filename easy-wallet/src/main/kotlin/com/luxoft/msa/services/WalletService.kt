package com.luxoft.msa.services

import com.luxoft.msa.repositories.WalletRepository
import entities.Wallet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.math.BigDecimal

@Service
class WalletService{
    @Autowired
    private lateinit var repo : WalletRepository

    fun replenish(fromId: Long, balanceToMove: BigDecimal) : Mono<Boolean> {
        return repo.findWallet(fromId).map {
            if (balanceToMove < BigDecimal.ZERO) {
                if (it.balance >= balanceToMove) {
                    it.balance.add(balanceToMove)
                } else {
                    return@map Mono.just(false)
                }
            }
            it.balance.add(balanceToMove)
        }.then(Mono.just(true))
    }


}