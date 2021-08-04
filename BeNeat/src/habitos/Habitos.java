package habitos;

import java.util.Date;

public class Habitos {
//Componentes
	String nombre;
	String descripcion;
	Date fechaInicio;
	Date fechaFin;
	int racha;	
	int[] diasSemana;
	long hora;
	
	Categoria categoria;
	
//metodo constructor
	public Habitos (String nom,String desc,Date fInicio, Date fFin, int rach, int[] diasSem, long hor, Categoria cate) {
		this.nombre=nom;
		this.descripcion=desc;
		this.fechaInicio=fInicio;
		this.fechaFin=fFin;
		this.racha=rach;
		this.diasSemana=diasSem;
		this.hora=hor;
		this.categoria=cate;
	}
	public Habitos (String nom,Date fInicio, int[] diasSem, long hor) {
		this.nombre=nom;
		this.descripcion=null;
		this.fechaInicio=fInicio;
		this.fechaFin=null;
		this.racha=0;
		this.diasSemana=diasSem;
		this.hora=hor;
		this.categoria=null;
	}
	public Habitos (String nom,Date fInicio, int rach, int[] diasSem, long hor) {
		this.nombre=nom;
		this.descripcion=null;
		this.fechaInicio=fInicio;
		this.fechaFin=null;
		this.racha=rach;
		this.diasSemana=diasSem;
		this.hora=hor;
		this.categoria=null;
	}
	public Habitos (String nom,Date fInicio, Date fFin, int rach, int[] diasSem, long hor) {
		this.nombre=nom;
		this.descripcion=null;
		this.fechaInicio=fInicio;
		this.fechaFin=fFin;
		this.racha=rach;
		this.diasSemana=diasSem;
		this.hora=hor;
		this.categoria=null;
	}
	public Habitos (String nom,Date fInicio, Date fFin, int[] diasSem, long hor) {
		this.nombre=nom;
		this.descripcion=null;
		this.fechaInicio=fInicio;
		this.fechaFin=fFin;
		this.racha=0;
		this.diasSemana=diasSem;
		this.hora=hor;
		this.categoria=null;
	}
	public Habitos (String nom,String desc, Date fInicio, int rach, int[] diasSem, long hor) {
		this.nombre=nom;
		this.descripcion=desc;
		this.fechaInicio=fInicio;
		this.fechaFin=null;
		this.racha=rach;
		this.diasSemana=diasSem;
		this.hora=hor;
		this.categoria=null;
	}
	public Habitos (String nom,String desc, Date fInicio, int[] diasSem, long hor) {
		this.nombre=nom;
		this.descripcion=desc;
		this.fechaInicio=fInicio;
		this.fechaFin=null;
		this.racha=0;
		this.diasSemana=diasSem;
		this.hora=hor;
		this.categoria=null;
	}

	public Habitos (String nom,String desc,Date fInicio, Date fFin, int rach, int[] diasSem, long hor) {
		this.nombre=nom;
		this.descripcion=desc;
		this.fechaInicio=fInicio;
		this.fechaFin=fFin;
		this.racha=rach;
		this.diasSemana=diasSem;
		this.hora=hor;
		this.categoria=null;
	}
	public Habitos (String nom,Date fInicio, int[] diasSem, long hor, Categoria cate) {
		this.nombre=nom;
		this.descripcion=null;
		this.fechaInicio=fInicio;
		this.fechaFin=null;
		this.racha=0;
		this.diasSemana=diasSem;
		this.hora=hor;
		this.categoria=cate;
	}
	public Habitos (String nom,Date fInicio, int rach, int[] diasSem, long hor, Categoria cate) {
		this.nombre=nom;
		this.descripcion=null;
		this.fechaInicio=fInicio;
		this.fechaFin=null;
		this.racha=rach;
		this.diasSemana=diasSem;
		this.hora=hor;
		this.categoria=cate;
	}
	public Habitos (String nom,Date fInicio, Date fFin, int rach, int[] diasSem, long hor, Categoria cate) {
		this.nombre=nom;
		this.descripcion=null;
		this.fechaInicio=fInicio;
		this.fechaFin=fFin;
		this.racha=rach;
		this.diasSemana=diasSem;
		this.hora=hor;
		this.categoria=cate;
	}
	public Habitos (String nom,Date fInicio, Date fFin, int[] diasSem, long hor, Categoria cate) {
		this.nombre=nom;
		this.descripcion=null;
		this.fechaInicio=fInicio;
		this.fechaFin=fFin;
		this.racha=0;
		this.diasSemana=diasSem;
		this.hora=hor;
	}
	public Habitos (String nom,String desc, Date fInicio, int rach, int[] diasSem, long hor, Categoria cate) {
		this.nombre=nom;
		this.descripcion=desc;
		this.fechaInicio=fInicio;
		this.fechaFin=null;
		this.racha=rach;
		this.diasSemana=diasSem;
		this.hora=hor;
		this.categoria=cate;
	}
	public Habitos (String nom,String desc, Date fInicio, int[] diasSem, long hor, Categoria cate) {
		this.nombre=nom;
		this.descripcion=desc;
		this.fechaInicio=fInicio;
		this.fechaFin=null;
		this.racha=0;
		this.diasSemana=diasSem;
		this.hora=hor;
		this.categoria=cate;
	}

	//metodos get
	public String getNombre() {
		return nombre;}
	public String getDescripcion() {
		return descripcion;}
	public Date getFechaInicio() {
		return fechaInicio;}
	public Date getFechaFin() {
		return fechaFin;}
	public int getRacha() {
		return racha;}
	public int[] getDiasSemana() {
		return diasSemana;}
	public long getHora() {
		return hora;}
	public Categoria getCategoria(){
		return categoria;}
	
//metodos set
	public void setNombre(String nombreR) {
		nombre=nombreR;}
	public void setDescripcion(String descripcionR) {
		descripcion=descripcionR;}
	public void setFechaInicio(Date fechaInicioR) {
		fechaInicio=fechaInicioR;}
	public void setFechaFin(Date fechaFinR) {
		fechaFin=fechaFinR;}
	public void setRacha(int rachaR) {
		racha=rachaR;}
	public void setDiasSemana(int[] diasSemanaR) {
		diasSemana=diasSemanaR;}
	public void setHora(long horaR) {
		hora=horaR;}
	public void setCategoria(Categoria cateR) {
		categoria=cateR;}
}