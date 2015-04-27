package ui.search;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import sound.PlayWave;
import ui.AllImages;
import ui.ComboTextField;
import ui.DateChooserJButton;
import ui.IScrollBarUI;
import ui.MyStringTable;
import ui.match.MatchHomePanel;
import vo.MatchShortVO;
import vo.PlayerBasicVO;
import vo.TeamBasicVO;
import BL.MatchBL;
import BL.MatchBL_Impl;
import BL.PlayerBL;
import BL.PlayerBL_Impl;
import BL.TeamBL;
import BL.TeamBL_Impl;

public class SearchPanel {
	/**
	 * @param 检索界面 
	 *         -> 检索比赛+球员+球队
	 *         -> 比赛按照时间检索 
	 *              -> 点击具体比赛展示具体信息如比赛时间比分双方球员的数据
	 *         -> 球员 模糊搜索名字 + 26字母的索引
	 *              -> 点击具体球员跳转到球员具体信息界面
	 *         -> 球队 模糊搜索名字 + 26字母的索引
	 *              -> 点击具体球队跳转到球队具体信息界面
	 * @author forIris
	 * @version  June 12, 2015 11:41:31 AM
	 * **/
	private JPanel searchPanel;
	private JPanel searchToolPanel;
	private JPanel tablePanel;
	private MyStringTable dataTable;
	private JScrollPane dataScrollPane;
	private JButton searchP;
	private JButton searchT;
	private JButton searchM;
	private ComboTextField comboField;
	//
	JLabel A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z;
	public DateChooserJButton beginTime;
	public DateChooserJButton endTime;
	//
	PlayerBL pbl = new PlayerBL_Impl();
	TeamBL tbl = new TeamBL_Impl();
	MatchBL mbl = new MatchBL_Impl();
	
	public JPanel init(){
		searchPanel = new JPanel();
		searchPanel.setOpaque(false);
		searchPanel.setBounds(130, 0, 1000-130, 700);
		searchPanel.setLayout(null);
		
		int width = 100;
		int height = 30;
		searchP = new JButton();
		searchP.setBounds(40, 40, width, height);
		searchP.setOpaque(false);
		searchP.setContentAreaFilled(false);
		searchP.setBorderPainted(false);
		searchP.setIcon(AllImages.IMG_SEARCHPLAYER);
		searchP.addMouseListener(new SPListener());
		searchPanel.add(searchP, 0);
		
		searchT = new JButton();
		searchT.setBounds(140, 40, width, height);
		searchT.setOpaque(false);
		searchT.setContentAreaFilled(false);
		searchT.setBorderPainted(false);
		searchT.setIcon(AllImages.IMG_SEARCHTEAM);
		searchT.addMouseListener(new STEAMListener());
		searchPanel.add(searchT, 0);
		
		searchM = new JButton();
		searchM.setBounds(240, 40, width, height);
		searchM.setOpaque(false);
		searchM.setContentAreaFilled(false);
		searchM.setBorderPainted(false);
		searchM.setIcon(AllImages.IMG_SEARCHMATCH);
		searchM.addMouseListener(new SMListener());
		searchPanel.add(searchM, 0);
		
		searchToolPanel = new JPanel();
		searchToolPanel.setOpaque(false);
		searchToolPanel.setBounds(0, 70, 1000-130, 100);
		searchToolPanel.setLayout(null);
		searchPanel.add(searchToolPanel, 0);
		
		tablePanel = new JPanel();
		tablePanel.setOpaque(false);
		tablePanel.setBounds(0, 170, 1000-130, 700-170);
		tablePanel.setLayout(null);
		searchPanel.add(tablePanel, 0);
		
		return searchPanel;
	}
	
	public void initPTool(){
		ArrayList<String> list = pbl.getPlayerNames();
		
		comboField = new ComboTextField(list);
		comboField.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		comboField.setOpaque(false);
		comboField.setBounds(40, 20, 150, 30);
		comboField.setForeground(Color.WHITE);
		comboField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println(ComboTextField.jcb.getSelectedItem().toString());
			}		
		});
		searchToolPanel.add(comboField, 0);
		
		JButton sure = new JButton();
		sure.setBounds(210, 20, 80, 30);
		sure.setBorderPainted(false);
		sure.setContentAreaFilled(false);
		sure.setOpaque(false);
		sure.setIcon(AllImages.IMG_SURE);
		sure.addMouseListener(new SurePListener());
		searchToolPanel.add(sure, 0);
		
		//TODO 索引
		int width = 15;
		int height = 30;
		A = new JLabel();
		A.setText("<html><u>A</u></html>");
		A.setOpaque(false);
		A.setForeground(Color.WHITE);
		A.setBounds(40, 60, width, height);
		A.setFont(new Font("Arial", Font.PLAIN, 15));
		A.addMouseListener(new AListener());
		searchToolPanel.add(A, 0);
		B = new JLabel();
		B.setText("<html><u>B</u></html>");
		B.setOpaque(false);
		B.setForeground(Color.WHITE);
		B.setBounds(70, 60, width, height);
		B.setFont(new Font("Arial", Font.PLAIN, 15));
		B.addMouseListener(new BListener());
		searchToolPanel.add(B, 0);
		C = new JLabel();
		C.setText("<html><u>C</u></html>");
		C.setOpaque(false);
		C.setForeground(Color.WHITE);
		C.setBounds(100, 60, width, height);
		C.setFont(new Font("Arial", Font.PLAIN, 15));
		C.addMouseListener(new CListener());
		searchToolPanel.add(C, 0);
		D = new JLabel();
		D.setText("<html><u>D</u></html>");
		D.setOpaque(false);
		D.setForeground(Color.WHITE);
		D.setBounds(130, 60, width, height);
		D.setFont(new Font("Arial", Font.PLAIN, 15));
		D.addMouseListener(new DListener());
		searchToolPanel.add(D, 0);
		E = new JLabel();
		E.setText("<html><u>E</u></html>");
		E.setOpaque(false);
		E.setForeground(Color.WHITE);
		E.setBounds(160, 60, width, height);
		E.setFont(new Font("Arial", Font.PLAIN, 15));
		E.addMouseListener(new EListener());
		searchToolPanel.add(E, 0);
		F = new JLabel();
		F.setText("<html><u>F</u></html>");
		F.setOpaque(false);
		F.setForeground(Color.WHITE);
		F.setBounds(190, 60, width, height);
		F.setFont(new Font("Arial", Font.PLAIN, 15));
		F.addMouseListener(new FListener());
		searchToolPanel.add(F, 0);
		G = new JLabel();
		G.setText("<html><u>G</u></html>");
		G.setOpaque(false);
		G.setForeground(Color.WHITE);
		G.setBounds(220, 60, width, height);
		G.setFont(new Font("Arial", Font.PLAIN, 15));
		G.addMouseListener(new GListener());
		searchToolPanel.add(G, 0);
		H = new JLabel();
		H.setText("<html><u>H</u></html>");
		H.setOpaque(false);
		H.setForeground(Color.WHITE);
		H.setBounds(250, 60, width, height);
		H.setFont(new Font("Arial", Font.PLAIN, 15));
		H.addMouseListener(new HListener());
		searchToolPanel.add(H, 0);
		I = new JLabel();
		I.setText("<html><u>I</u></html>");
		I.setOpaque(false);
		I.setForeground(Color.WHITE);
		I.setBounds(280, 60, width, height);
		I.setFont(new Font("Arial", Font.PLAIN, 15));
		I.addMouseListener(new IListener());
		searchToolPanel.add(I, 0);
		J = new JLabel();
		J.setText("<html><u>J</u></html>");
		J.setOpaque(false);
		J.setForeground(Color.WHITE);
		J.setBounds(310, 60, width, height);
		J.setFont(new Font("Arial", Font.PLAIN, 15));
		J.addMouseListener(new JListener());
		searchToolPanel.add(J, 0);
		K = new JLabel();
		K.setText("<html><u>K</u></html>");
		K.setOpaque(false);
		K.setForeground(Color.WHITE);
		K.setBounds(340, 60, width, height);
		K.setFont(new Font("Arial", Font.PLAIN, 15));
		K.addMouseListener(new KListener());
		searchToolPanel.add(K, 0);
		L = new JLabel();
		L.setText("<html><u>L</u></html>");
		L.setOpaque(false);
		L.setForeground(Color.WHITE);
		L.setBounds(370, 60, width, height);
		L.setFont(new Font("Arial", Font.PLAIN, 15));
		L.addMouseListener(new LListener());
		searchToolPanel.add(L, 0);
		M = new JLabel();
		M.setText("<html><u>M</u></html>");
		M.setOpaque(false);
		M.setForeground(Color.WHITE);
		M.setBounds(400, 60, width, height);
		M.setFont(new Font("Arial", Font.PLAIN, 15));
		M.addMouseListener(new MListener());
		searchToolPanel.add(M, 0);
		N = new JLabel();
		N.setText("<html><u>N</u></html>");
		N.setOpaque(false);
		N.setForeground(Color.WHITE);
		N.setBounds(430, 60, width, height);
		N.setFont(new Font("Arial", Font.PLAIN, 15));
		N.addMouseListener(new NListener());
		searchToolPanel.add(N, 0);
		O = new JLabel();
		O.setText("<html><u>O</u></html>");
		O.setOpaque(false);
		O.setForeground(Color.WHITE);
		O.setBounds(460, 60, width, height);
		O.setFont(new Font("Arial", Font.PLAIN, 15));
		O.addMouseListener(new OListener());
		searchToolPanel.add(O, 0);
		P = new JLabel();
		P.setText("<html><u>P</u></html>");
		P.setOpaque(false);
		P.setForeground(Color.WHITE);
		P.setBounds(490, 60, width, height);
		P.setFont(new Font("Arial", Font.PLAIN, 15));
		P.addMouseListener(new PListener());
		searchToolPanel.add(P, 0);
		Q = new JLabel();
		Q.setText("<html><u>Q</u></html>");
		Q.setOpaque(false);
		Q.setForeground(Color.WHITE);
		Q.setBounds(520, 60, width, height);
		Q.setFont(new Font("Arial", Font.PLAIN, 15));
		Q.addMouseListener(new QListener());
		searchToolPanel.add(Q, 0);
		R = new JLabel();
		R.setText("<html><u>R</u></html>");
		R.setOpaque(false);
		R.setForeground(Color.WHITE);
		R.setBounds(550, 60, width, height);
		R.setFont(new Font("Arial", Font.PLAIN, 15));
		R.addMouseListener(new RListener());
		searchToolPanel.add(R, 0);
		S = new JLabel();
		S.setText("<html><u>S</u></html>");
		S.setOpaque(false);
		S.setForeground(Color.WHITE);
		S.setBounds(580, 60, width, height);
		S.setFont(new Font("Arial", Font.PLAIN, 15));
		S.addMouseListener(new SListener());
		searchToolPanel.add(S, 0);
		T = new JLabel();
		T.setText("<html><u>T</u></html>");
		T.setOpaque(false);
		T.setForeground(Color.WHITE);
		T.setBounds(610, 60, width, height);
		T.setFont(new Font("Arial", Font.PLAIN, 15));
		T.addMouseListener(new TListener());
		searchToolPanel.add(T, 0);
		U = new JLabel();
		U.setText("<html><u>U</u></html>");
		U.setOpaque(false);
		U.setForeground(Color.WHITE);
		U.setBounds(640, 60, width, height);
		U.setFont(new Font("Arial", Font.PLAIN, 15));
		U.addMouseListener(new UListener());
		searchToolPanel.add(U, 0);
		V = new JLabel();
		V.setText("<html><u>V</u></html>");
		V.setOpaque(false);
		V.setForeground(Color.WHITE);
		V.setBounds(670, 60, width, height);
		V.setFont(new Font("Arial", Font.PLAIN, 15));
		V.addMouseListener(new VListener());
		searchToolPanel.add(V, 0);
		W = new JLabel();
		W.setText("<html><u>W</u></html>");
		W.setOpaque(false);
		W.setForeground(Color.WHITE);
		W.setBounds(700, 60, width, height);
		W.setFont(new Font("Arial", Font.PLAIN, 15));
		W.addMouseListener(new WListener());
		searchToolPanel.add(W, 0);
		X = new JLabel();
		X.setText("<html><u>X</u></html>");
		X.setOpaque(false);
		X.setForeground(Color.WHITE);
		X.setBounds(730, 60, width, height);
		X.setFont(new Font("Arial", Font.PLAIN, 15));
		X.addMouseListener(new XListener());
		searchToolPanel.add(X, 0);
		Y = new JLabel();
		Y.setText("<html><u>Y</u></html>");
		Y.setOpaque(false);
		Y.setForeground(Color.WHITE);
		Y.setBounds(760, 60, width, height);
		Y.setFont(new Font("Arial", Font.PLAIN, 15));
		Y.addMouseListener(new YListener());
		searchToolPanel.add(Y, 0);
		Z = new JLabel();
		Z.setText("<html><u>Z</u></html>");
		Z.setOpaque(false);
		Z.setForeground(Color.WHITE);
		Z.setBounds(790, 60, width, height);
		Z.setFont(new Font("Arial", Font.PLAIN, 15));
		Z.addMouseListener(new ZListener());
		//TODO
		searchToolPanel.add(Z, 0);
	}
	
	public void initTTool(){
		ArrayList<String> list = tbl.getTeamNames();
		
		comboField = new ComboTextField(list);
		comboField.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		comboField.setOpaque(false);
		comboField.setBounds(40, 20, 150, 30);
		comboField.setForeground(Color.WHITE);
		comboField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println(ComboTextField.jcb.getSelectedItem().toString());
			}		
		});
		searchToolPanel.add(comboField, 0);
		
		JButton sure = new JButton();
		sure.setBounds(210, 20, 80, 30);
		sure.setBorderPainted(false);
		sure.setContentAreaFilled(false);
		sure.setOpaque(false);
		sure.setIcon(AllImages.IMG_SURE);
		sure.addMouseListener(new SureTListener());
		searchToolPanel.add(sure, 0);
		
		//TODO 索引
		int width = 15;
		int height = 30;
		A = new JLabel();
		A.setText("<html><u>A</u></html>");
		A.setOpaque(false);
		A.setForeground(Color.WHITE);
		A.setBounds(40, 60, width, height);
		A.setFont(new Font("Arial", Font.PLAIN, 15));
		A.addMouseListener(new ATListener());
		searchToolPanel.add(A, 0);
		B = new JLabel();
		B.setText("<html><u>B</u></html>");
		B.setOpaque(false);
		B.setForeground(Color.WHITE);
		B.setBounds(70, 60, width, height);
		B.setFont(new Font("Arial", Font.PLAIN, 15));
		B.addMouseListener(new BTListener());
		searchToolPanel.add(B, 0);
		C = new JLabel();
		C.setText("<html><u>C</u></html>");
		C.setOpaque(false);
		C.setForeground(Color.WHITE);
		C.setBounds(100, 60, width, height);
		C.setFont(new Font("Arial", Font.PLAIN, 15));
		C.addMouseListener(new CTListener());
		searchToolPanel.add(C, 0);
		D = new JLabel();
		D.setText("<html><u>D</u></html>");
		D.setOpaque(false);
		D.setForeground(Color.WHITE);
		D.setBounds(130, 60, width, height);
		D.setFont(new Font("Arial", Font.PLAIN, 15));
		D.addMouseListener(new DTListener());
		searchToolPanel.add(D, 0);
		E = new JLabel();
		E.setText("<html><u>E</u></html>");
		E.setOpaque(false);
		E.setForeground(Color.WHITE);
		E.setBounds(160, 60, width, height);
		E.setFont(new Font("Arial", Font.PLAIN, 15));
		E.addMouseListener(new ETListener());
		searchToolPanel.add(E, 0);
		F = new JLabel();
		F.setText("<html><u>F</u></html>");
		F.setOpaque(false);
		F.setForeground(Color.WHITE);
		F.setBounds(190, 60, width, height);
		F.setFont(new Font("Arial", Font.PLAIN, 15));
		F.addMouseListener(new FTListener());
		searchToolPanel.add(F, 0);
		G = new JLabel();
		G.setText("<html><u>G</u></html>");
		G.setOpaque(false);
		G.setForeground(Color.WHITE);
		G.setBounds(220, 60, width, height);
		G.setFont(new Font("Arial", Font.PLAIN, 15));
		G.addMouseListener(new GTListener());
		searchToolPanel.add(G, 0);
		H = new JLabel();
		H.setText("<html><u>H</u></html>");
		H.setOpaque(false);
		H.setForeground(Color.WHITE);
		H.setBounds(250, 60, width, height);
		H.setFont(new Font("Arial", Font.PLAIN, 15));
		H.addMouseListener(new HTListener());
		searchToolPanel.add(H, 0);
		I = new JLabel();
		I.setText("<html><u>I</u></html>");
		I.setOpaque(false);
		I.setForeground(Color.WHITE);
		I.setBounds(280, 60, width, height);
		I.setFont(new Font("Arial", Font.PLAIN, 15));
		I.addMouseListener(new ITListener());
		searchToolPanel.add(I, 0);
		J = new JLabel();
		J.setText("<html><u>J</u></html>");
		J.setOpaque(false);
		J.setForeground(Color.WHITE);
		J.setBounds(310, 60, width, height);
		J.setFont(new Font("Arial", Font.PLAIN, 15));
		J.addMouseListener(new JTListener());
		searchToolPanel.add(J, 0);
		K = new JLabel();
		K.setText("<html><u>K</u></html>");
		K.setOpaque(false);
		K.setForeground(Color.WHITE);
		K.setBounds(340, 60, width, height);
		K.setFont(new Font("Arial", Font.PLAIN, 15));
		K.addMouseListener(new KTListener());
		searchToolPanel.add(K, 0);
		L = new JLabel();
		L.setText("<html><u>L</u></html>");
		L.setOpaque(false);
		L.setForeground(Color.WHITE);
		L.setBounds(370, 60, width, height);
		L.setFont(new Font("Arial", Font.PLAIN, 15));
		L.addMouseListener(new LTListener());
		searchToolPanel.add(L, 0);
		M = new JLabel();
		M.setText("<html><u>M</u></html>");
		M.setOpaque(false);
		M.setForeground(Color.WHITE);
		M.setBounds(400, 60, width, height);
		M.setFont(new Font("Arial", Font.PLAIN, 15));
		M.addMouseListener(new MTListener());
		searchToolPanel.add(M, 0);
		N = new JLabel();
		N.setText("<html><u>N</u></html>");
		N.setOpaque(false);
		N.setForeground(Color.WHITE);
		N.setBounds(430, 60, width, height);
		N.setFont(new Font("Arial", Font.PLAIN, 15));
		N.addMouseListener(new NTListener());
		searchToolPanel.add(N, 0);
		O = new JLabel();
		O.setText("<html><u>O</u></html>");
		O.setOpaque(false);
		O.setForeground(Color.WHITE);
		O.setBounds(460, 60, width, height);
		O.setFont(new Font("Arial", Font.PLAIN, 15));
		O.addMouseListener(new OTListener());
		searchToolPanel.add(O, 0);
		P = new JLabel();
		P.setText("<html><u>P</u></html>");
		P.setOpaque(false);
		P.setForeground(Color.WHITE);
		P.setBounds(490, 60, width, height);
		P.setFont(new Font("Arial", Font.PLAIN, 15));
		P.addMouseListener(new PTListener());
		searchToolPanel.add(P, 0);
		Q = new JLabel();
		Q.setText("<html><u>Q</u></html>");
		Q.setOpaque(false);
		Q.setForeground(Color.WHITE);
		Q.setBounds(520, 60, width, height);
		Q.setFont(new Font("Arial", Font.PLAIN, 15));
		Q.addMouseListener(new QTListener());
		searchToolPanel.add(Q, 0);
		R = new JLabel();
		R.setText("<html><u>R</u></html>");
		R.setOpaque(false);
		R.setForeground(Color.WHITE);
		R.setBounds(550, 60, width, height);
		R.setFont(new Font("Arial", Font.PLAIN, 15));
		R.addMouseListener(new RTListener());
		searchToolPanel.add(R, 0);
		S = new JLabel();
		S.setText("<html><u>S</u></html>");
		S.setOpaque(false);
		S.setForeground(Color.WHITE);
		S.setBounds(580, 60, width, height);
		S.setFont(new Font("Arial", Font.PLAIN, 15));
		S.addMouseListener(new STListener());
		searchToolPanel.add(S, 0);
		T = new JLabel();
		T.setText("<html><u>T</u></html>");
		T.setOpaque(false);
		T.setForeground(Color.WHITE);
		T.setBounds(610, 60, width, height);
		T.setFont(new Font("Arial", Font.PLAIN, 15));
		T.addMouseListener(new TTListener());
		searchToolPanel.add(T, 0);
		U = new JLabel();
		U.setText("<html><u>U</u></html>");
		U.setOpaque(false);
		U.setForeground(Color.WHITE);
		U.setBounds(640, 60, width, height);
		U.setFont(new Font("Arial", Font.PLAIN, 15));
		U.addMouseListener(new UTListener());
		searchToolPanel.add(U, 0);
		V = new JLabel();
		V.setText("<html><u>V</u></html>");
		V.setOpaque(false);
		V.setForeground(Color.WHITE);
		V.setBounds(670, 60, width, height);
		V.setFont(new Font("Arial", Font.PLAIN, 15));
		V.addMouseListener(new VTListener());
		searchToolPanel.add(V, 0);
		W = new JLabel();
		W.setText("<html><u>W</u></html>");
		W.setOpaque(false);
		W.setForeground(Color.WHITE);
		W.setBounds(700, 60, width, height);
		W.setFont(new Font("Arial", Font.PLAIN, 15));
		W.addMouseListener(new WTListener());
		searchToolPanel.add(W, 0);
		X = new JLabel();
		X.setText("<html><u>X</u></html>");
		X.setOpaque(false);
		X.setForeground(Color.WHITE);
		X.setBounds(730, 60, width, height);
		X.setFont(new Font("Arial", Font.PLAIN, 15));
		X.addMouseListener(new XTListener());
		searchToolPanel.add(X, 0);
		Y = new JLabel();
		Y.setText("<html><u>Y</u></html>");
		Y.setOpaque(false);
		Y.setForeground(Color.WHITE);
		Y.setBounds(760, 60, width, height);
		Y.setFont(new Font("Arial", Font.PLAIN, 15));
		Y.addMouseListener(new YTListener());
		searchToolPanel.add(Y, 0);
		Z = new JLabel();
		Z.setText("<html><u>Z</u></html>");
		Z.setOpaque(false);
		Z.setForeground(Color.WHITE);
		Z.setBounds(790, 60, width, height);
		Z.setFont(new Font("Arial", Font.PLAIN, 15));
		Z.addMouseListener(new ZTListener());
		searchToolPanel.add(Z, 0);
		//TODO
	}
	
	public void initMTool(){
		
		JLabel chooseBegin = new JLabel();
		chooseBegin.setText("起始时间");
		chooseBegin.setOpaque(false);
		chooseBegin.setForeground(Color.WHITE);
		chooseBegin.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		chooseBegin.setBounds(30, 20, 80, 35);
		searchToolPanel.add(chooseBegin, 0);
		
		beginTime = new DateChooserJButton();
		beginTime.setBounds(110, 20, 110, 35);
		beginTime.setBackground(Color.DARK_GRAY);
		beginTime.setFont(new Font("微软雅黑",Font.PLAIN,15));
		beginTime.setForeground(Color.WHITE);
		searchToolPanel.add(beginTime, 0);
		
		JLabel chooseEnd = new JLabel();
		chooseEnd.setText("结束时间");
		chooseEnd.setOpaque(false);
		chooseEnd.setForeground(Color.WHITE);
		chooseEnd.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		chooseEnd.setBounds(260, 20, 80, 35);
		searchToolPanel.add(chooseEnd, 0);
		
		endTime = new DateChooserJButton();
		endTime.setBounds(340, 20, 110, 35);
		endTime.setBackground(Color.DARK_GRAY);
		endTime.setFont(new Font("微软雅黑",Font.PLAIN,15));
		endTime.setForeground(Color.WHITE);
		searchToolPanel.add(endTime, 0);
		
		JButton sure = new JButton();
		sure.setBounds(510, 22, 80, 30);
		sure.setBorderPainted(false);
		sure.setContentAreaFilled(false);
		sure.setOpaque(false);
		sure.setIcon(AllImages.IMG_SURE);
		sure.addMouseListener(new SureMListener());
		searchToolPanel.add(sure, 0);
	}
	
	//TODO
	public JScrollPane initTable(Object[][] columnValue, String[] columnName){
		dataTable = new MyStringTable(columnValue, columnName);
		dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		dataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		dataTable.setForeground(Color.white);
		dataTable.setRowHeight(35);
		dataTable.setBounds(30, 20, 1000-130-100, 480);
		dataTable.setOpaque(false);
		
		dataTable.addMouseListener(new TableListener());

		dataTable.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		
		dataScrollPane = new JScrollPane();
	    dataScrollPane.setColumnHeaderView(dataTable.getTableHeader());	//设置头部（HeaderView部分）  
	    dataScrollPane.getColumnHeader().setOpaque(false);	//再取出头部，并设置为透明  
	    
	    dataScrollPane.setViewportView(dataTable);	//装载表格  
	    dataScrollPane.setOpaque(false);
	    dataScrollPane.getViewport().setOpaque(false);
	    dataScrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
	    dataScrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());
	    
	    dataScrollPane.setBounds(30, 20, 1000-130-100, 480);
        dataScrollPane.setBorder(null);
        dataScrollPane.setOpaque(false);
		
		return dataScrollPane;
	}
	public ArrayList<PlayerBasicVO> getPlayerDataList(String id){
		ArrayList<PlayerBasicVO> dataList = new ArrayList<PlayerBasicVO>();
		
		ArrayList<String> playerName = new ArrayList<String>();
		playerName = pbl.getPlayerNamesByBasic();
		for (int i=0;i < playerName.size();i++) {
			if(playerName.get(i).startsWith(id)){
				if(pbl.getPlayerBasicByName(playerName.get(i))!=null)
				dataList.add(pbl.getPlayerBasicByName(playerName.get(i)));
			}
		}
		return dataList;
	}
	public ArrayList<TeamBasicVO> getTeamDataList(String id){
		ArrayList<TeamBasicVO> dataList = new ArrayList<TeamBasicVO>();
		ArrayList<String> teamName = new ArrayList<String>();
		teamName = tbl.getTeamNames();
		for (int i=0;i < teamName.size();i++) {
			if (teamName.get(i).startsWith(id)) {
				dataList.add(tbl.getTeamBasicByName(teamName.get(i)));
			}
		}
		return dataList;
	}
	
	class SPListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			PlayWave.startClickSound();
			tablePanel.removeAll();
			tablePanel.repaint();
			searchToolPanel.removeAll();
			initPTool();
			searchToolPanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
		}
		public void mouseExited(MouseEvent arg0) {
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class STEAMListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			PlayWave.startClickSound();
			tablePanel.removeAll();
			tablePanel.repaint();
			searchToolPanel.removeAll();
			initTTool();
			searchToolPanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
		}
		public void mouseExited(MouseEvent arg0) {
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class SMListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			PlayWave.startClickSound();
			tablePanel.removeAll();
			tablePanel.repaint();
			searchToolPanel.removeAll();
			initMTool();
			searchToolPanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
		}
		public void mouseExited(MouseEvent arg0) {
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class AListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<PlayerBasicVO> data = getPlayerDataList("A");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			A.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			A.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class BListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<PlayerBasicVO> data = getPlayerDataList("B");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			B.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			B.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class CListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<PlayerBasicVO> data = getPlayerDataList("C");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			C.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			C.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class DListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<PlayerBasicVO> data = getPlayerDataList("D");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			D.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			D.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class EListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<PlayerBasicVO> data = getPlayerDataList("E");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			E.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			E.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class FListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<PlayerBasicVO> data = getPlayerDataList("F");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			F.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			F.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class GListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<PlayerBasicVO> data = getPlayerDataList("G");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			G.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			G.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class HListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<PlayerBasicVO> data = getPlayerDataList("H");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			H.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			H.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class IListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<PlayerBasicVO> data = getPlayerDataList("I");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			I.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			I.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class JListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<PlayerBasicVO> data = getPlayerDataList("J");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			J.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			J.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class KListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<PlayerBasicVO> data = getPlayerDataList("K");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			K.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			K.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class LListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<PlayerBasicVO> data = getPlayerDataList("L");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			L.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			L.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class MListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<PlayerBasicVO> data = getPlayerDataList("M");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			M.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			M.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class NListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<PlayerBasicVO> data = getPlayerDataList("N");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			N.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			N.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class OListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<PlayerBasicVO> data = getPlayerDataList("O");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			O.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			O.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class PListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<PlayerBasicVO> data = getPlayerDataList("P");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			P.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			P.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class QListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<PlayerBasicVO> data = getPlayerDataList("Q");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			Q.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			Q.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class RListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<PlayerBasicVO> data = getPlayerDataList("R");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			R.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			R.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class SListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<PlayerBasicVO> data = getPlayerDataList("S");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			S.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			S.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class TListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<PlayerBasicVO> data = getPlayerDataList("T");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			T.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			T.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class UListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<PlayerBasicVO> data = getPlayerDataList("U");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			U.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			U.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class VListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<PlayerBasicVO> data = getPlayerDataList("V");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			V.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			V.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class WListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<PlayerBasicVO> data = getPlayerDataList("W");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			W.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			W.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class XListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<PlayerBasicVO> data = getPlayerDataList("X");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			X.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			X.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class YListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<PlayerBasicVO> data = getPlayerDataList("Y");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			Y.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			Y.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class ZListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<PlayerBasicVO> data = getPlayerDataList("Z");
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getPlayerName();
				columnValues[i][1] = data.get(i).getBasicInfo()[0];
				columnValues[i][2] = data.get(i).getBasicInfo()[1];
				columnValues[i][3] = data.get(i).getBasicInfo()[2];
				columnValues[i][4] = data.get(i).getBasicInfo()[3];
				columnValues[i][5] = data.get(i).getBasicInfo()[4];
				columnValues[i][6] = data.get(i).getBasicInfo()[5];
				columnValues[i][7] = data.get(i).getBasicInfo()[6];
				columnValues[i][8] = data.get(i).getBasicInfo()[7];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			Z.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			Z.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class ATListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<TeamBasicVO> data = getTeamDataList("A");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			A.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			A.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class BTListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<TeamBasicVO> data = getTeamDataList("B");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			B.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			B.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class CTListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<TeamBasicVO> data = getTeamDataList("C");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			C.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			C.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class DTListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<TeamBasicVO> data = getTeamDataList("D");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			D.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			D.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class ETListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<TeamBasicVO> data = getTeamDataList("E");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			E.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			E.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class FTListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<TeamBasicVO> data = getTeamDataList("F");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			F.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			F.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class GTListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<TeamBasicVO> data = getTeamDataList("G");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			G.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			G.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class HTListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<TeamBasicVO> data = getTeamDataList("H");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			H.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			H.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class ITListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<TeamBasicVO> data = getTeamDataList("I");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			I.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			I.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class JTListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<TeamBasicVO> data = getTeamDataList("J");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			J.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			J.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class KTListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<TeamBasicVO> data = getTeamDataList("K");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			K.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			K.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class LTListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<TeamBasicVO> data = getTeamDataList("L");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			L.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			L.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class MTListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<TeamBasicVO> data = getTeamDataList("M");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			M.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			M.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class NTListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<TeamBasicVO> data = getTeamDataList("N");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			N.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			N.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class OTListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<TeamBasicVO> data = getTeamDataList("O");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			O.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			O.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class PTListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<TeamBasicVO> data = getTeamDataList("P");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			P.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			P.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class QTListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<TeamBasicVO> data = getTeamDataList("Q");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			Q.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			Q.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class RTListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<TeamBasicVO> data = getTeamDataList("R");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			R.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			R.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class STListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<TeamBasicVO> data = getTeamDataList("S");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			S.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			S.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class TTListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<TeamBasicVO> data = getTeamDataList("T");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			T.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			T.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class UTListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<TeamBasicVO> data = getTeamDataList("U");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			U.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			U.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class VTListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<TeamBasicVO> data = getTeamDataList("V");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			V.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			V.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class WTListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<TeamBasicVO> data = getTeamDataList("W");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			W.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			W.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class XTListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<TeamBasicVO> data = getTeamDataList("X");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			X.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			X.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class YTListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<TeamBasicVO> data = getTeamDataList("Y");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			Y.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			Y.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	class ZTListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			ArrayList<TeamBasicVO> data = getTeamDataList("Z");
			//球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[data.size()][columnName.length];
			for (int i = 0; i < data.size(); i++) {
				columnValues[i][0] = data.get(i).getTeamName();
				columnValues[i][1] = data.get(i).getLongName();
				columnValues[i][2] = data.get(i).getTeamInfo()[1];
				columnValues[i][3] = data.get(i).getTeamInfo()[2];
				columnValues[i][4] = data.get(i).getTeamInfo()[3];
				columnValues[i][5] = data.get(i).getTeamInfo()[4];
				columnValues[i][6] = data.get(i).getTeamInfo()[5];
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
			Z.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent arg0) {
			Z.setForeground(Color.WHITE);
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	
	class SurePListener implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println(comboField.getText());
			PlayerBasicVO playerBasicInfo= pbl.getPlayerBasicByName(comboField.getText());
			String[] columnName = new String[] { "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnValues = new Object[1][columnName.length];
			
			columnValues[0][0] = playerBasicInfo.getPlayerName();
			columnValues[0][1] = playerBasicInfo.getBasicInfo()[0];
			columnValues[0][2] = playerBasicInfo.getBasicInfo()[1];
			columnValues[0][3] = playerBasicInfo.getBasicInfo()[2];
			columnValues[0][4] = playerBasicInfo.getBasicInfo()[3];
			columnValues[0][5] = playerBasicInfo.getBasicInfo()[4];
			columnValues[0][6] = playerBasicInfo.getBasicInfo()[5];
			columnValues[0][7] = playerBasicInfo.getBasicInfo()[6];
			columnValues[0][8] = playerBasicInfo.getBasicInfo()[7];
			
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}

		public void mouseEntered(MouseEvent arg0) {
			
		}

		public void mouseExited(MouseEvent arg0) {
			
		}

		public void mousePressed(MouseEvent arg0) {
			
		}

		public void mouseReleased(MouseEvent arg0) {
			
		}
		
	}
	class SureTListener implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println(comboField.getText());
			TeamBasicVO teamBasicInfo = tbl.getTeamBasicByName(comboField.getText());
			String[] columnName = new String[] { "缩写","全名", "所在地", "赛区","分区","主场","建立时间" };
			Object[][] columnValues = new Object[1][columnName.length];
			columnValues[0][0] = teamBasicInfo.getTeamName();
			columnValues[0][1] = teamBasicInfo.getLongName();
			columnValues[0][2] = teamBasicInfo.getTeamInfo()[1];
			columnValues[0][3] = teamBasicInfo.getTeamInfo()[2];
			columnValues[0][4] = teamBasicInfo.getTeamInfo()[3];
			columnValues[0][5] = teamBasicInfo.getTeamInfo()[4];
			columnValues[0][6] = teamBasicInfo.getTeamInfo()[5];
			tablePanel.removeAll();
			tablePanel.add(initTable(columnValues, columnName), 0);
			tablePanel.repaint();
		}

		public void mouseEntered(MouseEvent arg0) {
			
		}

		public void mouseExited(MouseEvent arg0) {
			
		}

		public void mousePressed(MouseEvent arg0) {
			
		}

		public void mouseReleased(MouseEvent arg0) {
			
		}
		
	}
	class SureMListener implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println(beginTime.getDate()+"---"+endTime.getDate());
			String[] beginT = beginTime.getDate().split("-");
			String[] endT = endTime.getDate().split("-");
			String forMatchFT = beginT[0].substring(2, 4) + "-" + endT[0].substring(2, 4) + "_" + beginT[1] + "-" + beginT[2];
			String forMatchET = beginT[0].substring(2, 4) + "-" + endT[0].substring(2, 4) + "_" + endT[1] + "-" + endT[2];
			ArrayList<MatchShortVO> matchData = mbl.getShortMatchByPeriod(forMatchFT, forMatchET);
			String[] columnName_M = new String[] { "比赛名称", "胜方", "负方", "比分", "时间" };
			Object[][] columnMValues = new Object[2][columnName_M.length];
			for (int i = 0; i < 2; i++) {
				columnMValues[i][0] = "<html><u>"+"ATL"+"</u></html>";//matchData.get(i).getName()
				columnMValues[i][1] = matchData.get(i).getWinTeam();
				columnMValues[i][2] = matchData.get(i).getLostTeam();
				columnMValues[i][3] = matchData.get(i).getWinPointer()+":"+matchData.get(i).getLostPointer();
				columnMValues[i][4] = matchData.get(i).getTime();
			}
			tablePanel.removeAll();
			tablePanel.add(initTable(columnMValues, columnName_M), 0);
			tablePanel.repaint();
		}

		public void mouseEntered(MouseEvent arg0) {
			
		}

		public void mouseExited(MouseEvent arg0) {
			
		}

		public void mousePressed(MouseEvent arg0) {
			
		}

		public void mouseReleased(MouseEvent arg0) {
			
		}
		
	}
	
	class TableListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount()==2) {
				System.out.println(dataTable.getValueAt(dataTable.getSelectedRow(), dataTable.getSelectedColumn()));
				searchPanel.removeAll();
				MatchHomePanel mhp = new MatchHomePanel();
				searchPanel.add(mhp.init("ATL"));
				searchPanel.repaint();
			}
		}

		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent arg0) {
		}
		
	}
}
