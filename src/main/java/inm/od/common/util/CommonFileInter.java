package inm.od.common.util;

import java.util.function.Consumer;

public interface CommonFileInter {

    void fileUpload();

    void fileDownload();

    void fileUpload(Consumer param);
}
