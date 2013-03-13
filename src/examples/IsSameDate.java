package examples;

import java.sql.Date;

import types.FlowData;
import types.Predicate;

public class IsSameDate implements Predicate{
	
	public Date date;

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "Is it the same date?";
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public Class[] getInputTypes() {
		return new Class[]{Date.class};
	}

	@Override
	public Boolean execute(FlowData data) {
		Date dateData = Date.valueOf(data.toString());
		return dateData.equals(date);
	}

}
