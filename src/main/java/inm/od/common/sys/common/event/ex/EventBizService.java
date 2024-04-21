package inm.od.common.sys.common.event.ex;

import inm.od.common.sys.common.event.CentralizedEventHandler;
import inm.od.common.sys.common.event.DataSourceEvent;
import inm.od.common.sys.common.event.DataSourceOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EventBizService {
    @Autowired
    private CentralizedEventHandler eventHandler;

    public void updateBusinessData(Object data) {
        DataSourceEvent event = new DataSourceEvent(data, "MultiDataSourceOperation");
        List<DataSourceOperation> operations = Arrays.asList(
                () -> updateDataSource1(data),
                () -> updateDataSource2(data),
                () -> updateDataSource3(data),
                () -> updateDataSource4(data)
        );
        eventHandler.processEvent(event, operations);
    }

    private void updateDataSource1(Object data) { /* 업데이트 로직 */ }
    private void updateDataSource2(Object data) { /* 업데이트 로직 */ }
    private void updateDataSource3(Object data) { /* 업데이트 로직 */ }
    private void updateDataSource4(Object data) { /* 업데이트 로직 */ }
}
