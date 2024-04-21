package inm.od.common.sys.common.event;

public class DataSourceEvent {
    private final Object data;
    private final String dataSource;

    public DataSourceEvent(Object data, String dataSource) {
        this.data = data;
        this.dataSource = dataSource;
    }

    public Object getData() {
        return data;
    }

    public String getDataSource() {
        return dataSource;
    }
}
