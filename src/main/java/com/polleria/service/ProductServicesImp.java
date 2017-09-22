/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polleria.service;

import com.polleria.controller.AlertasCambiosCostosController;
import com.polleria.controller.articuloController;
import com.polleria.controller.articuloProductoController;
import com.polleria.controller.productoController;
import com.polleria.model.alertasCambiosCostos;
import com.polleria.model.articulo;
import com.polleria.model.articuloProducto;
import com.polleria.model.producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author W7
 */
@Service(value = "ProductServicesImp")
public class ProductServicesImp {
    
    
    articuloController articuloControlador = new  articuloController();
    articuloProductoController articuloProductoControlador = new articuloProductoController();
    productoController productoControlador = new productoController();
    AlertasCambiosCostosController alertasCambiosCostosController = new AlertasCambiosCostosController();

    public String retornarNombre() {
        return "Yeltsin";
    }

    public articulo findArticulo(int idArticulo) throws Exception {

        articulo articuloFiltrado = articuloControlador.find(idArticulo);
        return articuloFiltrado;
    }
    public List<Integer> findAllCambiosCosto() throws Exception {
        // retorna el id de los articulos
        List<Integer> filtroCambioCosto = alertasCambiosCostosController.readAll();
        return filtroCambioCosto;
    }

    public alertasCambiosCostos findAlertaCambioCosto(Integer idArticulo) throws Exception {
        alertasCambiosCostos alertaCambiadaFiltrado = alertasCambiosCostosController.find(idArticulo);
        return alertaCambiadaFiltrado;
    }

    public List<articuloProducto> findAllProductosByArticulo(int idArticulo) throws Exception {
        List<articuloProducto> ProductoXArticulo = articuloProductoControlador.findAllProductoByArticulo(idArticulo);
        return ProductoXArticulo;
    }

    public String updateProductoByArticulo(articuloProducto productoActualizar) throws Exception {
        String respuesta = "ok"; 
        if (respuesta.equals(articuloProductoControlador.update(productoActualizar))){
             return "ok"; 
         }else{
             return "bad";
         }
    }

    public producto findProductos(int codProducto) throws Exception {
        return productoControlador.find(codProducto);
    }

    public void deleteCambiosCosto(int idArticulo) throws Exception {
         alertasCambiosCostos alertaCambiadaFiltrado = null;
         alertaCambiadaFiltrado = alertasCambiosCostosController.find(idArticulo);
         if(!alertaCambiadaFiltrado.equals(null)){
             alertasCambiosCostosController.delete(idArticulo);
         }
    }


   

}
