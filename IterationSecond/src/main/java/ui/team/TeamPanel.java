package ui.team;

import java.awt.Dimension;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.gvt.GVTTreeRendererAdapter;
import org.apache.batik.swing.gvt.GVTTreeRendererEvent;
import org.apache.batik.swing.svg.GVTTreeBuilderAdapter;
import org.apache.batik.swing.svg.GVTTreeBuilderEvent;
import org.apache.batik.swing.svg.SVGDocumentLoaderAdapter;
import org.apache.batik.swing.svg.SVGDocumentLoaderEvent;

import ui.IScrollBarUI;

public class TeamPanel {
	/**
	 * @param 展示所有球队信息的界面
	 *           ->只展示所有球队的队徽和名称点击可以进入详细信息界面
	 * @author forIris
	 * @version  June 12, 2015 11:41:31 AM
	 * **/
	private JPanel teamPanel;
	private JScrollPane scrollPane;
	JSVGCanvas svgCanvas1 = new JSVGCanvas();
	JSVGCanvas svgCanvas2 = new JSVGCanvas();
	JSVGCanvas svgCanvas3 = new JSVGCanvas();
	JSVGCanvas svgCanvas4 = new JSVGCanvas();
	JSVGCanvas svgCanvas5 = new JSVGCanvas();
	JSVGCanvas svgCanvas6 = new JSVGCanvas();
	JSVGCanvas svgCanvas7 = new JSVGCanvas();
	JSVGCanvas svgCanvas8 = new JSVGCanvas();
	JSVGCanvas svgCanvas9 = new JSVGCanvas();
	JSVGCanvas svgCanvas10 = new JSVGCanvas();
	JSVGCanvas svgCanvas11 = new JSVGCanvas();
	JSVGCanvas svgCanvas12 = new JSVGCanvas();
	JSVGCanvas svgCanvas13 = new JSVGCanvas();
	JSVGCanvas svgCanvas14 = new JSVGCanvas();
	JSVGCanvas svgCanvas15 = new JSVGCanvas();
	JSVGCanvas svgCanvas16 = new JSVGCanvas();
	JSVGCanvas svgCanvas17 = new JSVGCanvas();
	JSVGCanvas svgCanvas18 = new JSVGCanvas();
	JSVGCanvas svgCanvas19 = new JSVGCanvas();
	JSVGCanvas svgCanvas20 = new JSVGCanvas();
	JSVGCanvas svgCanvas21 = new JSVGCanvas();
	JSVGCanvas svgCanvas22 = new JSVGCanvas();
	JSVGCanvas svgCanvas23 = new JSVGCanvas();
	JSVGCanvas svgCanvas24 = new JSVGCanvas();
	JSVGCanvas svgCanvas25 = new JSVGCanvas();
	JSVGCanvas svgCanvas26 = new JSVGCanvas();
	JSVGCanvas svgCanvas27 = new JSVGCanvas();
	JSVGCanvas svgCanvas28 = new JSVGCanvas();
	JSVGCanvas svgCanvas29 = new JSVGCanvas();
	JSVGCanvas svgCanvas30 = new JSVGCanvas();

	public JScrollPane init(){
		teamPanel = new JPanel();
		teamPanel.setOpaque(false);

		//TODO
		//---------------------------------
		//东部联盟
		//-------------东南分区--------------------
		File f1 = new File("teamImg/ATL.svg");
		File f2 = new File("teamImg/CHA.svg");
		File f3 = new File("teamImg/MIA.svg");
		File f4 = new File("teamImg/ORL.svg");
		File f5 = new File("teamImg/WAS.svg");
		//-------------中央分区--------------------
		File f6 = new File("teamImg/CHI.svg");
		File f7 = new File("teamImg/CLE.svg");
		File f8 = new File("teamImg/DET.svg");
		File f9 = new File("teamImg/IND.svg");
		File f10 = new File("teamImg/MIL.svg");
		//--------------大西洋分区-------------------
		File f11 = new File("teamImg/BOS.svg");
		File f12 = new File("teamImg/BKN.svg");
		File f13 = new File("teamImg/NYK.svg");
		File f14 = new File("teamImg/PHI.svg");
		File f15 = new File("teamImg/TOR.svg");
		//---------------------------------
		//西部联盟
		//--------------太平洋分区-------------------
		File f16 = new File("teamImg/GSW.svg");
		File f17 = new File("teamImg/LAC.svg");
		File f18 = new File("teamImg/LAL.svg");
		File f19 = new File("teamImg/PHX.svg");
		File f20 = new File("teamImg/SAC.svg");
		//--------------西北分区-------------------
		File f21 = new File("teamImg/DEN.svg");
		File f22 = new File("teamImg/MIN.svg");
		File f23 = new File("teamImg/OKC.svg");
		File f24 = new File("teamImg/POR.svg");
		File f25 = new File("teamImg/UTA.svg");
		//--------------西南分区-------------------
		File f26 = new File("teamImg/DAL.svg");
		File f27 = new File("teamImg/HOU.svg");
		File f28 = new File("teamImg/MEM.svg");
		File f29 = new File("teamImg/NOP.svg");
		File f30 = new File("teamImg/SAS.svg");
		
		
		int toLeftFirst = 60;
		int toLeftSecond = 310;
		int toLeftThird = 560;
		int width = 120;
		int height = 120;
		//TODO
		
		svgCanvas1.setBounds(toLeftFirst, 0, width, height);
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
				 System.out.println(1);
			 }
		});
		
		svgCanvas2.setBounds(toLeftFirst, 150, width, height);
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
				 System.out.println(2);
			 }
		});
		
		svgCanvas3.setBounds(toLeftFirst, 150*2, width, height);
		svgCanvas3.setURI(f3.toURI().toString());
		svgCanvas3.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas3.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas3.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) { 
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 System.out.println("3");
			 }
		});
		svgCanvas4.setBounds(toLeftFirst, 150*3, width, height);
		svgCanvas4.setURI(f4.toURI().toString());
		svgCanvas4.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas4.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas4.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 System.out.println(4);
			 }
		});
		
		svgCanvas5.setBounds(toLeftFirst, 150*4, width, height);
		svgCanvas5.setURI(f5.toURI().toString());
		svgCanvas5.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas5.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas5.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 System.out.println(5);
			 }
		});
		//TODO
		svgCanvas6.setBounds(toLeftSecond, 0, width, height);
		svgCanvas6.setURI(f6.toURI().toString());
		svgCanvas6.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas6.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas6.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) { 
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 System.out.println("6");
			 }
		});
		svgCanvas7.setBounds(toLeftSecond, 150, width, height);
		svgCanvas7.setURI(f7.toURI().toString());
		svgCanvas7.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas7.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas7.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 System.out.println(7);
			 }
		});
		
		svgCanvas8.setBounds(toLeftSecond, 150*2, width, height);
		svgCanvas8.setURI(f8.toURI().toString());
		svgCanvas8.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas8.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas8.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) { 
				 System.out.println(8);
			 }
		});
		
		svgCanvas9.setBounds(toLeftSecond, 150*3, width, height);
		svgCanvas9.setURI(f9.toURI().toString());
		svgCanvas9.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas9.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas9.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) { 
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 System.out.println("9");
			 }
		});
		svgCanvas10.setBounds(toLeftSecond, 150*4, width, height);
		svgCanvas10.setURI(f10.toURI().toString());
		svgCanvas10.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas10.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas10.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) { 
				 System.out.println(10);
			 }
		});
		//TODO
		svgCanvas11.setBounds(toLeftThird, 0, width, height);
		svgCanvas11.setURI(f11.toURI().toString());
		svgCanvas11.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas11.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas11.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) { 
				 System.out.println(11);
			 }
		});
		
		svgCanvas12.setBounds(toLeftThird, 150, width, height);
		svgCanvas12.setURI(f12.toURI().toString());
		svgCanvas12.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas12.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas12.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) { 
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 System.out.println("12");
			 }
		});
		svgCanvas13.setBounds(toLeftThird, 150*2, width, height);
		svgCanvas13.setURI(f13.toURI().toString());
		svgCanvas13.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas13.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas13.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 System.out.println(13);
			 }
		});
		
		svgCanvas14.setBounds(toLeftThird, 150*3, width, height);
		svgCanvas14.setURI(f14.toURI().toString());
		svgCanvas14.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas14.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas14.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 System.out.println(14);
			 }
		});
		
		svgCanvas15.setBounds(toLeftThird, 150*4, width, height);
		svgCanvas15.setURI(f15.toURI().toString());
		svgCanvas15.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas15.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas15.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) { 
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 System.out.println("15");
			 }
		});
		//TODO
		svgCanvas16.setBounds(toLeftFirst, 150*5, width, height);
		svgCanvas16.setURI(f16.toURI().toString());
		svgCanvas16.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas16.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas16.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 System.out.println(16);
			 }
		});
		
		svgCanvas17.setBounds(toLeftFirst, 150*6, width, height);
		svgCanvas17.setURI(f17.toURI().toString());
		svgCanvas17.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas17.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas17.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 System.out.println(17);
			 }
		});
		
		svgCanvas18.setBounds(toLeftFirst, 150*7, width, height);
		svgCanvas18.setURI(f18.toURI().toString());
		svgCanvas18.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas18.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas18.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) { 
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 System.out.println("18");
			 }
		});
		svgCanvas19.setBounds(toLeftFirst, 150*8, width, height);
		svgCanvas19.setURI(f19.toURI().toString());
		svgCanvas19.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas19.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas19.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {
				 System.out.println(19);
			 }
		});
		
		svgCanvas20.setBounds(toLeftFirst, 150*9, width, height);
		svgCanvas20.setURI(f20.toURI().toString());
		svgCanvas20.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas20.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas20.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 System.out.println(20);
			 }
		});
		//TODO
		svgCanvas21.setBounds(toLeftSecond, 150*5, width, height);
		svgCanvas21.setURI(f21.toURI().toString());
		svgCanvas21.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas21.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas21.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) { 
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 System.out.println("21");
			 }
		});
		svgCanvas22.setBounds(toLeftSecond, 150*6, width, height);
		svgCanvas22.setURI(f22.toURI().toString());
		svgCanvas22.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas22.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas22.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 System.out.println(22);
			 }
		});
		
		svgCanvas23.setBounds(toLeftSecond, 150*7, width, height);
		svgCanvas23.setURI(f23.toURI().toString());
		svgCanvas23.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas23.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas23.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {
				 System.out.println("23");
			 }
		});
		
		svgCanvas24.setBounds(toLeftSecond, 150*8, width, height);
		svgCanvas24.setURI(f24.toURI().toString());
		svgCanvas24.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas24.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas24.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) { 
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 System.out.println("24");
			 }
		});
		svgCanvas25.setBounds(toLeftSecond, 150*9, width, height);
		svgCanvas25.setURI(f25.toURI().toString());
		svgCanvas25.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas25.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas25.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 System.out.println("25");
			 }
		});
		//TODO
		svgCanvas26.setBounds(toLeftThird, 150*5, width, height);
		svgCanvas26.setURI(f26.toURI().toString());
		svgCanvas26.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas26.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas26.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 System.out.println("26");
			 }
		});
		
		svgCanvas27.setBounds(toLeftThird, 150*6, width, height);
		svgCanvas27.setURI(f27.toURI().toString());
		svgCanvas27.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas27.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas27.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) { 
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 System.out.println("27");
			 }
		});
		svgCanvas28.setBounds(toLeftThird, 150*7, width, height);
		svgCanvas28.setURI(f28.toURI().toString());
		svgCanvas28.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas28.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas28.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 System.out.println("28");
			 }
		});
		
		svgCanvas29.setBounds(toLeftThird, 150*8, width, height);
		svgCanvas29.setURI(f29.toURI().toString());
		svgCanvas29.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas29.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas29.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {
				 System.out.println("29");
			 }
		});
		
		svgCanvas30.setBounds(toLeftThird, 150*9, width, height);
		svgCanvas30.setURI(f30.toURI().toString());
		svgCanvas30.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas30.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas30.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) { 
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {  
				 System.out.println("30");
			 }
		});
		//TODO
		teamPanel.add(svgCanvas1, 0);
		teamPanel.add(svgCanvas2, 0);
		teamPanel.add(svgCanvas3, 0);
		teamPanel.add(svgCanvas4, 0);
		teamPanel.add(svgCanvas5, 0);
		teamPanel.add(svgCanvas6, 0);
		teamPanel.add(svgCanvas7, 0);
		teamPanel.add(svgCanvas8, 0);
		teamPanel.add(svgCanvas9, 0);
		teamPanel.add(svgCanvas10, 0);
		teamPanel.add(svgCanvas11, 0);
		teamPanel.add(svgCanvas12, 0);
		teamPanel.add(svgCanvas13, 0);
		teamPanel.add(svgCanvas14, 0);
		teamPanel.add(svgCanvas15, 0);
		teamPanel.add(svgCanvas16, 0);
		teamPanel.add(svgCanvas17, 0);
		teamPanel.add(svgCanvas18, 0);
		teamPanel.add(svgCanvas19, 0);
		teamPanel.add(svgCanvas20, 0);
		teamPanel.add(svgCanvas21, 0);
		teamPanel.add(svgCanvas22, 0);
		teamPanel.add(svgCanvas23, 0);
		teamPanel.add(svgCanvas24, 0);
		teamPanel.add(svgCanvas25, 0);
		teamPanel.add(svgCanvas26, 0);
		teamPanel.add(svgCanvas27, 0);
		teamPanel.add(svgCanvas28, 0);
		teamPanel.add(svgCanvas29, 0);
		teamPanel.add(svgCanvas30, 0);
		
		//TODO
		scrollPane = new JScrollPane(teamPanel);  
	    scrollPane.getViewport().setOpaque(false);    //将JScrollPane设置为透明  
	    scrollPane.setBounds(0, 100, 1000-130-60, 500);    
	    
	    //scrollPane.setViewportView(tablePanel);
	    teamPanel.setPreferredSize(new Dimension(1000-130-60, 1500));
	    scrollPane.setOpaque(false);
	    scrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
        scrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());
		teamPanel.setVisible(true);
		teamPanel.setLayout(null);	
		return scrollPane;
	}
}
