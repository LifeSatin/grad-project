package gradproj.demo.audio;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class AudioService {

    public void uploadFile(String fileId, MultipartFile file) {
        try {
            if (!file.isEmpty()) {file.transferTo(new File(fileId + ".mp3"));}
        } catch (Exception e) {
            log.info("file upload error");
            log.info(e.getMessage());
            return;
        }
        log.info("file upload success");
    }
}
