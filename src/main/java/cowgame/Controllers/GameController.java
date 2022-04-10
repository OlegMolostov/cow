package cowgame.Controllers;

import cowgame.entity.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
@SessionAttributes(types = Game.class)
@RequestMapping("/game")
public class GameController {

    @GetMapping
    public String newGame(HttpSession session, Model model) {
//        Game game=new Game();
        Game game = (Game) session.getAttribute("game");
        if (game == null) {
           game = new Game();
        }

        System.out.println(Arrays.toString(game.getNumber()));
        session.setAttribute("game", game);
        model.addAttribute("game", game);
        return "Game";
    }

    @GetMapping("/test")
    public String test(Model model) {
        Game game = new Game();

        model.addAttribute("game", game);
        return "test";
    }

    @PostMapping

    public String DoTry(HttpSession session, @RequestParam("number") String number, Model model) {
        System.out.println(number);
        Game game = (Game) session.getAttribute("game");
        System.out.println(Arrays.toString(game.getNumber()));
        for (int i = 0; i < game.getTries().size(); i++) {
            System.out.println(game.getTries().get(i).getBull());
            System.out.println(game.getTries().get(i).getCow());
            System.out.println(game.getTries().get(i).getNumber());
        }

        game.addTry(number);
        session.setAttribute("game", game);
        model.addAttribute("game", game);
//        return "redirect:Game";

        return "redirect:/";


    }
}
