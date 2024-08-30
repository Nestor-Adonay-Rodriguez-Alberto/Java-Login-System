package Proj.Login.Entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.*;



@Entity
@Table(name = "Roles")
public class Rol
{
    // ATRIBUTOS:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdRol;


    @NotBlank(message = "El Nombre Es Requerido")
    private String Nombre;


    // Tabla Empleado Relacionada Con Esta:
    @OneToMany(mappedBy = "Objeto_Rol", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Empleado> Lista_Empleados = new LinkedList<>();



    // ACCESORS:
    public Integer getIdRol() {
        return IdRol;
    }
    public void setIdRol(Integer idRol) {
        IdRol = idRol;
    }

    public @NotBlank(message = "El Nombre Es Requerido") String getNombre() {
        return Nombre;
    }
    public void setNombre(@NotBlank(message = "El Nombre Es Requerido") String nombre) {
        Nombre = nombre;
    }

    public List<Empleado> getLista_Empleados() {
        return Lista_Empleados;
    }
    public void setLista_Empleados(List<Empleado> lista_Empleados) {
        Lista_Empleados = lista_Empleados;
    }
}
