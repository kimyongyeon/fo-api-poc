package inm.od.common.sys.common.context;

public class ApiResponseContext {
    private static final ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    public static void setTransactionId(Object transactionId) {
        threadLocal.set(transactionId);
    }

    public static Object getTransactionId() {
        return threadLocal.get();
    }

    public static void clear() {
        threadLocal.remove();
    }
}
