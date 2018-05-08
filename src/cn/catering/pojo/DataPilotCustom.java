package cn.catering.pojo;

import java.io.Serializable;
import java.util.List;

public class DataPilotCustom extends DataPilot implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<DataPilotCustom> dataPilotCustomList;

	public List<DataPilotCustom> getDataPilotList() {
		return dataPilotCustomList;
	}

	public void setDataPilotList(List<DataPilotCustom> dataPilotCustomList) {
		this.dataPilotCustomList = dataPilotCustomList;
	}
}
