package bitlab.spring.trello;

import bitlab.spring.trello.model.Comments;
import bitlab.spring.trello.model.Folders;
import bitlab.spring.trello.model.TaskCategories;
import bitlab.spring.trello.model.Tasks;
import bitlab.spring.trello.repository.CategoryRepository;
import bitlab.spring.trello.repository.CommentRepository;
import bitlab.spring.trello.repository.FolderRepository;
import bitlab.spring.trello.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private FolderRepository folderRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(value = "/home")
    public String indexPage(Model model) {
        return "index";
    }

    // Task Categories

    @GetMapping(value = "/homeCategory")
    public String indexCategory(Model model) {
        List<TaskCategories> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @PostMapping(value = "/addCategory")
    public String addCategory(@RequestParam(name = "name") String name, Model model){
        List<TaskCategories> categories = categoryRepository.findAll();
        model.addAttribute("categorya", categories);
        TaskCategories category = new TaskCategories();
        category.setName(name);

        categoryRepository.save(category);
        return "redirect:/home";
    }

    @GetMapping(value = "/details/{id}")
    public String detailsCategory(Model model, @PathVariable(name = "id") Long id){
        TaskCategories categories = categoryRepository.findById(id).orElse(null);
        model.addAttribute("category", categories);
        return "detailsCategory";
    }

    @PostMapping(value = "/deleteCategory")
    public String deleteCategory(@RequestParam(name = "id") Long id){
        categoryRepository.deleteById(id);
        return "redirect:/home";
    }

    @GetMapping(value = "/updateCategory")
    public String updateCategory(@RequestParam(name = "id") Long id,
                                 @RequestParam(name = "name") String name){

        TaskCategories categories = categoryRepository.findById(id).orElse(null);

        categories.setName(name);
        categoryRepository.save(categories);
        return "redirect:/home";
    }

    // Folders
    @PostMapping(value = "/addFolder")
    public String addFolder(@RequestParam(name = "name") String name,
                            @RequestParam(name = "category") List<TaskCategories> categories,
                            Model model){
        List<Folders> folders = folderRepository.findAll();
        model.addAttribute("folder", folders);
        Folders folder = new Folders();
        folder.setName(name);
        folder.setCategories(categories);

        folderRepository.save(folder);
        return "redirect:/home";
    }

    @GetMapping(value = "/details/{id}")
    public String detailsFolder(Model model, @PathVariable(name = "id") Long id){
        Folders folders = folderRepository.findById(id).orElse(null);
        model.addAttribute("folders", folders);
        return "detailsFolder";
    }

    @PostMapping(value = "/deleteFolder")
    public String deleteFolder(@RequestParam(name = "id") Long id){
        folderRepository.deleteById(id);
        return "redirect:/home";
    }

    @GetMapping(value = "/updateFolder")
    public String updateFolder(@RequestParam(name = "id") Long id,
                               @RequestParam(name = "name") String name,
                               @RequestParam(name = "category") List<TaskCategories> categories){

        Folders folders = folderRepository.findById(id).orElse(null);

        folders.setName(name);
        folders.setCategories(categories);
        folderRepository.save(folders);
        return "redirect:/home";
    }

    // Tasks
    @PostMapping(value = "/addTask")
    public String addTask(@RequestParam(name = "title") String title,
                          @RequestParam(name = "description") String description,
                          @RequestParam(name = "status") int status,
                          @RequestParam(name = "folders") Folders folders,
                          Model model) {
        List<Tasks> tasks = taskRepository.findAll();
        model.addAttribute("task", tasks);
        Tasks task = new Tasks();
        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(status);
        task.setFolders(folders);

        taskRepository.save(task);
        return "redirect:/home";
    }

    @GetMapping(value = "/details/{id}")
    public String detailsTask(Model model, @PathVariable(name = "id") Long id){
        Tasks tasks = taskRepository.findById(id).orElse(null);
        model.addAttribute("tasks", tasks);
        return "detailsTask";
    }

    @PostMapping(value = "/deleteTask")
    public String deleteTask(@RequestParam(name = "id") Long id){
        taskRepository.deleteById(id);
        return "redirect:/home";
    }

    @GetMapping(value = "/updateTask")
    public String updateTask(@RequestParam(name = "id") Long id,
                             @RequestParam(name = "title") String title,
                             @RequestParam(name = "description") String description,
                             @RequestParam(name = "status") int status,
                             @RequestParam(name = "folders") Folders folders){

        Tasks tasks = taskRepository.findById(id).orElse(null);

        tasks.setTitle(title);
        tasks.setDescription(description);
        tasks.setStatus(status);
        tasks.setFolders(folders);
        taskRepository.save(tasks);
        return "redirect:/home";
    }

    // Comments
    @PostMapping(value = "/addComment")
    public String addComment(@RequestParam String comment,
                             @RequestParam Long id,
                             Model model) {
        List<Comments> comments = commentRepository.findAll();
        model.addAttribute("comments", comments);

        Comments comments1 = new Comments();
        comments1.setComment(comment);
        comments1.setId(id);

        commentRepository.save(comments1);
        return "redirect:/home";
    }
}
