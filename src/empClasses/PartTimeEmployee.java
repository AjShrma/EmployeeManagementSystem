package empClasses;

public class PartTimeEmployee extends Employee {

		int allowances;
	@Override
	public int setAllowances() {
		// TODO Auto-generated method stub
		this.allowances=100;
		return 0;
	}
	@Override
	public int getAllowances() {
		// TODO Auto-generated method stub
		return allowances;
	}

}
