package Proj.Login.Acceso_Datos.Servicios.Implementaciones;

import Proj.Login.Acceso_Datos.Repositorios.IRolRepository;
import Proj.Login.Acceso_Datos.Servicios.Interfaces.IRolService;
import Proj.Login.Entidades.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;



@Service
public class RolService implements IRolService
{
    // Representa La DB:
    @Autowired
    private IRolRepository _IRolRepository;


    // TODOS LOS REGISTROS DE LA DB:
    @Override
    public List<Rol> Obtener_Todos()
    {
        return _IRolRepository.findAll();
    }

    // RECIBE UN OBJETO Y LO GUARDA EN DB:
    @Override
    public Rol Crear_Editar(Rol rol)
    {
        return _IRolRepository.save(rol);
    }

    // OBTIENE DE LA DB UN OBJETO CON ESE ID:
    @Override
    public Optional<Rol> Buscar_PorID(Integer id)
    {
        return _IRolRepository.findById(id);
    }

    // BUSCA EN DB UN OBJETO CON ESE ID Y LO ELIMINA:
    @Override
    public void Eliminar_PorID(Integer id)
    {
        _IRolRepository.deleteById(id);
    }

}
