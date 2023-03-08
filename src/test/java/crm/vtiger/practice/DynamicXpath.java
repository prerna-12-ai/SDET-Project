package crm.vtiger.practice;

public class DynamicXpath {
	public static void main(String[] args) {
		String tabXpath="//a[.='###']";
		String xpath = tabXpath.replace("###", "Contact");
		System.out.println(xpath);
		String partialXpath="//a[.='%s']";
		String x = String.format(partialXpath, "Organization");
		
		System.out.println(x);
	}
}
