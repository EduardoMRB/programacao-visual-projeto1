package Process;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ActivityProcess {
	protected JTextField[] textFields;
	protected JComboBox[] combos;
	protected int mets[] = {5, 8, 11};
	
	public ActivityProcess(JTextField[] textFields, JComboBox[] combos) {
		this.textFields = textFields;
		this.combos     = combos;
	}
	
	public int calculate() {
		int met, tempo, count = 0;
		
		for (int i = 0; i < this.combos.length; i++) {
			JTextField textField = this.textFields[i];
			
			if (textField.getText().trim().isEmpty()) {
				throw new java.lang.IllegalArgumentException("Campo \"Tempo em minutos\" não pode ser vazio");
			}
			
			if (!textField.getText().matches("^([0-9][0-9]*)$")) {
				throw new java.lang.RuntimeException("Forneca um número inteiro e positivo para o campo \"Tempo em minutos\"");
			}
			
			met = this.mets[this.combos[i].getSelectedIndex()];
			tempo = Integer.parseInt(this.textFields[i].getText());
			
			count += ((met * 70) * tempo) / 60;
		}
		
		return count;
	}
}