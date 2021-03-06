package graduation.demo.pharmacymanagementsystem.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bills_products database table.
 * 
 */
@Entity
@Table(name="bills_products")
@NamedQuery(name="BillsProduct.findAll", query="SELECT b FROM BillsProduct b")
public class BillsProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BillsProductPK id;

	private int quantity;

	@Column(name="total_price")
	private float totalPrice;

	//bi-directional many-to-one association to Bill
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="bill_id",insertable=false,updatable=false)
	private Bill bill;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_code", insertable=false,updatable=false)

	private Product product;

	public BillsProduct() {
	}

	public BillsProductPK getId() {
		return this.id;
	}

	public void setId(BillsProductPK id) {
		this.id = id;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Bill getBill() {
		return this.bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}