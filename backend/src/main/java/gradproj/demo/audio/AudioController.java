package gradproj.demo.audio;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/file")
public class AudioController {

    @GetMapping()
    public ResponseEntity<Resource> getFile(String fileName) throws IOException {
        Path path = Paths.get("/home/ec2-user/gradprod/grad-project/backend/src/main/resources/work/Tomcat/localhost/ROOT/" + fileName + ".mp3");
        Resource resource = new FileSystemResource(path);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("audio/mpeg")) // mp3라면
                .body(resource);
    }
}
