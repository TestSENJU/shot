package ui;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.gvt.GVTTreeRendererAdapter;
import org.apache.batik.swing.gvt.GVTTreeRendererEvent;
import org.apache.batik.swing.svg.GVTTreeBuilderAdapter;
import org.apache.batik.swing.svg.GVTTreeBuilderEvent;
import org.apache.batik.swing.svg.SVGDocumentLoaderAdapter;
import org.apache.batik.swing.svg.SVGDocumentLoaderEvent;

import sound.PlaySE;

public class SvgPanel {

		static ImageIcon a = new ImageIcon("img/a.jpg");
		static ImageIcon first = new ImageIcon("img/first.jpg");
		JSVGCanvas svgCanvas1 = new JSVGCanvas();
		JSVGCanvas svgCanvas2 = new JSVGCanvas();
		JSVGCanvas svgCanvas3 = new JSVGCanvas();
		
		public static MyFrame popup;     //弹窗
		public static MyFrame subpopup;
		public static LandingPanel land;
		public static JPanel svgPanel;
		private static JButton back;
		
		public SvgPanel() {
			
		}
		
		public void showSvg() {
			land = new LandingPanel("img/tablebg.jpg");
			land.setOpaque(false);
			land.setBounds(0, 0, Controller.f.getWidth(), Controller.f.getHeight());
			land.setLayout(null);
			
			svgPanel = new JPanel();
			svgPanel.setBounds(0, 0, 500, 618);
			svgPanel.setOpaque(false);
			
			File f1 = new File("svg/ATL.svg");
			File f2 = new File("svg/BKN.svg");
			File f3 = new File("svg/BOS.svg");
			
			svgCanvas1.setBounds(120, 30, 100, 100);
			svgCanvas1.setURI(f1.toURI().toString());
			svgCanvas1.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
				public void documentLoadingStarted(SVGDocumentLoaderEvent e){
				}
				public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
				}
			});
			svgCanvas1.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
				public void gvtBuildStarted(GVTTreeBuilderEvent e){
				}
				public void gvtBuildCompleted(GVTTreeBuilderEvent e){
					//frame.pack();
				}
			});
			svgCanvas1.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
				 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
					 }   
				 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 }
			});
			
			svgCanvas2.setBounds(120, 160, 100, 100);
			svgCanvas2.setURI(f2.toURI().toString());
			svgCanvas2.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
				public void documentLoadingStarted(SVGDocumentLoaderEvent e){
				}
				public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
				}
			});
			svgCanvas2.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
				public void gvtBuildStarted(GVTTreeBuilderEvent e){
				}
				public void gvtBuildCompleted(GVTTreeBuilderEvent e){
					//frame.pack();
				}
			});
			svgCanvas2.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
				 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
					 }   
				 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 }
			});
			
			svgCanvas3.setBounds(120, 300, 100, 100);
			svgCanvas3.setURI(f3.toURI().toString());
			svgCanvas3.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
				public void documentLoadingStarted(SVGDocumentLoaderEvent e){
					System.out.println("load start");
				}
				public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
					System.out.println("loaded");
				}
			});
			svgCanvas3.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
				public void gvtBuildStarted(GVTTreeBuilderEvent e){
					System.out.println("build start");
				}
				public void gvtBuildCompleted(GVTTreeBuilderEvent e){
					System.out.println("build complete");
					//frame.pack();
				}
			});
			svgCanvas3.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
				 public void gvtRenderingPrepare(GVTTreeRendererEvent e) { 
					 System.out.println("render prepare");
					 }   
				 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
					 System.out.println("render complete");
				 }
			});
			land.add(svgCanvas1, 0);
			land.add(svgCanvas2, 0);
			land.add(svgCanvas3, 0);
			
			//back button
			back = new JButton();
			back.setBounds(760, 500, 100, 30);
			back.setBorderPainted(true);
			back.setContentAreaFilled(false);
			back.setText("Back");
			back.setFont(new Font("微软雅黑",Font.PLAIN,23));
			//back.setIcon(backbutton);
			back.addMouseListener(new BackListener());
			land.add(back,0);
			
			land.add(svgPanel);
			Controller.f.add(land);
		}
		
		class BackListener implements MouseListener {
			public void mouseClicked(MouseEvent e) {
				land.setVisible(false);
				land.removeAll();
				Controller c = new Controller();
				c.layout();
			}
			public void mouseEntered(MouseEvent e) {
				PlaySE se = new PlaySE("music/enter.wav");
				new Thread(se).start();
			}

			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {}

			public void mouseReleased(MouseEvent e) {}
		}
}

