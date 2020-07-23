package com.forLogging.maven_logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.Math;
import java.util.*;

/**
 * Hello world!
 *
 */
class SimpleInterestCalculator implements SimpleInterest{
	public double calculateSimpleInterest(double p,double r,int t){
	return ((p*r*t)/100);
	}
}
class CompoundInterestCalculator implements CompoundInterest{
	public double calculateCompoundInterest(double p,double r,int n,int t){
		double i=(r/100);
		double k=(1+(i/n));
		return (p*(Math.pow(k,(n*t))));
	}
}
public class InterestCalculator 
{
	private static final Logger LOGGER = LogManager.getLogger(InterestCalculator.class);
    public static void main( String[] args )
    {
    	double initialPrincipalBalance,interestRate,simpleInterest,compoundInterest;
		int time;
		int numberOfTimesInterestAppliedPerTimePeriod;
		SimpleInterestCalculator simple=new SimpleInterestCalculator();
		CompoundInterestCalculator compound=new CompoundInterestCalculator();
		Scanner objSimple=new Scanner(System.in);
		Scanner objCompound=new Scanner(System.in);
		LOGGER.info("FOR SIMPLE INTEREST::\nEnter InitialPrincipalBalance(p),Time(t),InterestRate(r)");
		initialPrincipalBalance=objSimple.nextDouble();
		interestRate=objSimple.nextDouble();
		time=objSimple.nextInt();
		LOGGER.info("FOR COMPOUND INTEREST::\nEnter InitialPrincipalBalance(p),Time(t),InterestRate(r),NumberOfTimesInterestAppliedPerTimePeriod(n)");
		initialPrincipalBalance=objCompound.nextDouble();
		interestRate=objCompound.nextDouble();
		time=objCompound.nextInt();
		numberOfTimesInterestAppliedPerTimePeriod=objCompound.nextInt();
		objSimple.close();
		objCompound.close();
		simpleInterest=simple.calculateSimpleInterest(initialPrincipalBalance,interestRate,time);
		compoundInterest=compound.calculateCompoundInterest(initialPrincipalBalance,interestRate,numberOfTimesInterestAppliedPerTimePeriod,time);
		LOGGER.debug("Simple Interest "+ simpleInterest);		
		LOGGER.debug("Compound Interest "+compoundInterest);
	}
}

    /*	LOGGER.debug("This is a DEBUG Logger");
    	LOGGER.info("This is a INFO Logger");
    	LOGGER.warn("This is a WARN Logger");
    	LOGGER.error("This is a ERROR Logger");
    	LOGGER.fatal("This is a FATAL Logger");
    }
}*/
