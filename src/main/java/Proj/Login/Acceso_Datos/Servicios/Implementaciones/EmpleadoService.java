package Proj.Login.Acceso_Datos.Servicios.Implementaciones;

import Proj.Login.Acceso_Datos.Repositorios.IEmpleadoRepository;
import Proj.Login.Acceso_Datos.Servicios.Interfaces.IEmpleadoService;
import Proj.Login.Entidades.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements IEmpleadoService
{
    @Autowired
    private IEmpleadoRepository _IEmpleadoRepository;

    @Override
    public List<Empleado> Obtener_Todos() {
        return _IEmpleadoRepository.findAll();
    }

    @Override
    public Empleado Crear_Editar(Empleado empleado) {
        return _IEmpleadoRepository.save(empleado);
    }

    @Override
    public Optional<Empleado> Buscar_PorID(Integer id) {
        return _IEmpleadoRepository.findById(id);
    }

    @Override
    public void Eliminar_PorID(Integer id) {
        _IEmpleadoRepository.findById(id);
    }
}
