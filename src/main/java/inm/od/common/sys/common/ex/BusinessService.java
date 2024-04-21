package inm.od.common.sys.common.ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class BusinessService {

    @Autowired
    TransactionTemplate transactionTemplate;


}