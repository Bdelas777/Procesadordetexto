package procesador;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;

public class ProcesadorStyle {

	public static void main(String[] args) {
		
		MarcoProcesadorII mimarco= new MarcoProcesadorII();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoProcesadorII extends JFrame{
	MarcoProcesadorII(){
		setTitle("Procesador de Texto");
		
		setBounds(600,300,600,350);
		
		LaminaProcesadorII milamina= new LaminaProcesadorII();
		
		add(milamina);	
		
		setVisible(true);
		
	}
	
}

class LaminaProcesadorII extends JPanel{
	public LaminaProcesadorII(){
		
		setLayout(new BorderLayout());
		
		JPanel laminaMenu=new JPanel();
		//Menus
		JMenuBar barra=new JMenuBar();
		
		fuente=new JMenu("Fuente");
		
		estilo=new JMenu("Estilo");
		
		tamano=new JMenu("Tamaño");
		//JMenu items
		ConfiguraMenu("Arial","fuente","Arial",9,10);
		
		ConfiguraMenu("Courier","fuente","Courier",9,10);
		
		ConfiguraMenu("Verdana","fuente","Verdana",9,10);
		
		ConfiguraMenu("Negrita","estilo","",Font.BOLD,1);
		
		ConfiguraMenu("Cursiva","estilo","",Font.ITALIC,1);
		
		ConfiguraMenu("12","tamano","",9,12);
		
		ConfiguraMenu("16","tamano","",9,16);
		
		ConfiguraMenu("20","tamano","",9,20);
		
		ConfiguraMenu("24","tamano","",9,24);
		
		
		//agregar menus a barra
		barra.add(fuente);
		
		barra.add(estilo);
		
		barra.add(tamano);
		
		laminaMenu.add(barra);
		
		add(laminaMenu,BorderLayout.NORTH);
		// texto area
		miarea=new JTextPane();
		
		add(miarea,BorderLayout.CENTER);
		
	}
	public void ConfiguraMenu(String rotulo,String menu, String tipoletra, int estilos
			, int tam) {
		
		JMenuItem elmenu= new JMenuItem(rotulo);
		
		if(menu.equals("fuente")) {
			
			fuente.add(elmenu);
			
			if(tipoletra=="Arial") {
				
				elmenu.addActionListener(new StyledEditorKit.FontFamilyAction("Change letter",
						"Arial"));
			} else if(tipoletra=="Courier") {
				
				elmenu.addActionListener(new StyledEditorKit.FontFamilyAction("Change letter",
						"Courier"));
			} else if(tipoletra=="Verdana") {
				
				elmenu.addActionListener(new StyledEditorKit.FontFamilyAction("Change letter",
						"Verdana"));
			}
			
		}else if(menu.equals("estilo")) {
			
			estilo.add(elmenu);
			
			if(estilos==Font.BOLD) {
				
				elmenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_DOWN_MASK));
				
				elmenu.addActionListener(new StyledEditorKit.BoldAction());
				
			}else if(estilos==Font.ITALIC) {
				
				elmenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,InputEvent.CTRL_DOWN_MASK));
				
				elmenu.addActionListener(new StyledEditorKit.ItalicAction());
				
			}
			
		}else if(menu.equals("tamano")){
			
			tamano.add(elmenu);
			
			elmenu.addActionListener(new StyledEditorKit.FontSizeAction("Change Size", tam));
			
		}
		
		
	}
	
	private JTextPane miarea;
	
	private JMenu fuente,estilo,tamano;
	
}