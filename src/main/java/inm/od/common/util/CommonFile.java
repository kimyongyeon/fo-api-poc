package inm.od.common.util;

import java.util.function.Consumer;

public class CommonFile implements CommonFileInter {
    @Override
    public void fileUpload() {

    }

    @Override
    public void fileDownload() {

    }

    @Override
    public void fileUpload(Consumer param) {
        param.accept("hello world");
    }


    public static void main(String[] args) {
        CommonFileInter commonFile = new CommonFile();
        commonFile.fileUpload();
        commonFile.fileDownload();

        commonFile.fileUpload((param) -> {
            System.out.println("File uploaded successfully :: " + param);
        });
    }
}
