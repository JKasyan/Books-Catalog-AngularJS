/**
 * This class is generated by jOOQ
 */
package catalog.angularjs.generated.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.2"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Book implements Serializable {

	private static final long serialVersionUID = 549298610;

	private Integer idBook;
	private String  title;
	private String  shortDescription;
	private String  datePublish;
	private Boolean status;

	public Book() {}

	public Book(Book value) {
		this.idBook = value.idBook;
		this.title = value.title;
		this.shortDescription = value.shortDescription;
		this.datePublish = value.datePublish;
		this.status = value.status;
	}

	public Book(
		Integer idBook,
		String  title,
		String  shortDescription,
		String  datePublish,
		Boolean status
	) {
		this.idBook = idBook;
		this.title = title;
		this.shortDescription = shortDescription;
		this.datePublish = datePublish;
		this.status = status;
	}

	public Integer getIdBook() {
		return this.idBook;
	}

	public void setIdBook(Integer idBook) {
		this.idBook = idBook;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDatePublish() {
		return this.datePublish;
	}

	public void setDatePublish(String datePublish) {
		this.datePublish = datePublish;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
