package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountTransaction", description = "a DTO that represents AccountTransaction")
public class AccountTransactionDto implements Serializable {

    private Long transactionId;
    private Long memberId;
    private Long amount;
    private LocalDate transactionDate;

    public AccountTransactionDto(Long memberId, Long amount, LocalDate transactionDate) {
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDto(Long memberId, Long transactionId, Long amount) {
        this.memberId = memberId;
        this.transactionId = transactionId;
        this.amount = amount;
        this.transactionDate = LocalDate.now();
    }

    public AccountTransactionDto(AccountTransaction accountTransaction) {
        this.setMemberId(accountTransaction.getMemberId());
        this.setAmount(accountTransaction.getAmount());
        this.setTransactionDate(accountTransaction.getTrDate());
    }

    public AccountTransactionDto() {
    }

   @ApiModelProperty(position = 1,
            value = "transactionId",
            name = "transactionId",
            notes = "Uniquely identifies the account type for the transaction on the account",
            dataType = "java.lang.Long",
            example = "10000",
            required = true)

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    @ApiModelProperty(
            position = 2,
            value = "Member ID",
            name = "memberId",
            notes = "Uniquely identifies a member",
            dataType = "java.lang.String",
            example = "1111",
            required = true
    )

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @ApiModelProperty(
            position = 3,
            value = "Amount",
            name = "Amount",
            notes = "Amount on the member's account",
            dataType = "java.lang.String",
            example = "200",
            required = true
    )

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @ApiModelProperty(
            position = 4,
            value = "Transaction Date",
            name = "transactionDate",
            notes = "The date the transaction occurred",
            dataType = "java.lang.String",
            example = "2021-02-01",
            required = true
    )

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @JsonIgnore
    public AccountTransaction getTransaction(AccountType accountType){
        return new AccountTransaction(this.getTransactionId(), accountType, this.getMemberId(), this.getAmount(), this.getTransactionDate());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, memberId, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "transactionId=" + transactionId +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }


}

