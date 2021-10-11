package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.logging.Logger;


@Transactional
@Component("createAccountTransactionFlowName")
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {

    //private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTransactionFlowImpl.class)

    private final AccountTransactionTranslator translator;

    @Autowired
    public CreateAccountTransactionFlowImpl(AccountTransactionTranslator translator) {
        this.translator = translator;
    }

    @Override
    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto) {

        //LOGGER.info("The input object was {} ", accountTransactionDto);


        if (null == accountTransactionDto.getTransactionDate()) {
            accountTransactionDto.setTransactionDate(LocalDate.now());
        }
        return translator.create(accountTransactionDto);
    }

}
