package entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
@Table("wallet")
data class Wallet(
        @Id
        @Column("id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @Column("balance") val balance: BigDecimal)
