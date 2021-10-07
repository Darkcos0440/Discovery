package za.ac.nwu.ac.logic.flow.impl;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class FetchAccountTypeFlowimpl implements FetchAccountTypeFlow{

    private AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeFlowimpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    //public FetchAccountTypeFlow(AccountTypeTranslator accountTypeTranslator){
       // this.accountTypeTranslator = accountTypeTranslator;
    //}

    @Override
    public List<AccountTypeDto> getAllAccountTypes() {
        //List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        //accountTypeDtos.add(new AccountTypeDto("MILES", "Miles", LocalDate.now()));
        //return accountTypeDtos;
        return accountTypeTranslator.getAllAccountTypes();
    }
}
