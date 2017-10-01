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
                articulos = new articulo();
                articulos = productServicesImp.findArticulo(articulo);
                //articulos = productServicesImp.findArticulo(19);
                articuloCambioCosto.add(articulos);
            }
            HttpHeaders headers = new HttpHeaders();
            headers.add("Access-Control-Allow-Origin", "*");
            headers.add("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS");
            headers.add("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");

            return new ResponseEntity<String>(gson.toJson(articuloCambioCosto), headers, hs);
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

        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS");
        headers.add("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
        if (!articuloCostoActual.equals(null)) {
            return new ResponseEntity<String>(gson.toJson(articuloCostoActual), headers, hs);
        } else {
            hs = HttpStatus.NOT_FOUND;
            return new ResponseEntity<String>(gson.toJson("data.not.found"), hs);
        }
    }

    // listar productos por insumo
    @RequestMapping(value = "/listaproductoInsumo/{codigo}", method = RequestMethod.GET)
    public ResponseEntity<String> listaProductoInsumo(@PathVariable(value = "codigo") int codigo) throws Exception {
        HttpStatus hs = HttpStatus.OK;
        List<producto> listaProductoInsumo = new ArrayList<producto>();
        producto productoBean = null;
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        List<articuloProducto> listaProductosXInsumo = productServicesImp.findAllProductosByArticulo(codigo);
        for (articuloProducto productoByInsumo : listaProductosXInsumo) {
            productoBean = new producto();
            productoBean = productServicesImp.findProductos(productoByInsumo.getCodProducto());
            listaProductoInsumo.add(productoBean);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS");
        headers.add("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");

        if (listaProductoInsumo.size() > 0) {
            return new ResponseEntity<String>(gson.toJson(listaProductoInsumo), headers, hs);
        } else {
            hs = HttpStatus.NOT_FOUND;
            return new ResponseEntity<String>(gson.toJson("data.not.found"), hs);
        }

    }

    //******************************************
    @RequestMapping(value = "/listaarticuloProducto/{codigo}", method = RequestMethod.GET)
    public ResponseEntity<String> listaProductoArticulo(@PathVariable(value = "codigo") int codigo) throws Exception {
        HttpStatus hs = HttpStatus.OK;
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        List<articuloProducto> listaProductosXInsumo = productServicesImp.findAllProductosByArticulo(codigo);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS");
        headers.add("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");

        if (listaProductosXInsumo.size() > 0) {
            return new ResponseEntity<String>(gson.toJson(listaProductosXInsumo), headers, hs);
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
    @RequestMapping(value = "/actualizarporcion/{codArticulo}/{codProducto}/{cantidad:.+}", method = RequestMethod.GET)
    public ResponseEntity<String> actualizarPorcion(@PathVariable(value = "codArticulo") Integer codArticulo,
            @PathVariable(value = "codProducto") Integer codProducto, @PathVariable(value = "cantidad") String cantidadTemp) throws Exception {
        // SI EXISTE ENTONCES ACTUALIZAR
        HttpStatus hs = HttpStatus.OK; 

        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS");
        headers.add("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        try {
            
            Double cantidad = Double.parseDouble(cantidadTemp);
            
            articuloProducto productoModificado = new articuloProducto(codArticulo, codProducto, 0, cantidad);
            String resultadoActualización = productServicesImp.updateProductoByArticulo(productoModificado);

            return new ResponseEntity<String>(gson.toJson("ok"), headers, HttpStatus.OK);

        } catch (Exception e) {
            System.err.println(e);
            hs = HttpStatus.NOT_FOUND;
            return new ResponseEntity<String>(gson.toJson("data.not.found"), headers, hs);
        }

    }

}
