package procesador;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;

public class ProcesadorEjercicio {

	public static void main(String[] args) {
		
		MarcoProcesador mimarco= new MarcoProcesador();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoProcesador extends JFrame{
	MarcoProcesador(){
		setTitle("Procesador de Texto");
		
		setBounds(600,300,600,350);
		
		LaminaProcesador milamina= new LaminaProcesador();
		
		add(milamina);	
		
		setVisible(true);
		
	}
	
}

class LaminaProcesador extends JPanel{
	public LaminaProcesador(){
		
		setLayout(new BorderLayout());
		
		JPanel laminaMenu=new JPanel();
		//Menus
		JMenuBar barra=new JMenuBar();
		
		fuente=new JMenu("Fuente");
		
		estilo=new JMenu("Estilo");
		
		tamano=new JMenu("Tamaño");
		//JMenu items
		ConfiguraMenu("Arial","fuente","Arial",9,10,"");
		
		ConfiguraMenu("Courier","fuente","Courier",9,10,"");
		
		ConfiguraMenu("Verdana","fuente","Verdana",9,10,"");
		
		//ConfiguraMenu("Negrita","estilo","",Font.BOLD,1,"src/graficos/negrita.gif");
		
		//ConfiguraMenu("Cursiva","estilo","",Font.ITALIC,1,"src/graficos/cursiva.ico");
		
		JCheckBoxMenuItem negrita= new JCheckBoxMenuItem("Negrita",new
				ImageIcon("src/graficos/negrita.gif"));
		
		JCheckBoxMenuItem  cursiva= new JCheckBoxMenuItem("Cursiva",new
				ImageIcon("src/graficos/cursiva.ico"));
		
		negrita.addActionListener(new StyledEditorKit.BoldAction());
		
		cursiva.addActionListener(new StyledEditorKit.ItalicAction());
		
		estilo.add(negrita);
		
		estilo.add(cursiva);
		
		/*ConfiguraMenu("12","tamano","",9,12,"");
		
		ConfiguraMenu("16","tamano","",9,16,"");
		
		ConfiguraMenu("20","tamano","",9,20,"");
		
		ConfiguraMenu("24","tamano","",9,24,"");*/
		
		ButtonGroup tamagno= new ButtonGroup();
		
		JRadioButtonMenuItem tam12= new JRadioButtonMenuItem("12",true);
		
		JRadioButtonMenuItem tam16= new JRadioButtonMenuItem("16");
		
		JRadioButtonMenuItem tam20= new JRadioButtonMenuItem("20");
		
		JRadioButtonMenuItem tam24= new JRadioButtonMenuItem("24");
		
		tamagno.add(tam12);
		
		tamagno.add(tam16);
		
		tamagno.add(tam20);
		
		tamagno.add(tam24);
		
		tam12.addActionListener(new StyledEditorKit.FontSizeAction("Change Size", 12));
		
		tam16.addActionListener(new StyledEditorKit.FontSizeAction("Change Size", 16));
		
		tam20.addActionListener(new StyledEditorKit.FontSizeAction("Change Size", 20));
		
		tam24.addActionListener(new StyledEditorKit.FontSizeAction("Change Size", 24));
		
		tamano.add(tam12);
		
		tamano.add(tam16);
		
		tamano.add(tam20);
		
		tamano.add(tam24);
		//agregar menus a barra
		barra.add(fuente);
		
		barra.add(estilo);
		
		barra.add(tamano);
		
		laminaMenu.add(barra);
		
		add(laminaMenu,BorderLayout.NORTH);
		// texto area
		miarea=new JTextPane();
		
		add(miarea,BorderLayout.CENTER);
		
		JPopupMenu emergente= new JPopupMenu();
		
		JMenuItem negrita2= new JMenuItem("Negrita");
		
		JMenuItem cursiva2= new JMenuItem("Cursiva");
		
		emergente.add(negrita2);
		
		emergente.add(cursiva2);
		
		miarea.setComponentPopupMenu(emergente);
		
	}
	public void ConfiguraMenu(String rotulo,String menu, String tipoletra, int estilos
			, int tam,String rutaIcono) {
		
		JMenuItem elmenu= new JMenuItem(rotulo, new ImageIcon(rutaIcono));
		
		if(menu.equals("fuente")) {
			
			fuente.add(elmenu);
			
		}else if(menu.equals("estilo")) {
			
			estilo.add(elmenu);
			
		}else if(menu.equals("tamano")){
			
			tamano.add(elmenu);
			
		}
		
		elmenu.addActionListener(new GestionaElementos(rotulo,tipoletra,estilos,tam));
		
	}
	private class GestionaElementos implements ActionListener{
		
		String tipotexto,menu;
		
		int estiloletra,tamanoletra;
		
		public GestionaElementos(String elemento, String texto2,int estilo2,
				int tamletra2){
			
			tipotexto=texto2;
			
			estiloletra=estilo2;
			
			tamanoletra=tamletra2;
			
			menu=elemento;
			
		}
		public void actionPerformed(ActionEvent e) {
			
			letras=miarea.getFont();
			
			if(menu=="Arial" || menu=="Courier" || menu=="Verdana") {
				
				estiloletra=letras.getStyle();
				
				tamanoletra=letras.getSize();
				
			}/*else if (menu=="Cursiva" || menu=="Negrita" ) {
				
				if (letras.getStyle()==1 || letras.getStyle()==1) {
					
					estiloletra=3;
					
				}
				
				tipotexto=letras.getFontName();
				
				tamanoletra=letras.getSize();
				
			} else if(menu=="12" || menu=="16" || menu=="20" || menu=="24") {
				
				tipotexto=letras.getFontName();
				
				estiloletra=letras.getStyle();
				
			}*/
			
			miarea.setFont(new Font(tipotexto, estiloletra, tamanoletra));
			
			System.out.println("Fuente: "+tipotexto+"  Estilo: "+estiloletra+" Tamaño: "+ tamanoletra);
		}
		
	}
	private JTextPane miarea;
	
	private JMenu fuente,estilo,tamano;
	
	private Font letras;
}
