package Proj.Login.Acceso_Datos.Servicios.Interfaces;

import Proj.Login.Entidades.Rol;

import java.util.List;
import java.util.Optional;

public interface IRolService
{
    // TODOS LOS REGISTROS DE LA DB:
    List<Rol> Obtener_Todos();

    // RECIBE UN OBJETO Y LO GUARDA EN DB:
    Rol Crear_Editar(Rol rol);

    // BUSCA EN DB UN OBJETO CON ESE ID:
    Optional<Rol> Buscar_PorID(Integer id);

    // BUSCA EN DB UN OBJETO CON ESE ID Y LO ELIMINA:
    void Eliminar_PorID(Integer id);

}
