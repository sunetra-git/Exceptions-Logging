package com.forLogging.maven_logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;

class StandardMaterialConstructionCost implements StandardMaterial{
	public double standardConstructionCost(String standard,double area,char cho){
		return (1200*area);
	}
}
class AboveStandardMaterialConstructionCost implements AboveStandardMaterial{
	public double aboveStandardConstructionCost(String standard,double area,char cho){
		return (1500*area);
	}
}
class HighStandardMaterialConstructionCost implements HighStandardMaterial{
	public double highStandardConstructionCost(String standard,double area,char cho){
		return (1800*area);
	}
}
class AutomatedAndHighStandardMaterialConstructionCost implements AutomatedAndHighStandardMaterial{
	public double automatedAndHighStandardConstructionCost(String standard,double area,char cho){
		return (2500*area);
	}
}

public class ConstructionCostCalculator {
	private static final Logger LOGGER = LogManager.getLogger(ConstructionCostCalculator.class);
	public static void main(String arg[]){
		String choice;
		double ar;
		char automated;
		double constructioncost;
		StandardMaterialConstructionCost sm=new StandardMaterialConstructionCost();
		AboveStandardMaterialConstructionCost asm=new AboveStandardMaterialConstructionCost();
		HighStandardMaterialConstructionCost hsm=new HighStandardMaterialConstructionCost();
		AutomatedAndHighStandardMaterialConstructionCost ahsm=new AutomatedAndHighStandardMaterialConstructionCost();
		Scanner obj=new Scanner(System.in);
		LOGGER.warn("\nAutomated Home is applicable only with \"Automated And High Standard Material\"\nPlease choose the Material Standard accordingly.");
		LOGGER.info("Enter Material Standard of your choice");
		choice=obj.nextLine().toLowerCase();
		LOGGER.info("Total Area Of House");
		ar=obj.nextDouble();
		LOGGER.warn("\nAutomated Home is not applicable with \"Standard Material\",\"Above Standard Material\" and \"High Standard Material\".\nPlease remember this while choosing. ");
		LOGGER.info("Do you want fully automated or not?Enter y/n");	
		automated=obj.next().charAt(0);
		switch(choice){
			case "standard material":
				if(automated=='n'){
					constructioncost=sm.standardConstructionCost(choice,ar,automated);
					LOGGER.debug("Construction Cost= " +constructioncost+" INR");
					break;
				}
				else if(automated=='y'){
					LOGGER.error("Fully Automated not applicable");
					break;
				}
			case "above standard material":
				if(automated=='n'){
					constructioncost=asm.aboveStandardConstructionCost(choice,ar,automated);
					LOGGER.debug("Construction Cost= " +constructioncost+" INR");
					break;
				}
				else if(automated=='y'){
					LOGGER.error("Fully Automated not applicable");
					break;
				}
			case "high standard material":
				if(automated=='n'){
					constructioncost=hsm.highStandardConstructionCost(choice,ar,automated);
					LOGGER.debug("Construction Cost= " +constructioncost+" INR");
					break;
				}
				else if(automated=='y'){
					LOGGER.error("Fully Automated not applicable");
					break;
				}
			case "automated and high standard material":
				if(automated=='y'){
					constructioncost=ahsm.automatedAndHighStandardConstructionCost(choice,ar,automated);
					LOGGER.debug("Construction Cost= "+constructioncost+" INR");
					break;
				}
				else if(automated=='n'){
					LOGGER.error("\nYou have chosen \"Automated And High Standard Material\" \nPlease go for only \"High Standard Material\" for Non-Automated Home");
					break;
				}
			
			default:
				LOGGER.error("Invalid Material Type");
		}
		obj.close();
	}
}

