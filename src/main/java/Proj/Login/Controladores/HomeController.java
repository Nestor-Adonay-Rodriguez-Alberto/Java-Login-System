package Proj.Login.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class HomeController
{
    // Nos Manda A La Vista
    @GetMapping
    public String Index()

    {
        return "Home/Index";
    }
}
