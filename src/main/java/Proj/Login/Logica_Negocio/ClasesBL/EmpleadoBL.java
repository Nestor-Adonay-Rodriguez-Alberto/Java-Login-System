package Proj.Login.Logica_Negocio.ClasesBL;

import Proj.Login.Acceso_Datos.Servicios.Implementaciones.EmpleadoService;
import Proj.Login.Entidades.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;



@Service
public class EmpleadoBL
{
    // Puentes Con La DB:
    @Autowired
    private EmpleadoService _EmpleadoService;


    // TODOS LOS REGISTROS DE LA DB:
    public List<Empleado> Obtener_Todos()
    {
        return _EmpleadoService.Obtener_Todos();
    }

    // RECIBE UN OBJETO Y LO GUARDA EN DB:
    public Empleado Crear_Editar(Empleado empleado)
    {
        return _EmpleadoService.Crear_Editar(empleado);
    }

    // OBTIENE DE LA DB UN OBJETO CON ESE ID:
    public Optional<Empleado> Buscar_PorID(Integer id)
    {
        return _EmpleadoService.Buscar_PorID(id);
    }

    // BUSCA EN DB UN OBJETO CON ESE ID Y LO ELIMINA:
    public void Eliminar_PorID(Integer id)
    {
        _EmpleadoService.Eliminar_PorID(id);
    }

}
