package inm.od.common.sys.common.tran;

public interface TransactionCallback <T>{
    T doInTransaction();
}
