package Proj.Login.Acceso_Datos.Servicios.Implementaciones;

import Proj.Login.Acceso_Datos.Repositorios.IRolRepository;
import Proj.Login.Acceso_Datos.Servicios.Interfaces.IRolService;
import Proj.Login.Entidades.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService implements IRolService
{
    @Autowired
    private IRolRepository _IRolRepository;

    @Override
    public List<Rol> Obtener_Todos()
    {
        return _IRolRepository.findAll();
    }

    @Override
    public Rol Crear_Editar(Rol rol) {
        return _IRolRepository.save(rol);
    }

    @Override
    public Optional<Rol> Buscar_PorID(Integer id) {
        return _IRolRepository.findById(id);
    }

    @Override
    public void Eliminar_PorID(Integer id)
    {
        _IRolRepository.findById(id);
    }
}
