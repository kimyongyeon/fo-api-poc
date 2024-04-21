package inm.od.common.sys.common.event;

@FunctionalInterface
public interface DataSourceOperation {
    void execute() throws Exception;
}
