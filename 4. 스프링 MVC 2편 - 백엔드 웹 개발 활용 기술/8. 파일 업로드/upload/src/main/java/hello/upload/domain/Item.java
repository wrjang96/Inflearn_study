package hello.upload.domain;

import lombok.Data;

import java.util.List;

@Data
public class Item {
    private Long id;
    private String itemName;
    private UploadFile attachFile;
    private List<UploadFile> imageFiles;
    // 이미지 같은 경우는 여러개의 파일을 업로드 할 수 있어야 함
}
