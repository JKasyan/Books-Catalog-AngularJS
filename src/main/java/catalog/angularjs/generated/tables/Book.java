/**
 * This class is generated by jOOQ
 */
package catalog.angularjs.generated.tables;


import catalog.angularjs.generated.Keys;
import catalog.angularjs.generated.Public;
import catalog.angularjs.generated.tables.records.BookRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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
public class Book extends TableImpl<BookRecord> {

	private static final long serialVersionUID = -82315036;

	/**
	 * The reference instance of <code>public.book</code>
	 */
	public static final Book BOOK = new Book();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<BookRecord> getRecordType() {
		return BookRecord.class;
	}

	/**
	 * The column <code>public.book.id_book</code>.
	 */
	public final TableField<BookRecord, Integer> ID_BOOK = createField("id_book", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.book.title</code>.
	 */
	public final TableField<BookRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

	/**
	 * The column <code>public.book.short_description</code>.
	 */
	public final TableField<BookRecord, String> SHORT_DESCRIPTION = createField("short_description", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

	/**
	 * The column <code>public.book.date_publish</code>.
	 */
	public final TableField<BookRecord, String> DATE_PUBLISH = createField("date_publish", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

	/**
	 * The column <code>public.book.status</code>.
	 */
	public final TableField<BookRecord, Boolean> STATUS = createField("status", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

	/**
	 * Create a <code>public.book</code> table reference
	 */
	public Book() {
		this("book", null);
	}

	/**
	 * Create an aliased <code>public.book</code> table reference
	 */
	public Book(String alias) {
		this(alias, BOOK);
	}

	private Book(String alias, Table<BookRecord> aliased) {
		this(alias, aliased, null);
	}

	private Book(String alias, Table<BookRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<BookRecord, Integer> getIdentity() {
		return Keys.IDENTITY_BOOK;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<BookRecord> getPrimaryKey() {
		return Keys.PK_BOOK;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<BookRecord>> getKeys() {
		return Arrays.<UniqueKey<BookRecord>>asList(Keys.PK_BOOK, Keys.UNIQUE_IDBOOK);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Book as(String alias) {
		return new Book(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Book rename(String name) {
		return new Book(name, null);
	}
}
