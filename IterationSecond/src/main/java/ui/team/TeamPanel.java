package ui.team;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.gvt.GVTTreeRendererAdapter;
import org.apache.batik.swing.gvt.GVTTreeRendererEvent;
import org.apache.batik.swing.svg.GVTTreeBuilderAdapter;
import org.apache.batik.swing.svg.GVTTreeBuilderEvent;
import org.apache.batik.swing.svg.SVGDocumentLoaderAdapter;
import org.apache.batik.swing.svg.SVGDocumentLoaderEvent;

import ui.AllImages;
import ui.IScrollBarUI;
import vo.PlayerBasicVO;
import BL.PlayerBL;
import BL.PlayerBL_Impl;
import BL.TeamBL;
import BL.TeamBL_Impl;

public class TeamPanel {
	/**
	 * @param 展示所有球队信息的界面
	 *           ->只展示所有球队的队徽和名称点击可以进入详细信息界面
	 * @author forIris
	 * @version  June 12, 2015 11:41:31 AM
	 * **/
	private JPanel basic;
	private JPanel teamPanel;
	private JScrollPane scrollPane;
	private JButton panelTitle;
	//
	private JButton eastLeague;
	private JButton esPart;
	private JButton cPart;
	private JButton atlanticPart;
	private JButton westLeague;
	private JButton pacificPart;
	private JButton wnPart;
	private JButton wsPart;
	//
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
	
	//
	TeamBL tbl = new TeamBL_Impl();
	PlayerBL pbl = new PlayerBL_Impl();

	public JPanel init(){
		basic = new JPanel();
		basic.setOpaque(false);
		basic.setBounds(130, 0, 1000-130, 700);
		basic.setLayout(null);
		teamPanel = new JPanel();
		teamPanel.setOpaque(false);

		panelTitle = new JButton();
		panelTitle.setBounds(40, 15, 300, 70);
		panelTitle.setOpaque(false);
		panelTitle.setContentAreaFilled(false);
		panelTitle.setBorderPainted(false);
		panelTitle.setIcon(AllImages.IMG_TEAMPANEL_TITLE);
		basic.add(panelTitle, 0);
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
		
		
		int toLeftFirst = 40;
		int toLeftSecond = 300;
		int toLeftThird = 560;
		int width = 120;
		int height = 120;
		//TODO
		eastLeague = new JButton();
		eastLeague.setBounds(toLeftFirst, 0, 200, 50);
		eastLeague.setContentAreaFilled(false);
		eastLeague.setOpaque(false);
		eastLeague.setBorderPainted(false);
		eastLeague.setIcon(AllImages.IMG_EASTERNTITLE);
		teamPanel.add(eastLeague, 0);
		
		esPart = new JButton();
		esPart.setBounds(toLeftFirst-30, 50, 150, 40);
		esPart.setContentAreaFilled(false);
		esPart.setBorderPainted(false);
		esPart.setOpaque(false);
		esPart.setIcon(AllImages.IMG_ES_PART);
		teamPanel.add(esPart, 0);
		
		cPart = new JButton();
		cPart.setBounds(toLeftSecond-30, 50, 150, 40);
		cPart.setContentAreaFilled(false);
		cPart.setBorderPainted(false);
		cPart.setOpaque(false);
		cPart.setIcon(AllImages.IMG_CENTER_PART);
		teamPanel.add(cPart, 0);
		
		atlanticPart = new JButton();
		atlanticPart.setBounds(toLeftThird-30+10, 50, 150, 40);
		atlanticPart.setContentAreaFilled(false);
		atlanticPart.setBorderPainted(false);
		atlanticPart.setOpaque(false);
		atlanticPart.setIcon(AllImages.IMG_ATLANTIC_PART);
		teamPanel.add(atlanticPart, 0);
		
		JLabel atl = new JLabel();
		atl.setBounds(toLeftFirst+120+40, 100+40, 80, 40);
		atl.setText("老鹰");
		atl.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		atl.setForeground(Color.WHITE);
		atl.setOpaque(false);
		teamPanel.add(atl, 0);
		
		svgCanvas1.setBounds(toLeftFirst, 0+100, width, height);
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
		svgCanvas1.addMouseListener(new Svg1Listener());
		
		JLabel cha = new JLabel();
		cha.setBounds(toLeftFirst+120+40, 150+100+40, 80, 40);
		cha.setText("黄蜂");
		cha.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		cha.setForeground(Color.WHITE);
		cha.setOpaque(false);
		teamPanel.add(cha, 0);
		
		svgCanvas2.setBounds(toLeftFirst, 150+100, width, height);
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
		svgCanvas2.addMouseListener(new Svg2Listener());
		
		JLabel mia = new JLabel();
		mia.setBounds(toLeftFirst+120+40, 150*2+100+40, 80, 40);
		mia.setText("热火");
		mia.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mia.setForeground(Color.WHITE);
		mia.setOpaque(false);
		teamPanel.add(mia, 0);
		
		svgCanvas3.setBounds(toLeftFirst, 150*2+100, width, height);
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
		svgCanvas3.addMouseListener(new Svg3Listener());
		
		JLabel orl = new JLabel();
		orl.setBounds(toLeftFirst+120+40, 150*3+100+40, 80, 40);
		orl.setText("魔术");
		orl.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		orl.setForeground(Color.WHITE);
		orl.setOpaque(false);
		teamPanel.add(orl, 0);
		
		svgCanvas4.setBounds(toLeftFirst, 150*3+100, width, height);
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
		svgCanvas4.addMouseListener(new Svg4Listener());
		
		JLabel was = new JLabel();
		was.setBounds(toLeftFirst+120+40, 150*4+100+40, 80, 40);
		was.setText("奇才");
		was.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		was.setForeground(Color.WHITE);
		was.setOpaque(false);
		teamPanel.add(was, 0);
		
		svgCanvas5.setBounds(toLeftFirst, 150*4+100, width, height);
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
		svgCanvas5.addMouseListener(new Svg5Listener());
		
		//TODO
		JLabel chi = new JLabel();
		chi.setBounds(toLeftSecond+120+40, 100+40, 80, 40);
		chi.setText("公牛");
		chi.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		chi.setForeground(Color.WHITE);
		chi.setOpaque(false);
		teamPanel.add(chi, 0);
		
		svgCanvas6.setBounds(toLeftSecond, 0+100, width, height);
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
		svgCanvas6.addMouseListener(new Svg6Listener());
		
		JLabel cle = new JLabel();
		cle.setBounds(toLeftSecond+120+40, 150+100+40, 80, 40);
		cle.setText("骑士");
		cle.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		cle.setForeground(Color.WHITE);
		cle.setOpaque(false);
		teamPanel.add(cle, 0);
		
		svgCanvas7.setBounds(toLeftSecond, 150+100, width, height);
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
		svgCanvas7.addMouseListener(new Svg7Listener());
		
		JLabel det = new JLabel();
		det.setBounds(toLeftSecond+120+40, 150*2+100+40, 80, 40);
		det.setText("活塞");
		det.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		det.setForeground(Color.WHITE);
		det.setOpaque(false);
		teamPanel.add(det, 0);
		
		svgCanvas8.setBounds(toLeftSecond, 150*2+100, width, height);
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
		svgCanvas8.addMouseListener(new Svg8Listener());
		
		JLabel ind = new JLabel();
		ind.setBounds(toLeftSecond+120+40, 150*3+100+40, 80, 40);
		ind.setText("步行者");
		ind.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		ind.setForeground(Color.WHITE);
		ind.setOpaque(false);
		teamPanel.add(ind, 0);
		
		svgCanvas9.setBounds(toLeftSecond, 150*3+100, width, height);
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
		svgCanvas9.addMouseListener(new Svg9Listener());
		
		JLabel mil = new JLabel();
		mil.setBounds(toLeftSecond+120+40, 150*4+100+40, 80, 40);
		mil.setText("雄鹿");
		mil.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mil.setForeground(Color.WHITE);
		mil.setOpaque(false);
		teamPanel.add(mil, 0);
		
		svgCanvas10.setBounds(toLeftSecond, 150*4+100, width, height);
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
		svgCanvas10.addMouseListener(new Svg10Listener());
		
		//TODO
		JLabel bos = new JLabel();
		bos.setBounds(toLeftThird+120+40, 100+40, 90, 40);
		bos.setText("凯尔特人");
		bos.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		bos.setForeground(Color.WHITE);
		bos.setOpaque(false);
		teamPanel.add(bos, 0);
		
		svgCanvas11.setBounds(toLeftThird, 0+100, width, height);
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
		svgCanvas11.addMouseListener(new Svg11Listener());
		
		JLabel bkn = new JLabel();
		bkn.setBounds(toLeftThird+120+40, 150+100+40, 90, 40);
		bkn.setText("篮网");
		bkn.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		bkn.setForeground(Color.WHITE);
		bkn.setOpaque(false);
		teamPanel.add(bkn, 0);
		
		svgCanvas12.setBounds(toLeftThird, 150+100, width, height);
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
		svgCanvas12.addMouseListener(new Svg12Listener());
		
		JLabel nyk = new JLabel();
		nyk.setBounds(toLeftThird+120+40, 150*2+100+40, 90, 40);
		nyk.setText("尼克斯");
		nyk.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		nyk.setForeground(Color.WHITE);
		nyk.setOpaque(false);
		teamPanel.add(nyk, 0);
		
		svgCanvas13.setBounds(toLeftThird, 150*2+100, width, height);
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
		svgCanvas13.addMouseListener(new Svg13Listener());
		
		JLabel phi = new JLabel();
		phi.setBounds(toLeftThird+120+40, 150*3+100+40, 80, 40);
		phi.setText("76人");
		phi.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		phi.setForeground(Color.WHITE);
		phi.setOpaque(false);
		teamPanel.add(phi, 0);
		
		svgCanvas14.setBounds(toLeftThird, 150*3+100, width, height);
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
		svgCanvas14.addMouseListener(new Svg14Listener());
		
		JLabel tor = new JLabel();
		tor.setBounds(toLeftThird+120+40, 150*4+100+40, 80, 40);
		tor.setText("猛龙");
		tor.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		tor.setForeground(Color.WHITE);
		tor.setOpaque(false);
		teamPanel.add(tor, 0);
		
		svgCanvas15.setBounds(toLeftThird, 150*4+100, width, height);
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
		svgCanvas15.addMouseListener(new Svg15Listener());
		
		//TODO
		westLeague = new JButton();
		westLeague.setBounds(toLeftFirst, 150*5+100, 200, 50);
		westLeague.setContentAreaFilled(false);
		westLeague.setOpaque(false);
		westLeague.setBorderPainted(false);
		westLeague.setIcon(AllImages.IMG_WESTERNTITLE);
		teamPanel.add(westLeague, 0);
		
		pacificPart = new JButton();
		pacificPart.setBounds(toLeftFirst-30+10, 150*5+100+50, 150, 40);
		pacificPart.setContentAreaFilled(false);
		pacificPart.setBorderPainted(false);
		pacificPart.setOpaque(false);
		pacificPart.setIcon(AllImages.IMG_PACIFIC_PART);
		teamPanel.add(pacificPart, 0);
		
		wnPart = new JButton();
		wnPart.setBounds(toLeftSecond-30, 150*5+100+50, 150, 40);
		wnPart.setContentAreaFilled(false);
		wnPart.setBorderPainted(false);
		wnPart.setOpaque(false);
		wnPart.setIcon(AllImages.IMG_WN_PART);
		teamPanel.add(wnPart, 0);
		
		wsPart = new JButton();
		wsPart.setBounds(toLeftThird-30, 150*5+100+50, 150, 40);
		wsPart.setContentAreaFilled(false);
		wsPart.setBorderPainted(false);
		wsPart.setOpaque(false);
		wsPart.setIcon(AllImages.IMG_WS_PART);
		teamPanel.add(wsPart, 0);
		
		JLabel gsw = new JLabel();
		gsw.setBounds(toLeftFirst+120+40, 150*5+200+40, 80, 40);
		gsw.setText("勇士");
		gsw.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		gsw.setForeground(Color.WHITE);
		gsw.setOpaque(false);
		teamPanel.add(gsw, 0);
		
		svgCanvas16.setBounds(toLeftFirst, 150*5+200, width, height);
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
		svgCanvas16.addMouseListener(new Svg16Listener());
		
		JLabel lac = new JLabel();
		lac.setBounds(toLeftFirst+120+40, 150*6+200+40, 80, 40);
		lac.setText("快船");
		lac.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lac.setForeground(Color.WHITE);
		lac.setOpaque(false);
		teamPanel.add(lac, 0);
		
		svgCanvas17.setBounds(toLeftFirst, 150*6+200, width, height);
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
		svgCanvas17.addMouseListener(new Svg17Listener());
		
		JLabel lal = new JLabel();
		lal.setBounds(toLeftFirst+120+40, 150*7+200+40, 80, 40);
		lal.setText("湖人");
		lal.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lal.setForeground(Color.WHITE);
		lal.setOpaque(false);
		teamPanel.add(lal, 0);
		
		svgCanvas18.setBounds(toLeftFirst, 150*7+200, width, height);
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
		svgCanvas18.addMouseListener(new Svg18Listener());
		
		JLabel phx = new JLabel();
		phx.setBounds(toLeftFirst+120+40, 150*8+200+40, 80, 40);
		phx.setText("太阳");
		phx.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		phx.setForeground(Color.WHITE);
		phx.setOpaque(false);
		teamPanel.add(phx, 0);
		
		svgCanvas19.setBounds(toLeftFirst, 150*8+200, width, height);
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
		svgCanvas19.addMouseListener(new Svg19Listener());
		
		JLabel sac = new JLabel();
		sac.setBounds(toLeftFirst+120+40, 150*9+200+40, 80, 40);
		sac.setText("国王");
		sac.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		sac.setForeground(Color.WHITE);
		sac.setOpaque(false);
		teamPanel.add(sac, 0);
		
		svgCanvas20.setBounds(toLeftFirst, 150*9+200, width, height);
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
		svgCanvas20.addMouseListener(new Svg20Listener());
		
		//TODO
		JLabel den = new JLabel();
		den.setBounds(toLeftSecond+120+40, 150*5+200+40, 80, 40);
		den.setText("掘金");
		den.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		den.setForeground(Color.WHITE);
		den.setOpaque(false);
		teamPanel.add(den, 0);
		
		svgCanvas21.setBounds(toLeftSecond, 150*5+200, width, height);
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
		svgCanvas21.addMouseListener(new Svg21Listener());
		
		JLabel min = new JLabel();
		min.setBounds(toLeftSecond+120+40, 150*6+200+40, 80, 40);
		min.setText("森林狼");
		min.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		min.setForeground(Color.WHITE);
		min.setOpaque(false);
		teamPanel.add(min, 0);
		
		svgCanvas22.setBounds(toLeftSecond, 150*6+200, width, height);
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
		svgCanvas22.addMouseListener(new Svg22Listener());
		
		JLabel okc = new JLabel();
		okc.setBounds(toLeftSecond+120+40, 150*7+200+40, 80, 40);
		okc.setText("雷霆");
		okc.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		okc.setForeground(Color.WHITE);
		okc.setOpaque(false);
		teamPanel.add(okc, 0);
		
		svgCanvas23.setBounds(toLeftSecond, 150*7+200, width, height);
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
		svgCanvas23.addMouseListener(new Svg23Listener());
		
		JLabel por = new JLabel();
		por.setBounds(toLeftSecond+120+40, 150*8+200+40, 80, 40);
		por.setText("开拓者");
		por.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		por.setForeground(Color.WHITE);
		por.setOpaque(false);
		teamPanel.add(por, 0);
		
		svgCanvas24.setBounds(toLeftSecond, 150*8+200, width, height);
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
		svgCanvas24.addMouseListener(new Svg24Listener());
		
		JLabel uta = new JLabel();
		uta.setBounds(toLeftSecond+120+40, 150*9+200+40, 80, 40);
		uta.setText("爵士");
		uta.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		uta.setForeground(Color.WHITE);
		uta.setOpaque(false);
		teamPanel.add(uta, 0);
		
		svgCanvas25.setBounds(toLeftSecond, 150*9+200, width, height);
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
		svgCanvas25.addMouseListener(new Svg25Listener());
		
		//TODO
		JLabel dal = new JLabel();
		dal.setBounds(toLeftThird+120+40, 150*5+200+40, 80, 40);
		dal.setText("小牛");
		dal.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		dal.setForeground(Color.WHITE);
		dal.setOpaque(false);
		teamPanel.add(dal, 0);
		
		svgCanvas26.setBounds(toLeftThird, 150*5+200, width, height);
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
		svgCanvas26.addMouseListener(new Svg26Listener());
		
		JLabel hou = new JLabel();
		hou.setBounds(toLeftThird+120+40, 150*6+200+40, 80, 40);
		hou.setText("火箭");
		hou.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		hou.setForeground(Color.WHITE);
		hou.setOpaque(false);
		teamPanel.add(hou, 0);
		
		svgCanvas27.setBounds(toLeftThird, 150*6+200, width, height);
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
		svgCanvas27.addMouseListener(new Svg27Listener());
		
		JLabel mem = new JLabel();
		mem.setBounds(toLeftThird+120+40, 150*7+200+40, 80, 40);
		mem.setText("灰熊");
		mem.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mem.setForeground(Color.WHITE);
		mem.setOpaque(false);
		teamPanel.add(mem, 0);
		
		svgCanvas28.setBounds(toLeftThird, 150*7+200, width, height);
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
		svgCanvas28.addMouseListener(new Svg28Listener());
		
		JLabel nop = new JLabel();
		nop.setBounds(toLeftThird+120+40, 150*8+200+40, 80, 40);
		nop.setText("鹈鹕");
		nop.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		nop.setForeground(Color.WHITE);
		nop.setOpaque(false);
		teamPanel.add(nop, 0);
		
		svgCanvas29.setBounds(toLeftThird, 150*8+200, width, height);
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
		svgCanvas29.addMouseListener(new Svg29Listener());
		
		JLabel sas = new JLabel();
		sas.setBounds(toLeftThird+120+40, 150*9+200+40, 80, 40);
		sas.setText("马刺");
		sas.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		sas.setForeground(Color.WHITE);
		sas.setOpaque(false);
		teamPanel.add(sas, 0);
		
		svgCanvas30.setBounds(toLeftThird, 150*9+200, width, height);
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
		svgCanvas30.addMouseListener(new Svg30Listener());
		
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
	    scrollPane.setBounds(20, 100, 1000-130-80+30, 520);    
	    
	    //scrollPane.setViewportView(tablePanel);
	    teamPanel.setPreferredSize(new Dimension(1000-130-80, 1700));
	    scrollPane.setOpaque(false);
	    scrollPane.setBorder(null);
	    scrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
        scrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());
		teamPanel.setVisible(true);
		teamPanel.setLayout(null);
		
		basic.add(scrollPane, 0);
		return basic;
	}
	
	class Svg1Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("ATL"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("ATL");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					File img = new File("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					if (img.exists()) {
						columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					} else {
						columnPValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
					}
					
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg2Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("CHA"));
				
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("CHA");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					File img = new File("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					if (img.exists()) {
						columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					} else {
						columnPValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
					}					
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg3Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("MIA"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("MIA");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					File img = new File("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					if (img.exists()) {
						columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					} else {
						columnPValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
					}
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg4Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("ORL"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("ORL");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					File img = new File("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					if (img.exists()) {
						columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					} else {
						columnPValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
					}
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg5Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("WAS"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("WAS");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					File img = new File("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					if (img.exists()) {
						columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					} else {
						columnPValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
					}
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg6Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("CHI"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("CHI");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					File img = new File("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					if (img.exists()) {
						columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					} else {
						columnPValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
					}
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg7Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("CLE"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("CLE");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					File img = new File("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					if (img.exists()) {
						columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					} else {
						columnPValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
					}
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg8Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("DET"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("DET");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					File img = new File("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					if (img.exists()) {
						columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					} else {
						columnPValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
					}
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg9Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("IND"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("IND");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					File img = new File("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					if (img.exists()) {
						columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					} else {
						columnPValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
					}
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg10Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("MIL"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("MIL");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					File img = new File("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					if (img.exists()) {
						columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					} else {
						columnPValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
					}
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg11Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("BOS"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("BOS");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					File img = new File("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					if (img.exists()) {
						columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					} else {
						columnPValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
					}
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg12Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("BKN"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("BKN");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					File img = new File("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					if (img.exists()) {
						columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					} else {
						columnPValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
					}
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg13Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("NYK"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("NYK");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					File img = new File("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					if (img.exists()) {
						columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					} else {
						columnPValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
					}
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg14Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("PHI"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("PHI");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					File img = new File("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					if (img.exists()) {
						columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					} else {
						columnPValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
					}
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg15Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("TOR"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("TOR");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					File img = new File("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					if (img.exists()) {
						columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					} else {
						columnPValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
					}
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg16Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("GSW"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("GSW");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					File img = new File("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					if (img.exists()) {
						columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					} else {
						columnPValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
					}
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg17Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("LAC"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("LAC");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					File img = new File("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					if (img.exists()) {
						columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					} else {
						columnPValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
					}
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg18Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("LAL"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("LAL");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					File img = new File("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					if (img.exists()) {
						columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					} else {
						columnPValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
					}
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg19Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("PHX"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("PHX");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					File img = new File("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					if (img.exists()) {
						columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					} else {
						columnPValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
					}
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg20Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("SAC"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("SAC");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					File img = new File("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					if (img.exists()) {
						columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					} else {
						columnPValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
					}
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg21Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("DEN"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("DEN");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					File img = new File("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					if (img.exists()) {
						columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					} else {
						columnPValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
					}
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg22Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("MIN"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("MIN");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg23Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("OKC"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("OKC");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg24Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("POR"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("POR");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg25Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("UTA"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("UTA");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg26Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("DAL"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("DAL");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg27Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("HOU"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("HOU");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg28Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("MEM"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("MEM");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg29Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("NOP"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("NOP");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
	class Svg30Listener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				basic.removeAll();
				TeamHomePanel thp = new TeamHomePanel();
				basic.add(thp.init("SAS"));
				ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam("SAS");
				
				String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
				Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
				for (int i = 0; i < teamPlayerInfoList.size(); i++) {
					PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
					pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
					columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
					columnPValues[i][1] = teamPlayerInfoList.get(i);
					if (pbvo==null) {
						columnPValues[i][2] = "null";
						columnPValues[i][3] = "null";
						columnPValues[i][4] = "null";
						columnPValues[i][5] = "null";
						columnPValues[i][6] = "null";
						columnPValues[i][7] = "null";
						columnPValues[i][8] = "null";
						columnPValues[i][9] = "null";
					} else {
						columnPValues[i][2] = pbvo.getBasicInfo()[0];
						columnPValues[i][3] = pbvo.getBasicInfo()[1];
						columnPValues[i][4] = pbvo.getBasicInfo()[2];
						columnPValues[i][5] = pbvo.getBasicInfo()[3];
						columnPValues[i][6] = pbvo.getBasicInfo()[4];
						columnPValues[i][7] = pbvo.getBasicInfo()[5];
						columnPValues[i][8] = pbvo.getBasicInfo()[6];
						columnPValues[i][9] = pbvo.getBasicInfo()[7];
					}	
				}
				TeamHomePanel.TablePanel.removeAll();		
				TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
				TeamHomePanel.TablePanel.repaint();
				basic.repaint();
			}		
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}	
	}
}
