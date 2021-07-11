
package graduation.demo.pharmacymanagementsystem.dao;

import java.util.Date;
import java.util.List;

import graduation.demo.pharmacymanagementsystem.entity.Bill;

public interface BillsDAO {

	public List <Bill> findAllBills();
	
	public Bill findByBillID (long thebill_id);
	
	public void saveORupdate (Bill theBill);
	
	public void deleteByBillID (int theCode);

	public void save(Bill theBill);

	public List<Bill> findCustomerBillsById(int theCustomerId);

	List<Bill> find_product_while_aperiod(Date replyTime1, Date replyTime2);

	//public List<Bill> searchByName(String theName);
	
	
}
