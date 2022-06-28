/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gifbin;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kimmo
 */
@Controller
public class FileObjectController {
    
    @Autowired
    FileObjectRepository fileObjectRepository;
    
    @GetMapping(path = "/gifs/{id}/content", produces = "image/gif")
    @ResponseBody
    public byte[] viewContent(@PathVariable Long id) {
        byte[] content = fileObjectRepository.getOne(id).getContent();
        return content;
    }
    
    @GetMapping("/gifs")
    public String viewFirst() {
        return "redirect:/gifs/1";
    }
    
    @GetMapping(path = "/gifs/{id}")
    public String viewById(Model model, @PathVariable Long id) {
        
        Long count = fileObjectRepository.count();
        model.addAttribute("count", count);
                if (id >= 1L && id <= count) {
            model.addAttribute("current", id);
        }
                
        if (id < count && id > 0L) {
            model.addAttribute("next", id + 1);
        }
        
        if (id > 1L) {
            model.addAttribute("previous", id - 1);
        }
        return "gifs";
    }
    
    @PostMapping("/gifs")
    public String save(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        if (file.getContentType().equals("image/gif")) {
            FileObject fo = new FileObject();
            fo.setContent(file.getBytes());
            fileObjectRepository.save(fo);
            model.addAttribute("count", fileObjectRepository.count());
        } 
        return "redirect:/gifs";
    }
}
