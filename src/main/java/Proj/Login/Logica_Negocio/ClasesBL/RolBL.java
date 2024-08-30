package Proj.Login.Logica_Negocio.ClasesBL;

import Proj.Login.Acceso_Datos.Servicios.Implementaciones.RolService;
import Proj.Login.Entidades.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;



@Service
public class RolBL
{
    // Puente Con La DB:
    @Autowired
    private RolService _RolService;


    // TODOS LOS REGISTROS DE LA DB:
    public List<Rol> Obtener_Todos()
    {
        return _RolService.Obtener_Todos();
    }

    // RECIBE UN OBJETO Y LO GUARDA EN DB:
    public Rol Crear_Editar(Rol rol)
    {
        return _RolService.Crear_Editar(rol);
    }

    // OBTIENE DE LA DB UN OBJETO CON ESE ID:
    public Optional<Rol> Buscar_PorID(Integer id)
    {
        return _RolService.Buscar_PorID(id);
    }

    // BUSCA EN DB UN OBJETO CON ESE ID Y LO ELIMINA:
    public void Eliminar_PorID(Integer id)
    {
        _RolService.Eliminar_PorID(id);
    }

}
