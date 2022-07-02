package procesador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;

public class ProcesadorEmergente {

	public static void main(String[] args) {
		
		MarcoProcesadorEmergente mimarco= new MarcoProcesadorEmergente();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoProcesadorEmergente extends JFrame{
	MarcoProcesadorEmergente(){
		setTitle("Procesador de Texto");
		
		//setBounds(600,300,600,350);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		LaminaProcesadorEmergente milamina= new LaminaProcesadorEmergente();
		
		add(milamina);	
		
		setVisible(true);
		
	}
	
}

class LaminaProcesadorEmergente extends JPanel{
	public LaminaProcesadorEmergente(){
		
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
		//Imagenes muy grandes es un ejemplo
		ConfiguraMenu("Negrita","estilo","",Font.BOLD,1,"src/graficos/negrita.gif.ico");
		
		ConfiguraMenu("Cursiva","estilo","",Font.ITALIC,1,"src/graficos/cursiva.ico");
		//4 es parametro para subrayado la clase FOnt no tiene subrayado
		ConfiguraMenu("Subrayado","estilo","",4,1,"src/graficos/subrayado.ico");
		
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
		
		//tam24.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_DOWN_MASK));
		
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
		//Ventana emergente
		JPopupMenu emergente= new JPopupMenu();
		
		JMenuItem negrita2= new JMenuItem("Negrita");
		
		JMenuItem cursiva2= new JMenuItem("Cursiva");
		
		JMenuItem subrayado2= new JMenuItem("Subrayado");
		
		negrita2.addActionListener(new StyledEditorKit.BoldAction());
		
		cursiva2.addActionListener(new StyledEditorKit.ItalicAction());
		
		subrayado2.addActionListener(new StyledEditorKit.UnderlineAction());
		
		emergente.add(negrita2);
		
		emergente.add(cursiva2);
		
		emergente.add(subrayado2);
		
		miarea.setComponentPopupMenu(emergente);
		
		//Barras de herramientas
		
		barra2=new JToolBar();
		
		ConfiguraBarra("src/graficos/negrita.gif").addActionListener
			(new StyledEditorKit.BoldAction());
		
		ConfiguraBarra("src/graficos/cursiva.gif").addActionListener
		(new StyledEditorKit.ItalicAction());
		
		ConfiguraBarra("src/graficos/subrayado.gif").addActionListener
			(new StyledEditorKit.UnderlineAction());
		
		barra2.addSeparator();
		
		ConfiguraBarra("src/graficos/azul.gif").addActionListener
		(new StyledEditorKit.ForegroundAction("Change Blue", Color.BLUE));
		
		ConfiguraBarra("src/graficos/rojo.gif").addActionListener
		(new StyledEditorKit.ForegroundAction("Change Red", Color.RED));
		
		ConfiguraBarra("src/graficos/negro.gif").addActionListener
		(new StyledEditorKit.ForegroundAction("Change Black", Color.BLACK));
		
		ConfiguraBarra("src/graficos/izquierda.gif").addActionListener
		(new StyledEditorKit.AlignmentAction("Izquieda", 0));
		
		ConfiguraBarra("src/graficos/centrado.gif").addActionListener
		(new StyledEditorKit.AlignmentAction("Centrado", 1));
		
		ConfiguraBarra("src/graficos/derecha.gif").addActionListener
		(new StyledEditorKit.AlignmentAction("Derecha", 2));
		
		ConfiguraBarra("src/graficos/justificado.gif").addActionListener
		(new StyledEditorKit.AlignmentAction("Justificado", 3));
		
		barra2.addSeparator();
		
		//barra2.setOrientation(1);
		
		add(barra2,BorderLayout.SOUTH);
		
		
	}
	
	public JButton ConfiguraBarra(String ruta) {
		
		JButton boton= new JButton(new ImageIcon(ruta));
		
		barra2.add(boton);
		
		return boton;
		
	}
	public void ConfiguraMenu(String rotulo,String menu, String tipoletra, int estilos
			, int tam,String rutaIcono) {
		
		JMenuItem elmenu= new JMenuItem(rotulo, new ImageIcon(rutaIcono));
		
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
				
			}else if(estilos==4){
				
				elmenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK));
				
				elmenu.addActionListener(new StyledEditorKit.UnderlineAction());
				
			}
			
		}
		
	}
		
	private JTextPane miarea;
	
	private JMenu fuente,estilo,tamano;
	
	private JToolBar barra2;
}
//Barra herramienta version larga
/*JToolBar barra2=new JToolBar();
//cambio estilo
JButton negrita3= new JButton(new ImageIcon ("src/graficos/negrita.gif"));

JButton cursiva3= new JButton(new ImageIcon ("src/graficos/cursiva.gif"));

JButton subrayado3= new JButton(new ImageIcon ("src/graficos/subrayado.gif"));
//cambio color
JButton AzulBarra= new JButton(new ImageIcon ("src/graficos/azul.gif"));

JButton RojoBarra= new JButton(new ImageIcon ("src/graficos/rojo.gif"));

JButton AmarilloBarra= new JButton(new ImageIcon ("src/graficos/amarillo.gif"));
//cambio alineacion
JButton Derecha= new JButton(new ImageIcon ("src/graficos/derecha.gif"));

JButton Izquierda= new JButton(new ImageIcon ("src/graficos/izquierda.gif"));

JButton Centrado= new JButton(new ImageIcon ("src/graficos/centrado.gif"));

JButton Justificado= new JButton(new ImageIcon ("src/graficos/justificado.gif"));

negrita3.addActionListener(new StyledEditorKit.BoldAction());

cursiva3.addActionListener(new StyledEditorKit.ItalicAction());

subrayado3.addActionListener(new StyledEditorKit.UnderlineAction());

AzulBarra.addActionListener(new StyledEditorKit.ForegroundAction("Change Blue", 
		Color.BLUE));

AmarilloBarra.addActionListener(new StyledEditorKit.ForegroundAction("Change Yellow", 
		Color.YELLOW));

RojoBarra.addActionListener(new StyledEditorKit.ForegroundAction("Change RED", 
		Color.RED));

Izquierda.addActionListener(new StyledEditorKit.AlignmentAction("Izquieda", 0));

Centrado.addActionListener(new StyledEditorKit.AlignmentAction("Centrado", 1));

Derecha.addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 2));

Justificado.addActionListener(new StyledEditorKit.AlignmentAction("Justificado", 3));

barra2.add(cursiva3);

barra2.add(negrita3);

barra2.add(subrayado3);

barra2.add(AzulBarra);

barra2.add(RojoBarra);

barra2.add(AmarilloBarra);

barra2.add(Izquierda);

barra2.add(Centrado);

barra2.add(Derecha);

barra2.add(Justificado);*/