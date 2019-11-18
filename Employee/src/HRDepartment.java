import java.util.*;

public class HRDepartment implements HRCodes {
	ArrayList<Employee> directory = new ArrayList<Employee>();

	public void addEmployee(int employeeId, String name, int role) {
		Employee employee = new Employee(employeeId, name, role);
		directory.add(employee);
	}

	public void printAllEmployees() {
		for (int index = 0; index < directory.size(); index++) {
			System.out.println(directory.get(index).toString());
		}
	}

	public Employee findEmployee(int employeeId) {
		for (int index = 0; index < directory.size(); index++) {
			if (directory.get(index).getEmployeeId() == employeeId) {
				return directory.get(index);
			}
		}
		return null;
	}

	public boolean recordEmployeeAppraisal(int employeeId, Date appraisalDate, int score) {
		for (int index = 0; index < directory.size(); index++) {
			Employee current = directory.get(index);
			if (current.getEmployeeId() == employeeId) {
				EmployeeAppraisal appraisal = new EmployeeAppraisal(appraisalDate, score);
				ArrayList<EmployeeAppraisal> history = current.getAppraisalHistory();
				history.add(appraisal);
				current.setAppraisalHistory(history);
				return true;
			}
		}
		return false;
	}

	public boolean promoteEmployee(int employeeId) {
		for (int index = 0; index < directory.size(); index++) {
			Employee current = directory.get(index);
			if (current.getEmployeeId() == employeeId) {
				ArrayList<EmployeeAppraisal> history = current.getAppraisalHistory();
				if((history.get(history.size()-1).getAppraisalScore()==EXCEEDED_EXPECTATIONS)&&
						(history.get(history.size()-2).getAppraisalScore()==EXCEEDED_EXPECTATIONS)) {
					Calendar calendar = Calendar.getInstance(); 
					calendar.setTime(new Date());
					calendar.add(Calendar.YEAR,-1); 
					Date date = calendar.getTime();
					if(current.getPromotionDate()==null || date.before(current.getPromotionDate())) {
						switch (current.getRole()) {
						case TESTER:
							current.setRole(DEVELOPER);
							break;
						case DEVELOPER:
							current.setRole(DESIGNER);
							break;
						case DESIGNER:
							current.setRole(MANAGER);
							break;
						case MANAGER:
							current.setRole(EXECUTIVE);
							break;
						default:
							break;
						}
						Calendar calendar1 = Calendar.getInstance();
						calendar1.setTime(new Date()); 
						Date date1 = calendar.getTime();
						current.setPromotionDate(date1);
						return true;
					}
				}
			}
		}
		return false;
	}
}
