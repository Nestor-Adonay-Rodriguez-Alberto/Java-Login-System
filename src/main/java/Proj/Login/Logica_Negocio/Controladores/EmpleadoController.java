package Proj.Login.Logica_Negocio.Controladores;

import Proj.Login.Entidades.Empleado;
import Proj.Login.Logica_Negocio.ClasesBL.EmpleadoBL;
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
@RequestMapping("/Empleado")
public class EmpleadoController
{
    // Puente Con La DB:
    @Autowired
    private EmpleadoBL _EmpleadoBL;

    @Autowired
    private RolBL _RolBL;


    // TODOS LOS REGISTROS DE LA DB:
    @GetMapping("/Empleados_Registrados")
    public String Empleados_Registrados(Model model)
    {
        model.addAttribute("Lista_Empleados",_EmpleadoBL.Obtener_Todos());

        return "Empleados/Index";
    }


    // OBTIENE DE LA DB UN OBJETO CON ESE ID:
    @GetMapping("/Detalle_Empleado/{id}")
    public String Detalle_Empleado(@PathVariable("id") Integer id, Model model)
    {
        model.addAttribute("Empleado_Obtenido", _EmpleadoBL.Buscar_PorID(id).get());

        return "Empleados/Details";
    }


    // Nos Manda A La Vista:
    @GetMapping("/Vista_Registrar")
    public String Vista_Registrar(Empleado empleado, Model model)
    {
        model.addAttribute("Lista_Roles", _RolBL.Obtener_Todos());
        model.addAttribute("empleado",empleado);

        return "Empleados/Create";
    }

    // RECIBE UN OBJETO Y LO GUARDA EN LA DB:
    @PostMapping("/Registrar_Empleado")
    public String Registrar_Empleado(@Valid Empleado empleado, BindingResult result, Model model, RedirectAttributes attributes)
    {
        // Validar Los Campos:
        if (result.hasErrors())
        {
            model.addAttribute("Lista_Roles", _RolBL.Obtener_Todos());
            model.addAttribute("empleado", empleado);

            return "Empleados/Create";
        }

        // Guardamos
        _EmpleadoBL.Crear_Editar(empleado);

        //Msg Confirmacion
        attributes.addFlashAttribute("msg", "Nuevo Empleado Guardado Correctamente.");

        return "redirect:/Empleado/Empleados_Registrados";
    }


    // OBTIENE DE LA DB UN OBJETO CON ESE ID:
    @GetMapping("/Editar_Empleado/{id}")
    public String Editar_Empleado(@PathVariable("id") Integer id, Model model)
    {
        model.addAttribute("Lista_Roles", _RolBL.Obtener_Todos());
        model.addAttribute("Empleado_Obtenido", _EmpleadoBL.Buscar_PorID(id).get());

        return "Empleados/Edit";
    }


    // OBTIENE DE LA DB UN OBJETO CON ESE ID:
    @GetMapping("/Vista_Eliminar/{id}")
    public String Vista_Eliminar(@PathVariable("id") Integer id, Model model)
    {
        model.addAttribute("Empleado_Obtenido", _EmpleadoBL.Buscar_PorID(id).get());

        return "Empleados/Delete";
    }

    // BUSCA EN DB UN OBJETO CON ESE ID Y LO ELIMINA:
    @PostMapping("/Eliminar_Empleado")
    public String Eliminar_Empleado(Empleado empleado, RedirectAttributes attributes)
    {
        // Eliminamos
        _EmpleadoBL.Eliminar_PorID(empleado.getIdEmpleado());

        // Msg Confimacion:
        attributes.addFlashAttribute("msg", "Empleado Eliminado correctamente");

        return "redirect:/Empleado/Empleados_Registrados";
    }


}
