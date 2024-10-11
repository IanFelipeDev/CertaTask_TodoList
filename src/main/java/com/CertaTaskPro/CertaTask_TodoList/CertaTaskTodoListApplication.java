package com.CertaTaskPro.CertaTask_TodoList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.CertaTaskPro.CertaTask_TodoList.entity.Employee;
import com.CertaTaskPro.CertaTask_TodoList.entity.Task;
import com.CertaTaskPro.CertaTask_TodoList.entity.TaskStatus;

@SpringBootApplication
public class CertaTaskTodoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(CertaTaskTodoListApplication.class, args);
	}


	public class Program {

		public static void main(String[] args) throws ParseException {

			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			List<Employee> todoList = new ArrayList<>();

			Calendar cal = Calendar.getInstance();
			int thisMonth = cal.get(Calendar.MONTH) + 1;
			int thisYear = cal.get(Calendar.YEAR);

			boolean restart = true;

			do {
				System.out.print("Nome do funcionário: ");
				String name = sc.nextLine();

				System.out.print("Insira o número de tarefas deste funcionário: ");
				int tasks = sc.nextInt();
				sc.nextLine();
				System.out.println();

				List<Task> taskList = new ArrayList<>();

				for (int i = 1; i <= tasks; i++) {
					System.out.print("Insira o Id da " + i + "ª tarefa: ");
					int taskId = sc.nextInt();
					sc.nextLine();

					System.out.println("Insira os dados da " + i + "ª tarefa abaixo: ");

					System.out.print("Título: ");
					String title = sc.nextLine();

					System.out.print("Descrição: ");
					String desc = sc.nextLine();

					System.out.print("Data de criação (dd/MM/yyyy): ");
					String dateInput = sc.next();
					Date creationDate = sdf.parse(dateInput);
					sc.nextLine();

					System.out.print("Tempo gasto em horas: ");
					double hoursWorked = sc.nextDouble();
					sc.nextLine();

					System.out.print("Status (PENDENTE ou CONCLUIDA): ");
					String statusInput = sc.next().toUpperCase();
					TaskStatus status;
					status = TaskStatus.valueOf(statusInput);

					System.out.println();

					Task task = new Task(title, desc, creationDate, taskId, status, hoursWorked);
					taskList.add(task);
				}

				Employee existingEmployee = FoundEmployeeName(name, todoList);

				if (existingEmployee != null) {
					existingEmployee.getTaskList().addAll(taskList);
				} else {
					Employee employee = new Employee(name, taskList);
					todoList.add(employee);
				}

				System.out.print("Deseja adicionar tarefas de outro funcionário (S/N)? ");
				char otherEmployee = sc.next().toUpperCase().charAt(0);
				sc.nextLine();

				if (otherEmployee == 'S') {
					restart = true;
				} else {
					restart = false;
				}

			} while (restart);

			System.out.println();
			for (Employee employee : todoList) {
				System.out.println(employee);
			}
			System.out.println();

			System.out.print("Deseja alterar o status de alguma tarefa? (S/N) ");
			char changeStatusTask = sc.next().toUpperCase().charAt(0);
			sc.nextLine();

			if (changeStatusTask == 'S') {

				System.out.print("Digite o Id da tarefa que será alterada: ");
				int taskId = sc.nextInt();
				sc.nextLine();

				boolean found = false;

				for (Employee employee : todoList) {
					for (Task task : employee.getTaskList()) {
						if (task.getTaskId() == taskId) {
							if (task.getStatus() == TaskStatus.PENDENTE) {
								task.setStatus(TaskStatus.CONCLUIDA);
								System.out.println("Status da tarefa atualizada com sucesso para CONCLUIDA.");
							} else {
								System.out.println("A tarefa já está com o status " + task.getStatus() + ".");
							}
							found = true;
							break;
						}
					}
					if (found)
						break;
				}

				if (!found) {
					System.out.println("Tarefa com Id " + taskId + " não encontrada.");
				}
			}

			System.out.println("\nLista Final de Tarefas:");
			for (Employee employee : todoList) {
				System.out.println(employee);
			}

			sc.close();
		}

		private static Employee FoundEmployeeName(String name, List<Employee> employeeList) {
			for (Employee emp : employeeList) {
				if (emp.getName().equalsIgnoreCase(name)) {
					return emp;
				}
			}
			return null;
		}
	}

}
