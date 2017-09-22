/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polleria.web;

import com.polleria.service.ProductServicesImp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.polleria.model.alertasCambiosCostos;
import com.polleria.model.articulo;
import com.polleria.model.articuloProducto;
import com.polleria.model.producto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author W7
 */
@RestController
@RequestMapping("/porciones")
public class ProductREST {

    @Autowired
    private ProductServicesImp productServicesImp;

    // prueba de mostrar
    @RequestMapping(value = "/prueba", method = RequestMethod.GET)
    public ResponseEntity<String> mostrarProductos() {
        HttpStatus hs = HttpStatus.OK;
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return new ResponseEntity<String>(gson.toJson("hola " + productServicesImp.retornarNombre()), hs);
    }

    /*
     // Actualizar  mostrar
     @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
     public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
     System.out.println("Updating User " + id);

     User currentUser = userService.findById(id);

     if (currentUser == null) {
     System.out.println("User with id " + id + " not found");
     return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
     }

     currentUser.setName(user.getName());
     currentUser.setAge(user.getAge());
     currentUser.setSalary(user.getSalary());

     userService.updateUser(currentUser);
     return new ResponseEntity<User>(currentUser, HttpStatus.OK);
     }
    
     // obtener un usuario
     @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<User> getUser(@PathVariable("id") long id) {
     System.out.println("Fetching User with id " + id);
     User user = userService.findById(id);
     if (user == null) {
     System.out.println("User with id " + id + " not found");
     return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
     }
     return new ResponseEntity<User>(user, HttpStatus.OK);
     }
     */
    //obtener muchos insumos  ok
    @RequestMapping(value = "/lista/insumos/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> listAllArticulos() throws Exception {
        articulo articulos = null;
        HttpStatus hs = HttpStatus.OK;
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        List<articulo> articuloCambioCosto = new ArrayList<articulo>();
        List<Integer> alertaCambioCosto = productServicesImp.findAllCambiosCosto();
        if (!alertaCambioCosto.isEmpty()) {
            for (Integer articulo : alertaCambioCosto) {
                articulos = productServicesImp.findArticulo(articulo);
                //articulos = productServicesImp.findArticulo(19);
                articuloCambioCosto.add(articulos);
            }
            HttpHeaders headers = new HttpHeaders();
            headers.add("Access-Control-Allow-Origin", "*");
            headers.add("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS");
            headers.add("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");

            return new ResponseEntity<String>(gson.toJson(articulos), headers, hs);
        } else {
            hs = HttpStatus.NOT_FOUND;
            return new ResponseEntity<>(gson.toJson("data.not.found"), hs);
        }
    }

    // obtener costo alerta   ok
    @RequestMapping(value = "/costoactualarticulo/{codigo}", method = RequestMethod.GET)
    public ResponseEntity<String> costoActualArticulo(@PathVariable(value = "codigo") int codigo) throws Exception {
        HttpStatus hs = HttpStatus.OK;
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        alertasCambiosCostos articuloCostoActual = productServicesImp.findAlertaCambioCosto(codigo);

        if (!articuloCostoActual.equals(null)) {
            return new ResponseEntity<String>(gson.toJson(articuloCostoActual), hs);
        } else {
            hs = HttpStatus.NOT_FOUND;
            return new ResponseEntity<String>(gson.toJson("data.not.found"), hs);
        }
    }

    // listar productos por insumo
    @RequestMapping(value = "/listaproductoInsumo/{codigo}", method = RequestMethod.GET)
    public ResponseEntity<String> listaProductoInsumo(@PathVariable(value = "codigo") int codigo) throws Exception {
        HttpStatus hs = HttpStatus.OK;
        List<producto> listaProductoInsumo = null;
        producto productoBean = null;
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        List<articuloProducto> listaProductosXInsumo = productServicesImp.findAllProductosByArticulo(codigo);
        for (articuloProducto productoByInsumo : listaProductosXInsumo) {
            productoBean = new producto();
            listaProductoInsumo = new ArrayList<producto>();
            productoBean = productServicesImp.findProductos(productoByInsumo.getCodProducto());
            listaProductoInsumo.add(productoBean);
        }
        if (listaProductoInsumo.size() > 0) {
            return new ResponseEntity<String>(gson.toJson(listaProductoInsumo), hs);
        } else {
            hs = HttpStatus.NOT_FOUND;
            return new ResponseEntity<String>(gson.toJson("data.not.found"), hs);
        }

    }

    // Actualizar precio de porciones
    /*  Que es lo que se espera
     recibir un bean de tipo articuloProducto
     este tendra el campo cantidad de porcion donde se modificara en la bd para indicar la porción por  
     producto.
     */
    @RequestMapping(value = "/actualizarporcion/", method = RequestMethod.PUT)
    public ResponseEntity<String> actualizarPorcion(@RequestBody articuloProducto productoModificado) throws Exception {
        // SI EXISTE ENTONCES ACTUALIZAR
        HttpStatus hs = HttpStatus.OK;
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        try {
            String resultadoActualización = productServicesImp.updateProductoByArticulo(productoModificado);
            // ELIMINAR DE LA LISTA DE LOS PENDIENTES
            if (resultadoActualización.equals("ok")) {
                productServicesImp.deleteCambiosCosto(productoModificado.getCodArticulo());
            }
            return new ResponseEntity<String>("ok", HttpStatus.OK);

        } catch (Exception e) {
            hs = HttpStatus.NOT_FOUND;
            return new ResponseEntity<String>(gson.toJson("data.not.found"), hs);
        }

    }

}
