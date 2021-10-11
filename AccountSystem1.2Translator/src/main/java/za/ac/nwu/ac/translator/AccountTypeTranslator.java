package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.util.List;

public interface AccountTypeTranslator {


    //AccountTypeDto getAccountTypeByMnemonic(String mnemonic);

    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto create(AccountTypeDto accountTypeDto);

    AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic);

    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);

    //AccountTransactionDto create(AccountTransactionDto );
}
