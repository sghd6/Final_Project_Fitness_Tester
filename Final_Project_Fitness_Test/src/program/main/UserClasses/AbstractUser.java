package program.main.UserClasses;

import java.text.DecimalFormat;

import program.main.WorkoutStrategies.IWorkoutStrategy;

public abstract class AbstractUser {
	protected String userName;
	protected int age;
	protected double weight;
	protected double height;
	protected int pushupGoal;
	protected int situpGoal;
	protected int squatGoal;
	protected double runGoal;
	protected IWorkoutStrategy workoutStrategy;
	protected double intensityValue = 1;
	
	//private static final DecimalFormat df = new DecimalFormat("#.##");
	
	
	
	///Simple helper methods
	public AbstractUser() {
		
	}
	
	/////Baseline Instantiator
	public AbstractUser(String name, int age, double height, double weight)
	{
		this.userName = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		
	}
	
	
	/////Complete Instantiator (Used for testing)
	
	public AbstractUser(String name, int age, double height, double weight, int pushupGoal, int situpGoal, int squatGoal, double runGoal)
	{
		this.userName = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.pushupGoal = pushupGoal;
		this.situpGoal = situpGoal;
		this.squatGoal = squatGoal;
		this.runGoal = runGoal;
		
	}
	
	public void setTestValue(double multiplier){
		this.intensityValue = multiplier;
	}
	
	public double getTestValue() {
		return intensityValue;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}


	public int getPushupGoal() {
		return (int)(pushupGoal * intensityValue);
	}
	public void setPushupGoal(int pushupGoal) {
		this.pushupGoal = pushupGoal;
	}
	
	public int getSitupGoal() {
		return (int)(situpGoal * intensityValue);
	}
	
	public void setSitupGoal(int situpGoal) {
		this.situpGoal = situpGoal;
	}
	
	public int getSquatGoal() {
		return (int)(squatGoal * intensityValue);
	}
	
	public void setSquatGoal(int squatGoal) {
		this.squatGoal = squatGoal;
	}
	
	public double getRunGoal() {
		return (int)(runGoal * intensityValue);
	}
	
	public void setRunGoal(double runGoal) {
		this.runGoal = runGoal;
	}
	
	public IWorkoutStrategy getWorkoutStrategy() {
		return workoutStrategy;
	}

	public void setWorkoutStrategy(IWorkoutStrategy workoutStrategy) {
		this.workoutStrategy = workoutStrategy;
	}
	
	////Calculation/Conversion Methods
	

	public String goalProgress(int pushupInput, int situpInput, int squatInput, int runInput) {
		
		String pushupCompareString = "";
		String situpCompareString = "";
		String squatCompareString = "";
		String runCompareString = "";
	
		
		int pushupCompareInt = this.pushupGoal - Math.abs(pushupInput);
		int situpCompareInt = this.situpGoal - Math.abs(situpInput);
		int squatCompareInt = this.squatGoal - Math.abs(squatInput);
		double runCompareDbl = this.runGoal - Math.abs(runInput);
		
		if(pushupCompareInt <= 0)
		{
			pushupCompareString = "You have met your pushup goal.";
		}
		else
		{
			pushupCompareString = "You still have " + pushupCompareInt + " pushups left.";
		}
		
		if(situpCompareInt <= 0)
		{
			situpCompareString = "You have met your situp goal.";
		}
		else
		{
			situpCompareString = "You still have " + situpCompareInt + " situps left.";
		}
		
		if(squatCompareInt <= 0)
		{
			squatCompareString = "You have met your squat goal.";
		}
		else
		{
			squatCompareString = "You still have " + squatCompareInt + " squats left";
		}
		
		if(runCompareDbl <= 0)
		{
			runCompareString = "You have met your running goal.";
		}
		else
		{
			runCompareString = "You still have " + runCompareDbl + " kilometers left.";
		}
		
		return pushupCompareString + "\n" + situpCompareString + "\n" + squatCompareString + "\n" + runCompareString;
		
		
		
	}
	
	public void implementStrategy() {
		workoutStrategy.choosePlan(this);
	}
	
////This takes a value and converts it to a specified unit
	public void MetricImperialWeightConverter(int value, String unit)
	{
		if(unit == "Metric" || unit == "metric")
		{
			double kilogram = value / 2.2046226218;
			this.weight = kilogram;
		}
		else if(unit == "Imperial" || unit == "imperial") {
			
			double pound = value / 0.45359237;
			this.weight = pound;
		}
		else
			System.out.println("Invalid Entry: Please try again");
		
	}
	
	
///This takes a value and converts it to a specified unit
	public void MetricImperialHeightConverter(int value, String unit) 
	{
		if(unit == "Metric" || unit == "metric")
		{
			double centimeter = value * 2.54;
			this.height = centimeter;
		}
		else if(unit == "Imperial" || unit == "imperial") {
			
			double inch = value / 2.54;
			this.height = inch;
		}
		else
			System.out.println("Invalid Entry: Please try again");
		
	}
	

	
	public String toString()
	{
		return "User [name= " + userName + ", age= "+ age + ",height= " + height + ",weight= " + weight +"]";
	}
	
	
	

}
