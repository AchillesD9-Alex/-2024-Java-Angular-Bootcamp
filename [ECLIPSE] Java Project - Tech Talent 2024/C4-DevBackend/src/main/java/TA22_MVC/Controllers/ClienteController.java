package TA22_MVC.Controllers;

import TA22_MVC.Models.Cliente;
import TA22_MVC.Views.ClienteView;

import java.sql.Connection;

public class ClienteController {
    private Cliente modelo;
    private ClienteView vista;
    private ClienteDAO clienteDAO;

    public ClienteController(Cliente modelo, ClienteView vista, Connection connection) {
        this.modelo = modelo;
        this.vista = vista;
        this.clienteDAO = new ClienteDAO(connection);
    }

    public void agregarCliente() {
        // Obtener datos de la vista y actualizar el modelo
        modelo.setNombre(vista.getNombre());
        modelo.setApellido(vista.getApellido());
        modelo.setDireccion(vista.getDireccion());
        modelo.setDni(vista.getDni());
        // Lógica para agregar un cliente a la base de datos
        clienteDAO.agregarCliente(modelo);
    }

    public void actualizarCliente() {
        // Obtener datos de la vista y actualizar el modelo
        modelo.setNombre(vista.getNombre());
        modelo.setApellido(vista.getApellido());
        modelo.setDireccion(vista.getDireccion());
        modelo.setDni(vista.getDni());
        // Lógica para actualizar un cliente en la base de datos
        clienteDAO.actualizarCliente(modelo);
    }

    public void eliminarCliente() {
        // Lógica para eliminar un cliente de la base de datos
        clienteDAO.eliminarCliente(modelo.getId());
    }

    public void buscarCliente(int idCliente) {
        // Lógica para buscar un cliente en la base de datos
        Cliente cliente = clienteDAO.obtenerCliente(idCliente);
        if (cliente != null) {
            // Actualizar la vista con los datos del cliente encontrado
            vista.setNombre(cliente.getNombre());
            vista.setApellido(cliente.getApellido());
            vista.setDireccion(cliente.getDireccion());
            vista.setDni(cliente.getDni());
        } else {
            // Mostrar mensaje de error en la vista
            vista.mostrarMensaje("Cliente no encontrado.");
        }
    }
}
