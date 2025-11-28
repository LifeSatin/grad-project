package gradproj.demo.audio;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@Slf4j
@RequiredArgsConstructor
public class AudioService {

    public void uploadFile(String fileId, MultipartFile file) {
            String uploadDir = "/files/";
            if (file.isEmpty()) {
                log.info("file is empty");
            } else {
                log.info("file is not empty");
                try {
                    log.info("uploading files...");
                    File dest = new File(uploadDir + fileId + ".mp3");
                    file.transferTo(dest);
                    log.info("saved to: " + dest.getAbsolutePath());
                } catch (Exception e) {
                    log.info("file upload error");
                    log.info(e.getMessage());
                    return;
                }
            }

            try {
                Path path = Path.of(uploadDir, fileId + ".mp3");
                log.info("exists: " + Files.exists(path));
            } catch (Exception e) {
                log.info("exception raised");
                log.info(e.getMessage());
            }
            log.info("function ended");
    }
}
