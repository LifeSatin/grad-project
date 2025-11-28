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
        if (file.isEmpty()) {
            log.info("file is empty");
        } else {
            log.info("file is not empty");
            try {
                file.transferTo(new File(fileId + ".mp3"));
            } catch (Exception e) {
                log.info("file upload error");
                log.info(e.getMessage());
                return;
            }
        }

        log.info("file upload success");
        try {
            log.info("exists: " + Files.exists(Path.of(new URI(fileId + ".mp3"))));
        } catch (URISyntaxException e) {
            log.info("URI wrong");
        } catch (Exception e) {
            log.info("exception raised");
        }
        log.info("function ended");
    }
}
