/*
 * generated by Xtext 2.13.0
 */
package wodeledu.dsls.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class EduTestAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("wodeledu/dsls/parser/antlr/internal/InternalEduTest.tokens");
	}
}
