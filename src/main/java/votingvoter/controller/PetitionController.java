package votingvoter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import votingvoter.Model.Document;
import votingvoter.Model.Petition;
import votingvoter.Model.Vote;
import votingvoter.ModelService.DocumentService;
import votingvoter.ModelService.PetitionService;
import votingvoter.ModelService.VoteService;
import votingvoter.Repository.PetitionRepository;
import votingvoter.Security.user.PrincipalService;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/petition")
@RequiredArgsConstructor
public class PetitionController {
    private final PrincipalService principals;
    private final PetitionRepository petitionRep;
    private final PetitionService petitionService;
    private final VoteService voteService;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir" + "/uploads");

    @GetMapping("/{id}")
    public String viewPetition(Model model, @PathVariable("id") Long id, Principal principal){
        Petition petition =  petitionService.getPetiton(id);
        List<Vote> votes = voteService.getVotesByPetittion(petition);

        model.addAttribute("contentFragment", "/frag/petition/petition-view");
        model.addAttribute("pageTitle", "Vote");
        model.addAttribute("petition",petition);
        model.addAttribute("votes",votes);

        return "template";
    }

//    @GetMapping("/download/{id}")
//    public void downloadFile(@PathVariable("id")Long id, HttpServletResponse response) throws IOException {
//        Petition document = petitionRep.readPetition(id);
//
//        byte[] fileArray = document.getDocumentData();
//
//        response.setContentType(MimeTypeUtils.APPLICATION_OCTET_STREAM.getType());
//        response.setHeader("Content Disposion", "Attachment; filename " + document.getHeader());
//        response.setContentLength(fileArray.length);
//
//        OutputStream os = response.getOutputStream();
//        try{
//            os.write(fileArray, 0, fileArray.length);
//        } finally {
//            os.close();
//        }
//    }

//    @PostMapping("/uploadDocument")
//    public String uploadDocument(Model model, MultipartFile file)throws IOException{
//
//        StringBuilder fileNames = new StringBuilder();
//        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
//        fileNames.append(file.getOriginalFilename());
//        Files.write(fileNameAndPath, file.getBytes());
//        System.out.println(fileNames);
//        model.addAttribute("msg", "Uploaded documents: " + fileNames.toString());
//
//        return "redirect:/petition/list";
//    }

    @GetMapping("/list")
    public String getPetitionList(Model model, Principal principal){
        model.addAttribute("petitions", petitionService.getPetitionList());
        model.addAttribute("userid", principals.getEmployee(principal).getUserId());
        model.addAttribute("contentFragment", "/frag/petition/display-petitions");
        model.addAttribute("pageTitle", "List petition");

        return "template";
    }

    @GetMapping("/add")
    public String getPetitionForm(Model model){
        model.addAttribute("contentFragment", "/frag/petition/create-petitions");
        model.addAttribute("pageTitle", "Add petition");

        return "template";
    }

    @PostMapping("/add")
    public String addPetition(Petition petition, Principal principal){
        petitionService.createPetition(petition, principal);
        return "redirect:/petition/list";
    }

    @PostMapping("/del")
    public String deletePetition(@ModelAttribute("petition") Petition petition, Principal principal, Model model){
//        System.out.println(petition.getPetitionId());
        petitionService.deletePetition(petition, principal);
        return "redirect:/petition/list?deleted";
    }
}
