package procesador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
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
import javax.swing.text.StyledEditorKit.FontSizeAction;
import javax.swing.text.StyledEditorKit.ForegroundAction;

public class ProcesadorPersonal {

	public static void main(String[] args) {
		
		Marco1 mimarco= new Marco1();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class Marco1 extends JFrame{
	Marco1(){
		setTitle("Procesador de Texto");
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		Lamina1 milamina= new Lamina1();
		
		add(milamina);	
		
		setVisible(true);
		
	}
	
}

class Lamina1 extends JPanel{
	public Lamina1(){
		
		setLayout(new BorderLayout());
		
		laminaMenu=new JPanel();
		//Menus
		JMenuBar barra=new JMenuBar();
		
		fuente=new JMenu("Fuente");
		
		estilo=new JMenu("Estilo");
		
		tamano=new JMenu("Tamaño");
		
		color=new JMenu("Color");
		
		//JItem
		String [] NombresDeFuentes=GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getAvailableFontFamilyNames();
		
		for(String NombreFuente:NombresDeFuentes) {
			
			set_fuente(NombreFuente);
			
		}
		
		set_estilo("Negrita",Font.BOLD);
		
		set_estilo("Cursiva",Font.ITALIC);
		
		set_estilo("Subrayado",4);
		
		for(int i=8;i<72;i+=4) {
			
			String cadena= i + "";
			
			set_tamano(cadena,i);
			
		}
		
		set_color("Rojo",Color.red);
		
		set_color("Azul",Color.BLUE);
		
		set_color("Negro",Color.BLACK);
		
		barra.add(fuente);
		
		barra.add(estilo);
		
		barra.add(tamano);
		
		barra.add(color);

		laminaMenu.add(barra);
		
		add(laminaMenu,BorderLayout.NORTH);
		
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
		
		add(barra2,BorderLayout.SOUTH);
		
	}
	
	public void set_fuente(String rotulo) {
		
		JMenuItem elmenu= new JMenuItem(rotulo);
		
		fuente.add(elmenu);
		
		elmenu.addActionListener(new StyledEditorKit.FontFamilyAction("Change letter",
				rotulo));
		
	}
	
	public void set_estilo(String rotulo,int estilos) {
		
		JMenuItem elmenu= new JMenuItem(rotulo);
		
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
	
	public void set_tamano(String rotulo,int tamano2) {
	
		ButtonGroup tamagno= new ButtonGroup();
		
		if(rotulo.equals("12")) {
			
			JRadioButtonMenuItem tam= new JRadioButtonMenuItem(rotulo,true);
			
			tamagno.add(tam);
			
			tam.addActionListener(new StyledEditorKit.FontSizeAction("Change Size", tamano2));
			
			tamano.add(tam);
			
		}else {
			
			JRadioButtonMenuItem tam= new JRadioButtonMenuItem(rotulo,false);
			
			tamagno.add(tam);
			
			tam.addActionListener(new StyledEditorKit.FontSizeAction("Change Size", tamano2));
			
			tamano.add(tam);
		}
			
	}
	
	public void set_color(String rotulo, Color color2) {
		
		ButtonGroup colores= new ButtonGroup();
		
			if(rotulo.equals("Negro")) {
				
				JRadioButtonMenuItem col= new JRadioButtonMenuItem(rotulo,true);
			
				colores.add(col);
			
				col.addActionListener(new StyledEditorKit.ForegroundAction("Change Color",color2));
			
				color.add(col);
			
			}else {
			
				JRadioButtonMenuItem col= new JRadioButtonMenuItem(rotulo,false);
			
				colores.add(col);
			
				col.addActionListener(new StyledEditorKit.ForegroundAction("Change Color",color2));
			
				color.add(col);
		}
		
	}
		
public JButton ConfiguraBarra(String ruta) {
		
		JButton boton= new JButton(new ImageIcon(ruta));
		
		barra2.add(boton);
		
		return boton;
		
	}
	
	private JMenu fuente,estilo,tamano,color;
	
	private JTextPane miarea;
	
	private JPanel laminaMenu;
	
	private JToolBar barra2;
	
}