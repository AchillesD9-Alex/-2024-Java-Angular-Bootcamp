package TA22_MVC.Controllers;

import java.util.Date;

import TA22_MVC.Models.Cliente;
import TA22_MVC.Views.ClienteView;

public class ClienteController {
    private Cliente modelo;
    private ClienteView vista;

    public ClienteController(Cliente modelo, ClienteView vista) {
        this.modelo = modelo;
        this.vista = vista;
        initController();
    }

    private void initController() {
        vista.addAgregarListener(e -> agregarCliente());
        vista.addActualizarListener(e -> actualizarCliente());
        vista.addEliminarListener(e -> eliminarCliente());
        vista.addBuscarListener(e -> buscarCliente());
    }

    public void agregarCliente() {
        Cliente cliente = new Cliente(
            0, 
            vista.getNombre(), 
            vista.getApellido(), 
            vista.getDireccion(), 
            vista.getDni(), 
            new Date()
        );
        Cliente.agregarCliente(cliente);
    }

    public void actualizarCliente() {
        Cliente cliente = new Cliente(
            modelo.getId(), 
            vista.getNombre(), 
            vista.getApellido(), 
            vista.getDireccion(), 
            vista.getDni(), 
            new Date()
        );
        Cliente.actualizarCliente(cliente);
    }

    public void eliminarCliente() {
        Cliente.eliminarCliente(modelo.getId());
    }

    public void buscarCliente() {
        int idCliente = modelo.getId();
        Cliente cliente = Cliente.obtenerCliente(idCliente);
        if (cliente != null) {
            vista.setNombre(cliente.getNombre());
            vista.setApellido(cliente.getApellido());
            vista.setDireccion(cliente.getDireccion());
            vista.setDni(cliente.getDni());
        }
    }
}
