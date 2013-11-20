package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Process.ActivityProcess;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField firstActivityTime;
	private JTextField secondActivityTime;
	private JTextField thirdActivityTime;
	private JComboBox firstActivity;
	private JComboBox secondActivity;
	private JComboBox thirdActivity;
	private JLabel labelTotal;
	private int count;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void activityEvent(java.awt.AWTEvent e) {
		try {
			JTextField[] textFields = {firstActivityTime, secondActivityTime, thirdActivityTime};
			JComboBox[] combos      = {firstActivity, secondActivity, thirdActivity};
			
			ActivityProcess process = new ActivityProcess(textFields, combos);
			
			labelTotal.setText("Calorias perdidas: " + Integer.toString(process.calculate()) + " Kcal");
		} catch (java.lang.IllegalArgumentException argEx) {
			
		} catch (java.lang.RuntimeException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel labelPlanos = new JLabel("Plano de exercícios");
		contentPane.add(labelPlanos, "2, 2");
		
		JLabel lblExercicio = new JLabel("Exercicio");
		contentPane.add(lblExercicio, "2, 6");
		
		JLabel lblTempoEmMinutos = new JLabel("Tempo em minutos");
		contentPane.add(lblTempoEmMinutos, "10, 6");
		
		firstActivity = new JComboBox();
		firstActivity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activityEvent(e);
			}
		});
		firstActivity.setModel(new DefaultComboBoxModel(new String[] {"Caminhada", "Trote Regenerativo", "Corrida"}));
		contentPane.add(firstActivity, "2, 10, fill, default");
		
		firstActivityTime = new JTextField();
		firstActivityTime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				activityEvent(e);
			}
		});
		contentPane.add(firstActivityTime, "10, 10, fill, default");
		firstActivityTime.setColumns(10);
		
		secondActivity = new JComboBox();
		secondActivity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activityEvent(e);
			}
		});
		secondActivity.setModel(new DefaultComboBoxModel(new String[] {"Caminhada", "Trote Regenerativo", "Corrida"}));
		contentPane.add(secondActivity, "2, 14, fill, default");
		
		secondActivityTime = new JTextField();
		secondActivityTime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				activityEvent(e);
			}
		});
		secondActivityTime.setColumns(10);
		contentPane.add(secondActivityTime, "10, 14, fill, default");
		
		thirdActivity = new JComboBox();
		thirdActivity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activityEvent(e);
			}
		});
		thirdActivity.setModel(new DefaultComboBoxModel(new String[] {"Caminhada", "Trote Regenerativo", "Corrida"}));
		contentPane.add(thirdActivity, "2, 18, fill, default");
		
		thirdActivityTime = new JTextField();
		thirdActivityTime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				activityEvent(e);
			}
		});
		thirdActivityTime.setColumns(10);
		contentPane.add(thirdActivityTime, "10, 18, fill, default");
		
		labelTotal = new JLabel("Calorias perdidas:");
		contentPane.add(labelTotal, "2, 24");
	}

}
