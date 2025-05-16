package com.jaimetorres.model.mongo;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pagosFechas")
public class PagoFecha {

    @Id
    private String id;
    private String fechaPago;
    private String aportante;
    private String tipoIdentificacion;
    private String numIdentificacion;
    private String tipoEntidad;
    private Integer numTrabajadores;
    private Integer numAdministradoras;
    private Double totalPago;
    private String originador;
    private String tipoPago;
    private String numeroPlanilla;
    private String formaPago;
    private String entidad;
    private String anioPago;
    private String mesPago;
    private Integer departamento;
    private Integer municipio;
    private String email;
    private String telefono;
    private String direccion;
    private String celular;
    private String sucursal;
    private Integer registroSalida;
    private String usuario;
    private Integer cantidadPagos;
    private String tipoPlanilla;
    private String entidadRecaudo;
    private Integer __v;

    public PagoFecha(){

    }    

    public PagoFecha(String id, String fechaPago, String aportante, String tipoIdentificacion, String numIdentificacion,
            String tipoEntidad, Integer numTrabajadores, Integer numAdministradoras, Double totalPago,
            String originador, String tipoPago, String numeroPlanilla, String formaPago, String entidad,
            String anioPago, String mesPago, Integer departamento, Integer municipio, String email, String telefono,
            String direccion, String celular, String sucursal, Integer registroSalida, String usuario,
            Integer cantidadPagos, String tipoPlanilla, String entidadRecaudo, Integer __v) {
        this.id = id;
        this.fechaPago = fechaPago;
        this.aportante = aportante;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numIdentificacion = numIdentificacion;
        this.tipoEntidad = tipoEntidad;
        this.numTrabajadores = numTrabajadores;
        this.numAdministradoras = numAdministradoras;
        this.totalPago = totalPago;
        this.originador = originador;
        this.tipoPago = tipoPago;
        this.numeroPlanilla = numeroPlanilla;
        this.formaPago = formaPago;
        this.entidad = entidad;
        this.anioPago = anioPago;
        this.mesPago = mesPago;
        this.departamento = departamento;
        this.municipio = municipio;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.celular = celular;
        this.sucursal = sucursal;
        this.registroSalida = registroSalida;
        this.usuario = usuario;
        this.cantidadPagos = cantidadPagos;
        this.tipoPlanilla = tipoPlanilla;
        this.entidadRecaudo = entidadRecaudo;
        this.__v = __v;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFechaPago() {
        return fechaPago;
    }
    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }
    public String getAportante() {
        return aportante;
    }
    public void setAportante(String aportante) {
        this.aportante = aportante;
    }
    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }
    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }
    public String getNumIdentificacion() {
        return numIdentificacion;
    }
    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }
    public String getTipoEntidad() {
        return tipoEntidad;
    }
    public void setTipoEntidad(String tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }
    public Integer getNumTrabajadores() {
        return numTrabajadores;
    }
    public void setNumTrabajadores(Integer numTrabajadores) {
        this.numTrabajadores = numTrabajadores;
    }
    public Integer getNumAdministradoras() {
        return numAdministradoras;
    }
    public void setNumAdministradoras(Integer numAdministradoras) {
        this.numAdministradoras = numAdministradoras;
    }
    public Double getTotalPago() {
        return totalPago;
    }
    public void setTotalPago(Double totalPago) {
        this.totalPago = totalPago;
    }
    public String getOriginador() {
        return originador;
    }
    public void setOriginador(String originador) {
        this.originador = originador;
    }
    public String getTipoPago() {
        return tipoPago;
    }
    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }
    public String getNumeroPlanilla() {
        return numeroPlanilla;
    }
    public void setNumeroPlanilla(String numeroPlanilla) {
        this.numeroPlanilla = numeroPlanilla;
    }
    public String getFormaPago() {
        return formaPago;
    }
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
    public String getEntidad() {
        return entidad;
    }
    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }
    public String getAnioPago() {
        return anioPago;
    }
    public void setAnioPago(String anioPago) {
        this.anioPago = anioPago;
    }
    public String getMesPago() {
        return mesPago;
    }
    public void setMesPago(String mesPago) {
        this.mesPago = mesPago;
    }
    public Integer getDepartamento() {
        return departamento;
    }
    public void setDepartamento(Integer departamento) {
        this.departamento = departamento;
    }
    public Integer getMunicipio() {
        return municipio;
    }
    public void setMunicipio(Integer municipio) {
        this.municipio = municipio;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getSucursal() {
        return sucursal;
    }
    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    public Integer getRegistroSalida() {
        return registroSalida;
    }
    public void setRegistroSalida(Integer registroSalida) {
        this.registroSalida = registroSalida;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public Integer getCantidadPagos() {
        return cantidadPagos;
    }
    public void setCantidadPagos(Integer cantidadPagos) {
        this.cantidadPagos = cantidadPagos;
    }
    public String getTipoPlanilla() {
        return tipoPlanilla;
    }
    public void setTipoPlanilla(String tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }
    public String getEntidadRecaudo() {
        return entidadRecaudo;
    }
    public void setEntidadRecaudo(String entidadRecaudo) {
        this.entidadRecaudo = entidadRecaudo;
    }
    public Integer get__v() {
        return __v;
    }
    public void set__v(Integer __v) {
        this.__v = __v;
    }

    
}
