package votingvoter.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import votingvoter.Exceptions.FileNotFoundException;
import votingvoter.ModelService.DocumentService;

import java.io.IOException;

@Controller
@RequestMapping("/document")
@RequiredArgsConstructor
public class DocumentController {
    private final DocumentService documentService;
    @GetMapping("/list")
    public String displayUploadedFiles(Model model) throws IOException {
        model.addAttribute("contentFragment", "/frag/displayFiles");
        model.addAttribute("pageTitle", "Files");
        return "template";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws Exception {
        documentService.saveContent(file);
        return "redirect:/petition/list";
    }

    @GetMapping(value = "/upload/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public void getFile(@PathVariable Long id) throws Exception {
        documentService.getContent(id);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<?> handleFileNotFound(FileNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }
}
