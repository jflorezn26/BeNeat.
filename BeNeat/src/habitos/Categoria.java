package habitos;

public class Categoria {
	//Componentes
		String nombre;
		String descripcion;
		String color;
		
	//metodos thisConstructor
		public Categoria (String nom,String desc,String col) {
			this.nombre=nom;
			this.descripcion=desc;
			this.color=col;
		}
		public Categoria (String nom,String desc) {
			this.nombre=nom;
			this.descripcion=desc;
			this.color=null;
		}
		public Categoria (String nom) {
			this.nombre=nom;
			this.descripcion=null;
			this.color=null;
		}
		public Categoria() {
			
		}
		
	//metodos get
		public String getNombre() {
			return nombre;}
		public String getDescripcion() {
			return descripcion;}
		public String getColor() {
			return color;}
		
	//metodos set
		public void setNombre(String nombreR) {
			nombre=nombreR;}
		public void setDescripcion(String descripcionR) {
			descripcion=descripcionR;}
		public void setColor(String colorR) {
			color=colorR;}
		
	}