package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Contribuinte {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		TaxPayer taxPayer = new TaxPayer();
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Quantos contribuintes você vai digitar? ");
		int N =  sc.nextInt();
		
		sc.nextLine();
		for(int i =0; i < N;i++) {
			System.out.println("Digite os dados do " + (i+1)+"o contribuinte:");
			
			System.out.print("Renda anual com salário: ");
			double salario = sc.nextDouble();
			
			System.out.print("Renda anual com prestação de serviço: ");
			double serviço= sc.nextDouble();
			
			System.out.print("Renda anual com ganho de capital: ");
			double ganhoCapital = sc.nextDouble();
			
			System.out.print("Gastos médicos: ");
			double gastosMedicos = sc.nextDouble();
			
			System.out.print("gastos educacionais: ");
			double gastosEducacionais = sc.nextDouble();
			
			list.add(new TaxPayer(salario, serviço, ganhoCapital, gastosMedicos, gastosEducacionais));
		}
		
		System.out.println();
		
			double impostoBruto = 0;
			double abatimento = 0;
			double impostoDevido = 0;
			
		for(TaxPayer x : list) {
			System.out.println("Resumo do "+ (list.indexOf(x)+ 1) +"º contribuinte:");
			
			//double imposedSalary = taxPayer.salaryTax(x.getSalaryIncome());
			double imposedSalary = x.salaryTax(x.getSalaryIncome());			
			double imposedService = x.servicesTax(x.getServicesIncome());
			double imposedCapital = x.capitalTax(x.getCapitalIncome());
			
			impostoBruto = x.grossTax(imposedSalary, imposedService, imposedCapital);
			System.out.printf("Imposto bruto total: %.2f\n", impostoBruto);
			
			abatimento = x.taxRebate(impostoBruto, (x.getEducationSpending()+x.getHealthSpending()));
			System.out.printf("Abatimento: %.2f\n", abatimento);
			
			impostoDevido = x.netTax(impostoBruto, abatimento);
			System.out.printf("Imposto devido: %.2f\n", impostoDevido);
			
			sc.nextLine();
			
		}
		sc.close();
	}

}
