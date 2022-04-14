package cowgame.Controllers;

import cowgame.entity.User;
import cowgame.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping()
public class TopController {

    @Autowired
    UserRepo userRepo;

    @GetMapping("/top")
    public String showTop(Model model) {
        List<User> top = userRepo.TopUsers();
        List<Integer> score=new ArrayList<>(top.size());
        top.sort((o1,o2)->o1.rating()- o2.rating());

        for (User u: top
             ) {
            score.add(u.rating());
        }
        model.addAttribute("top", top);
        model.addAttribute("score", score);
        return "Top";
    }
}
