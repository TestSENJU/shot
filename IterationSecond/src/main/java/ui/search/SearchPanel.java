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

import ui.AllImages;
import ui.ComboTextField;
import ui.MyStringTable;

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
		searchT.addMouseListener(new STListener());
		searchPanel.add(searchT, 0);
		
		searchM = new JButton();
		searchM.setBounds(240, 40, width, height);
		searchM.setOpaque(false);
		searchM.setContentAreaFilled(false);
		searchM.setBorderPainted(false);
		searchM.setIcon(AllImages.IMG_SEARCHMATCH);
		searchM.addMouseListener(new SMListener());
		searchPanel.add(searchM, 0);
		
		//TODO
		searchToolPanel = new JPanel();
		searchToolPanel.setOpaque(false);
		searchToolPanel.setBounds(0, 70, 1000-130, 100);
		searchToolPanel.setLayout(null);
		searchPanel.add(searchToolPanel, 0);
		
		//TODO
		tablePanel = new JPanel();
		tablePanel.setOpaque(false);
		tablePanel.setBounds(0, 170, 1000-130, 700-170);
		tablePanel.setLayout(null);
		searchPanel.add(tablePanel, 0);
		
		return searchPanel;
	}
	
	//TODO
	public void initPTool(){
		String[] name = {"ab","bc","bcd","bcc","bdd","befg","ff","gt","hy","ibc","jkb","kib","lac","mb","nac","opu","pab","qsc","rst","uwv"};
		ArrayList<String> list = new ArrayList<String>();
		for (int i=0;i < name.length;i++) {
			list.add(name[i]);
		}
		comboField = new ComboTextField(list);
		comboField.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		comboField.setOpaque(false);
		comboField.setBounds(40, 20, 150, 30);
		comboField.setForeground(Color.WHITE);
		comboField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(ComboTextField.jcb.getSelectedItem().toString());
			}		
		});
		searchToolPanel.add(comboField, 0);
		
		JButton sure = new JButton();
		sure.setBounds(210, 20, 80, 30);
		sure.setBorderPainted(true);
		sure.setContentAreaFilled(false);
		sure.setOpaque(false);
		sure.setIcon(AllImages.IMG_SURE);
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
		searchToolPanel.add(Z, 0);
	}
	
	public void initTTool(){
		
	}
	
	public void initMTool(){
		
	}
	
	//TODO
	public JScrollPane initTable(Object[][] columnValue, String[] columnName){
		dataScrollPane = new JScrollPane();
		
		return dataScrollPane;
	}
	
	class SPListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
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
	class STListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
}
