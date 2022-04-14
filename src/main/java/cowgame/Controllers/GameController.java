package cowgame.Controllers;

import cowgame.entity.Game;


import cowgame.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.util.Arrays;


@Controller

@RequestMapping("/game")
public class GameController {

    @Autowired
    UserRepo userRepo;

    @GetMapping()
    public String newGame(HttpSession session, Model model) {
        Game game = (Game) session.getAttribute("game");
        if (game == null ) {
           game = new Game();
        }
        session.setAttribute("game", game);
        model.addAttribute("game", game);
        return "Game";
    }



    @PostMapping
    public String doTry(HttpSession session, @RequestParam("number") String number, Model model, Authentication authentication) {

        Game game = (Game) session.getAttribute("game");
        System.out.println(game.getNumber());

        game.addTry(number);
        if (game.isVictory()){
            userRepo.setUpdate((long)game.getTries().size(),authentication.getName());
        }
        session.setAttribute("game", game);
        model.addAttribute("game", game);
        return "redirect:/game";
    }

    @PostMapping("/again")
    public String again(HttpSession session){
        Game game = (Game) session.getAttribute("game");
        game=null;
        session.setAttribute("game", game);

        return "redirect:/game";
    }
}
