package examples;

import java.sql.Date;

import types.FlowData;
import types.Predicate;

public class IsSameDate implements Predicate{
	
	public String strDate;

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "Is it the same date?";
	}

	@Override
	public Class[] getInputTypes() {
		return new Class[]{Date.class};
	}

	public String getStrDate() {
		return strDate;
	}

	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}

	@Override
	public boolean execute(FlowData data) {
		Date givenDate = Date.valueOf(strDate);
		Date dateData = Date.valueOf(data.toString());
		return dateData.equals(givenDate);
	}

}
