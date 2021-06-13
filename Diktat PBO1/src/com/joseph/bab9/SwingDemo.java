/**
 * @author Joseph Setiawan Hardadi (1972007)
 */
package com.joseph.bab9;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class SwingDemo {
    private JSplitPane rootPanel;
    private JTable tableStudent;
    private JTextField textNama;
    private JTextField textNomorUnik;
    private JRadioButton lakiLakiRadioButton;
    private JRadioButton perempuanRadioButton;
    private JComboBox<Jurusan> comboJurusan;
    private JButton addJurusanButton;
    private JButton addStudentButton;
    private JButton updateStudentButton;
    private JButton deleteStudentButton;
    private JButton resetButtonButton;

    private List<Student> studentList;
    private List<Jurusan> jurusanList;

    private Student selectedStudent;
    private Jurusan selectedJurusan;
    private int selectedJurusanIdx;
    private DefaultComboBoxModel<Jurusan> jurusanComboModel;
    private StudentTableModel studentTableModel;
    private  ButtonGroup buttonGroup;
    public SwingDemo() {
        buttonGroup = new ButtonGroup();
        buttonGroup.add(lakiLakiRadioButton);
        buttonGroup.add(perempuanRadioButton);

        studentList = new ArrayList<>();
        jurusanList = new ArrayList<>();
        jurusanList.add(new Jurusan(1,"Informatika"));
        jurusanList.add(new Jurusan(2,"Sistem Informasi"));
        studentList.add(new Student("1972007","Joseph","Laki-laki",jurusanList.get(0)));

        jurusanComboModel = new DefaultComboBoxModel<>(jurusanList.toArray(new Jurusan[0]));
        comboJurusan.setModel(jurusanComboModel);

        studentTableModel = new StudentTableModel(studentList);
        tableStudent.setModel(studentTableModel);
        tableStudent.setAutoCreateRowSorter(true);

        addStudentButton.addActionListener(e -> {
            if(textNomorUnik.getText().trim().length()!=0 && textNama.getText().trim().length()!=0 && buttonGroup.getSelection()!=null && comboJurusan.getSelectedItem()!=null) {
                Student student = new Student(textNomorUnik.getText(),textNama.getText(),buttonGroup.getSelection().getActionCommand(), (Jurusan) comboJurusan.getSelectedItem());
                studentList.add(student);
                studentTableModel.fireTableDataChanged();
                reset();
            }
            else{
                JOptionPane.showMessageDialog(this.rootPanel,"Please Fill all the field","Error",JOptionPane.ERROR_MESSAGE);
            }
        });


        updateStudentButton.addActionListener(e -> {
            selectedStudent.setNoUnik(textNomorUnik.getText());
            selectedStudent.setGender(buttonGroup.getSelection().getActionCommand());
            selectedStudent.setNamaOrang(textNama.getText());
            selectedStudent.setJurusan((Jurusan) comboJurusan.getSelectedItem());
            studentList.add(selectedStudent);

        });


        tableStudent.getSelectionModel().addListSelectionListener(e->{
            if(!tableStudent.getSelectionModel().isSelectionEmpty()){
                int selectedIndex = tableStudent.convertRowIndexToModel(tableStudent.getSelectedRow());
                selectedStudent = studentList.get(selectedIndex);
                if(selectedStudent!=null){
                    textNama.setText(selectedStudent.getNamaOrang());
                    textNomorUnik.setText(selectedStudent.getNoUnik());
                    if(selectedStudent.getGender().equals(lakiLakiRadioButton.getActionCommand())){
                        lakiLakiRadioButton.setSelected(true);
                        perempuanRadioButton.setSelected(false);
                    }
                    else{
                        lakiLakiRadioButton.setSelected(false);
                        perempuanRadioButton.setSelected(true);
                    }
                    comboJurusan.setSelectedIndex(jurusanList.indexOf(selectedStudent.getJurusan()));
                }

            }
        });

        resetButtonButton.addActionListener(e -> reset());
        addJurusanButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Input nama jurusan");
            jurusanList.add(new Jurusan(input));
            jurusanComboModel = new DefaultComboBoxModel<>(jurusanList.toArray(new Jurusan[0]));
            comboJurusan.setModel(jurusanComboModel);
            comboJurusan.setSelectedItem(null);
        });
        reset();
    }

    private static class StudentTableModel extends AbstractTableModel{
        private List<Student> students;
        private final String[] COLUMNS = {"NO UNIK","NAMA","GENDER","JURUSAN"};

        public StudentTableModel(List<Student> students) {
            this.students = students;
        }

        @Override
        public int getRowCount() {
            return students.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex){
                case 0 -> students.get(rowIndex).getNoUnik();
                case 1 -> students.get(rowIndex).getNamaOrang();
                case 2 -> students.get(rowIndex).getGender();
                case 3 -> students.get(rowIndex).getJurusan().getNamaJurusan();
                default -> "";
            };
        }

        @Override
        public String getColumnName(int column) {
            return COLUMNS[column];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if(getValueAt(0,columnIndex)!=null){
                return getValueAt(0,columnIndex).getClass();
            }
            return Object.class;
        }
    }

    private void reset(){
        updateStudentButton.setEnabled(false);
        textNama.setText("");
        textNomorUnik.setText("");
        lakiLakiRadioButton.setSelected(false);
        perempuanRadioButton.setSelected(false);
        buttonGroup.clearSelection();
        comboJurusan.setSelectedItem(null);

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("SwingDemo");
        frame.setContentPane(new SwingDemo().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
