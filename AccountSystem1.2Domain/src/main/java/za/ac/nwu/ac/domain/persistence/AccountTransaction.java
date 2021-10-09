package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNTTRANSACTION",schema = "ABIE")
public class AccountTransaction implements Serializable {

    private Long Account_Tr_Id;
    private AccountType accountType;
    private long MemberId;
    private  long Amount;
    private LocalDate TR_Date;

    public AccountTransaction(){

    }

    public AccountTransaction(Long transactionId, AccountType accountType, Long memberId, Long amount, LocalDate transactionDate) {
        this.Account_Tr_Id = transactionId;
        this.accountType = accountType;
        this.MemberId= memberId;
        this.Amount = amount;
        this.TR_Date = transactionDate;
    }

    @Id
    @SequenceGenerator(name="ACCOUNTTRANSACTION_SEQ", sequenceName = "HR.ACCOUNTTRANSACTION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNTTRANSACTION_SEQ")
    @Column(name = "TX_ID")
    public Long getTransactionId() {
        return Account_Tr_Id;
    }

    @Column(name = "MEMBERID")
    public Long getMemberId() {
        return MemberId;
    }

    @Column(name = "AMOUNT")
    public Long getAmount() {
        return Amount;
    }

    @Column(name = "TX_DATE")
    public LocalDate getTrDate() {
        return TR_Date;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType(){
        return accountType;
    }

    public void setTransactionId(Long transactionId) {
        this.Account_Tr_Id = transactionId;
    }

    public void setAccountTypeId(AccountType accountTypeId) {
        this.accountType = accountTypeId;
    }

    public void setMemberId(Long memberId) {
        this.MemberId = memberId;
    }

    public void setAmount(Long amount) {
        this.Amount = amount;
    }

    public void setTrDate(LocalDate transactionDate) {
        this.TR_Date = transactionDate;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionId=" + Account_Tr_Id +
                ", accountType=" + accountType +
                ", memberId=" + MemberId +
                ", amount=" + Amount +
                ", transactionDate=" + TR_Date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(Account_Tr_Id, that.Account_Tr_Id) && Objects.equals(accountType, that.accountType) && Objects.equals(MemberId, that.MemberId) && Objects.equals(Amount, that.Amount) && Objects.equals(TR_Date, that.TR_Date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Account_Tr_Id, accountType, MemberId, Amount, TR_Date);
    }
}


    //private static final long serialVersionUID = 1199041377884282633L;

    /*private Long transactionId;
    private AccountType accountType;
    private Long memberId;
    private Long amount;
    private LocalDate transactionDate;

    public AccountTransaction(Long accountTypeId, Long memberId, Long amount, LocalDate transactionDate) {
    }

    public AccountTransaction(Long transactionId, AccountType accountType, Long memberId, Long amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountType = accountType;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    @Id
    @SequenceGenerator(name = "ACCOUNTTRANSACTION_SEQ", sequenceName = "ABIE.ACCOUNTTRANSACTION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNTTRANSACTION_SEQ")
    @Column(name = "TX_ID")
    public Long getTransactionId() {
        return transactionId;
    }

    @Column(name = "MEMBER_ID")
    public Long getMemberId() {
        return memberId;
    }

    @Column(name = "AMOUNT")
    public Long getAmount() {
        return amount;
    }

    @Column(name = "TX_DATE")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType() {
        return accountType;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public void setAccountTypeId(AccountType accountTypeId) {
        this.accountType = accountTypeId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public AccountTransaction(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountType, that.accountType) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountType, memberId, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionId=" + transactionId +
                ", accountType=" + accountType +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }*/
