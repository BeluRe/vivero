package com.vivero.demo.service;

import com.vivero.demo.entity.Producto;
import com.vivero.demo.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class ProductoService {

    @Autowired //inyeccion de dependencia
    ProductoRepository productoRepository;

    //lo que toma del repository y devuelve al controller

    //listar
    public List<Producto> list (){
        return productoRepository.findAll();
    }

    //obtener un producto por id
    public Optional<Producto> getOne(long id){
        return  productoRepository.findById(id);
    }

    //obtener un producto por nombre
    public Optional<Producto> getByNombre(String nombre){
        return  productoRepository.findByNombre(nombre);
    }

    //guardar producto

    public void save(Producto producto){
        productoRepository.save(producto);
    }

    //borrar producto
    public void delete(long id) {
        productoRepository.deleteById(id);
    }

    //si existe por id
    public boolean existsById(long id) {
        return productoRepository.existsById(id);

    }
    //si existe por nombre
    public boolean existByNombre(String nombre) {
        return productoRepository.existsByNombre(nombre);

    }
}
