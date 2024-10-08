package Proj.Login.Acceso_Datos.Servicios.Implementaciones;

import Proj.Login.Acceso_Datos.Repositorios.IEmpleadoRepository;
import Proj.Login.Acceso_Datos.Servicios.Interfaces.IEmpleadoService;
import Proj.Login.Entidades.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;



@Service
public class EmpleadoService implements IEmpleadoService
{
    // Representa La DB:
    @Autowired
    private IEmpleadoRepository _IEmpleadoRepository;


    // TODOS LOS REGISTROS DE LA DB:
    @Override
    public List<Empleado> Obtener_Todos()
    {
        return _IEmpleadoRepository.findAll();
    }

    // RECIBE UN OBJETO Y LO GUARDA EN DB:
    @Override
    public Empleado Crear_Editar(Empleado empleado)
    {
        return _IEmpleadoRepository.save(empleado);
    }

    // OBTIENE DE LA DB UN OBJETO CON ESE ID:
    @Override
    public Optional<Empleado> Buscar_PorID(Integer id)
    {
        return _IEmpleadoRepository.findById(id);
    }

    // BUSCA EN DB UN OBJETO CON ESE ID Y LO ELIMINA:
    @Override
    public void Eliminar_PorID(Integer id)
    {
        _IEmpleadoRepository.deleteById(id);
    }

}
