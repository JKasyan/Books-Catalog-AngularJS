/**
 * This class is generated by jOOQ
 */
package catalog.angularjs.generated.tables.records;


import catalog.angularjs.generated.tables.SelectAuthors;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Row4;
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
public class SelectAuthorsRecord extends TableRecordImpl<SelectAuthorsRecord> implements Record4<Integer, String, String, Boolean> {

	private static final long serialVersionUID = -326904256;

	/**
	 * Setter for <code>public.select_authors.id_author</code>.
	 */
	public void setIdAuthor(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.select_authors.id_author</code>.
	 */
	public Integer getIdAuthor() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>public.select_authors.first_name</code>.
	 */
	public void setFirstName(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.select_authors.first_name</code>.
	 */
	public String getFirstName() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>public.select_authors.second_name</code>.
	 */
	public void setSecondName(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.select_authors.second_name</code>.
	 */
	public String getSecondName() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>public.select_authors.status</code>.
	 */
	public void setStatus(Boolean value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.select_authors.status</code>.
	 */
	public Boolean getStatus() {
		return (Boolean) getValue(3);
	}

	// -------------------------------------------------------------------------
	// Record4 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Integer, String, String, Boolean> fieldsRow() {
		return (Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Integer, String, String, Boolean> valuesRow() {
		return (Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return SelectAuthors.SELECT_AUTHORS.ID_AUTHOR;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return SelectAuthors.SELECT_AUTHORS.FIRST_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return SelectAuthors.SELECT_AUTHORS.SECOND_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Boolean> field4() {
		return SelectAuthors.SELECT_AUTHORS.STATUS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getIdAuthor();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getFirstName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getSecondName();
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
	public SelectAuthorsRecord value1(Integer value) {
		setIdAuthor(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SelectAuthorsRecord value2(String value) {
		setFirstName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SelectAuthorsRecord value3(String value) {
		setSecondName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SelectAuthorsRecord value4(Boolean value) {
		setStatus(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SelectAuthorsRecord values(Integer value1, String value2, String value3, Boolean value4) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached SelectAuthorsRecord
	 */
	public SelectAuthorsRecord() {
		super(SelectAuthors.SELECT_AUTHORS);
	}

	/**
	 * Create a detached, initialised SelectAuthorsRecord
	 */
	public SelectAuthorsRecord(Integer idAuthor, String firstName, String secondName, Boolean status) {
		super(SelectAuthors.SELECT_AUTHORS);

		setValue(0, idAuthor);
		setValue(1, firstName);
		setValue(2, secondName);
		setValue(3, status);
	}
}
