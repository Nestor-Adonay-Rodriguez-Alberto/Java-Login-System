package Proj.Login.Logica_Negocio.Controladores;

import Proj.Login.Entidades.Rol;
import Proj.Login.Logica_Negocio.ClasesBL.RolBL;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/Rol")
public class RolController
{
    // Puente Con La DB:
    @Autowired
    private RolBL _RolBL;




    // TODOS LOS REGISTROS DE LA DB:
    @GetMapping("/Roles_Registrados")
    public String Roles_Registrados(Model model)
    {
        model.addAttribute("Lista_Roles",_RolBL.Obtener_Todos());

        return "Roles/Index";
    }

    // OBTIENE DE LA DB UN OBJETO CON ESE ID:
    @GetMapping("/Detalle_Rol/{id}")
    public String Detalle_Rol(@PathVariable("id") Integer id, Model model)
    {
        model.addAttribute("Rol_Obtenido", _RolBL.Buscar_PorID(id).get());

        return "Roles/Details";
    }


    // Nos Manda A La Vista:
    @GetMapping("/Vista_Registrar")
    public String Vista_Registrar(Rol rol, Model model)
    {
        model.addAttribute("rol",rol);

        return "Roles/Create";
    }

    // RECIBE UN OBJETO Y LO GUARDA EN LA DB:
    @PostMapping("/Registrar_Rol")
    public String Registrar_Rol(@Valid Rol rol, BindingResult result, Model model, RedirectAttributes attributes)
    {
        // Validar Los Campos:
        if (result.hasErrors())
        {
            model.addAttribute("rol", rol);

            return "Roles/Create";
        }

        // Guardamos
        _RolBL.Crear_Editar(rol);

        //Msg Confirmacion
        attributes.addFlashAttribute("msg", "Nuevo Rol Guardado Correctamente.");

        return "redirect:/Rol/Roles_Registrados";
    }


    // OBTIENE DE LA DB UN OBJETO CON ESE ID:
    @GetMapping("/Editar_Rol/{id}")
    public String Editar_Rol(@PathVariable("id") Integer id, Model model)
    {
        model.addAttribute("Rol_Obtenido", _RolBL.Buscar_PorID(id).get());

        return "Roles/Edit";
    }


    // OBTIENE DE LA DB UN OBJETO CON ESE ID:
    @GetMapping("/Vista_Eliminar/{id}")
    public String Vista_Eliminar(@PathVariable("id") Integer id, Model model)
    {
        model.addAttribute("Rol_Obtenido", _RolBL.Buscar_PorID(id).get());

        return "Roles/Delete";
    }

    // BUSCA EN DB UN OBJETO CON ESE ID Y LO ELIMINA:
    @PostMapping("/Eliminar_Rol")
    public String Eliminar_Rol(Rol rol, RedirectAttributes attributes)
    {
        // Eliminamos
        _RolBL.Eliminar_PorID(rol.getIdRol());

        // Msg Confimacion:
        attributes.addFlashAttribute("msg", "Rol Eliminado correctamente");

        return "redirect:/Rol/Roles_Registrados";
    }


}
