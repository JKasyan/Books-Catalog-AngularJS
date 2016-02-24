/**
 * This class is generated by jOOQ
 */
package catalog.angularjs.generated.tables.records;


import catalog.angularjs.generated.tables.SelBook;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.TableRecordImpl;


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
public class SelBookRecord extends TableRecordImpl<SelBookRecord> implements Record5<Integer, String, String, Boolean, String> {

	private static final long serialVersionUID = -1861802365;

	/**
	 * Setter for <code>public.sel_book.id_book</code>.
	 */
	public void setIdBook(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.sel_book.id_book</code>.
	 */
	public Integer getIdBook() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>public.sel_book.date_publish</code>.
	 */
	public void setDatePublish(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.sel_book.date_publish</code>.
	 */
	public String getDatePublish() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>public.sel_book.short_description</code>.
	 */
	public void setShortDescription(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.sel_book.short_description</code>.
	 */
	public String getShortDescription() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>public.sel_book.status</code>.
	 */
	public void setStatus(Boolean value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.sel_book.status</code>.
	 */
	public Boolean getStatus() {
		return (Boolean) getValue(3);
	}

	/**
	 * Setter for <code>public.sel_book.title</code>.
	 */
	public void setTitle(String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>public.sel_book.title</code>.
	 */
	public String getTitle() {
		return (String) getValue(4);
	}

	// -------------------------------------------------------------------------
	// Record5 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row5<Integer, String, String, Boolean, String> fieldsRow() {
		return (Row5) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row5<Integer, String, String, Boolean, String> valuesRow() {
		return (Row5) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return SelBook.SEL_BOOK.ID_BOOK;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return SelBook.SEL_BOOK.DATE_PUBLISH;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return SelBook.SEL_BOOK.SHORT_DESCRIPTION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Boolean> field4() {
		return SelBook.SEL_BOOK.STATUS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field5() {
		return SelBook.SEL_BOOK.TITLE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getIdBook();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getDatePublish();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getShortDescription();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean value4() {
		return getStatus();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value5() {
		return getTitle();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SelBookRecord value1(Integer value) {
		setIdBook(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SelBookRecord value2(String value) {
		setDatePublish(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SelBookRecord value3(String value) {
		setShortDescription(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SelBookRecord value4(Boolean value) {
		setStatus(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SelBookRecord value5(String value) {
		setTitle(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SelBookRecord values(Integer value1, String value2, String value3, Boolean value4, String value5) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached SelBookRecord
	 */
	public SelBookRecord() {
		super(SelBook.SEL_BOOK);
	}

	/**
	 * Create a detached, initialised SelBookRecord
	 */
	public SelBookRecord(Integer idBook, String datePublish, String shortDescription, Boolean status, String title) {
		super(SelBook.SEL_BOOK);

		setValue(0, idBook);
		setValue(1, datePublish);
		setValue(2, shortDescription);
		setValue(3, status);
		setValue(4, title);
	}
}
