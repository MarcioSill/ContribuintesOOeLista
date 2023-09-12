package entities;

public class TaxPayer {
	
	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;
	
	public TaxPayer() {
	}

	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending,
			Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(Double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}
	
	public double salaryTax(double salary) {
		double val = salary / 12;
		
		if(val <= 3000.0 ) {
		return 0.0;
		}
		else if(val <= 5000.0) {
		return salary * 0.1;
	    }
		else {
			return salary * 0.2;
		}
	}
	
	public double servicesTax(double service) {		
		return service * 0.15;
	}
	
	public double capitalTax(double capital) {		
		return capital * 0.2;
	}
	
	public double grossTax(double salary, double sevice, double capital) {
		 return salary + sevice + capital;			
	}
	
	public double taxRebate(double grossTax, double spentDoctorEducates) {
		if((grossTax*0.3) <spentDoctorEducates) {
			return grossTax * 0.3;
		}
		else {
			return spentDoctorEducates;
		}
	}
	
	public double netTax(double grosTax, double rebate) {
		return grosTax - rebate;
	}

}
