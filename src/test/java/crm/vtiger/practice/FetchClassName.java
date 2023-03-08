package crm.vtiger.practice;

import com.tyss.genericUtiltiy.enums.ExcelSheet;

public class FetchClassName {
public static void main(String[] args) {
//	FetchClassName cl = new FetchClassName();
//	System.out.println(cl.getClass().getSimpleName());
	
	String key = ExcelSheet.ORGANIZATION.getSheetName();
	
	System.out.println(key);

}
}
