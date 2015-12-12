/**
 * This class is generated by jOOQ
 */
package catalog.angularjs.generated.tables.records;


import catalog.angularjs.generated.tables.AuthorBook;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


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
public class AuthorBookRecord extends UpdatableRecordImpl<AuthorBookRecord> implements Record2<Integer, Integer> {

	private static final long serialVersionUID = 722665197;

	/**
	 * Setter for <code>public.author_book.id_author</code>.
	 */
	public void setIdAuthor(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.author_book.id_author</code>.
	 */
	public Integer getIdAuthor() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>public.author_book.id_book</code>.
	 */
	public void setIdBook(Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.author_book.id_book</code>.
	 */
	public Integer getIdBook() {
		return (Integer) getValue(1);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record2<Integer, Integer> key() {
		return (Record2) super.key();
	}

	// -------------------------------------------------------------------------
	// Record2 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row2<Integer, Integer> fieldsRow() {
		return (Row2) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row2<Integer, Integer> valuesRow() {
		return (Row2) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return AuthorBook.AUTHOR_BOOK.ID_AUTHOR;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field2() {
		return AuthorBook.AUTHOR_BOOK.ID_BOOK;
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
	public Integer value2() {
		return getIdBook();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AuthorBookRecord value1(Integer value) {
		setIdAuthor(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AuthorBookRecord value2(Integer value) {
		setIdBook(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AuthorBookRecord values(Integer value1, Integer value2) {
		value1(value1);
		value2(value2);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached AuthorBookRecord
	 */
	public AuthorBookRecord() {
		super(AuthorBook.AUTHOR_BOOK);
	}

	/**
	 * Create a detached, initialised AuthorBookRecord
	 */
	public AuthorBookRecord(Integer idAuthor, Integer idBook) {
		super(AuthorBook.AUTHOR_BOOK);

		setValue(0, idAuthor);
		setValue(1, idBook);
	}
}
