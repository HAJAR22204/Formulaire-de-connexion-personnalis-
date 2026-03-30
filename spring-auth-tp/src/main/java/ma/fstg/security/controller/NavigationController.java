package ma.fstg.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

    @GetMapping("/connexion")
    public String pageConnexion() {
        return "connexion";
    }

    @GetMapping("/accueil")
    public String pageAccueil() {
        return "accueil";
    }

    @GetMapping("/gestion/panneau")
    public String panneauGestion() {
        return "panneau-gestion";
    }

    @GetMapping("/espace/personnel")
    public String espacePersonnel() {
        return "espace-personnel";
    }
}
