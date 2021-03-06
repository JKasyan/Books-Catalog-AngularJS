/**
 * This class is generated by jOOQ
 */
package catalog.angularjs.generated;


import catalog.angularjs.generated.Sequences;
import catalog.angularjs.generated.tables.Author;
import catalog.angularjs.generated.tables.AuthorBook;
import catalog.angularjs.generated.tables.Book;
import catalog.angularjs.generated.tables.TestTable;
import catalog.angularjs.generated.tables.Visitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Public extends SchemaImpl {

	private static final long serialVersionUID = -290674932;

	/**
	 * The reference instance of <code>public</code>
	 */
	public static final Public PUBLIC = new Public();

	/**
	 * No further instances allowed
	 */
	private Public() {
		super("public");
	}

	@Override
	public final List<Sequence<?>> getSequences() {
		List result = new ArrayList();
		result.addAll(getSequences0());
		return result;
	}

	private final List<Sequence<?>> getSequences0() {
		return Arrays.<Sequence<?>>asList(
			Sequences.AUTHOR_ID_AUTHOR_SEQ,
			Sequences.BOOK_ID_BOOK_SEQ,
			Sequences.TEST_TABLE_ID_SEQ,
			Sequences.VISITORS_ID_SEQ);
	}

	@Override
	public final List<Table<?>> getTables() {
		List result = new ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final List<Table<?>> getTables0() {
		return Arrays.<Table<?>>asList(
			Author.AUTHOR,
			AuthorBook.AUTHOR_BOOK,
			Book.BOOK,
			TestTable.TEST_TABLE,
			Visitor.VISITOR);
	}
}
