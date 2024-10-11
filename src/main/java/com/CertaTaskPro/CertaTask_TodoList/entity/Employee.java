package com.CertaTaskPro.CertaTask_TodoList.entity;

import java.util.Calendar;
import java.util.List;



public class Employee {

    private String name;
    private TaskStatus status;
    private List<Task> taskList;
    private Task task;


    public Employee(String name, List<Task> taskList) {
        this.name = name;
        this.taskList = taskList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public double getHoursWorkedMonth() {

        Calendar cal = Calendar.getInstance();
        int currentMonth = cal.get(Calendar.MONTH) + 1;
        int currentYear = cal.get(Calendar.YEAR);
        double totalHours = 0.0;

        for (Task task : taskList) {

            cal.setTime(task.getCreationDate());
            int taskMonth = cal.get(Calendar.MONTH) + 1;
            int taskYear = cal.get(Calendar.YEAR);

            if (taskMonth == currentMonth && taskYear == currentYear) {
                totalHours += task.getHoursWorked();
            }
        }

        return totalHours;
    }

    @Override
    public String toString() {

        int taskComplete = 0;
        int taskPending = 0;


        for (Task task : taskList) {

            if (task.getStatus() == TaskStatus.CONCLUIDA) {
                taskComplete++;
            }


            else if (task.getStatus() == TaskStatus.PENDENTE) {
                taskPending++;
            }


        }

        return "Lista de tarefas:\nNome do funcionário:" + name
                + " Tarefas Concluídas: " + taskComplete
                + " Tarefas Pendentes: " + taskPending
                + "\nTotal de horas trabalhadas no mês: " + getHoursWorkedMonth();
    }


}