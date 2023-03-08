package crm.vtiger.objectRepository;

public enum TabNames {

	CONTACTS("Contacts"), 
	ORGANIZATIONS("Organizations"),
	DASHBOARD("Dashboard"), 
	PRODUCTS("Products"),
	DOCUMENTS("Documents"),
	EMAIL("Email"),
	LEADS("Leads");
	private String tabName;

	private TabNames(String tabName) {
		this.tabName=tabName;
	}
	
	public String getTab() {
		return tabName;
	}


}
