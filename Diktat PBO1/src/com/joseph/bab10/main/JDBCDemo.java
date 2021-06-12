/**
 * @author Joseph Setiawan Hardadi (1972007)
 */
package com.joseph.bab10.main;

import com.joseph.bab10.dao.JurusanDao;
import com.joseph.bab10.dao.StudentDao;
import com.joseph.bab9.Jurusan;
import com.joseph.bab9.Student;
import com.joseph.bab9.SwingDemo;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {

    private JTextField textNama;
    private JTextField textNomorUnik;
    private JComboBox<Jurusan> comboJurusan;
    private JButton addJurusanButton;
    private JRadioButton lakiLakiRadioButton;
    private JRadioButton perempuanRadioButton;
    private JButton addStudentButton;
    private JButton updateStudentButton;
    private JButton deleteStudentButton;
    private JButton resetButtonButton;
    private JTable tableStudent;
    private JPanel rootPanel;

    private List<Student> studentList;
    private List<Jurusan> jurusanList;

    private Student selectedStudent;
    private Jurusan selectedJurusan;
    private int selectedJurusanIdx;
    private DefaultComboBoxModel<Jurusan> jurusanComboModel;
    private StudentTableModel studentTableModel;
    private ButtonGroup buttonGroup;
    private JurusanDao jurusanDao;
    private StudentDao studentDao;

    public JDBCDemo(){
        buttonGroup = new ButtonGroup();
        lakiLakiRadioButton.setActionCommand("Laki-laki");
        perempuanRadioButton.setActionCommand("Perempuan");
        buttonGroup.add(lakiLakiRadioButton);
        buttonGroup.add(perempuanRadioButton);

        jurusanDao = new JurusanDao();
        studentDao = new StudentDao();

        studentList = new ArrayList<>();
        jurusanList = new ArrayList<>();
        try {
            studentList.addAll(studentDao.fetchAll());
            jurusanList.addAll(jurusanDao.fetchAll());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

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
            try {
                if(jurusanDao.addData(new Jurusan(input))==1){
                    jurusanList.clear();
                    jurusanList.addAll(jurusanDao.fetchAll());
                    jurusanComboModel.removeAllElements();
                    jurusanComboModel.addAll(jurusanList);
                }
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        });
        reset();
    }

    private static class StudentTableModel extends AbstractTableModel {
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
        JFrame frame = new JFrame("JDBCDemo");
        frame.setContentPane(new JDBCDemo().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
