package Proj.Login.Acceso_Datos.Servicios.Interfaces;

import Proj.Login.Entidades.Empleado;
import java.util.*;


public interface IEmpleadoService
{
    // TODOS LOS REGISTROS DE LA DB:
    List<Empleado> Obtener_Todos();

    // RECIBE UN OBJETO Y LO GUARDA EN DB:
    Empleado Crear_Editar(Empleado empleado);

    // BUSCA EN DB UN OBJETO CON ESE ID:
    Optional<Empleado> Buscar_PorID(Integer id);

    // BUSCA EN DB UN OBJETO CON ESE ID Y LO ELIMINA:
    void Eliminar_PorID(Integer id);
}
