import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoListApp extends JFrame {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskInputField;
    private JButton addButton, deleteButton;

    public ToDoListApp() {
        setTitle("To-Do List");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        taskInputField = new JTextField();
        addButton = new JButton("Add");

        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        // Task List
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Delete Button
        deleteButton = new JButton("Delete Selected");

        // Add components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(deleteButton, BorderLayout.SOUTH);

        // Add Button Action
        addButton.addActionListener(e -> {
            String task = taskInputField.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskInputField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a task.");
            }
        });

        // Delete Button Action
        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a task to delete.");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoListApp::new);
    }
}
